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
@RequestMapping("/hi")
public class HiController {

    private static final Logger log = LoggerFactory.getLogger(HiController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/miss")
    public String call(){
        log.info("calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8989/miss/hi",String.class);
    }

    @GetMapping("/info")
    public String info() {
        log.info("calling trace service-hi");
        return "I'm service-hi";
    }
}
