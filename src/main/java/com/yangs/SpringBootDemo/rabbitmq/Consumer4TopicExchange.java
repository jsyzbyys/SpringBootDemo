package com.yangs.SpringBootDemo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer4TopicExchange {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1、创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.7.23");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //2、通过connectionFactory创建Connection
        Connection connection = connectionFactory.newConnection();
        //3、通过connection创建Channel
        Channel channel = connection.createChannel();
        String exchangeName = "test_topic_exchange";
        String exchangeType = "topic";
        String queueName = "test_topic_name";
        String routingName = "user.*";
       //声明交换机
        channel.exchangeDeclare(exchangeName,exchangeType,true,false,false,null);
        //4、创建一个队列
        channel.queueDeclare(queueName,true,false,false,null);
        //建立绑定关系
        channel.queueBind(queueName,exchangeName,routingName);
        //5、创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //6、设置channel
        channel.basicConsume(queueName,true,queueingConsumer);
        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.err.println("消费端："+message);
            //Envelope envelope = delivery.getEnvelope();
        }

    }
}
