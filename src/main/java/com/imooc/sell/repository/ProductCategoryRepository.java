package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
     * 通过商品的类型查询商品
     * @param categoryTypeList
     * @return
     */
      List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
