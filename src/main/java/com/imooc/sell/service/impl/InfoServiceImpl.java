package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.StockDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void increateStock(List<StockDTO> stockDTOList) {

    }


    @Transactional
    public synchronized void decreateStock(List<StockDTO> stockDTOList) {
        Integer productStock = null;
        if(stockDTOList.size()>0){
            for(StockDTO s:stockDTOList){
                ProductInfo productInfo = productInfoRepository.findOne(s.getProductId());
                if(productInfo==null){
                   throw  new SellException(ResultEnum.PRODUCT_NOT_EXSIST);
                }
                productStock = productInfo.getProductStock()-s.getProductQuantity();
                if(productStock<0){
                   // System.out.println("00000000000000000000000000000000000000000000000000000");
                    throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);

                }
                productInfo.setProductStock(productStock);
                productInfoRepository.save(productInfo);

            }
        }

    }
}
