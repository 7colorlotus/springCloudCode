package com.lotus.mq.direct;

import com.lotus.Application;
import com.lotus.mq.fanout.FanoutSender;
import com.lotus.mq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by zhusheng on 2017/8/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)//初始化spring 容器
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void testQueueSender(){
        queueSender.send();
    }

    @Test
    public void testTopicSender(){
        topicSender.send1();

        topicSender.send2();
    }

    @Test
    public void testFanoutSender(){
        fanoutSender.send();
    }
}
