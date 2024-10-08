package com.atguigu.gulimall.member.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class GuliFeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
       return new RequestInterceptor() {
           @Override
           public void apply(RequestTemplate requestTemplate) {
               ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
               if (attributes!=null){
                   HttpServletRequest request = attributes.getRequest();
                   if(request!=null){
                       requestTemplate.header("Cookie", request.getHeader("Cookie"));
                   }
               }
           }
       };
    }
}
