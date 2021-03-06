package com.imooc.sell.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新下单"),
    FINSHED(1,"完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String msg;



   OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
