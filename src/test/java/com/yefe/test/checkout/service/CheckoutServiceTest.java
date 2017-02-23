package com.yefe.test.checkout.service;


import com.yefe.test.checkout.TestUtils;
import com.yefe.test.checkout.domain.Price;
import com.yefe.test.checkout.exception.PriceNotFoundException;
import com.yefe.test.checkout.service.CheckoutService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.yefe.test.checkout.TestUtils.*;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class CheckoutServiceTest {

    private CheckoutService checkoutService;

    @Before
    public void setUp() {
        checkoutService = new CheckoutService();
    }

    @Test
    public void shouldReturnZeroAmountWhenThereIsNoItemInCheckout() {
        getTotalAndAssertWith(0);
    }

    @Test(expected = PriceNotFoundException.class)
    public void shouldThrowPriceNotFoundExceptionIfSkuIsNotPresentInList() {
        checkoutService.add("some-sku");
        checkoutService.totalOfTransaction(emptyList());
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenOnlyOneSkuIsInCheckout() {
        addItem(PRICE_A);

        getTotalAndAssertWith(50);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenMultipleDifferentItemAreInCheckout() {
        addItem(PRICE_A, PRICE_B, PRICE_C);

        getTotalAndAssertWith(100);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenMultipleSameItemAreInCheckout() {
        addItem(PRICE_C, PRICE_C, PRICE_C);

        getTotalAndAssertWith(60);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs1() {
        addItem(PRICE_A);

        getTotalAndAssertWith(50);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs3() {
        addItem(PRICE_A, PRICE_A, PRICE_A);

        getTotalAndAssertWith(130);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs4() {
        addItem(PRICE_A, PRICE_A, PRICE_A, PRICE_A);

        getTotalAndAssertWith(180);
    }

    private void addItem(Price... prices) {
        Arrays.asList(prices).stream().forEach(price -> checkoutService.add(price.getSku()));
    }

    private void getTotalAndAssertWith(double expectedAmount) {
        double total = checkoutService.totalOfTransaction(createPriceList());
        assertEquals(expectedAmount, total, TestUtils.DELTA);
    }
}