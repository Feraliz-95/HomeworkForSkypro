import java.text.DecimalFormat;

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

        }
        while (distanceTraveled <= 42195);
        //Задача 2 вариан с циклом for
        for (int i = 0; i <= 42195; i += 500) {
            System.out.println("Держитесь! Осталось " + i + " метров ");
        }
        //Задача 3.1
        int budget = 1000;
        int day = 0;
        while (budget > 0) {
            day++;
            if (day % 5 == 0) {
                continue;
            }
            budget -= 100;
        }
        System.out.println("Количество дней равно - " + day);

        // Задача 3.2
        int balance = 1000;
        int parkingDay = 0;
        int i = 0;
        for (; i < balance; i++) {
            parkingDay++;

            if (parkingDay % 5 == 0) {
                continue;
            }
            balance -= 100;
        }
        System.out.println("Количество дней равно - " + parkingDay);
        //Задача 4
        DecimalFormat df = new DecimalFormat("0.00");
        int month = 0;
        double total = 0;
        while (total < 12_000_000) {
            month++;
            total = total + 15_000;
            if (month % 6 == 0) {
                total = total * 1.07;
                if (total >= 12_000_000) {
                    break;
                }
            }
            System.out.println("Месяц " + month + " Итого:" + df.format(total));
        }
        //Задача 5
        int charge = 20;
        int minute = 0;
        int overheats = 0;
        while (charge < 100 && overheats <=3) {
            minute++;
            charge += 2;
            if (minute % 10 == 0) {
                overheats++;
                minute++;
                continue;
            }
            System.out.println("Зарядка прекращена. Текущий заряд: " + charge + " %.");
            if (overheats == 3) {
                break;
            }
            System.out.println("Время зарядки составило " + minute + " минут.");

        }
    }
}




















