package com.rabbitmq.listner;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    private static final String MY_QUEUE="MyQueue";

    @Bean
    Queue myQueue(){
        return new Queue(MY_QUEUE,true);
    }

    @Bean
    Exchange myExchange(){
        return ExchangeBuilder.topicExchange("newTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding bindings(){
       // return new Binding(MY_QUEUE,Binding.DestinationType.QUEUE,"newTopicExchange","topic",null);
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with("topic")
                .noargs();
    }

    @Bean
    ConnectionFactory myConnectionFactory(){
        CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return  cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(myConnectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setupMessageListener(new RabbitMqListner());
        return simpleMessageListenerContainer;
    }

}
