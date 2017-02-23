package com.yefe.checkout;

import com.yefe.checkout.domain.SpecialPrice;
import com.yefe.checkout.domain.Price;

import java.util.Arrays;
import java.util.List;

import static com.yefe.checkout.domain.Price.createPrice;

public class ObjectMother {

    public static final double DELTA = 0.001;

    // I kept following sample prices as same as the test document to make the tests easy to read
    // for specifically this test
    // Normally, I would have PRICE, PRICE_BUY_ONE_GET_ONE_FREE, PRICE_3_FOR_130, PRICE_WITH_PRECISION etc.
    // I would give more self explained names

    public static final SpecialPrice SPECIAL_PRICE_FOR_A = SpecialPrice.createSpecialPrice(3, 130);
    public static final SpecialPrice SPECIAL_PRICE_FOR_B = SpecialPrice.createSpecialPrice(2, 45);

    public static final Price PRICE_A = createPrice("A", 50, SPECIAL_PRICE_FOR_A);
    public static final Price PRICE_B = createPrice("B", 30, SPECIAL_PRICE_FOR_B);
    public static final Price PRICE_C = createPrice("C", 20);
    public static final Price PRICE_D = createPrice("D", 15);

    public static List<Price> createPriceList() {
        return Arrays.asList(PRICE_A, PRICE_B, PRICE_C, PRICE_D);
    }

}
