package client.controller;

import client.service.ComputeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(tags = "ConsumerService")
public class ConsumerController {
    //未使用断路器版本
    /*
    @Autowired
    RestTemplate restTemplate;*/

    @Autowired
    private ComputeService computeService;

    @ApiOperation(value = "加法运算",notes = "默认使用10+20")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        //未使用断路器版本
        /*return restTemplate.getForEntity("http://provider-service/add?a=10&b=20", String.class).getBody();*/
        return computeService.addService();
    }
}