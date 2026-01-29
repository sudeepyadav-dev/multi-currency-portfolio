package com.healthcare.tradingportfolio.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for handling money related operations.
 * Keeps rounding logic in one place.
 */
public final class MoneyUtil {

    // Default scale for money values (2 decimal places)
    private static final int SCALE = 2;

    // Private constructor to prevent object creation
    private MoneyUtil() {
        // utility class, no object needed
    }

    /**
     * Rounds the given amount to the default scale.
     * If amount is null, returns zero.
     */
    public static BigDecimal scale(BigDecimal amount) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return amount.setScale(SCALE, RoundingMode.HALF_UP);
    }
}
