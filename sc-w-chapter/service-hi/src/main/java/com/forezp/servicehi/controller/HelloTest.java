package com.forezp.servicehi.controller;

import com.forezp.servicehi.dto.ReturnResultDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.forezp.servicehi.util.ReturnResultUtil.handleSuccess;

/**
 * @author wjj
 * @date 2019/7/22
 */
@Api(value = "spring-cloud测试接口", tags = {"测试接口"})
@RestController
@RequestMapping("/helloTest")
public class HelloTest {

    @Value("${server.port}")
    private String port;

    @ApiOperation(value = "说话接口", notes = "说话接口")
    @GetMapping("/sayHello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "words", required = true, dataType = "string", paramType = "query")
    })
    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(@RequestParam(name = "words", defaultValue = "helloWorld") String words) {
        return "Say " + words + " ,I'm from port" + port;
    }

    public String helloError(String words) {
        return "Say," + words + ",sorry,error!";
    }

    @ApiOperation(value = "测试hi", notes = "测试Hi")
    @GetMapping("testHi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", dataType = "string", paramType = "query")
    })
    public ReturnResultDto<String> testHi(@RequestParam(name ="content") String content){
        Assert.hasText(content,"说话内容不能为空");
        String data = "Hi,"+ content+" , I'm from port "+ port;
        return handleSuccess(data,"查询成功");
    }
}
