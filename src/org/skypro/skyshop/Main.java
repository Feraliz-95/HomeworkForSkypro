package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Создаём объект SearchEngine с максимальным количеством результатов 10
        SearchEngine searchEngine = new SearchEngine(10);

        // Создаём товары для проверки
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

        // Добавляем все товары в SearchEngine
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        // Добавляем все статьи в SearchEngine
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        // Демонстрируем функциональность поиска с разными запросами
        System.out.println("=== ДЕМОНСТРАЦИЯ ФУНКЦИОНАЛЬНОСТИ ПОИСКА ===");

        // Поиск по слову "яблок"
        System.out.println("\nРезультаты поиска по запросу 'яблок':");
        Searchable[] results1 = searchEngine.search("яблок");
        System.out.println(Arrays.toString(results1));

        // Поиск по слову "апельсин"
        System.out.println("\nРезультаты поиска по запросу 'апельсин':");
        Searchable[] results2 = searchEngine.search("апельсин");
        System.out.println(Arrays.toString(results2));

        // Поиск по слову "банан"
        System.out.println("\nРезультаты поиска по запросу 'банан':");
        Searchable[] results3 = searchEngine.search("банан");
        System.out.println(Arrays.toString(results3));

        // Поиск по слову "витамин"
        System.out.println("\nРезультаты поиска по запросу 'витамин':");
        Searchable[] results4 = searchEngine.search("Мандарин");
        System.out.println(Arrays.toString(results4));

        // Поиск по слову "кавендиш"
        System.out.println("\nРезультаты поиска по запросу 'виноград':");
        Searchable[] results5 = searchEngine.search("виноград");
        System.out.println(Arrays.toString(results5));

        // Поиск по несуществующему слову "ананас"
        System.out.println("\nРезультаты поиска по запросу несуществующему 'ананас':");
        Searchable[] results6 = searchEngine.search("апельсин");
        System.out.println(Arrays.toString(results6));

        // Дополнительный поиск по слову "цитрусовые"
        System.out.println("\nРезультаты поиска по запросу 'цитрусовые':");
        Searchable[] results7 = searchEngine.search("");
        System.out.println(Arrays.toString(results7));
    }
}


