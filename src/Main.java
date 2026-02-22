//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Задача1
        int age = 19;

        if (age >= 18) {
            System.out.println("Если возраст человека равен " + age + ", то он совершеннолетний.");
        } else {
            System.out.println("Если возраст человека равен " + age + ", то он не достиг совершеннолетия, нужно немного подождать.");
        }
        //Задача2
        int temperature = 5;

        if (temperature < 5) {
            System.out.println("На улице " + temperature + " градусов, нужно надеть шапку");
        } else {
            System.out.println("На улице " + temperature + " градусов, можно идти без шапки");
        }
        // Задача3
        int speed = 65;
        if (speed > 60 ) {
            System.out.println("Если скорость " + speed + " ," + " то придется заплатить штраф");
        }else{
            System.out.println("Если скорость " + speed + " ," + " можно ездить спокойно");
        }
        // Задача4
        int year = 25;
        if (year >= 2 && year <=6) {
            System.out.println("Если возраст человека равен " + year + ", " + " то ему нужно ходить в детский сад.");
        }
        if ( year >= 7 && year <= 17) {
            System.out.println("Если возраст человека равен " + year + ", " + " то ему нужно ходить в школу.");
        }
        if (year >= 18 && year <= 24) {
            System.out.println("Если возраст человека равен " + year + ", " + " то его место в университете." );
        }
        if ( year > 24) {
          System.out.println("Если возраст человека равен " + year + ", " + " то ему пора ходить на работу.");
        }
        // Задача5
        int ageChildren = 22;
        if (ageChildren < 5) {
            System.out.println("Если возраст ребенка равен " + ageChildren + "," + " нельзя кататься на аттракционе.");
        }
        if (ageChildren >= 5 && ageChildren <= 14) {
            System.out.println("Если возраст ребенка равен " + ageChildren + "," + " можно кататься на аттракционе в сопровождении.");
        }
        if (ageChildren > 14) {
            System.out.println("Если возраст ребенка равен " + ageChildren + "," + " можно кататься на аттракционе без сопровождения взрослого.");
        }
        //Задача 6
        int capacity = 102;
        int seatedSeats = 60;
        int standingSeats = capacity - seatedSeats;
        int currentPassenger = 65;
        if (currentPassenger >= capacity);{
            System.out.println("Вагон уже забит.");
        }
        if (currentPassenger < seatedSeats) {
            System.out.println("Есть сидячие места");
        }else{
            System.out.println("Есть стоячие места.");
        }
        //Задача 7
        int one = 1;
        int two = 2;
        int three = 3;
        if ( one >= two && one >= three) {
            System.out.println(one + " Это самое больше число.");
        }
        if (two >= one && two >=three) {
            System.out.println(two + " Это самое больше число.");
        }else{
            System.out.println(three + " Это самое больше число.");
        }

    }
}











