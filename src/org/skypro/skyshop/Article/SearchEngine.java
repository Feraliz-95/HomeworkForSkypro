package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.Product;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    // Список для хранения searchable объектов
    public Set<Searchable> search(Set<Searchable> items) {
        // Создаем TreeSet с кастомным компаратором
        Set<Searchable> result = new TreeSet<>(new SearchableComparator());
        result.addAll(items);
        return result;
    }

    // Кастомный компаратор для сортировки Searchable объектов
    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            // Сначала сортируем по длине названия (от большего к меньшему)
            int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            // При равной длине - сортируем по алфавиту
            return o1.getName().compareTo(o2.getName());
        }
    }
}

