import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//8. Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
//массива с номерами от k до m.

public class AlgorithmizationDecompozition8 {
    public static void main(String[] args) throws IOException {
        int [] array = new int[] {4,5,7,2,7,1,9,3,6,9};
        System.out.println(sum(array));

    }
    public static int sum (int [] array) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k;
        int sum = 0;

        do {
            System.out.println("Write the first of three numbers, the sum of which will be found.");
            System.out.println("But it dont must be bigger then " + (array.length - 3) + " and smallest then 0:");
            k = Integer.parseInt(reader.readLine());
        }
        while (k > array.length - 3);

        for(int i = k; i < k+3; i++){
            sum += array[i];
        }
        return sum;
    }
}
