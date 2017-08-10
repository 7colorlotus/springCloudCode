package com.lotus.mq.java;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendTest {
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
         String message = "hello World!!!!!!!!!!!!!!hello World!!!!!!!!";
         /* RabbitMQ默认有一个exchange，叫default exchange，它用一个空字符串表示，
          * 它是direct exchange类型，任何发往这个exchange的消息都会被路由到routing key
          * 的名字对应的队列上，如果没有对应的队列，则消息会被丢弃。这就是为什么代码中channel执行
          * basicPulish方法时，第二个参数本应该为routing key，却被写上了QUEUE_NAME。*/
         channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
         channel.close();
         connection.close();
     }
 }