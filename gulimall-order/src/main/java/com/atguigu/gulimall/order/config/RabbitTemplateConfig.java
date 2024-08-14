package com.atguigu.gulimall.order.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
@Configuration
public class RabbitTemplateConfig {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @PostConstruct
    public void initRabbitTemplate(){
        //消息抵达服务器调用
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {

                System.out.println(correlationData+" "+b);
            }
        });
        //消息没有抵达队列调用
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println( returnedMessage.getMessage()+" "+returnedMessage.getReplyCode()+" "+returnedMessage.getReplyText()+" "+returnedMessage.getExchange()+" "+returnedMessage.getRoutingKey());
            }
        });
    }
}
