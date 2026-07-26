package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items list cannot be null");
        }

        // Создаём копию и делаем список неизменяемым для защиты внутреннего состояния
        this.items = Collections.unmodifiableList(new java.util.ArrayList<>(items));

        // Считаем общую стоимость корзины через Stream API
        this.total = items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}