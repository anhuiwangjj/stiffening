package com.forezp.servicefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wjj
 * @date 2019/7/23
 */
@Service
@FeignClient(name = "service-hi", fallback = ServiceHiFallBack.class)
public interface ServiceHiFeign {

    /**
     * service-hi say方法实现
     *
     * @param words
     * @return
     */
    @RequestMapping(value = "/helloTest/sayHello", method = RequestMethod.GET)
    String sayHello(@RequestParam(name = "words") String words);
}
