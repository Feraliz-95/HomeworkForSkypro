package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.Product;

import java.util.Comparator;
import java.util.Objects;

public final class Article implements Searchable, Comparator<Article> {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    @Override
    public int compare(Article a1, Article a2) {
        // Сравниваем длины названий в обратном порядке (от большего к меньшему)
        int lengthComparison = Integer.compare(a2.getName().length(), a1.getName().length());

        // Если длины равны, сравниваем названия в лексикографическом порядке
        if (lengthComparison == 0) {
            return a1.getName().compareTo(a2.getName());
        }

        return lengthComparison;
    }
}









}


