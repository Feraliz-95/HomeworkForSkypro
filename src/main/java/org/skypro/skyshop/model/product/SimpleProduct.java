package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    int price;

    public SimpleProduct(UUID id, String name, int price) {
        super(id,name);
        this.price = price;
        if (price < 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
    }

   @Override
    public int getPrice() {
        return price;
    }
   @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public String getSearchableName() {
        // Верните имя продукта, которое вы хотите использовать для поиска
        return name;  // Или любое другое соответствующее значение
    }
}