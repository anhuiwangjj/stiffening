package com.forezp.servicehi.controller.mobile;

import com.forezp.servicehi.dto.ReturnResultDto;
import com.forezp.servicehi.dto.StudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.forezp.servicehi.util.ReturnResultUtil.handleSuccess;

/**
 * 手持端测试接口
 * @author wjj
 * @date 2019/11/5
 */
@Api(value = "手持端测试接口", tags = {"手持端测试接口"})
@RestController
@RequestMapping("mobile")
public class MobileTestController {

    @ApiOperation(value = "获取基本信息", notes = "获取基本信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query")
    })
    @GetMapping("getBasicInfo")
    public ReturnResultDto<StudentDto> getBasicInfo(@RequestParam(name ="id") String id){
        Assert.hasText(id,"id不能为空");
        StudentDto dto = new StudentDto("1","Jack",18, "301");
        return handleSuccess(dto);
    }
}
