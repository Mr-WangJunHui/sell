package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.service.DetailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DetailServiceImplTest {

    @Autowired
    private DetailService detailService;

    @Test
    public void findOrderDetailByOrderId() {
      List<OrderDetail> orderDetailList = detailService.findOrderDetailByOrderId("1530369311122221156");
      orderDetailList.forEach((p)->System.out.println(p));
    }
}