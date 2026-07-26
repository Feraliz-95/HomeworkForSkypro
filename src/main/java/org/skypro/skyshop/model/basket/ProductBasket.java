package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> items;

    public ProductBasket() {
        // Инициализируем внутреннюю мапу как обычный HashMap — он будет изменяться внутри класса
        this.items = new HashMap<>();
    }

    /*
            * Добавляет товар в корзину.
            * Если товар уже есть — увеличивает количество на 1.
            * @param productId UUID товара
     */
    public void addProduct(UUID productId) {
        if (productId == null) {
            return; // или можно выбросить IllegalArgumentException, если нужна строгая валидация
        }
        items.put(productId, items.getOrDefault(productId, 0) + 1);
    }

    /*
            * Возвращает неизменяемую копию содержимого корзины.
     * Это защищает внутреннюю мапу от внешних изменений.
     */
    public Map<UUID, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }
}