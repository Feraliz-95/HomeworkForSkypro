package org.skypro.skyshop.model.product;

import java.util.UUID;
public class DiscountedProduct extends Product{
    int basePrice;
    int discount;

    public DiscountedProduct(UUID id , String name, int basePrice, int discount) {
        super(id,name);
        this.basePrice = basePrice;
        this.discount = discount;
        if (basePrice < 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Диапозон скидки должен быть от 0 до 100 включительно");
        }
    }
    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
    public int getDiscount() {
        return discount;
    }
    @Override
    public String toString() {
        return getName() + " со скидкой: " + getPrice() + " (" + discount + "%)";
    }
    @Override
    public String getSearchableName() {
        // Верните название, по которому продукт может быть найден
        return "Скидочный продукт";  // Замените на нужное значение
    }
}