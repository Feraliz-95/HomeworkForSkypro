public class Author {
    private String firstName;
    private String lastName;



    // Конструктор, заполняющий все поля
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Геттеры
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;

        }
    }
