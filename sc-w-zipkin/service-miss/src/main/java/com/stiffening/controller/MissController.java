package com.stiffening.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wjj
 * @date 2019/7/25
 */
@RestController
@RequestMapping("/miss")
public class MissController {

    private static final Logger log = LoggerFactory.getLogger(MissController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hi")
    public String home() {
        log.info("hi is being called");
        return "Hi, I'm miss!";
    }

    @GetMapping("/missInfo")
    public String info() {
        log.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/hi/info", String.class);
    }
}
