package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.StockDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InfoService {
    public ProductInfo findOneProductInfoService(String productId);
    public ProductInfo productInfoSaveService(ProductInfo productInfo);
    public void productInfoDeleteService(String productId);
    public List<ProductInfo> productInfoFindAll();
    public List<ProductInfo> productInfoByStatus(Integer productStatus);
    //加库存
    public void increateStock(List<StockDTO> stockDTOList);
    //减库存
    public void decreateStock(List<StockDTO> stockDTOList);

}
