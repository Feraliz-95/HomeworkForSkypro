package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    /**
     * Статический фабричный метод для создания SearchResult из Searchable.
     */
    public static SearchResult fromSearchable(Searchable searchable) {
        String id;
        if (searchable.getId() instanceof UUID) {
            id = ((UUID) searchable.getId()).toString(); // Преобразование UUID в строку
        } else {
            id = String.valueOf(searchable.getId()); // Если id уже строка, просто присваиваем
        }

        return new SearchResult(id, searchable.getSearchableName(), searchable.getContentType());
    }
}