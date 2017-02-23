package com.yefe.test.checkout.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String sku) {
        super("Price not found for sku: " + sku);
    }
}
