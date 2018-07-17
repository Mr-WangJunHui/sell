package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.StockDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
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

    @Override
    public void decreateStock(List<StockDTO> stockDTOList) {
        if(stockDTOList == null && stockDTOList.size()>0){
            //商品不存在
            throw new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
        }
        Integer stock = 0;
        for(StockDTO stockDTO:stockDTOList){
           ProductInfo productInfo = productInfoRepository.findOne(stockDTO.getProductId());
           stock = productInfo.getProductStock()-stockDTO.getProductQuantity();
           if(stock<0){
               //商品库存不足
               throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
           }
           //更新库存
           productInfo.setProductStock(stock);

        }
    }

    @Override
    public void increateStock(String productId) {

    }
}
