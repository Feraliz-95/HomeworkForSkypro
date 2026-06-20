package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.Product;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    // Список для хранения searchable объектов
    public Map<String, Searchable> search(List<Searchable> items) {
        Map<String, Searchable> result = new TreeMap<>();

        for (Searchable item : items) {
            result.put(item.getName(), item);
        }
        return result;
    }
}

