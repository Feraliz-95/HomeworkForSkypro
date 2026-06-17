import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.BestResultNotFound;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Создаём поисковый движок
        SearchEngine searchEngine = new SearchEngine();




        // Создаём товары
        Product product1 = new SimpleProduct("Яблоко", 50);
        Product product2 = new DiscountedProduct("Банан", 70, 10);
        Product product3 = new FixPriceProduct("Апельсин");
        Product product4 = new SimpleProduct("Мандарин", 80);
        Product product5 = new DiscountedProduct("Виноград", 150, 20);
        Product product6 = new FixPriceProduct("Арбуз");


        // Создаём статьи
        Article article1 = new Article("Польза яблок для здоровья",
                "Яблоки содержат много витаминов и клетчатки. Особенно полезны яблоки " +
                        "для тех, кто следит за фигурой. Яблоки Голден - отличный выбор!");
        Article article2 = new Article("Как выбрать спелый апельсин",
                "Выбирайте апельсины с тонкой кожурой, они обычно самые сочные. Апельсины Валенсия " +
                        "известны своим сладким вкусом.");
        Article article3 = new Article("Рецепты с бананами",
                "Бананы - отличный ингредиент для смузи и десертов. Бананы Кавендиш часто используют в выпечке");
        Article article4 = new Article("Витамины в фруктах",
                "Большинство фруктов содержат витамины группы C и B. Особенно богаты витаминами цитрусовые: апельсины, мандарины.");

        // Добавляем все товары в поисковый движок
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);


        // Добавляем все статьи в поисковый движок
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);


 HW-19
        // Демонстрация проверки данных в классе main
        try {
            SimpleProduct productSimple = new SimpleProduct(" ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());


    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("- " + result.getStringRepresentation());
            } else {
                System.out.println("- (Ничего не найдено)");
            }

        }

        try {
            DiscountedProduct productDiscounted = new DiscountedProduct("Valid Product", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct productS = new SimpleProduct("Product with spaces", 10);
            DiscountedProduct productD = new DiscountedProduct("Another Product", 100, 50);

            // Пример списка товаров

            List<Searchable> products = List.of(product1, product2);

            Searchable bestMatch = searchEngine.findBestMatch("Product", products);

            System.out.println("Лучший подходящий продукт: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        // Изменение метода main
        ProductBasket basket = new ProductBasket();
        Product apple = new SimpleProduct("Яблоко", 10);
        Product banana = new DiscountedProduct("Банан", 15, 25);
        Product orange = new FixPriceProduct("Апельсин");

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);

        // Удаление существующего продукта
        List<Product> removedProducts = basket.removeProductsByName("Яблоко");
        System.out.println("Удаленные продукты: " + removedProducts);
        basket.printBasket();

        // Удаление несуществующего продукта
        removedProducts = basket.removeProductsByName("Груша");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();


        // Добавляем примеры объектов, которые реализуют интерфейс Searchable
        searchEngine.add(new SimpleProduct("Apple", 10));
        searchEngine.add(new SimpleProduct("Banana", 25));
        searchEngine.add(new SimpleProduct("Egg", 110));
        // Выполняем поиск
        String query = "an";
        List<Searchable> results = searchEngine.search(query);

        System.out.println("Результаты поиска для '" + query + "':");
        for (Searchable item : results) {
            System.out.println(item.getSearchTerm());
        }
        // Можно выполнить поиск с другим запросом
        query = "pe";
        results = searchEngine.search(query);
        System.out.println("Результаты поиска для '" + query + "':");
        for (Searchable item : results) {
            System.out.println(item.getSearchTerm());
        }
    }


}

 HW-19












