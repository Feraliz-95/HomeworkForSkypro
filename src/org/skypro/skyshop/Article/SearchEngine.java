package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    // Список для хранения searchable объектов
    private final List<Searchable> items;

    public SearchEngine() {
        this.items = new ArrayList<>();
    }

    public void add(Searchable item) {
        items.add(item);
    }

    // Метод поиска, возвращающий все соответствующие результаты
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        if (query == null || query.isEmpty()) {
            return results; // Возвращаем пустой список, если запрос пуст
        }

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }

        return results; // Возвращаем все найденные результаты
    }

    // Метод для нахождения лучшего совпадения, как и раньше
    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        // Обработка крайних случаев
        if (items == null || items.isEmpty() || search == null || search.isEmpty()) {
            return null;
        }
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            int count = countOccurrences(term, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Подходящий объект не найден для запроса: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        if (text == null || search == null || text.isEmpty() || search.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int occurrenceIndex;

        occurrenceIndex = text.indexOf(search, index);

        while (occurrenceIndex != -1) {
            count++;
            index = occurrenceIndex + search.length();
            occurrenceIndex = text.indexOf(search, index);
        }

        return count;
    }
}

