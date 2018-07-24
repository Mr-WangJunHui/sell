package com.imooc.sell.utlis;

import com.imooc.sell.enums.CodeEnum;

public class SellEnumUtils {

   public static <T extends CodeEnum> T getEnumConvert(Integer code, Class<T> enumClass){
       for(T ench: enumClass.getEnumConstants()){
           if(ench.getCode()== code){
               return ench;
           }
       }
       return null;
   }


}
