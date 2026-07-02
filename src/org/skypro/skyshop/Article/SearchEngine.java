package org.skypro.skyshop.Article;
import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    // Список для хранения searchable объектов
 HW-24
    public TreeSet<String> search(List<String> list) {
        return list.stream() //list.stream() — преобразует список в поток.
                .filter(s -> s.startsWith("prefix")) // Пример условия фильтрации
                .collect(Collectors.toCollection(           //собирает элементы в коллекцию, используя Supplier
                        () -> new TreeSet<>(Comparator.comparing(String::length).reversed())

                ));


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

    public Map<String, Searchable> search(List<Searchable> items) {
        Map<String, Searchable> result = new TreeMap<>();

        for (Searchable item : items) {
            result.put(item.getName(), item);
        }
        return result;
    }


}

