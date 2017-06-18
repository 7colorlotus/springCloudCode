package com.lotus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2017/6/18.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekahaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekahaApplication.class, args);
    }
}
