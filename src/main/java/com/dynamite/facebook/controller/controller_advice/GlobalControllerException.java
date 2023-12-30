package com.dynamite.facebook.controller.controller_advice;

import com.dynamite.facebook.base.BaseResponse;
import com.dynamite.facebook.base.BaseResponseBody;
import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(value = {"com.dynamite.facebook"})
public class GlobalControllerException{
    @ExceptionHandler(ResponseException.class)
    @ResponseBody
    public BaseResponse<?> handleException(ResponseException e) {
        return new BaseResponse<>(e.getStatus(), e.getBody());
    }
}
