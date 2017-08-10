package com.lotus.mq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhusheng on 2017/8/9 0009.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate template;

    public void send1(){
        template.convertAndSend("exchange","topic.message","1============hello topic");
    }

    public void send2(){
        template.convertAndSend("exchange","topic.messages","2============hello topics");
    }
}
