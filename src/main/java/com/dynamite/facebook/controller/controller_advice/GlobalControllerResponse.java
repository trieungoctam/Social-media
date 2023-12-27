package com.dynamite.facebook.controller.controller_advice;


import com.dynamite.facebook.base.BaseResponseBody;
import com.dynamite.facebook.constant.ResponseValue;
import io.micrometer.common.lang.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(value = {"com.dynamite.HelloWorldNgocTam"})
public class GlobalControllerResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public BaseResponseBody<?> beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof BaseResponseBody) {
            return (BaseResponseBody<?>) body;
        }
        return new BaseResponseBody<>(ResponseValue.SUCCESS, body);
    }
}
