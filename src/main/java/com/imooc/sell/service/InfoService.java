package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InfoService {
    public ProductInfo findOneProductInfoService(String productId);
    public ProductInfo productInfoSaveService(ProductInfo productInfo);
    public void productInfoDeleteService(String productId);
    public List<ProductInfo> productInfoFindAll();
    public List<ProductInfo> productInfoByStatus(Integer productStatus);

}
