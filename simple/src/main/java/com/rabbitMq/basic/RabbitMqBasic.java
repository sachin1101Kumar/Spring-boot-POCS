package com.rabbitMq.basic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqBasic {
    public static void main(String[] args) {
        //using auto closable interfaces
        try{
            ConnectionFactory connectionFactory=new ConnectionFactory();
            Connection connection=connectionFactory.newConnection();
            Channel channel=connection.createChannel();
            String message="My First Spring boot with Rabbit MQ example..";
            //at place of Routing key(2nd paramater we can also give the Queue Name)
            channel.basicPublish("",
                    "MyQueue",
                    null,
                    message.getBytes());
            channel.close();
            connection.close();
           }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
