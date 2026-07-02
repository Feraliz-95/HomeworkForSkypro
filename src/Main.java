import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.BestResultNotFound;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Создаём поисковый движок

        Set<Searchable> items = new HashSet<>();
        items.add(new Article("Java", "Basics"));
        items.add(new Article("JavaScript", "JavaScript for beginners"));
        items.add(new Article("Java Advanced", "Programming"));
        items.add(new SimpleProduct("Apple", 28));// будет добавлен
        items.add(new SimpleProduct("Apple", 28));// не будет добавлен, дубликат
        items.add(new SimpleProduct("Banana", 55));
        items.add(new DiscountedProduct("kiwi", 100, 25));
        items.add(new FixPriceProduct("egg"));
        // Вывод результатов поиска
        System.out.println("Список статей и продуктов:");
        for (Object item : items) {
            System.out.printf("- %s%n", item);


        }
    }
}





