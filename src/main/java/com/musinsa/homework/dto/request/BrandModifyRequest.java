package com.musinsa.homework.dto.request;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import org.apache.commons.lang3.StringUtils;

public record BrandModifyRequest(String titleKr, String titleEn, String modifiedBy) {
    public void checkValid() {
        if (StringUtils.isAnyBlank(titleKr, titleEn, modifiedBy)) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }
    }
}