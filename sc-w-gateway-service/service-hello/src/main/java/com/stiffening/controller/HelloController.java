package com.stiffening.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @date 2019/8/7
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/home")
    public String home(@RequestParam(value = "name", defaultValue = "springCloud") String name) {
        return "hello " + name + " ,i am from port:" + port;
    }
}
