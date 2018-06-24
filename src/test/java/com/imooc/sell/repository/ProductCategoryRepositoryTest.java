package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void fiindoneProductCategory(){
      ProductCategory pcr =   productCategoryRepository.findOne(1);
      System.out.println(pcr);

    }
   @Test
    public void updateProductCategory(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryType(10);
        productCategoryRepository.save(productCategory);

    }

}