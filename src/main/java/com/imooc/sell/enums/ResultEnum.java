package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"取消订单成功"),
    PARAM_ERROR(1,"输入参数异常"),
    PRODUCT_NOT_EXSIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    INPUT_ARGUEMENT_ERROR(12,"输入参数不正确"),
    ORDER_NOT_EXSIST(13,"订单不存在"),
    ORDERDETAIL_NOT_EXSIST(14,"订单详情不存在"),
    ORDER_STATUS_ERROR(15,"订单状态错误"),
    UPDATE_ORDER_STATUS_ERROR(16,"更新订单状态失败"),
    ORDER_FINISHED(17,"订单已支付"),
    PAY_ORDER_ERROR(18,"支付失败"),
    CART_EMPTY(19,"购物车为空"),
    OPEN_ID_ERROR(20,"微信openid错误"),
    GET_ACCESS_TOKEN_FAIL(21,"获取access_token失败"),
    SUCCESS_FINISHED(22,"完成订单成功！"),

    ;

    ResultEnum(Integer code, String message) {
        this.code = code;
        Message = message;
    }


    private Integer code;
    private String Message;
}
