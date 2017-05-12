package com.lotus;

import com.lotus.dao.UserRepository;
import com.lotus.entity.User;
import groovy.transform.ToString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setAge(19);
        user.setName("lisi");
        userRepository.save(user);


    }

    @Test
    public void testFindUser(){
        User user = userRepository.findByName("lisi");
        Assert.assertEquals(new Integer(19),user.getAge());

        user = userRepository.findByNameAndAge("lisi", 19);
        Assert.assertEquals(new Integer(19),user.getAge());
    }


}
