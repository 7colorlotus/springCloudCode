package com.lotus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/loginSuccess")
    public String loginSuccess() {
        return "hello";
    }
}
