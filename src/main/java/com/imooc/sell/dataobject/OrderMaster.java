package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //商品ID
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态，默认0未支付
    private Integer payStatus = PayStatusEnum.UNPAY.getCode();
    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
