package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
public class App {
    public static void main(String[] args) {
        // Создаем продукцию
                Product apple = new Product("Яблоко", 100);
                Product banana = new Product("Банан", 150);
                Product orange = new Product("Апельсин", 200);
                Product kiwi = new Product("Киви", 250);
                Product mango = new Product("Манго", 300);
                Product grape = new Product("Виноград", 350); // Этот продукт не будет добавлен из-за ограничения

                // Создаем корзину
                ProductBasket basket = new ProductBasket();

                // Добавляем продукты в корзину
                basket.addProduct(apple);
                basket.addProduct(banana);
                basket.addProduct(orange);
                basket.addProduct(kiwi);
                basket.addProduct(mango);
                basket.addProduct(grape); // Поскольку корзина уже полна, этот продукт не будет добавлен

                // Печатаем содержимое корзины
                basket.printContents();
        System.out.println("Корзина содержит яблоко: " + basket.containsProduct("Яблоко"));
        System.out.println("Корзина содержит ананас: " + basket.containsProduct("Ананас"));

        // Очищаем корзину
        basket.clearBasket();
        System.out.println("Корзина очищена.");

        // Печатаем содержимое корзины после очистки
        basket.printContents();
            }
        }
