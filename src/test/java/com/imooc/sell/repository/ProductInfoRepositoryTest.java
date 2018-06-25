package com.imooc.sell.repository;

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

;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 根据Id查询商品信息
     */
    @Test
     public void findOneProductInfo(){
         ProductInfo productInfo = productInfoRepository.findOne("1");
         Assert.assertNotNull(productInfo);
         System.out.println(productInfo);
     }

    @Test
     public  void createProductInfoTest() {
        ProductInfo p = new ProductInfo();
        p.setProductId("1");
        p.setProductPrice(new BigDecimal(23.00));
        p.setProductName("玩具汽车");
        p.setProductStock(1000);
        p.setProductDescription("适合10-20岁的小盆友玩");
        p.setProductIcon("123.jpg");
        p.setCategoryType(1);
        p.setCreateTime(new Date(System.currentTimeMillis()));
        p.setUpdateTime(new Date(System.currentTimeMillis()));
        ProductInfo pi = productInfoRepository.save(p);
        Assert.assertNotNull(pi);
        System.out.println(pi);
    }
    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> lists = productInfoRepository.findByProductStatus(1);
        Assert.assertNotNull(lists);
        System.out.println(lists);
    }

}