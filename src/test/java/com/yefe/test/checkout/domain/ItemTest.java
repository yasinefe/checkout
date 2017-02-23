package com.yefe.test.checkout.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static com.yefe.test.checkout.TestUtils.DELTA;
import static com.yefe.test.checkout.TestUtils.PRICE_C;
import static junit.framework.TestCase.assertEquals;

public class ItemTest {

    private Item item = Item.createItem(PRICE_C, 5);

    @Test
    public void shouldReturnCalculatedTotalAmount() {
        BigDecimal total = item.calculateTotalAmount();

        assertEquals(100, total.doubleValue(), DELTA);
    }

}