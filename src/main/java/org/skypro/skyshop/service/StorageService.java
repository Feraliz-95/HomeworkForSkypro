package org.skypro.skyshop.service;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;


@Component
@Service
public class StorageService {
    // Используем изменяемый список внутри, но наружу отдаём неизменяемую обёртку
    private final Map<UUID, Product> products = new HashMap<>();
    private final List<Article> articles = new ArrayList<>();

    public StorageService() {
        seedTestData();
    }

    private void seedTestData() {
        UUID p1Id = UUID.randomUUID();
        UUID p2Id = UUID.randomUUID();
        UUID p3Id = UUID.randomUUID();

        Product p1 = new SimpleProduct(p1Id, "Ноутбук", 15000);
        Product p2 = new DiscountedProduct(p2Id, "Мышь беспроводная", 1300, 15);
        Product p3 = new FixPriceProduct(p3Id, "Клавиатура");

        products.put(p1Id, p1);
        products.put(p2Id, p2);
        products.put(p3Id, p3);


        UUID a1Id = UUID.randomUUID();
        UUID a2Id = UUID.randomUUID();
        UUID a3Id = UUID.randomUUID();

        articles.add(new Article(a1Id, "Как выбрать ноутбук", "Подробное руководство..."));
        articles.add(new Article(a2Id, "Обзор беспроводной мыши", "Тестируем модели..."));
        articles.add(new Article(a3Id, "Топ-5 клавиатур 2026", "Подборка лучших..."));
    }

    public Collection<Searchable> getAllSearchableItems() {
        List<Searchable> allItems = new ArrayList<>(products.values());
        allItems.addAll(articles);
        return allItems;
    }
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    public Collection<Product> getAllProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public Collection<Article> getAllArticles() {
        return Collections.unmodifiableCollection(articles);
    }
}