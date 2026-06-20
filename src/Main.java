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











