package com.yefe.test.checkout.domain;

import java.math.BigDecimal;

public class Item {

    private Price price;
    private int quantity;

    private Item(Price price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public static Item createItem(Price price, int quantity) {
        return new Item(price, quantity);
    }

    public BigDecimal calculateTotalAmount() {
        return price.calculateTotalAmount(quantity);
    }
}
