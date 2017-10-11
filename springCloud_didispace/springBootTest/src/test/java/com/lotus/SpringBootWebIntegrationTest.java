package com.lotus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * 启动servlet容器，并访问测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebIntegrationTest(randomPort=true) 已经过时，使用SpringBootTest代替
public class SpringBootWebIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void pageNotFound() {
        RestTemplate rest = new RestTemplate();
        rest.getForObject(
                "http://localhost:{port}/hello", String.class,port);
    }


}
