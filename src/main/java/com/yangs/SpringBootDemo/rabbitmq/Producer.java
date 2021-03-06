package com.yangs.SpringBootDemo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.7.23");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //2、通过connectionFactory创建Connection
        Connection connection = connectionFactory.newConnection();

        //3、通过connection创建Channel
        Channel channel = connection.createChannel();
        String message = "Hello RabbitMQ!";
        for(int i=0;i<5;i++){
            channel.basicPublish("","test001",null,message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
