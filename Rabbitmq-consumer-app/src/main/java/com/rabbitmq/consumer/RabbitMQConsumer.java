package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class RabbitMQConsumer {

    //@RabbitListeners(value = ["TV","Mobile","AC"])
    @RabbitListener(queues= "marketingQueue")
    public void getMessagefromQueue(byte[] message){
        //System.out.println("Message is "+message.toString());

        String stringMessage=new String(message,StandardCharsets.UTF_8);
        System.out.println(stringMessage);
    }
}
