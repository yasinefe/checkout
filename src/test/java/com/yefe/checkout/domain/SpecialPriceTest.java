package com.yefe.checkout.domain;

import com.yefe.checkout.ObjectMother;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class SpecialPriceTest {

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs1() {
        BigDecimal total = ObjectMother.SPECIAL_PRICE_FOR_A.calculateTotalAmount(BigDecimal.valueOf(50), 1);

        TestCase.assertEquals(50, total.doubleValue(), ObjectMother.DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs3() {
        BigDecimal total = ObjectMother.SPECIAL_PRICE_FOR_A.calculateTotalAmount(BigDecimal.valueOf(50), 3);

        TestCase.assertEquals(130, total.doubleValue(), ObjectMother.DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs4() {
        BigDecimal total = ObjectMother.SPECIAL_PRICE_FOR_A.calculateTotalAmount(BigDecimal.valueOf(50), 4);

        TestCase.assertEquals(180, total.doubleValue(), ObjectMother.DELTA);
    }

    @Test
    public void shouldCalculateTotalAmountWhenQuantityIs7() {
        BigDecimal total = ObjectMother.SPECIAL_PRICE_FOR_A.calculateTotalAmount(BigDecimal.valueOf(50), 7);

        TestCase.assertEquals(310, total.doubleValue(), ObjectMother.DELTA);
    }

}
