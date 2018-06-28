package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 每条数据的对象
 */
@Data
public class ProductVo {
    @JsonProperty("name")
    private String productName;

    @JsonProperty("type")
    private Integer productType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
