package com.lotus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by zhusheng on 2017/7/14 0014.
 */
@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
