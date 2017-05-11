package com.lotus.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
@RestController
public class HelloController {

    @ApiOperation(value = "欢迎语", notes = "欢迎的语句")
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @ApiOperation(value = "欢迎有参数", notes = "欢迎有参数")
    @ApiImplicitParam(name = "id", value = "用户id", required = false)
    @RequestMapping("/indexHasParam")
    public String indexHasParam(String id){
        return "indexHasParam";
    }

    @RequestMapping("/helloException")
    public String helloException() throws Exception{
        throw new Exception("发生错误");
    }
}
