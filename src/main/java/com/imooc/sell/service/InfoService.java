package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;

import java.util.List;

public interface InfoService {
    List<ProductInfo> findByProductStatusService(Integer productStatus);
    ProductInfo findProductInfoByProductIdService(String productId);
    ProductInfo createProductInfoService(ProductInfo productInfo);
    ProductInfo updateProductInfoService(ProductInfo productInfo);
    void deleteProductInfoService(String productId);
    List<ProductInfo>  findAllProductInfo();
}
