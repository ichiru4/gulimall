package com.atguigu.gulimall.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class GulimallOrderApplicationTests {
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void sendMessageTest(){
        rabbitTemplate.convertAndSend("hello.java.exchange","hello.java","HELLO WORLD");

    }
    @Test
    void createExchange() {
        DirectExchange directExchange = new DirectExchange("hello.java.exchange",true,false);
        amqpAdmin.declareExchange(directExchange);
        log.info("Exchange[{}]创建成功",directExchange.getName());
    }
    @Test
    void createQueue() {
        Queue queue = new Queue("hello.java.queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("Queue[{}]创建成功",queue.getName());
    }
    @Test
    void bind(){
        Binding binding = new Binding("hello.java.queue", Binding.DestinationType.QUEUE,"hello.java.exchange","hello.java",null);
        amqpAdmin.declareBinding(binding);
        log.info("Binding[{}]创建成功",binding.toString());
    }

}
