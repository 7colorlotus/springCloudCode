package com.lotus;

import com.lotus.dao.UserRepository;
import com.lotus.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before(){
        User user = userRepository.findByName("中文");
        if(null == user){
            userRepository.save(new User("中文",10));
        }
    }

    @Test
    public void test(){
        User user = userRepository.findByName("中文");
        System.out.println("第一次查询："+user.getAge());

        user = userRepository.findByName("中文");
        System.out.println("第二次查询："+user.getAge());
    }


}
