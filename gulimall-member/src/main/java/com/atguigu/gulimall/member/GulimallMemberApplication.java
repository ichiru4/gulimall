package com.atguigu.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
* 1.引入openfeign
* 2.编写一个接口，@FeignClient("gulimall.coupon")
* 3.开启远程调用功能
* */


@EnableFeignClients(basePackages = "com.atguigu.gulimall.member.feign")
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
