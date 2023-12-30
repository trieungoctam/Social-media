package com.dynamite.facebook.base;

import com.dynamite.facebook.constant.ResponseValue;
import lombok.Data;

@Data
public class BaseResponseBody<T> {
    private String message;
    private T data;
    BaseResponseBody(){
    }

    public BaseResponseBody(String message, T data){
        this.message = message;
        this.data = data;
    }

    public BaseResponseBody(ResponseValue responseValue, T data){
        this(responseValue.getMessage(), data);
    }

    public BaseResponseBody(ResponseValue responseValue){
        this(responseValue.getMessage(), null);
    }
}