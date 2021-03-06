package com.imooc.sell.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTOConvert {
    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();


        orderDTO.setBuyerName(orderForm.getName());

        orderDTO.setBuyerPhone(orderForm.getPhone());

        orderDTO.setBuyerAddress(orderForm.getAddress());

        orderDTO.setBuyerOpenid(orderForm.getOpenid());


        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        //将string的json转换为java的对象
        try{
           orderDetails =  gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());

        }catch(Exception e){
            log.error("[对象转换]错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
         gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());

        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;

    }
}
