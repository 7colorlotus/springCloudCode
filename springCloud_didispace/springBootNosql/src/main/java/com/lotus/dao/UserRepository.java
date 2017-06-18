package com.lotus.dao;

import com.lotus.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhusheng on 2017/6/12 0012.
 */
public interface UserRepository extends MongoRepository<User,Long>{
    User findByUsername(String username);
}
