package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        loadTestData();
    }

    public Collection<Product> getAllProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public Collection<Article> getAllArticles() {
        return Collections.unmodifiableCollection(articles.values());
    }

    // Новый метод для поиска
    public List<Searchable> getAllSearchableItems() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(getAllArticles());
        result.addAll(getAllProducts());
        return result;
    }

    private void loadTestData() {
        // Генерируем UUID для каждого объекта
        UUID p1Id = UUID.randomUUID();
        UUID p2Id = UUID.randomUUID();
        UUID p3Id = UUID.randomUUID();
        // Создаём продукты с UUID
        SimpleProduct simpleProduct = new SimpleProduct(p1Id, "Ноутбук", 15000);
        DiscountedProduct discountedProduct = new DiscountedProduct(p2Id, "Мышь беспроводная", 1300, 15);
        FixPriceProduct fixPriceProduct = new FixPriceProduct(p3Id, "Клавиатура");

        products.put(p1Id, simpleProduct);
        products.put(p2Id, discountedProduct);
        products.put(p3Id, fixPriceProduct);

        //Статьи
        UUID a1Id = UUID.randomUUID();
        UUID a2Id = UUID.randomUUID();

        Article article1 = new Article(a1Id, "Как выбрать ноутбук", "Советы по выбору ноутбука: процессор, экран, батарея");
        Article article2 = new Article(a2Id, "Обзор беспроводных мышей", "Сравнение популярных моделей и удобство использования");

        articles.put(a1Id, article1);
        articles.put(a2Id, article2);

    }

}