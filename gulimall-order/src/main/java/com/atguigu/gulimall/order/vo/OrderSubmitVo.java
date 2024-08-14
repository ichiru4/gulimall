package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSubmitVo {
    private Long addrId;
    private Integer payType;
    //优惠发票

    //
    private String orderToken;
    private BigDecimal payPrice;
    private String node;
}
