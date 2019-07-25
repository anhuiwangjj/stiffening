package com.stiffening.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @date 2019/7/24
 */
@RestController
public class TestController {

    @Value("${foo}")
    private String scDemo;

    @GetMapping("/hello")
    public String hello() {
        return scDemo;
    }
}
