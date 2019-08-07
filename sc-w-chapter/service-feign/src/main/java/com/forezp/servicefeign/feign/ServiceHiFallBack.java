package com.forezp.servicefeign.feign;

import org.springframework.stereotype.Component;

/**
 * @author wjj
 * @date 2019/7/23
 */
@Component
public class ServiceHiFallBack implements ServiceHiFeign {

    @Override
    public String sayHello(String words) {
        return "Sorry," + words + " error";
    }
}
