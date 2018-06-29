package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

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
   @Transactional
    public void updateProductCategory(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryType(80);
        productCategory.setCategoryName("绿萝大陆");
       ProductCategory productCategory1 =  productCategoryRepository.save(productCategory);
       Assert.assertNotNull(productCategory1);

    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> categoryTypes = new ArrayList<Integer>();
        categoryTypes.add(1);
        categoryTypes.add(30);
        List<ProductCategory> lists = productCategoryRepository.findByCategoryTypeIn(categoryTypes);

        Assert.assertNotNull(lists);
        System.out.print(lists);
    }

}