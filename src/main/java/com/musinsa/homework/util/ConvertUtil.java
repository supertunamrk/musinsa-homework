package com.musinsa.homework.util;

import java.math.BigDecimal;

public final class ConvertUtil {
    private ConvertUtil() {
    }

    public static BigDecimal toBigDecimal(String target) {
        return new BigDecimal(target);
    }
}