package com.lotus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhusheng on 2017/10/11 0011.
 */
@Controller
public class IndexController {
    @GetMapping("hello")
    @ResponseBody
    public String hello(ModelMap modelMap){
        List<String> bookList = new ArrayList<String>();
        modelMap.put("bookList", bookList);
        return "hello";
    }

    @GetMapping("helloSecurity")
    @ResponseBody
    public String helloSecurity(){
        return "helloSecurity";
    }

}
