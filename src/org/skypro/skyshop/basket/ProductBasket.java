package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
        // Максимальный размер корзины
        private static final int MAX_PRODUCTS = 5;
        // Массив для хранения продуктов
        private Product[] products;
        // Текущий индекс для хранения продукта
        private int currentIndex;

        // Конструктор
        public ProductBasket() {
            this.products = new Product[MAX_PRODUCTS];
            this.currentIndex = 0;
        }

        // Метод добавления продукта в корзину
        public void addProduct(Product product) {
            if (currentIndex < MAX_PRODUCTS) {
                products[currentIndex] = product;
                currentIndex++;
            } else {
                System.out.println("Невозможно добавить продукт");
            }
        }

        // Метод получения общей стоимости корзины
        public int getTotalPrice() {
            int totalPrice = 0;
            for (int i = 0; i < currentIndex; i++) {
                totalPrice += products[i].getPrice();
            }
            return totalPrice;
        }

        // Метод, который печатает содержимое корзины
        public void printContents() {
            if (currentIndex == 0) {
                System.out.println("В корзине пусто.");
                return;
            }

            for (int i = 0; i < currentIndex; i++) {
                System.out.println(products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Итого: " + getTotalPrice());
        }

        // Метод, проверяющий продукт в корзине по имени
        public boolean containsProduct(String productName) {
            for (int i = 0; i < currentIndex; i++) {
                if (products[i].getName().equals(productName)) {
                    return true;
                }
            }
            return false;
        }

        // Метод очистки корзины
        public void clearBasket() {
            for (int i = 0; i < currentIndex; i++) {
                products[i] = null; // Очищаем элемент
            }
            currentIndex = 0; // Обнуляем индекс
        }
    }


