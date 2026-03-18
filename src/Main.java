
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        //Задача 1
        int[] inputArray1 = {91, 1115, 765, 350, 400};
        int outputArray1 = 0;
        int sum = 0;
        int maxSum = 0;
        int min = inputArray1[0];
        float middleSum = 0;

        for (int element : inputArray1) {
            sum = sum + element;
        }
        System.out.println("Сумма выплат: " + sum);
        for (int max : inputArray1) {
            if (max > maxSum) {
                maxSum = max;
            }
        }
        System.out.println("Максимальная выплата: " + maxSum);

        for (int minNums : inputArray1) {
            if (minNums < min) {
                min = minNums;
            }
        }
        System.out.println("Минимальная выплата: " + min);
        for (float mid : inputArray1) {
            middleSum += mid;
        }
        middleSum = middleSum / inputArray1.length;
        System.out.println("Среднее значение: " + middleSum);

        //Задача 2
        int[] inputArray2 = {800, 2500, 4300, 200, 3250};
        float[] outputArray2 = new float[5];
        int index = 0;
        for (float salary : inputArray2) {
            float tax = salary * 0.13f;
            outputArray2[index] = tax;
            index++;
            System.out.println(tax);
        }
        //Задача 3
        int[] inputArray3 = {3000, 4500, 6000, 5300, 7000};
        boolean[] outputArray3 = new boolean[inputArray3.length];
        int index1 = 0;
        for (int bonus : inputArray3) {
            if (bonus > 5000) {
                outputArray3[index1] = true;
            }else{
                outputArray3[index1] = false;
            }
            index1++;
        }
        for (boolean flag : outputArray3) {
            System.out.println(flag);
        }

        //Задача 4
        int[] inputArray4 = {100, 50, 25, -10, 30};
        boolean outputArray4 = true;
        for (int balance : inputArray4) {
            if (balance < 0) {
                outputArray4 = false;
                break;
            }
        }
        System.out.println(outputArray4);

        //Задача 5
        int[] inputArray5 = {100, -50, 200, 0, 300};

        // Переменная для подсчета прибыльных месяцев
        int outputArray5 = 0;

        // Цикл for-each
        for (int profit : inputArray5) {
            if (profit > 0) {
                outputArray5++;
            }
        }
        System.out.println("Количество прибыльных месяцев: " + outputArray5);



    }
}





















