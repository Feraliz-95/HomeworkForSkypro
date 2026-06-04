import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
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


        Article article1 = new Article("Польза яблок для здоровья",
                "Яблоки содержат много витаминов и клетчатки. Особенно полезны яблоки " +
                        "для тех, кто следит за фигурой. Яблоки Голден - отличный выбор!");
        Article article2 = new Article("Как выбрать спелый апельсин",
                "Выбирайте апельсины с тонкой кожурой, они обычно самые сочные. Апельсины Валенсия " +
                        "известны своим сладким вкусом.");
        Article article3 = new Article("Рецепты с бананами",
                "Бананы - отличный ингредиент для смузи и десертов.  Бананы Кавендиш часто используют в выпечке");


        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);


        System.out.println("Результаты поиска по запросу 'яблок':");
        printSearchResults(searchEngine.search("яблок"));

        System.out.println("\nРезультаты поиска по запросу 'апельсин':");
        printSearchResults(searchEngine.search("апельсин"));

        System.out.println("\nРезультаты поиска по запросу 'банан':");
        printSearchResults(searchEngine.search("банан"));

        System.out.println("\nРезультаты поиска по запросу 'витамин':");
        printSearchResults(searchEngine.search("витамин"));

        System.out.println("\nРезультаты поиска по запросу 'кавендиш':");
        printSearchResults(searchEngine.search(""));

        System.out.println("\nРезультаты поиска по запросу несуществующему 'ананас':");
        printSearchResults(searchEngine.search(""));
    }



    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("- " + result.getStringRepresentation());
            } else {
                System.out.println("- (Ничего не найдено)");
            }
        }
    }
}

