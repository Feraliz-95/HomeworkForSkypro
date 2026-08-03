package org.skypro.skyshop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;

import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SkyshopApplicationTests {

	@Test
	void contextLoads() {
	}
	@Nested
	@ExtendWith(MockitoExtension.class)
	class SearchServiceTest {

		@InjectMocks
		private SearchService searchService;

		@Mock
		private StorageService storageService;

		private Product product1;
		private Product product2;
		private Article article1;

		@BeforeEach
		void setUp() {
			UUID id1 = UUID.randomUUID();
			UUID id2 = UUID.randomUUID();
			UUID artId = UUID.randomUUID();

			product1 = new SimpleProduct(id1, "Ноутбук игровой", 15000);
			product2 = new DiscountedProduct(id2, "Мышь беспроводная", 1300, 15);
			article1 = new Article(artId, "Как выбрать ноутбук", "Подробное руководство...");
		}

    /*
			* Сценарий 1: В StorageService нет объектов вообще.
     * Ожидаем: пустой список результатов.
     */
		@Test
		void search_whenStorageIsEmpty_returnsEmptyList() {
			when(storageService.getAllSearchableItems()).thenReturn(new ArrayList<>());

			List<SearchResult> results = searchService.search("ноутбук");

			assertThat(results).isEmpty();
		}

    /*
			* Сценарий 2: Объекты есть, но нет подходящих по pattern.
				* Ожидаем: пустой список.
				*/
		@Test
		void search_whenItemsExistButNoMatch_returnsEmptyList() {
			List<Searchable> items = new ArrayList<>();
			items.add(product1);
			items.add(product2);
			items.add(article1);

			when(storageService.getAllSearchableItems()).thenReturn(items);

			// Ищем слово, которого точно нет ни в одном названии
			List<SearchResult> results = searchService.search("холодильник");

			assertThat(results).isEmpty();
		}

    /*
			* Сценарий 3: Есть подходящие объекты — проверяем, что они возвращаются.
     * Ищем по подстроке "ноутбук" — должен найти product1 и article1.
     */
		@Test
		void search_whenMatchingItemsExist_returnsCorrectResults() {
			List<Searchable> items = new ArrayList<>();
			items.add(product1);      // "Ноутбук"
			items.add(product2);      // "Мышь беспроводная"
			items.add(article1);      // "Как выбрать ноутбук"

			when(storageService.getAllSearchableItems()).thenReturn(items);

			List<SearchResult> results = searchService.search("Ноутбук");

			assertThat(results)
					.hasSize(2)
					.extracting("name")
					.containsExactlyInAnyOrder("Ноутбук игровой", "Как выбрать ноутбук");
		}

    /*
			* Дополнительный сценарий: поиск по пустой строке.
				* Если логика SearchService возвращает всё при пустой строке — проверяем это.
				*/
		@Test
		void search_withEmptyPattern_returnsAllItems() {
			List<Searchable> items = new ArrayList<>();
			items.add(product1);
			items.add(product2);
			items.add(article1);

			when(storageService.getAllSearchableItems()).thenReturn(items);

			List<SearchResult> results = searchService.search("");

			assertThat(results).hasSize(3);
		}


	}

	@Nested
	@ExtendWith(MockitoExtension.class)
	class BasketServiceTest {

		@InjectMocks
		private BasketService basketService;

		@Mock
		private ProductBasket productBasket;

		@Mock
		private StorageService storageService;

		private UUID existingProductId;
		private UUID nonExistingProductId;
		private Product existingProduct;

		@BeforeEach
		void setUp() {
			existingProductId = UUID.randomUUID();
			nonExistingProductId = UUID.randomUUID();
			existingProduct = new SimpleProduct(existingProductId, "Ноутбук", 15000);
		}
    /*
			* Сценарий 1: Добавление несуществующего товара → выбрасывается NoSuchProductException.
				*/
		@Test
		void addToBasket_whenProductDoesNotExist_throwsNoSuchProductException() {
			when(storageService.getProductById(nonExistingProductId)).thenReturn(Optional.empty());

			assertThatThrownBy(() -> basketService.addToBasket(nonExistingProductId))
					.isInstanceOf(NoSuchProductException.class)
					.hasMessageContaining(nonExistingProductId.toString());
		}

    /*
			* Сценарий 2: Добавление существующего товара → вызывается productBasket.addProduct(id).
				*/
		@Test
		void addToBasket_whenProductExists_callsProductBasketAddProduct() {
			when(storageService.getProductById(existingProductId)).thenReturn(Optional.of(existingProduct));

			basketService.addToBasket(existingProductId);

			verify(productBasket).addProduct(existingProductId);
		}
    /*
			* Сценарий 3: getUserBasket → пустая корзина, если ProductBasket пуст.
				* Ожидаем: пустой список items и total = 0.
				*/
		@Test
		void getUserBasket_whenProductBasketIsEmpty_returnsEmptyUserBasket() {
			Map<UUID, Integer> emptyMap = Collections.emptyMap();
			when(productBasket.getItems()).thenReturn(emptyMap);

			UserBasket userBasket = basketService.getUserBasket();

			assertThat(userBasket).isNotNull();
			assertThat(userBasket.getItems()).isEmpty();
			assertThat(userBasket.getTotal()).isEqualTo(0.0);
		}
    /*
			* Сценарий 4: getUserBasket → возвращает корзину с товарами, если в ProductBasket есть товары.
				* Проверяем:
				* - в корзине ровно 2 позиции,
				* - присутствуют ожидаемые товары,
				* - total считается корректно (цена × количество).
				*/
		@Test
		void getUserBasket_whenProductBasketHasItems_returnsCorrectUserBasket() {
			UUID p1 = UUID.randomUUID();
			UUID p2 = UUID.randomUUID();

			Product prod1 = new SimpleProduct(p1, "Ноутбук", 10000);
			Product prod2 = new DiscountedProduct(p2, "Мышь", 1300, 10); // цена уже финальная

			// Мокаем StorageService: возвращаем продукты по ID
			when(storageService.getProductById(p1)).thenReturn(Optional.of(prod1));
			when(storageService.getProductById(p2)).thenReturn(Optional.of(prod2));

			// Мокаем ProductBasket: корзина содержит 2 ноутбука и 3 мыши
			Map<UUID, Integer> basketMap = new HashMap<>();
			basketMap.put(p1, 2);
			basketMap.put(p2, 3);
			when(productBasket.getItems()).thenReturn(basketMap);

			UserBasket userBasket = basketService.getUserBasket();

			assertThat(userBasket).isNotNull();

			List<BasketItem> items = userBasket.getItems();
			assertThat(items).hasSize(2);

			// Проверяем, что в корзине есть нужные товары с правильными количествами
			Optional<BasketItem> item1Opt = items.stream()
					.filter(i -> i.getProduct().getId().equals(p1))
					.findFirst();
			Optional<BasketItem> item2Opt = items.stream()
					.filter(i -> i.getProduct().getId().equals(p2))
					.findFirst();

			assertThat(item1Opt).isPresent();
			assertThat(item2Opt).isPresent();

			BasketItem item1 = item1Opt.orElseThrow();
			BasketItem item2 = item2Opt.orElseThrow();

			assertThat(item1.getQuantity()).isEqualTo(2);
			assertThat(item2.getQuantity()).isEqualTo(3);

			// Проверяем total: (10000 * 2) + (1300 * 3) = 20000 + 3900 = 23900
			double expectedTotal = (prod1.getPrice() * 2) + (prod2.getPrice() * 3);
			assertThat(userBasket.getTotal()).isEqualTo(expectedTotal);
		}
	}
}













