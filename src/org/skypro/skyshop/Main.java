package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
public class Main {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Яблоко", 50);
        Product product2 = new DiscountedProduct("Банан", 70, 10);
        Product product3 = new FixPriceProduct("Апельсин");
        Product product4 = new SimpleProduct("Мандарин", 80);
        Product product5 = new DiscountedProduct("Виноград", 150, 20);
        Product product6 = new FixPriceProduct("Арбуз");

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продукта в корзину.");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct(product6);


        System.out.println("Печать содержимого корзины с несколькими товарами.");
        basket.printBasket();

        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Поиск товара, который есть в корзине.");
        System.out.println("Есть ли яблоко в корзине: " + basket.containsProduct("Яблоко"));

        System.out.println("Поиск товара, которого нет в корзине.");
        System.out.println("Есть ли груша в корзине: " + basket.containsProduct("Груша"));

        System.out.println("Очистка корзины.");
        basket.clearBasket();

        System.out.println("Печать содержимого пустой корзины.");
        basket.printBasket();

        System.out.println("Получение стоимости пустой корзины.");
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Поиск товара по имени в пустой корзине.");
        System.out.println("Есть ли яблоко в корзине: " + basket.containsProduct("Яблоко"));
    }
}
