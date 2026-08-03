package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;

import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }
    public void addToBasket(UUID productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Optional<Product> productOpt = storageService.getProductById(productId);
        if (!productOpt.isPresent()) {
            // Здесь теперь выбрасываем кастомное исключение
            throw new NoSuchProductException("Product with id " + productId + " not found");
        }

        productBasket.addProduct(productId);
    }

    public Map<UUID, Integer> getBasketContents() {
        return productBasket.getItems();
    }
    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getItems();

        List<BasketItem> items = basketMap.entrySet().stream()
                // Оставляем только товары, которые ещё есть в хранилище
                .filter(entry -> storageService.getProductById(entry.getKey()).isPresent())
                .map(entry -> {
                    Product product = storageService.getProductById(entry.getKey())
                            .orElseThrow(); // безопасно: фильтр выше уже гарантирует наличие
                    return new BasketItem(product, entry.getValue());
                })
                .collect(Collectors.toList());

        return new UserBasket(items);
    }
}

