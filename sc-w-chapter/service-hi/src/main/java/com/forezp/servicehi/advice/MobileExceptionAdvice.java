package com.forezp.servicehi.advice;

import com.forezp.servicehi.dto.ReturnResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 手持端全局异常处理
 * @author wjj
 * @date 2019/11/04
 */

@ControllerAdvice("com.forezp.servicehi.controller.mobile")
@Order(1)
@ResponseBody
public class MobileExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(MobileExceptionAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ReturnResultDto<?> handleAssertException(Exception e){
        ReturnResultDto<?> result = new ReturnResultDto<>();
        String message = e.getClass() + ":" + e.getMessage();
        result.setCode("02");
        result.setMsg(e.getMessage());
        result.setException(message);
        logger.error(message,e);
        return result;
    }
}
