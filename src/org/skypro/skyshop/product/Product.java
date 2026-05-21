package org.skypro.skyshop.product;

public class Product {
        // Поля для хранения названия и стоимости продукта
        private  String name;
        private  int price;

        // Конструктор
        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        // Геттер для названия продукта
        public String getName() {
            return name;
        }

        // Геттер для стоимости продукта
        public int getPrice() {
            return price;
        }
    }

