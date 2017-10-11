package com.lotus.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/helloSecurity").hasRole("ADMIN")
                .and().httpBasic()
                //配置验证过滤器，首先是Basic认证过滤，再做Digest认证过滤
                .and().addFilterAfter(digestAuthenticationFilter(), BasicAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                ;
    }

    @Bean
    public DigestAuthenticationFilter digestAuthenticationFilter(){
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setUserDetailsService(getCustomUserService());
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
        digestAuthenticationFilter.setCreateAuthenticatedToken(true);
        digestAuthenticationFilter.setPasswordAlreadyEncoded(true);
        return digestAuthenticationFilter;
    }

    @Bean
    public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint(){
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setRealmName("Contacts Realm via Digest Authentication");
        digestAuthenticationEntryPoint.setKey("acegi");
        digestAuthenticationEntryPoint.setNonceValiditySeconds(300);
        return digestAuthenticationEntryPoint;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(getCustomUserService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new ShaPasswordEncoder();
    }

    public CustomUserService getCustomUserService() {
        return customUserService;
    }

    public void setCustomUserService(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }
}
