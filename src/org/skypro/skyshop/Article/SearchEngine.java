package org.skypro.skyshop.Article;

public class SearchEngine {

    private final Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[resultIndex] = searchable;
                resultIndex++;

                if (resultIndex == 5) {
                    break; // Прерываем цикл, если нашли 5 результатов
                }
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
        } else {
            System.out.println("Массив searchables заполнен.");
        }
    }

    // Дополнительно, метод для проверки, что поиск не вернет все null
    public boolean isEmpty() {
        for(Searchable s : searchables){
            if(s != null) return false;
        }
        return true;
    }
}