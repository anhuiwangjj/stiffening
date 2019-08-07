package com.forezp.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wjj
 * @date 2019/7/22
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String words) {
        return restTemplate.getForObject("http://SERVICE-HI/helloTest/sayHello?words=" + words, String.class);
    }

    public String hiError(String words) {
        return "Hi," + words + " ,sorry error!";
    }
}
