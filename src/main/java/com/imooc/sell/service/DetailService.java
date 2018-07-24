package com.imooc.sell.service;

import com.imooc.sell.dataobject.OrderDetail;

import java.util.List;

public interface DetailService {
    List<OrderDetail> findOrderDetailByOrderId(String orderId);
}
