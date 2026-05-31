package org.skypro.skyshop.Article;

public record Article(String title, String text) implements Searchable {

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
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
}

