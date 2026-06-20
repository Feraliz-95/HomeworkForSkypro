package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> cart;

    public ProductBasket() {
        cart = new HashMap<>();
    }

    public void addProduct(Product product) {
        cart.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Метод для удаления продукта
    public void removeProduct(Product product) {
        List<Product> products = cart.get(product.getName());
        if (products != null) {
            products.remove(product);
            if (products.isEmpty()) {
                cart.remove(product.getName());
            }
        }
    }


    public void printCart() {
        // Перебираем все записи в Map
        for (Map.Entry<String, List<Product>> entry : cart.entrySet()) {
            String productName = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.println("Product Name: " + productName);
            // Вложенный цикл для перебора всех продуктов с одним и тем же именем
            for (Product product : products) {
                System.out.println("Product price: " + product.getPrice());
            }
        }
    }

    public List<Product> getProductsByName(String name) {
        return cart.getOrDefault(name, new ArrayList<>());
    }
}