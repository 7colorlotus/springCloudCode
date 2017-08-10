package com.lotus.mq.direct;

import com.lotus.mq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhusheng on 2017/8/9 0009.
 */
@Component
public class HelloReceive {

//    @RabbitListener(queues = "queue") //direct模式同时只能一个监听queue,写多个会按照顺序以第一个为准
    public void process(String str) {
        System.out.println("direct==>" + "String:" + str);
    }

    @RabbitListener(queues = "queue")
    public void processUser(User user){
        System.out.println("direct==>" + "Object:" + user);
    }
}
