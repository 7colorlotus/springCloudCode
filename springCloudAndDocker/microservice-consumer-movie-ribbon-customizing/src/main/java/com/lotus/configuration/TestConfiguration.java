package com.lotus.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/25.
 */
@Configuration
@RibbonClient(name = "microservice-provider-user",configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
