package com.yefe.checkout.domain;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class Price {

    private String sku;
    private BigDecimal price;
    private SpecialPrice specialPrice;

    private Price(String sku, BigDecimal price) {
        this.sku = sku;
        this.price = price;
    }

    private Price(String sku, BigDecimal price, SpecialPrice specialPrice) {
        this(sku, price);
        this.specialPrice = specialPrice;
    }

    public static Price createPrice(String sku, double price) {
        return new Price(sku, valueOf(price));
    }

    public static Price createPrice(String sku, double price, SpecialPrice specialPrice) {
        return new Price(sku, valueOf(price), specialPrice);
    }

    public BigDecimal calculateTotalAmount(int quantity) {
        if (specialPrice != null) {
            return specialPrice.calculateTotalAmount(price, quantity);
        }
        return price.multiply(valueOf(quantity));
    }

    public String getSku() {
        return sku;
    }
}
