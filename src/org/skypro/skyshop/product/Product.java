package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

public abstract class Product implements Searchable {
    protected final String name;

    protected Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
        }
        this.name = name;
    }


    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Product {name= '" + name + "'}";
    }
}



