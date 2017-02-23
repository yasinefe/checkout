package com.yefe.test.checkout.domain;

import java.math.BigDecimal;

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
        return new Price(sku, BigDecimal.valueOf(price));
    }

    public static Price createPrice(String sku, double price, SpecialPrice specialPrice) {
        return new Price(sku, BigDecimal.valueOf(price), specialPrice);
    }

    public BigDecimal calculateTotalAmount(int quantity) {
        if (specialPrice != null) {
            return specialPrice.calculateTotalAmount(price, quantity);
        }
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getSku() {
        return sku;
    }
}
