package com.forezp.servicehi.dto;

/**
 * 通用返回对象
 * @param <T>
 */
public class ReturnResultDto<T> {

    /**
     * 返回数据对象
     */
    private T data;

    /**
     * 状态码
     */
    private String code;

    private String msg;

    private String exception;

    private Object extras;

    public ReturnResultDto() {
    }

    public T getData() {
        return data;
    }

    public ReturnResultDto<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ReturnResultDto<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnResultDto<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getException() {
        return exception;
    }

    public ReturnResultDto<T> setException(String exception) {
        this.exception = exception;
        return this;
    }

    public Object getExtras() {
        return extras;
    }

    public ReturnResultDto<T> setExtras(Object extras) {
        this.extras = extras;
        return this;
    }
}
