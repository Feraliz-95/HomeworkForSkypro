
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Homework-9
        System.out.println("Задача 1");
 
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.println("Ф.И.О. сотрудника — " + fullName);

        System.out.println("Задача 2");
        System.out.println("Данные Ф. И. О. сотрудника для заполнения отчета — " + fullName.toUpperCase());

        System.out.println("Задача 3");
        String fullName1 = "Иванов Семён Семёнович";
        String correctedFullName = fullName1.replace("ё", "e");
        System.out.println("Данные Ф. И. О. сотрудника — " + correctedFullName);

    }
}










































