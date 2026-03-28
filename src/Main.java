public class Main {
    //Задача 1
    public static void leapYears(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    //Задача 2
    public static void softwareDefinition(int clientDeviceYear, int clientOs1) {
        if (clientOs1 == 0 && clientDeviceYear <= 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке.");
        } else if (clientOs1 == 1 && clientDeviceYear <= 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке.");
        }
        if (clientOs1 == 0 && clientDeviceYear > 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else if (clientOs1 == 1 && clientDeviceYear > 2015) {
            System.out.println("Установите версию приложения для Android по ссылке.");
        }
    }

    //Задача 3
    public static void distanceOfDays(int deliveryDistance) {
        int days = 1;
        if (deliveryDistance < 20) {
            System.out.println("Потребуется дней: " + days);
        } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            days += 1;
            System.out.println("Потребуется дней: " + days);
        } else if  (deliveryDistance >= 60 && deliveryDistance < 100) {
            days += 2;
            System.out.println("Потребуется дней: " + days);
        } else {
            System.out.println("Свыше 100 км доставки нет.");
        }
    }
    public static void main(String[] args) {
    leapYears(2024);
    softwareDefinition(2017, 1);
    distanceOfDays(102);
        }
    }


























