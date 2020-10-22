package com.yangs.SpringBootDemo.message;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

        Map<String,Object> headers = new HashMap<>();
        headers.put("my1","111");
        headers.put("my2","222");
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties.Builder()
                            .deliveryMode(2)
                            .contentEncoding("UTF-8")
                            .expiration("10000")
                            .headers(headers)
                             .build();

        String message = "Hello RabbitMQ!";
        for(int i=0;i<5;i++){
            channel.basicPublish("","test001",basicProperties,message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
