package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@Entity
@Data
public class ProductInfo {
    //商品ID
    @Id
    private String productId;
    //商品价格
    private BigDecimal productPrice;
    //商品名称
    private String productName;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //商品状态  0正常1下架
    private Integer productStatus;

    public ProductInfo(String productId, BigDecimal productPrice, String productName, Integer productStock, String productDescription, String productIcon, Integer categoryType, Date createTime, Date updateTime, Integer productStatus) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.productStatus = productStatus;
    }

    public ProductInfo() {

    }
}
