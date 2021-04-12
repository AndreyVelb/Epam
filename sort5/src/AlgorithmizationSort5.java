import java.util.Arrays;

// 5. Сортировка вставками. Дана последовательность чисел
// a1 ,a2 ,... ,an.
// Требуется переставить числа в порядке возрастания.
// Делается это следующим образом. Пусть
// a1 ,a2 ,...,an - упорядоченная последовательность, т. е.
// a1 <= a2 <=...<=an.
// Берется следующее число ai+1
// и вставляется в последовательность так, чтобы новая
// последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
// не будут перебраны.
// Примечание. Место помещения очередного элемента в отсортированную часть производить
// с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.

public class AlgorithmizationSort5 {

    public static int binarySearch(int [] array, int endSortedtArray, int value) {
        int low = 0;
        int high = endSortedtArray;
        int mid = 0;

        while (low <= high ){
            mid = (high + low)/2;

            if (array[mid] == value){
                return mid;
            }

            if(array[mid] > value){
                if(high == low) return low;
                if(high == low + 1) return low;

                high = mid - 1;
            }

            if(array[mid] < value){
                if(high == low) return high+1;
                if(high == low + 1) return high;

                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int [] array = new int []{17,55,0,26,37,91,8,4,9,2};

        int temp;

        for(int i=0; i<array.length-1; i++){

            if(array[i] > array[i+1]){
                int targetCell = binarySearch(array, i, array[i+1]);
                temp = array[i+1];
                for(int j=i; j>=targetCell; j--){
                    array[j+1] = array[j];
                }
                array[targetCell] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
    }

}
