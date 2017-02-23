package com.yefe.checkout.service;

import com.yefe.checkout.domain.Item;
import com.yefe.checkout.domain.Price;
import com.yefe.checkout.exception.PriceNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.yefe.checkout.domain.Item.createItem;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class CheckoutService {

    private List<String> skus = new ArrayList<>();

    public void add(String sku) {
        skus.add(sku);
    }

    public double totalOfTransaction(List<Price> priceList) {
        if (skus.isEmpty()) {
            return 0;
        }
        List<Item> items = createItems(priceList);
        return calculateTotalAmount(items).doubleValue();
    }

    private List<Item> createItems(List<Price> priceList) {
        Map<String, Long> skuQuantityMap = skus.stream()
                .collect(groupingBy(item -> item, counting()));

        return skuQuantityMap.entrySet().stream()
                .map(entry -> createItem(findPrice(priceList, entry.getKey()), entry.getValue().intValue()))
                .collect(toList());
    }

    private Price findPrice(List<Price> priceList, String sku) {
        return priceList.stream()
                .filter(price -> price.getSku().equals(sku))
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException(sku));
    }

    private BigDecimal calculateTotalAmount(List<Item> items) {
        return items.stream()
                .map(Item::calculateTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
