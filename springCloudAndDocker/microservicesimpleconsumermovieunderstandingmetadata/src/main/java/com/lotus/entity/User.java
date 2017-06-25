package com.lotus.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/31.
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
