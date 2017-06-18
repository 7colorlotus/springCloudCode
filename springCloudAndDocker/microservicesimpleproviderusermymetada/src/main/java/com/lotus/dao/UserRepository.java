package com.lotus.dao;

import com.lotus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
