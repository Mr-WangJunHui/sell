package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.dto.StockDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.OrderDetailRepository;
import com.imooc.sell.repository.OrderMasterRepository;
import com.imooc.sell.service.InfoService;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utlis.KeyUtils;
import com.imooc.sell.convert.OrderMaster2OrderDTOConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private InfoService infoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */

    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

       //库存数量
        Integer  productStock = 0;
        //订单ID
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        List<StockDTO> stockDTOList = new ArrayList<StockDTO>();
        //1.查询商品（数量，价格）
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
              ProductInfo productInfo = infoService.findProductInfoByProductIdService(orderDetail.getProductId());
              if(productInfo == null){
                  throw new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
              }
            //2.计算订单总价

                orderAmount = productInfo.getProductPrice()
                        .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                          .add(orderAmount);

            //订单详情入库

            orderDetail.setDetailId(KeyUtils.genUniqueKey());
              orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

            StockDTO stockDTO = new StockDTO();
            stockDTO.setProductQuantity(orderDetail.getProductQuantity());
            stockDTO.setProductId(orderDetail.getProductId());
            stockDTOList.add(stockDTO);
        }

        //3.写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId


        );
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.UNPAY.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        infoService.decreateStock(stockDTOList);

        return orderDTO;
    }

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    public OrderDTO findOne(String orderId) {
        if(orderId == null) {
            throw new SellException(ResultEnum.INPUT_ARGUEMENT_ERROR);
        }
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if(orderMaster == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXSIST);
        }
        List<OrderDetail> orderDetail = orderDetailRepository.findByOrderId(orderId);
        if(orderDetail == null){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXSIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetail);
        return orderDTO;
    }

    /**
     * 查询用户的所有订单，并进行分页
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
         Page<OrderMaster> orderMasterList = orderMasterRepository.findByBuyerOpenidIn(buyerOpenid,pageable);
        Page<OrderDTO> orderDTOS = new PageImpl<OrderDTO>(OrderMaster2OrderDTOConvert.convertList(orderMasterList.getContent()),
                pageable,orderMasterList.getSize());
        return orderDTOS;
    }

    /**
     * 查询所有的订单
     * @param pageable
     * @return
     */
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findAll(pageable);
        List<OrderDTO> orderMasterList = OrderMaster2OrderDTOConvert.convertList(orderMasters.getContent());
        return new PageImpl<>(orderMasterList,pageable,orderMasters.getTotalElements());
    }


    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    @Transactional
    public OrderDTO cancle(OrderDTO orderDTO) {
       OrderMaster orderMaster =  orderMasterRepository.findOne(orderDTO.getOrderId());
       if(orderMaster == null){
           throw new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
       }
      /* List<OrderDetail> orderDetail = orderDetailRepository.findByOrderId(orderDTO.getOrderId());
       if(orderDetail == null){
           throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXSIST);
       }*/
      if(orderMaster.getPayStatus() == PayStatusEnum.PAY.getCode()){
          //发起退款
      }
       if(orderMaster.getOrderStatus() != OrderStatusEnum.CANCEL.getCode()){
           orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
       }

        return orderDTO;
    }


    /**
     * 完结订单
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO finished(OrderDTO orderDTO) {
        OrderMaster orderMaster =  orderMasterRepository.findOne(orderDTO.getOrderId());
        if(orderMaster == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
        }
        if(orderDTO.getOrderStatus() != OrderStatusEnum.NEW.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.FINSHED.getCode());
        OrderMaster orderMaster1 = orderMasterRepository.save(orderMaster);
        if(orderMaster1 == null){
            throw new SellException(ResultEnum.UPDATE_ORDER_STATUS_ERROR);
        }
        return OrderMaster2OrderDTOConvert.convert(orderMaster1);
    }


    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        OrderMaster orderMaster =  orderMasterRepository.findOne(orderDTO.getOrderId());
        if(orderMaster == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
        }
        if(orderMaster.getPayStatus() == PayStatusEnum.PAY.getCode()){
            throw new SellException(ResultEnum.ORDER_FINISHED);
        }
        orderMaster.setPayStatus(PayStatusEnum.PAY.getCode());
        OrderMaster orderMaster1 = orderMasterRepository.save(orderMaster);
        if(orderMaster1 == null){
            throw new SellException(ResultEnum.PAY_ORDER_ERROR);
        }
        return OrderMaster2OrderDTOConvert.convert(orderMaster1);
    }
}
