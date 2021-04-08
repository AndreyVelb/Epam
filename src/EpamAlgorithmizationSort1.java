import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2_Algorithmization. Одномерные массивы. Сортировки
// 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
//один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
//дополнительный массив.

public class EpamAlgorithmizationSort1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] arr1 = new int[]{13,35,15,65,12};
        int [] arr2 = new int[]{14,65,26,76,35,51};

        int k;

        do{
            System.out.println("Write a number:");
            k = Integer.parseInt(reader.readLine());
        }
        while (k > arr1.length);

        int [] finalArray = new int[arr1.length+ arr2.length];

        int iteratorArr2 = 0;

        for(int i=0; i < finalArray.length-(arr1.length - (k+1)); i++){
            if(i < k){
                finalArray[i] = arr1[i];
            }

            if(i == k){
                finalArray[i] = arr1[i];
                int iteratorArr1 = k+1;
                int backIteratorFinalArray = finalArray.length-1;
                while (iteratorArr1 <= arr1.length-1){
                    finalArray[backIteratorFinalArray] = arr1[iteratorArr1];
                    iteratorArr1++;
                    backIteratorFinalArray--;
                }
            }

            if(i > k){
                finalArray[i] = arr2[iteratorArr2];
                iteratorArr2++;
            }
        }
        System.out.print(Arrays.toString(finalArray));
    }
}
