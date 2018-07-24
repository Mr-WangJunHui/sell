package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utlis.SellEnumUtils;
import com.imooc.sell.utlis.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //商品ID
    private String orderId;
    //买家姓名
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家的微信openid
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;

    //订单状态,默认0新下单
    private Integer orderStatus;
    //支付状态，默认0未支付
    private Integer payStatus;
    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


    List<OrderDetail> orderDetailList = new ArrayList<>();


    //获取订单状态的枚举
    @JsonIgnoreProperties  //在转换为json串时，忽略转换次属性
    public OrderStatusEnum getOrderStatusEnum(){
        return SellEnumUtils.getEnumConvert(this.orderStatus,OrderStatusEnum.class);
    }
    //获取订单支付状态的枚举
    @JsonIgnoreProperties  //在转换为json串时，忽略转换次属性
    public PayStatusEnum getPayStatusEnum(){
        return SellEnumUtils.getEnumConvert(this.payStatus,PayStatusEnum.class);
    }
}
