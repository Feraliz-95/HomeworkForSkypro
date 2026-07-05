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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

        List<Searchable> products = new ArrayList<>();
        products.add(new SimpleProduct("Banana", 28));
        products.add(new DiscountedProduct("Apple", 100, 25));
        products.add(new FixPriceProduct("Orange"));
        products.add(new SimpleProduct("Apple", 100)); // Можно добавить несколько одинаковых продуктов

        SearchEngine searchEngine = new SearchEngine();
        Map<String, Searchable> searchResults = searchEngine.search(products);

        // Вывод результатов поиска
        System.out.println("Search Results (sorted by name):");
        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
            String productName = entry.getKey();
            Product product = (Product) entry.getValue(); // Приведение типа обратно к Product
            System.out.println("Product Name: " + productName + ", Price: " + product.getPrice());
        }
    }
}













