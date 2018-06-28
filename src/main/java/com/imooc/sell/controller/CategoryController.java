package com.imooc.sell.controller;

import com.imooc.sell.vo.ProductInfoVo;
import com.imooc.sell.vo.ProductVo;
import com.imooc.sell.vo.ResultVo;
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

    @RequestMapping("/list")
    public ResultVo showCategoryController(){
        ResultVo<ProductVo> resultVo = new ResultVo<ProductVo>();
        ProductVo productVo = new ProductVo();
        ProductInfoVo productInfoVo = new ProductInfoVo();
        List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
        productInfoVoList.add(productInfoVo);
        productVo.setProductInfoVoList(productInfoVoList);
        resultVo.setCode(0);
        resultVo.setMsg("交易成功");
        resultVo.setData(productVo);
        return resultVo;
    }
}
