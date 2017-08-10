package com.lotus.mq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhusheng on 2017/8/10 0010.
 */
@Component
public class FanoutReceive {

    @RabbitListener(queues = "fanout.A")
    public void processA(String str) {
        System.out.println("ReceiveA : " + str);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB : " + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC : " + str);
    }
}
