import java.util.Arrays;

//3. Сортировка выбором. Дана последовательность чисел
//a1 <= a2 <= ... <= an.
//Требуется переставить элементы так,
//чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
//элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
//повторяется. Написать алгоритм сортировки выбором.

public class AlgorithmizationSort3 {
    public static void main(String[] args) {
        int [] array = new int[]{1,2,4,4,6,8,10,10,12};

        int maxOfArray = array[0];
        int maxIndex = 0;
        int temp;

        for(int i=0; i<array.length; i++){
            for(int j=i; j< array.length; j++){

                if(array[j] > maxOfArray) {
                    maxOfArray = array[j];
                    maxIndex = j;
                }

            }
            temp = array[i];
            array[i] = maxOfArray;
            array[maxIndex] = temp;

            maxOfArray = 0;
        }

        System.out.println(Arrays.toString(array));
    }
}
