package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.InfoService;
import com.imooc.sell.utlis.ResultVOUtils;
import com.imooc.sell.vo.ProductInfoVo;
import com.imooc.sell.vo.ProductVo;
import com.imooc.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类目的Controller
 */
@RestController
@RequestMapping("/buyer/product")
public class CategoryController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResultVo showCategoryController(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = infoService.productInfoFindAll();

        //2.查询类目(一次性查出)
        List<Integer> cateTypelist = new ArrayList<Integer>();
        for(ProductInfo productInfo :productInfoList){
            cateTypelist.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(cateTypelist);
        //3.数据的拼装
        List<ProductVo> productVoLists = new ArrayList<ProductVo>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setProductName(productCategory.getCategoryName());
            productVo.setProductType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVos = new ArrayList<ProductInfoVo>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType()==productCategory.getCategoryType()){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVos);
            productVoLists.add(productVo);
        }
        return ResultVOUtils.success(productVoLists);
    }
}
