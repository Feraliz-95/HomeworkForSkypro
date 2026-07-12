package org.skypro.skyshop.service;


import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket basket;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket basket, StorageService storageService) {
        this.basket = basket;
        this.storageService = storageService;
    }
    public void addProductToBasket(UUID productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        Optional<Product> productOpt = storageService.getProductById(productId);

        if (!productOpt.isPresent()) {
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        }

        // Продукт найден — добавляем в сессионную корзину
        basket.addProduct(productId);
    }
    public UserBasket getUserBasket() {
        var items = basket.getContents().entrySet().stream()
                .flatMap(entry -> {
                    UUID id = entry.getKey();
                    int qty = entry.getValue();

                    Optional<Product> opt = storageService.getProductById(id);
                    if (opt.isEmpty()) {
                        // Товар удалён из хранилища — не показываем его в корзине
                        return java.util.stream.Stream.empty();
                    }

                    return java.util.stream.Stream.of(new BasketItem(opt.get(), qty));
                })
                .collect(Collectors.toList());

        return new UserBasket(items);
    }
}

