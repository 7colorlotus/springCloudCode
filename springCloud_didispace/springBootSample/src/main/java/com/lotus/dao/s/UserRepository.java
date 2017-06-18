package com.lotus.dao.s;

import com.lotus.entity.s.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("UserRepositorySecond")
public interface UserRepository extends JpaRepository<User, Long> {
}