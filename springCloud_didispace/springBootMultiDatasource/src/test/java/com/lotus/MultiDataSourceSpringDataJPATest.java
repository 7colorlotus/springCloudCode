package com.lotus;

import com.lotus.dao.p.MessageRepository;
import com.lotus.entity.p.MessageEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lotus.dao.p.UserRepository;
import com.lotus.entity.p.User;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MultiDataSourceSpringDataJPATest {
    @Autowired
    @Qualifier("UserRepositoryPrimary")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("MessageRepositoryPrimary")
    private MessageRepository messageRepository;


    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));
        Assert.assertEquals(5, userRepository.findAll().size());

        MessageEntity message = new MessageEntity();
        message.setContent("hello world");
        message.setName("test");
        messageRepository.save(message);
    }


}
