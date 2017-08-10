package com.lotus.mq.java;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveTest {
     private final static String QUEUE_NAME = "hello";
     public static void main(String[] arg) throws Exception{
         //创建连接工程
         ConnectionFactory factory = new ConnectionFactory();
         factory.setHost("localhost");
         //创建连接
         Connection connection = factory.newConnection();
         //创建channel
         Channel channel = connection.createChannel();
         //创建队列，将消息发送到队列，便于消费
         channel.queueDeclare(QUEUE_NAME, false, false, false, null);
         QueueingConsumer consumer = new QueueingConsumer(channel);
         channel.basicConsume(QUEUE_NAME, true, consumer);
         while(true){
             QueueingConsumer.Delivery delivery = consumer.nextDelivery();
             String message = new String(delivery.getBody());
             System.out.println(message);
         }
     }
 }