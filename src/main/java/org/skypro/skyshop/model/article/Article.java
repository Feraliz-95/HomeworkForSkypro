package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String article; //название статьи в виде строки
    private final String text; //текст статьи в виде строки.

    public Article(UUID id ,String article, String text) {
        this.id = id;
        this.article = article;
        this.text = text;
    }
    @Override
    public UUID getId() {
        return id;
    }

   @Override
    public String getSearchTerm() {
        return toString(); // Возвращает строку из toString()
    }
    @Override
    public String getContentType() {
        return "ARTICLE";  // Тип контента — ARTICLE
    }

    @Override
    public String getSearchableName() {
        return article;
    }
    @Override
    public String toString() {
        return article + text;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // проверка на сравнение с самим собой
        if (o == null || getClass() != o.getClass()) return false; // проверка типа
        Article articleObj = (Article) o;
        return Objects.equals(article, articleObj.article); // сравнение только по названию
    }

    @Override
    public int hashCode() {
        return Objects.hash(article); // хэш-код только на основе названия
    }

}