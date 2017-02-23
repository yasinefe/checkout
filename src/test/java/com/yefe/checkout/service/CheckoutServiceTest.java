package com.yefe.checkout.service;


import com.yefe.checkout.ObjectMother;
import com.yefe.checkout.domain.Price;
import com.yefe.checkout.exception.PriceNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        addItem(ObjectMother.PRICE_A);

        getTotalAndAssertWith(50);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenMultipleDifferentItemAreInCheckout() {
        addItem(ObjectMother.PRICE_A, ObjectMother.PRICE_B, ObjectMother.PRICE_C);

        getTotalAndAssertWith(100);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenMultipleSameItemAreInCheckout() {
        addItem(ObjectMother.PRICE_C, ObjectMother.PRICE_C, ObjectMother.PRICE_C);

        getTotalAndAssertWith(60);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs1() {
        addItem(ObjectMother.PRICE_A);

        getTotalAndAssertWith(50);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs3() {
        addItem(ObjectMother.PRICE_A, ObjectMother.PRICE_A, ObjectMother.PRICE_A);

        getTotalAndAssertWith(130);
    }

    @Test
    public void shouldReturnCorrectTotalAmountWhenItemHasSpecialPriceAndQuantityIs4() {
        addItem(ObjectMother.PRICE_A, ObjectMother.PRICE_A, ObjectMother.PRICE_A, ObjectMother.PRICE_A);

        getTotalAndAssertWith(180);
    }

    private void addItem(Price... prices) {
        Arrays.asList(prices).stream().forEach(price -> checkoutService.add(price.getSku()));
    }

    private void getTotalAndAssertWith(double expectedAmount) {
        double total = checkoutService.totalOfTransaction(ObjectMother.createPriceList());
        assertEquals(expectedAmount, total, ObjectMother.DELTA);
    }
}