
package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапозоне от 0 до 100 включительно");
        }
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discountPercentage) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercentage + "%)";
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
