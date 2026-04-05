public class Main {
Homework-11
    public static void main(String[] args) {
        Author author = new Author("Лев", "Толстой");
        Book book = new Book("Война и мир", author, 1869);

        System.out.println("Название: " + book.getTitle());
        System.out.println("Автор: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        System.out.println("Год публикации: " + book.getPublicationYear());

        Author author1 = new Author("Федор", "Достаевский");
        Author author2 = new Author("Оскар", "Уайльд");


        Book book1 = new Book("Белые ночи", author1, 1848);
        Book book2 = new Book("Идиот", author1, 1869);
        Book book3 = new Book("Портрет Дориана Грея", author2, 1890);
        Book book4 = new Book("Счастливый принц", author2, 1888);
        book1.setPublicationYear(1850);
        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);
        System.out.println("book3 = " + book3);
        System.out.println("book4 = " + book4);
    }


    }
























































