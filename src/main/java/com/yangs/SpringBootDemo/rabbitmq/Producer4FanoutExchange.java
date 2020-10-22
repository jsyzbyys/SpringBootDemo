package com.yangs.SpringBootDemo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer4FanoutExchange {
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
        String message1 = "Hello RabbitMQ FOR Fanout Exchange!_____1";
        String message2 = "Hello RabbitMQ FOR Fanout Exchange!_____2";
        String message3 = "Hello RabbitMQ FOR Fanout Exchange!_____3";
        String exchangeName = "test_fanout_exchange";
        String routingKey = "";
        channel.basicPublish(exchangeName,routingKey,null,message1.getBytes());
        channel.basicPublish(exchangeName,routingKey,null,message2.getBytes());
        channel.basicPublish(exchangeName,routingKey,null,message3.getBytes());
        channel.close();
        connection.close();
    }
}
