package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@Data
public class OrderDetail {
    //订单详情细节Id
    @Id
    private String detailId;

    //订单Id
    private String orderId;

    //商品Id
    private String productId;

    //商品名称
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;
    //商品小图
    private String productIcon;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
