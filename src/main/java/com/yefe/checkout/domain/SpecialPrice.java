package com.yefe.checkout.domain;

import java.math.BigDecimal;

public class SpecialPrice {

    private int quantity;
    private BigDecimal price;

    private SpecialPrice(int quantity, BigDecimal price) {
        this.quantity = quantity;
        this.price = price;
    }

    public static SpecialPrice createSpecialPrice(int quantity, double price) {
        return new SpecialPrice(quantity, BigDecimal.valueOf(price));
    }

    public BigDecimal calculateTotalAmount(BigDecimal priceForOne, int totalQuantity) {
        int remainedCount = totalQuantity % quantity;
        int groupCount = (totalQuantity - remainedCount) / quantity;

        return price
                .multiply(BigDecimal.valueOf(groupCount))
                .add(priceForOne.multiply(BigDecimal.valueOf(remainedCount)));
    }
}
