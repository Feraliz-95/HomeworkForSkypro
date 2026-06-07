package org.skypro.skyshop.Article;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

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
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }

        private final Searchable[] items;
        private int currentSize = 0;
        private static final int MAX_RESULTS = 5;
    public SearchEngine( int capacity){
            this.items = new Searchable[capacity];
        }

        public void add (Searchable item){
            if (currentSize < items.length) {
                items[currentSize++] = item;
            }
        }

        public Searchable[] search (String query){
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
