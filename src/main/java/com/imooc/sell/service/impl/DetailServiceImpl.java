package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.OrderDetailRepository;
import com.imooc.sell.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl  implements DetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 同过订单id查询所有的订单详情
     * @param orderId
     * @return
     */
    public List<OrderDetail> findOrderDetailByOrderId(String orderId) {
       List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        if(orderDetails == null){
            //订单详情不存在
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXSIST);
        }
        return orderDetails;
    }
}
