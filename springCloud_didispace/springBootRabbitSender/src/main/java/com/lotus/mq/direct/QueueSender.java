package com.lotus.mq.direct;

import com.lotus.mq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
//        template.convertAndSend("queue", "hello,rabbit~"); //推送字符串

        User user = new User();  //对象必须序列化，实现Serializable接口
        user.setUsername("zhangshan");
        user.setPassword("123456");
        template.convertAndSend("queue",user);
    }
}