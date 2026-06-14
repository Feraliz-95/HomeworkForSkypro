package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
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

        int count = 0;  // количество вхождений
        int index = 0;   // текущий индекс поиска
        int occurrenceIndex;  // индекс найденного вхождения

        // Первое вхождение
        occurrenceIndex = text.indexOf(search, index);


        // Цикл пока есть вхождения
        while (occurrenceIndex != -1) {
            count++;  // увеличиваем счётчик вхождений
            index = occurrenceIndex + search.length();  // перемещаем индекс за найденное вхождение
            occurrenceIndex = text.indexOf(search, index);  // ищем следующее вхождение
        }

        return count;
    }

    private final Searchable[] items;
    private int currentSize = 0;
    private static final int MAX_RESULTS = 5;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (currentSize < items.length) {
            items[currentSize++] = item;
        }
    }

    public Searchable[] search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
                if (results.size() >= MAX_RESULTS) {
                    break;
                }
            }
        }

        // Преобразуем в массив фиксированного размера (5 элементов)
        Searchable[] resultArray = new Searchable[MAX_RESULTS];
        for (int i = 0; i < Math.min(results.size(), MAX_RESULTS); i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }
}