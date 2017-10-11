package com.lotus.configuration;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomUserService implements UserDetailsService {
    Map<String,User> userMap = new HashMap<String,User>();

    public CustomUserService(){

        SimpleGrantedAuthority roleUserGrantedAuthority=new SimpleGrantedAuthority("ROLE_USER");
        SimpleGrantedAuthority roleAdminGrantedAuthority=new SimpleGrantedAuthority("ROLE_ADMIN");


        User clientUser = new User("client"
                ,"f6b0dc4ba82919dce0125758cb46bced"
                , Arrays.asList(new SimpleGrantedAuthority[]{roleUserGrantedAuthority}));
        User clientbasicUser = new User("clientbasic"
                ,"81246a30267e378bffda42b02ab38ea43c8344b3"
                , Arrays.asList(new SimpleGrantedAuthority[]{roleUserGrantedAuthority}));
        User adminUser = new User("admin"
                ,"469487a0bbf91c26ee80562c2d5e204f"
                , Arrays.asList(new SimpleGrantedAuthority[]{roleUserGrantedAuthority,roleAdminGrantedAuthority}));
        userMap.put("client", clientUser);
        userMap.put("admin", adminUser);
        userMap.put("clientbasic", clientbasicUser);
    }

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(userName)){
            throw new UsernameNotFoundException("用户名参数为空");
        }
        User user = userMap.get(userName);
        if(null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }

        User returnUser = new User(user.getUsername()
                ,user.getPassword()
                , user.getAuthorities());
        return returnUser;
	}

}
