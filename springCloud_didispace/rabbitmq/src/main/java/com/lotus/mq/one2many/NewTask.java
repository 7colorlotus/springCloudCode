package com.lotus.mq.one2many;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

/**
 * 发送端和场景1不同点：
 1、使用“task_queue”声明了另一个Queue，因为RabbitMQ不容许声明2个相同名称、配置不同的Queue
 2、使"task_queue"的Queue的durable的属性为true，即使消息队列durable
 3、使用MessageProperties.PERSISTENT_TEXT_PLAIN使消息durable

 When RabbitMQ quits or crashes it will forget the queues and messages unless you tell it not to.
 Two things are required to make sure that messages aren't lost: we need to mark both the queue and messages as durable.
 */
public class NewTask {
  
  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void main(String[] argv) throws Exception {

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    
    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
    
    String message = getMessage(argv);
    
    channel.basicPublish( "", TASK_QUEUE_NAME, 
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
    System.out.println(" [x] Sent '" + message + "'");
    
    channel.close();
    connection.close();
  }
    
  private static String getMessage(String[] strings){
    if (strings.length < 1)
      return "Hello World!";
    return joinStrings(strings, " ");
  }  
  
  private static String joinStrings(String[] strings, String delimiter) {
    int length = strings.length;
    if (length == 0) return "";
    StringBuilder words = new StringBuilder(strings[0]);
    for (int i = 1; i < length; i++) {
      words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}