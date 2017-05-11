package com.lotus.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@Controller
@RequestMapping("Template")
public class TemplateController {

    @RequestMapping("thymeleaf")
    public String thymeleafTemplate(ModelMap map){
        map.put("host","http://www.7colorlotus.net");
        return "thymeleafTemplate";
    }


}


