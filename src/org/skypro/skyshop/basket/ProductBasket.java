package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : basket) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int specialItemsCount = 0;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
                if (product.isSpecial()) {
                    specialItemsCount++;
                }
            }
        }

        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialItemsCount);
        }
    }

    public boolean containsProduct(String productName) {
        for (Product product : basket) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(basket, null);
    }
}


