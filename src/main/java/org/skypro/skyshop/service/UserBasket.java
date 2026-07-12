package org.skypro.skyshop.service;

import java.util.List;
import java.util.Objects;

public final class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        Objects.requireNonNull(items, "Items list cannot be null");
        // Создаем неизменяемую копию списка
        this.items = List.copyOf(items);

        // Считаем общую стоимость через StreamAPI: цена * количество для каждого товара
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