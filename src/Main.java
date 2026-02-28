//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Задача 1
        int clientOs = 0;
        if (clientOs == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else if (clientOs == 1) {
            System.out.println("Установите версию приложения для Android по ссылке.");
        } else {
            System.out.println("Неизвестная операционная система.");
        }
        //Задача 2
        int clientOs1 = 1;
        int clientDeviceYear = 2012;
        if (clientOs1 == 0 && clientDeviceYear < 2016) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке.");
        } else if (clientOs1 == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке.");
        }
        if (clientOs1 == 0 && clientDeviceYear > 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else if (clientOs1 == 1 && clientDeviceYear > 2015) {
            System.out.println("Установите версию приложения для Android по ссылке.");
        }
        //Задача 3
        int year = 2021;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
        //Задача 4
        int deliveryDistance = 60;
        int deliveryDay = 1;
        if (deliveryDistance > 100) {
            System.out.println("Нет доставки");
            return;
        } else if (deliveryDistance > 20) {
            deliveryDay++;
        } else if (deliveryDistance > 60){
            deliveryDay++;
        }
        System.out.println("Доставка займет " + deliveryDay + " суток");

        //Задача 5

        int monthNumber = 6;
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца");
            return;
        }
        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Некорректный номер месяца");

        }
    }
}















