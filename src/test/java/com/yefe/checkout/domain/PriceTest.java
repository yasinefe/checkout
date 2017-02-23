package com.yefe.checkout.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static com.yefe.checkout.ObjectMother.*;
import static com.yefe.checkout.ObjectMother.PRICE_C;
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
