package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product  {
    private static final int FIXED_PRICE = 90;

    public FixPriceProduct(UUID id, String name) {
        super(id,name);
    }
    @Override
    public int getPrice() {
        return 0;
    }

    public int getFixedPrice() {
        return FIXED_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return name + " c фиксированной ценой: Фиксировання цена " + FixPriceProduct.FIXED_PRICE;
    }

    @Override
    public String getSearchableName() {
        // Здесь вы должны вернуть имя, по которому продукт будет искаться
        return "Имя продукта";  // Замените на нужное значение
    }
}