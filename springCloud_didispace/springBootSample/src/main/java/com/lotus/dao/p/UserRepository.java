package com.lotus.dao.p;

import com.lotus.entity.p.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("UserRepositoryPrimary")
public interface UserRepository extends JpaRepository<User, Long> {
}