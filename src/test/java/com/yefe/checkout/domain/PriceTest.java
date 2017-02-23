package com.yefe.checkout.domain;

import com.yefe.checkout.ObjectMother;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class PriceTest {

    @Test
    public void shouldCalculateTotalAmountWhenSpecialPriceIsNotPresent() {
        BigDecimal total = ObjectMother.PRICE_C.calculateTotalAmount(5);

        TestCase.assertEquals(100, total.doubleValue(), ObjectMother.DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenSpecialPriceIsPresent() {
        BigDecimal total = ObjectMother.PRICE_A.calculateTotalAmount(3);

        TestCase.assertEquals(130, total.doubleValue(), ObjectMother.DELTA);
    }
}
