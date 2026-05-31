package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name);
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
}
