package com.yefe.checkout.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String sku) {
        super("Price not found for sku: " + sku);
    }
}
