package com.rabbitMq.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        Connection connection=connectionFactory.newConnection();
        Channel channel=connection.createChannel();

        DeliverCallback deliverCallback=(consumerTag, message) -> {
            String msg=new String(message.getBody());
            System.out.println("Message = " + msg);
        };
        channel.basicConsume("MyQueue",true,deliverCallback,consumerTag -> {});
    }
}
