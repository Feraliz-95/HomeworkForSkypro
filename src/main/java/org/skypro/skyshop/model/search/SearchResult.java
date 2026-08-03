package org.skypro.skyshop.model.search;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;

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
    public static SearchResult fromSearchable(Searchable item) {
        if (item == null) {
            throw new IllegalArgumentException("Searchable item cannot be null");
        }

        String id = item.getId().toString(); // UUID -> String
        String name;
        String contentType;

        if (item instanceof Product product) {
            name = product.getName();
            contentType = "product";
        } else if (item instanceof Article article) {
            name = article.getSearchableName();
            contentType = "article";
        } else {
            // Если появится другой тип Searchable — можно расширить логику
            name = "Unknown";
            contentType = "unknown";
        }

        return new SearchResult(id, name, contentType);
    }
}