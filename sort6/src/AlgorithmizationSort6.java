import java.util.Arrays;

//6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//Делается это следующим образом: сравниваются два соседних элемента ai и ai+1.
// Если ai <= ai+1, то продвигаются на один элемент вперед.
// Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
//Составить алгоритм этой сортировки.

public class AlgorithmizationSort6 {
    public static void main(String[] args) {

        int[] array = new int[]{14, 16, 17, 86, 34, -5, 52, 14, 65, 19, 15};
        shellSort(array);

        System.out.println(Arrays.toString(array));

    }

    public static int[] shellSort(int [] array){
        int step = array.length / 2;
        int temp;

        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                        temp = array[j];
                        array[j] = array[j - step];
                        array[j - step] = temp;
                }
            }
            step = step / 2;
        }
        return array;
    }
}
