package com.yefe.checkout.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static com.yefe.checkout.ObjectMother.DELTA;
import static com.yefe.checkout.ObjectMother.SPECIAL_PRICE_FOR_A;
import static java.math.BigDecimal.valueOf;
import static junit.framework.TestCase.assertEquals;

public class SpecialPriceTest {

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs1() {
        BigDecimal total = SPECIAL_PRICE_FOR_A.calculateTotalAmount(valueOf(50), 1);

        assertEquals(50, total.doubleValue(), DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs3() {
        BigDecimal total = SPECIAL_PRICE_FOR_A.calculateTotalAmount(valueOf(50), 3);

        assertEquals(130, total.doubleValue(), DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs4() {
        BigDecimal total = SPECIAL_PRICE_FOR_A.calculateTotalAmount(valueOf(50), 4);

        assertEquals(180, total.doubleValue(), DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs7() {
        BigDecimal total = SPECIAL_PRICE_FOR_A.calculateTotalAmount(valueOf(50), 7);

        assertEquals(310, total.doubleValue(), DELTA);
    }

}
