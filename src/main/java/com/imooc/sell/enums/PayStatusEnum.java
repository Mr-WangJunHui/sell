package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    PAY(1,"已付款"),
    UNPAY(0,"未付款");
     private Integer code;
     private String msg;

    PayStatusEnum(Integer code,String msg){
           this.code = code;
           this.msg = msg;
    }
}
