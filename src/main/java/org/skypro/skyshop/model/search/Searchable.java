package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    //Возвращает поисковый термин (текст, по которому будет производиться поиск).
    String getSearchTerm();


    //Возвращает тип контента (например, "книга", "статья", "продукт").
    String getContentType();

    //Возвращает имя объекта, который можно искать.
    String getSearchableName();

    UUID getId();



    default String getStringRepresentation(){
        return getSearchableName() + getContentType();
    }

}