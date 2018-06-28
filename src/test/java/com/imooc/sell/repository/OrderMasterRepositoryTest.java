package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 测试通过买家id查询订单信息，查询结果分页后返回
     */
    @Test
    public void orderMasterFindBuyerOpenIdTest(){
        PageRequest pageRequest = new PageRequest(1,2);
        Page<OrderMaster> lists =orderMasterRepository.findByBuyerOpenidIn("100001333",pageRequest);
        Assert.assertNotNull(lists);
        for(OrderMaster orderMaster:lists){
            System.out.println(orderMaster);
        }

    }


    /**
     * 测试订单表的新增一条订单
     */
    @Test
    public void oderMasterSaveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("100004");
        orderMaster.setBuyerName("小铁头");
        orderMaster.setBuyerAddress("杭州");
        orderMaster.setBuyerPhone("18678908765");
        orderMaster.setBuyerOpenid("100001888");
        orderMaster.setOrderAmount(new BigDecimal(1));
        OrderMaster orderMaster1 = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(orderMaster1);
        System.out.println(orderMaster1);


    }

    /**
     * 测试订单表更新一条数据
     */
    public void orderMasterTest2(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("100004");
        orderMaster.setBuyerName("小圆头");
        orderMaster.setBuyerPhone("18273347678");

    }


}