package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小天王");
        orderDTO.setBuyerAddress("杭州");
        orderDTO.setBuyerPhone("127373733");
        orderDTO.setBuyerOpenid("11110000");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1000201");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1000203");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);


        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO s = orderService.create(orderDTO);
        log.info("创建商品信息"+s);

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1530407656815245074");
        OrderDTO o1 = orderService.findOne(orderDTO.getOrderId());
        System.out.println("查询订单的结果："+o1);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,4);
        Page<OrderDTO> orderDTOS = orderService.findList("11110000",pageRequest);
        System.out.println("所有的商品："+orderDTOS);

    }

    @Test
    public void cancle() {
        OrderDTO orderDTO = orderService.findOne("1530404713735597307");


        OrderDTO orderDTO1 = orderService.cancle(orderDTO);
        System.out.println(orderDTO1);
    }

    @Test
    public void finished() {
        OrderDTO orderDTO = orderService.findOne("1530404713735597307");
        OrderDTO orderDTO1 = orderService.finished(orderDTO);
        System.out.println(orderDTO1);

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1530404713735597307");
        OrderDTO orderDTO1 = orderService.paid(orderDTO);
        System.out.println(orderDTO1);
    }
}