package com.rabbit.producer.producer;

import com.rabbit.producer.config.RabbitProducerConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

    private final RabbitProducerConfig rabbitProducerConfig;

    private final AmqpTemplate rabbitTemplate;

    public RabbitProducer(RabbitProducerConfig rabbitProducerConfig, AmqpTemplate rabbitTemplate) {
        this.rabbitProducerConfig = rabbitProducerConfig;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage1(String message){
        rabbitTemplate.convertAndSend(rabbitProducerConfig.getExchange(),rabbitProducerConfig.getRoutingKey1(),message);
    }

    public void sendMessage2(String message){
        rabbitTemplate.convertAndSend(rabbitProducerConfig.getExchange(),rabbitProducerConfig.getRoutingKey2(),message);
    }
}
