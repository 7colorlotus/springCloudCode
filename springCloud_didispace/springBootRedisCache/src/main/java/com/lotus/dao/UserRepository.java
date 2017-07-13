package com.lotus.dao;

import com.lotus.entity.User;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(key = "#p0")
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name ")
    User findUser(@Param("name") String name);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.age = :age where u.id = :id")
    @Transactional

    int updateUserAgeById(@Param("id")Long id, @Param("age")Integer age);

    @CachePut(key = "#p0.name")
    User save(User user);

    @CacheEvict
    @Transactional
    void deleteUserByName(String name);
}