package com.musinsa.homework.controller.advice;

import com.musinsa.homework.dto.response.ApiResponse;
import com.musinsa.homework.exception.ApiRuntimeException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseModelAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();

        if (body instanceof ApiRuntimeException) {
            apiResponse.setHeader((ApiRuntimeException) body);
            apiResponse.setBody(null);
        } else if (body instanceof ApiResponse) {
            apiResponse = (ApiResponse) body;
        } else {
            apiResponse.setBody(body);
        }

        return new MappingJacksonValue(apiResponse);
    }
}