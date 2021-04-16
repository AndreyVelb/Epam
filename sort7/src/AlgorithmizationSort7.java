import java.util.Arrays;

//7. Пусть даны две неубывающие последовательности действительных чисел
//a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm.
//Требуется указать те места, на которые нужно вставлять элементы последовательности
//b1 <= b2 <=...<= bm в первую последовательность так,
//чтобы новая последовательность оставалась возрастающей.

public class AlgorithmizationSort7 {
    public static void main(String[] args) {
        int[] array1 = new int[]{3, 5, 7, 20, 23, 26, 31, 38};
        int[] array2 = new int[]{1, 4, 6, 7, 8, 22, 27, 30, 41};
        searchPlaceInArray(array1, array2);

    }
    public static void searchPlaceInArray(int[] array1, int[] array2){
         for(int i=0; i < array2.length; i++){
             int resultPlace = binarySearch(array1, array2[i]) + i; //добавляем число уже прибавленных к массиву 1 элементов массива 2
             System.out.println("Элемент " + array2[i] + " массива 2 должен занять место " + resultPlace + " в массиве 1." );
         }
    }

    public static int binarySearch(int[] array, int value){
        int num = 0;
        int low = 0;
        int high = array.length - 1;

            while (low <= high) {
                int mid = (high + low) / 2;
                if (array[mid] == value) return mid;

                if(array[mid] < value){
                    if(high == low) return high + 1;
                    if(high == low + 1) return high;

                    low = mid + 1;
                }
                if(array[mid] > value){
                    if(high == low) return low;
                    if(high == low + 1) return low;

                    high = mid - 1;
                }
            }
        return num;
    }
}
