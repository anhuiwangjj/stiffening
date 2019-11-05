package com.forezp.servicehi.util;

import com.forezp.servicehi.dto.ReturnResultDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * 通用返回对象工具类
 * @author wjj
 * @date 2019/11/04
 */
public class ReturnResultUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReturnResultUtil.class);

    public static ReturnResultDto<?> handleException(Exception e,String message){
        return handleException(e,new ReturnResultDto<>(), message);
    }

    public static ReturnResultDto<?> handleException(Exception e,ReturnResultDto<?> result,String message){
        if (e instanceof IllegalArgumentException) {
            message = e.getMessage();
        }
        message = StringUtils.isNotBlank(message)?  message : "失败";
        result.setCode("01");
        result.setMsg(message);
        result.setException(e.getClass().getName()+":"+e.getMessage());
        logger.error(message,e);
        return result;
    }

    public static <T> ReturnResultDto<T> handleSuccess(){
        return handleSuccess(new ReturnResultDto<>(),null,"");
    }

    public static <T> ReturnResultDto<T> handleSuccess(String message) {
        return handleSuccess(new ReturnResultDto<>(), null, message);
    }

    public static <T> ReturnResultDto<T> handleSuccess(T data) {
        return handleSuccess(new ReturnResultDto<>(), data, "");
    }

    public static <T> ReturnResultDto<T> handleSuccess(T data, String message){
        return handleSuccess(new ReturnResultDto<>(), data, message);
    }

    public static <T> ReturnResultDto<T> handleSuccess(T data, Object extras, String message){
        return handleSuccess(new ReturnResultDto<>(), data, extras, message);
    }

    public static <T> ReturnResultDto<T> handleSuccess(ReturnResultDto<T> result, T data, String message){
        message = StringUtils.isNotBlank(message)? message : "成功";
        result.setCode("00");
        if (Objects.nonNull(data)) {
            result.setData(data);
        }
        result.setMsg(message);
        return result;
    }

    public static <T> ReturnResultDto<T> handleSuccess(ReturnResultDto<T> result, T data, Object extras, String message){
        message = StringUtils.isNotBlank(message)? message : "成功";
        result.setCode("00");
        if (Objects.nonNull(data)) {
            result.setData(data);
        }
        if (Objects.nonNull(extras)) {
            result.setExtras(extras);
        }
        result.setMsg(message);
        return result;
    }
}
