package com.musinsa.homework.dto.request;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import org.apache.commons.lang3.StringUtils;

public record BrandCreateRequest(String titleKr, String titleEn, String registeredBy) {
    public void checkValid() {
        if (StringUtils.isAnyBlank(titleKr, titleEn, registeredBy)) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }
    }
}