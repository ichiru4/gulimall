package com.atguigu.gulimall.authserver.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FeignClientConfiguration {


        @Bean
        public Logger.Level  feignLogLevel(){
            return Logger.Level.FULL;
        }
    }
