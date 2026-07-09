package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final UUID id;
    String name;

    public Product(UUID id ,String name) {
        this.id = id;
        this.name = name;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ввод не может быть пустым");
        }
    }
    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getSearchTerm() {
        return name.toLowerCase(); // Поиск по имени товара
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента — PRODUCT
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}