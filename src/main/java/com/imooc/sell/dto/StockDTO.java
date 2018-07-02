package com.imooc.sell.dto;

import lombok.Data;

import java.util.List;

@Data
public class StockDTO {

    //商品ID
    private String productId;
    //商品的数量
    private Integer productQuantity;
    private List<StockDTO> ListStock;
}
