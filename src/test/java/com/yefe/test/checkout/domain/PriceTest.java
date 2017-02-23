package com.yefe.test.checkout.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static com.yefe.test.checkout.TestUtils.DELTA;
import static com.yefe.test.checkout.TestUtils.PRICE_A;
import static com.yefe.test.checkout.TestUtils.PRICE_C;
import static junit.framework.TestCase.assertEquals;

public class PriceTest {

    @Test
    public void shouldCalculateTotalAmountWhenSpecialPriceIsNotPresent() {
        BigDecimal total = PRICE_C.calculateTotalAmount(5);

        assertEquals(100, total.doubleValue(), DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenSpecialPriceIsPresent() {
        BigDecimal total = PRICE_A.calculateTotalAmount(3);

        assertEquals(130, total.doubleValue(), DELTA);
    }
}
