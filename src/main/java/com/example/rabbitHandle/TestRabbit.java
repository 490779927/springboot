package com.example.rabbitHandle;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test")
public class TestRabbit {

    @RabbitHandler
    public void process(String context){
        System.out.println("Receiver:  "+context);
    }
}
