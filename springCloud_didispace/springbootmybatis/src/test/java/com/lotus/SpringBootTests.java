package com.lotus;

import com.lotus.Application;
import com.lotus.entity.User;
import com.lotus.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhusheng on 2017/6/13 0013.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class SpringBootTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByName()throws Exception{
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        System.out.println(u.getId());
        Assert.assertEquals(20, u.getAge().intValue());
    }
}
