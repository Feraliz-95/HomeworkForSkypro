package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

import java.util.Objects;


public abstract class Product implements Searchable, Comparable<Product> {
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
    @Override
    public int compareTo(Product other) {
        // Такая же логика сравнения, как в компараторе
        int lengthCompare = Integer.compare(other.getName().length(), this.getName().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return this.getName().compareTo(other.getName());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


}