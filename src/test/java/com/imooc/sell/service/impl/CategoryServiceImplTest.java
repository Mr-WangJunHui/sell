package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceimpl;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryServiceimpl.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> lists = categoryServiceimpl.findAll();
        System.out.println(lists);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypes = new ArrayList<Integer>();
        categoryTypes.add(1);
        categoryTypes.add(30);
        List<ProductCategory> lists = categoryServiceimpl.findByCategoryTypeIn(categoryTypes);
        System.out.println(lists);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("夏季大热卖，男生小衬衫");
        productCategory.setCategoryType(1);
        ProductCategory p = categoryServiceimpl.save(productCategory);
        p.toString();
        System.out.println(p);

    }
}