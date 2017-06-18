package com.lotus.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    private String username;
    private Integer age;

    public User(){

    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}