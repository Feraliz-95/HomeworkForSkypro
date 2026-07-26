package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            pattern = "";
        }

        String searchPattern = pattern.toLowerCase();

        return storageService.getAllSearchableItems()
                .stream()
                .filter(item -> {
                    String textToSearch;
                    if (item instanceof Product product) {
                        textToSearch = product.getName();
                    } else if (item instanceof Article article) {
                        textToSearch = article.getSearchableName();
                    } else {
                        return false;
                    }
                    return textToSearch.toLowerCase().contains(searchPattern);
                })
                .map(SearchResult::fromSearchable)
                .toList();
    }
}