package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoServiceImplTest {
    @Autowired
    private InfoServiceImpl infoServiceimpl;

    @Test
    public void findOneProductInfoServiceTest() {
        ProductInfo p = infoServiceimpl.findOneProductInfoService("1");
        Assert.assertNotNull(p);
        System.out.println(p);
    }

    @Test
    public void productInfoSaveServiceTest() {
        ProductInfo p = new ProductInfo();
        p.setProductId("3");
        p.setProductPrice(new BigDecimal(23.00));
        p.setProductName("玩具汽车1111");
        p.setProductStock(1000);
        p.setProductDescription("适合10-20岁的小盆444友玩");
        p.setProductIcon("1223.jpg");
        p.setCategoryType(2);
        p.setCreateTime(new Date(System.currentTimeMillis()));
        p.setUpdateTime(new Date(System.currentTimeMillis()));
        ProductInfo productInfo = infoServiceimpl.productInfoSaveService(p);
        Assert.assertNotNull(productInfo);
        System.out.println(productInfo);
    }

    @Test
    public void productInfoDeleteServiceTest() {
        infoServiceimpl.productInfoDeleteService("3");
    }

    @Test
    public void productInfoFindAllTest() {
        List<ProductInfo> lists = infoServiceimpl.productInfoFindAll();
        System.out.println(lists);
    }

    @Test
    public void productInfoByStatusTest() {
        List<ProductInfo> lists =infoServiceimpl.productInfoByStatus(1);
        System.out.println(lists);
    }
}