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
    public static int calculationOfDeliveryDays(int deliveryDistance) {
        int deliveryDays = 1;
        if (deliveryDistance <= 20) {
        } else if (deliveryDistance <= 60) {
            deliveryDays += deliveryDays;
        } else if (deliveryDistance <= 100) {
            deliveryDays = deliveryDays + 2;
        } else {
            System.out.println("Доставка недоступна на расстояние более 100 км");
            return -1;
        }
        System.out.println("Потребуется дней: " + deliveryDays);
        return deliveryDays;
    }



    public static void main(String[] args) {
        leapYears(2024);
        softwareDefinition(2017, 1);
        calculationOfDeliveryDays(54);
    }
}


























