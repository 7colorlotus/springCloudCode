package com.lotus.dao.s;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lotus.entity.s.User;
import org.springframework.stereotype.Service;

@Service("UserRepositorySecond")
public interface UserRepository extends JpaRepository<User, Long> {
}