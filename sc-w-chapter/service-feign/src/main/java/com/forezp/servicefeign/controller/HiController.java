package com.forezp.servicefeign.controller;

import com.forezp.servicefeign.feign.ServiceHiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @date 2019/7/23
 */
@RestController
public class HiController {

    @Autowired
    private ServiceHiFeign serviceHiFeign;

    @GetMapping("/sayHello")
    public String sayHello (@RequestParam String words) {
        return serviceHiFeign.sayHello(words);
    }
}
