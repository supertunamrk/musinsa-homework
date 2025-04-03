package com.musinsa.homework.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.musinsa.homework.exception.ApiRuntimeException;

@JsonPropertyOrder({"isSuccessful", "errorCode", "errorMessage"})
public class ApiHeader {
    private boolean successful;
    private String errorCode;
    private String errorMessage;

    public ApiHeader() {
        successful = true;
        errorCode = null;
        errorMessage = null;
    }

    public ApiHeader(ApiRuntimeException apiRuntimeException) {
        successful = apiRuntimeException.isSuccessful();
        errorCode = apiRuntimeException.getErrorCode();
        errorMessage = apiRuntimeException.getErrorMessage();
    }

    @JsonProperty("isSuccessful")
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}