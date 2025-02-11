package com.rabbit.producer.service;

import com.rabbit.producer.producer.RabbitProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitProducer rabbitProducer;

    public ProducerService(RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage1(){
        rabbitProducer.sendMessage1("Message 1");
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage2(){
        rabbitProducer.sendMessage2("Message 2");
    }

}
