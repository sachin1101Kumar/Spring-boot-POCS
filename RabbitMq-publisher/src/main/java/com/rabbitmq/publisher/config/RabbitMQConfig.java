package com.rabbitmq.publisher.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue financeQueue(){
        return QueueBuilder.durable("FinanceQueue")
                .build();
    }
    @Bean
    Queue marketingQueue(){
        return QueueBuilder.durable("Marketing")
                .build();
    }
    @Bean
    Queue adminQueue(){
        return QueueBuilder.durable("Admin")
                .build();
    }
    @Bean
    Exchange headersExchange(){
        return ExchangeBuilder.headersExchange("DigitalHeadersExchange")
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }
    @Bean
    Binding marketingBinding(Queue marketingQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueue).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    Binding financeBinding(Queue financeQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueue).to(headerExchange).where("department").matches("finance");
    }

    @Bean
    Binding adminBinding(Queue adminQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(adminQueue).to(headerExchange).where("department").matches("admin");
    }
}
