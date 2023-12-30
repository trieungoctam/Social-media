package com.dynamite.facebook.base;

import com.dynamite.facebook.constant.ResponseValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class BaseResponse<T> extends ResponseEntity<BaseResponseBody<T>> {
    public BaseResponse(ResponseValue responseValue){
        super(new BaseResponseBody<>(responseValue.getMessage(), null), responseValue.getStatus());
    }

    public BaseResponse(ResponseValue responseValue, T data){
        super(new BaseResponseBody<>(responseValue, data), responseValue.getStatus());
    }

    public BaseResponse(HttpStatus status, BaseResponseBody<T> body){
        super(body, status);
    }
}