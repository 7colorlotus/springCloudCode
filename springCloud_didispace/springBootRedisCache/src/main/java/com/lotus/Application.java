package com.lotus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
