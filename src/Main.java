//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Задача 1
        int firstFriday = 3;
        for (int i = 1; i <= 31; i++) {
            if ((i - firstFriday) % 7 == 0) {
                System.out.println("Сегодня пятница, " + i + "-е число. Необходимо подготовить отчет.");
            }
        }
        //Задача 2
        int distanceTraveled = 0;
        do {
            System.out.println("Держитесь! Осталось " + distanceTraveled + " метров ");
            distanceTraveled += 500;
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
        int balance = 1100;
        int parkingDay = 0;
        int i = 0;
        for (; i < balance; i++) {
            parkingDay++;
            balance -= 100;

            if (parkingDay % 5 == 0) {
                continue;

            }
            System.out.println("Количество дней равно - " + parkingDay);
        }
        //Задача 4
        int month = 0;
        double total = 0;
        while (total < 12_000_000) {
            month++;
            total = total + 15_000;
            if (month % 6 == 0) {
                total = total * 1.07;
                {
                    System.out.printf("Месяц %d Итого %.2f \n", month, total);
                }
                if (total >= 12_000_000) {
                    break;
                }

            }
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



















