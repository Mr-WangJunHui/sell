package com.imooc.sell.utlis;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMaster2OrderDTOConvert {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convertList(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOS= new ArrayList<OrderDTO>();
        for(OrderMaster orderMaster:orderMasterList){
            orderDTOS.add(convert(orderMaster));
        }
        return orderDTOS;
    }
}
