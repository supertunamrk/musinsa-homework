package com.musinsa.homework.dto.request;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

public record ProductModifyRequest(Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD,
                                   String modifiedBy) {
    public void checkValid() {
        if (ObjectUtils.anyNull(brandId, categoryId, basePriceKRW, basePriceUSD)) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        if (StringUtils.isBlank(modifiedBy) || !NumberUtils.isCreatable(basePriceUSD)) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        if (brandId < 1L || categoryId < 1L || basePriceKRW <= 0 || new BigDecimal(basePriceUSD).compareTo(BigDecimal.ZERO) < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }
    }
}