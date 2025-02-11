package com.rabbitmq.consumer.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RabbitListeners {

    private final RabbitListenerConfigurer rabbitListenerConfigurer;

    public RabbitListeners(RabbitListenerConfigurer rabbitListenerConfigurer) {
        this.rabbitListenerConfigurer = rabbitListenerConfigurer;
    }

    @RabbitListener(queuesToDeclare = @Queue("queue1"))
    public void listener1(String message){
        System.out.println("Listener 1: " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("queue2"))
    public void listener2(String message){
        System.out.println("Listener 2: " + message);
        System.out.println("************");
    }

}
