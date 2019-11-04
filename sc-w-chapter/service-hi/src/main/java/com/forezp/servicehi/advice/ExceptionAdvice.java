package com.forezp.servicehi.advice;

import com.forezp.servicehi.dto.ReturnResultDto;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.forezp.servicehi.util.ReturnResultUtil.handleException;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ReturnResultDto<?> handleHttpJson(Exception e){
        return handleException(e,"json数据格式不正确,无法解析");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ReturnResultDto<?> handleAssertException(Exception e){
        return handleException(e,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ReturnResultDto<?> handleCommonException(Exception e){
        return handleException(e,"操作失败");
    }
}
