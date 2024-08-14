package com.atguigu.gulimall.order.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//
//@Data
public class OrderConfirmVo {
    @Getter @Setter
    List<MemberAddressVo> address;
    @Getter @Setter
    List<OrderItemVo> items;
    @Getter @Setter
    Integer integration;
    @Getter @Setter
    String orderToken;
    @Getter @Setter
    Map<Long,Boolean> stocks;

//    BigDecimal total;

    public Integer getCount(){
        Integer i = 0;
        if(items!=null){
            for (OrderItemVo item : items) {
                i+=item.getCount();
            }
        }
        return i;
    }
    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if(items!=null){
            for (OrderItemVo item : items) {
                BigDecimal multiply = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
                sum=sum.add(multiply);
            }
        }
        return sum;
    }
//
//    BigDecimal payPrice;
    public BigDecimal getPayPrice() {
      return getTotal();
    }
}
