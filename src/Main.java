
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        System.out.println("Задача 1");
        int[] inputArray1 = {91, 1115, 765, 350, 400};
        int sum = 0;
        int max = inputArray1[0];
        int min = inputArray1[0];
        for (int payment : inputArray1) {
            sum += payment;

            if (payment > max) {
                max = payment;


        //Задача 1
        int[] arr = new int[] {1, 2, 3};
        //Задача 1.1
        double [] array = {1.57,7.654, 9.986};
        //Задача 1.2
        int[] arrays = new int[] {15, 26, 44, 92, 100};
        //Задача 2
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrays));

        //Задача 3
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }

        }
        System.out.println();
        //Задача 3.1
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");

            }

            if (payment < min) {
                min = payment; //
            }

            double average = sum / (double) inputArray1.length;

            System.out.println("inputArray1: ");
            for (int payment1 : inputArray1) {
                System.out.print(payment1 + " ");
            }
            System.out.println();
            double[] outputArray1 = {sum, max, min, average};

            System.out.println("outputArray1: ");
            for (double result : outputArray1) {
                System.out.print(result + " ");
            }
            System.out.println();
            //Задача 2
            System.out.println("Задача 2");
            int[] inputArray2 = {800, 2500, 4300, 200, 3250};
            float[] outputArray2 = new float[inputArray2.length];
            int index = 0;
            for (float salary : inputArray2) {
                float tax = salary * 0.13f;
                outputArray2[index] = tax;
                index++;
            }
            System.out.println(Arrays.toString(inputArray2));
            System.out.println(Arrays.toString(outputArray2));

            //Задача 3
            System.out.println("Задача 3");
            int[] inputArray3 = {3000, 4500, 6000, 5300, 7000};
            boolean[] outputArray3 = new boolean[inputArray3.length];
            int index1 = 0;
            for (int bonus : inputArray3) {
                if (bonus > 5000) {
                    outputArray3[index1] = true;
                } else {
                    outputArray3[index1] = false;
                }
                index1++;
            }
            System.out.println(Arrays.toString(inputArray3));
            System.out.println(Arrays.toString(outputArray3));
            //Задача 4
            System.out.println("Задача 4");
            int[] inputArray4 = {100, 50, 25, -10, 30};
            boolean[] outputArray4 = {true};
            for (int balance : inputArray4) {
                if (balance < 0) {
                    outputArray4 = new boolean[]{false};
                    break;
                }
            }
            System.out.println(Arrays.toString(inputArray4));
            System.out.println(Arrays.toString(outputArray4));


            //Задача 5
            System.out.println("Задача 5");
            int[] inputArray5 = {100, -50, 200, 0, 300};

            int[] outputArray5 = {0};

            // Цикл for-each
            for (int profit : inputArray5) {
                if (profit > 0) {
                    outputArray5[0]++;
                }
            }
            System.out.println(Arrays.toString(inputArray5));
            System.out.println(Arrays.toString(outputArray5));
        }
    }
}



















