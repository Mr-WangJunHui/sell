package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOneProductInfoService(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public ProductInfo productInfoSaveService(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void productInfoDeleteService(String productId) {
           productInfoRepository.delete(productId);
    }

    @Override
    public List<ProductInfo> productInfoFindAll() {
        return productInfoRepository.findAll();
    }

    @Override
    public List<ProductInfo> productInfoByStatus(Integer productStatus) {
        return productInfoRepository.findByProductStatus(productStatus);
    }
}
