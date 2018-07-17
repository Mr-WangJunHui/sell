package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.StockDTO;

import java.util.List;

public interface InfoService {
    //通过商品状态查询商品
    List<ProductInfo> findByProductStatusService(Integer productStatus);

    //通过商品id查询商品
    ProductInfo findProductInfoByProductIdService(String productId);

    //创建商品
    ProductInfo createProductInfoService(ProductInfo productInfo);

    //更新商品
    ProductInfo updateProductInfoService(ProductInfo productInfo);

    //删除商品
    void deleteProductInfoService(String productId);

    //查询所有的订单
    List<ProductInfo>  findAllProductInfo();

    //减库存
    void decreateStock(List<StockDTO> stockDTOList);

    //加库存
    void increateStock(String productId);
}
