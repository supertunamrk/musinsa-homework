package com.musinsa.homework.dto.response;

import com.musinsa.homework.exception.ApiRuntimeException;

public class ApiResponse<T> {
    private ApiHeader header;
    private T body;

    public ApiResponse() {
        header = new ApiHeader();
    }

    public ApiResponse(T body) {
        this.header = new ApiHeader();
        this.body = body;
    }

    public ApiResponse(ApiHeader apiHeader, T body) {
        this.header = apiHeader;
        this.body = body;
    }

    public ApiHeader getHeader() {
        return header;
    }

    public void setHeader(ApiHeader header) {
        this.header = header;
    }

    public void setHeader(ApiRuntimeException apiRuntimeException) {
        header = new ApiHeader(apiRuntimeException);
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
