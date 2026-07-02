package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.FixPriceProduct;
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


    // Метод для вычисления общей стоимости корзины
    public int getTotalPrice() {
        return cart.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
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

    //Печатает содержимое корзины.
    public void printCart() {
        long specialCount = getSpecialCount();

        System.out.println("Корзина");
        // Внешний forEach по записям карты (сохраняет группировку по имени)
        cart.forEach((productName, products) -> {
            System.out.println("Product Name: " + productName);
            // Внутренний forEach по списку товаров
            products.forEach(product ->
                    System.out.println("Product price: " + product.getPrice())
            );
        });
        // Подсчёт общего количества товаров через Stream
        long totalItems = cart.values().stream()
                .mapToInt(List::size)
                .sum();

        System.out.println("Всего товаров: " + totalItems);
        System.out.println("Специальных товаров: " + specialCount);
        System.out.println("Полная стоимость: " + getTotalPrice() + " руб.");
    }
    //Приватный метод для подсчёта специальных продуктов.
    private long getSpecialCount() {
        return cart.values().stream()
                .flatMap(Collection::stream)
                .filter(this::isSpecialProduct)
                .count();

 HW-24
    }
    private boolean isSpecialProduct(Product product) {
        return product instanceof FixPriceProduct;
    }


    public List<Product> getProductsByName(String name) {
        return cart.getOrDefault(name, new ArrayList<>());
    }

}




    public List<Product> getProductsByName(String name) {
        return cart.getOrDefault(name, new ArrayList<>());
    }


    }










