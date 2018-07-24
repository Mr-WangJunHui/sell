package com.imooc.sell.controller;


import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.DetailService;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerBehindOrderController {

    @Autowired
    private OrderService orderService;

   @Autowired
    private DetailService detailService;

    @RequestMapping("/behindList")
    public ModelAndView findlist(@RequestParam(value="page" , defaultValue="1" ,required=false) Integer page,
                                 @RequestParam(value = "size" ,defaultValue="5", required=false) Integer size,
                                 Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage =orderService.findList(pageRequest);
        map.put("orderList",orderDTOPage.getContent());
        map.put("totalPage",orderDTOPage.getTotalPages());
        map.put("currentPage",page);
        size = 5;
        map.put("size",size);
        return new ModelAndView("/order/list",map);
    }

    @RequestMapping("/behindCancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){

        try{
            OrderDTO orderDTO = orderService.findOne(orderId);
            OrderDTO dto = orderService.cancle(orderDTO);
        }catch (SellException e){
           map.put("msg",e.getMessage());
           map.put("url","/sell/buyer/order/behindList");
           return new ModelAndView("/order/error",map);
        }
        map.put("msg",ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/buyer/order/behindList");


        return new ModelAndView("/order/success",map);
    }

    /**
     * 查询订单的详情
     * @param orderId
     * @return
     */
    @RequestMapping("/hehindDetailList")
    public ModelAndView getOrderDetailController(@RequestParam(value= "orderId",required = true) String orderId,
                                                 Map<String,Object> map){
        //订单描述
        OrderDTO orderMaster = orderService.findOne(orderId);
        map.put("orderDTO",orderMaster);
        //订单详细条目
        List<OrderDetail> orderDetails =  detailService.findOrderDetailByOrderId(orderId);
        map.put("orderDetails",orderDetails);

        return new ModelAndView("order/detail",map);
    }

    /**
     * 完结订单
     * @param orderId
     * @param map
     * @return
     */
    @RequestMapping("/behindFinished")
     public ModelAndView behindFinished(@RequestParam(value="orderId",required = true) String orderId,
                                  Map<String,Object> map){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null ){
            throw new SellException(ResultEnum.ORDER_NOT_EXSIST);
        }
        OrderDTO returnOrderDTO = orderService.finished(orderDTO);
        map.put("isFinished",true);
        map.put("msg",ResultEnum.SUCCESS_FINISHED.getMessage());
        map.put("url","/sell/buyer/order/behindList");
        return new ModelAndView("order/finished",map);
     }

}
