package com.rabbitmq.listner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMqListner implements MessageListener {
    @Override
    public void onMessage(Message message) {
        //We need to create a configuration file for Connection factory Message Listner
        // and then we need to publish a message in the newly created queue
        System.out.println("message = " + message);
        System.out.println("Message is "+new String(message.getBody()));
    }
}
