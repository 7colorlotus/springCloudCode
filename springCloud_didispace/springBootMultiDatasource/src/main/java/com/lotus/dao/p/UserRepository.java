package com.lotus.dao.p;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lotus.entity.p.User;
import org.springframework.stereotype.Service;

@Service("UserRepositoryPrimary")
public interface UserRepository extends JpaRepository<User, Long> {
}