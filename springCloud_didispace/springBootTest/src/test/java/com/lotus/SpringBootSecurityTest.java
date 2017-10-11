package com.lotus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.Reader;

/**
 * Created by zhusheng on 2017/10/11 0011.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
@WebAppConfiguration //开启web上下文测试
public class SpringBootSecurityTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                //springSecurity() 方法返回了一个Mock MVC配置器，为Mock MVC开启了Spring Security支持
                                .apply(SecurityMockMvcConfigurers.springSecurity())
                                .build();
    }

    /**
     * WithMockUser方式访问带有Spring Security安全认证的接口
     * @throws Exception
     */
    @Test
    @WithMockUser(username="admin",
            password="469487a0bbf91c26ee80562c2d5e204f",
            roles="ADMIN")
    public void testHelloSecurity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/helloSecurity"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    /**
     * WithUserDetails方式访问带有Spring Security安全认证的接口,不用在注解中写死访问账户和密码
     * @throws Exception
     */
    @Test
    @WithUserDetails(value = "admin",userDetailsServiceBeanName = "customUserService") //使用admin用户
    public void testHelloSecurity2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/helloSecurity"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }
}
