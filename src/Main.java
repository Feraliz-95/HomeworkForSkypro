//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Задача 1

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

        int clientOs = 0;
        if (clientOs == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else if (clientOs == 1) {
            System.out.println("Установите версию приложения для Android по ссылке.");
        } else {


        }

        //Задача 2

        for (int num = 10; num > 0; num--) {
            System.out.println(num);

        int clientOs1 = 1;
        int clientDeviceYear = 2015;
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
        //Задача 3
        for (int num1 = 0; num1 <= 17; num1 += 2) {
            System.out.println(num1);
        }
        //Задача 4
        for (int num2 = 10; num2 >= -10; num2--) {
            System.out.println(num2);
        }
        //Задача 5
        for (int leapYear = 1904; leapYear < 2096; leapYear += 4) {
            System.out.println(leapYear + " год является високосным");
        }
        //Задача 6
        for (int num3 = 7; num3 <= 98; num3 += 7) {
            System.out.println(num3);
        }
        //Задача 7
        for (int num4 = 1; num4 <= 512; num4 *= 2) {
            System.out.println(num4);
        }
        //Задача 8
        int salary = 29000;
        int total = 0;
        for (int i  = 0; i < 12; i++) {
            total = total + salary;
            System.out.println("Месяц " + i +","+ "сумма накоплений равна " + total + " рублей");
        }
       // Задача 9
        int salary1 = 29000;
        int total1 = 0;
        for (int i = 0; i < 12; i++) {
            total1 = total1 + total1/100;
            total1 = total1 + salary1;
            System.out.println("Месяц " + i + "," + "сумма накоплений равна " + total1 + " рублей");
        }
        //Задача 10
        int num = 2;
        int result;
        for (int i = 1; i <= 10; i++) {
            result = num * i;
            System.out.println(num + "*" + i + "=" + result);
        }
        }
    }

















