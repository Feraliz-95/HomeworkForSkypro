
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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
        }
        System.out.println();

        //Задача 3.2
        for (int i = arrays.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(arrays[i]);
            } else {
                System.out.print(arrays[i] + ", ");
            }
        }
        System.out.println();

        //Задача 4
        int [] num = {1, 2, 3, 5};
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 !=0) {
                num[i]++;
                System.out.print(num[i] + " ");

            }
        }


        }

}




















