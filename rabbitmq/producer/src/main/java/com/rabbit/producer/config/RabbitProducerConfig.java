package com.rabbit.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitProducerConfig {


    private String queue1 = "queue1";
    private String queue2 = "queue2";

    private String routingKey1 = "routingKey1";
    private String routingKey2 = "routingKey2";

    private String exchange = "exchange";

    public String getQueue1() {
        return queue1;
    }

    public String getQueue2() {
        return queue2;
    }

    public String getRoutingKey1() {
        return routingKey1;
    }

    public String getRoutingKey2() {
        return routingKey2;
    }

    public String getExchange() {
        return exchange;
    }

    @Bean
    public Queue queue1(){
        return new Queue(queue1,true);
    }

    @Bean
    public Queue queue2(){
        return new Queue(queue2,true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding1(Queue queue1, DirectExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with(routingKey1);
    }

    @Bean
    public Binding binding2(Queue queue2, DirectExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with(routingKey2);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
