package com.yefe.checkout.domain;

import com.yefe.checkout.ObjectMother;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ItemTest {

    private Item item = Item.createItem(ObjectMother.PRICE_C, 5);

    @Test
    public void shouldReturnCalculatedTotalAmount() {
        BigDecimal total = item.calculateTotalAmount();

        TestCase.assertEquals(100, total.doubleValue(), ObjectMother.DELTA);
    }

}