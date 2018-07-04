package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    public List<ProductInfo> findByProductStatusService(Integer productStatus) {
        return productInfoRepository.findByProductStatus(productStatus);
    }


    public ProductInfo findProductInfoByProductIdService(String productId) {
        return productInfoRepository.findOne(productId);
    }


    public ProductInfo createProductInfoService(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo updateProductInfoService(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void deleteProductInfoService(String productId) {
        productInfoRepository.delete(productId);
    }

    @Override
    public List<ProductInfo> findAllProductInfo() {
        return productInfoRepository.findAll();
    }
}
