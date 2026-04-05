public class Book {
    private String title;
    private Author author;
    private int publicationYear;
    public String toString() {
        return "Название: " + title + ", Автор: " + author.getFirstName() + " " + author.getLastName() + ", Год публикации: " + publicationYear;
    }



    // Конструктор, заполняющий все поля
    public Book(String title, Author author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

   //Геттеры
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Сеттер для года публикации
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}

