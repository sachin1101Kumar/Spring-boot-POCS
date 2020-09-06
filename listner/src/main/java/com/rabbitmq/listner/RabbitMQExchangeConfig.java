package com.rabbitmq.listner;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    @Bean
    Exchange exampleExchange(){
        return new DirectExchange("ExampleExchange");
    }

    @Bean
    Exchange example2ndExchange(){
        return ExchangeBuilder.directExchange("example2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }
    @Bean
    Exchange newTopicExchange(){
        return ExchangeBuilder.topicExchange("NewTopicExchange")
                .internal()
                .autoDelete()
                .durable(true)
                .build();
    }

    @Bean
    Exchange newFanoutExchange(){
        return ExchangeBuilder.fanoutExchange("NewFanoutExchange")
                .durable(true)
                .autoDelete()
                .internal()
                .build();
    }
    @Bean
    Exchange newHeaderExchange(){
        return ExchangeBuilder.headersExchange("NewHeadersExchange")
                .internal()
                .autoDelete()
                .ignoreDeclarationExceptions()
                .durable(true)
                .build();
    }
}
