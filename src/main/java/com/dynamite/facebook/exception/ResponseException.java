package com.dynamite.facebook.exception;

import com.dynamite.facebook.base.BaseResponseBody;
import com.dynamite.facebook.constant.ResponseValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseException extends Exception{
    private HttpStatus status;
    private BaseResponseBody<?> body;
    private ResponseValue responseValue;

    public ResponseException(){
    }

    public <T> ResponseException(ResponseValue responseValue){
        this(responseValue, null);
    }

    public ResponseException(HttpStatus status, BaseResponseBody<?> body){
        this.status = status;
        this.body = body;
    }
    public ResponseException(ResponseValue responseValue, BaseResponseBody<?> body){
        this(responseValue.getStatus(), new BaseResponseBody<>(responseValue, body));
        this.responseValue = responseValue;
    }
}
