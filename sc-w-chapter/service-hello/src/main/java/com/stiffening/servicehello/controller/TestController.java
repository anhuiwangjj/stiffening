package com.stiffening.servicehello.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @date 2019/7/26
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(@RequestParam(name ="words", defaultValue = "helloWorld") String words){
        return "Say "+ words + " ,I'm from port"+ port;
    }

    public String helloError(String words) {
        return "Say,"+words+",sorry,error!";
    }
}
