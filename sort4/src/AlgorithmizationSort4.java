import java.util.Arrays;

// 4. Сортировка обменами. Дана последовательность чисел
// a1 <= a2 <=...<= an.
// Требуется переставить числа в
// порядке возрастания( видимо автор ошибся, и имеется ввиду "в порядке убывания"
// поскольку они уже изначально расставлены в порядке возрастания).
// Для этого сравниваются два соседних числа
// ai и ai+1.
// Если ai > ai+1, то делается перестановка.
// Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
// Составить алгоритм сортировки, подсчитывая при этом количество перестановок.

public class AlgorithmizationSort4 {
    public static void main(String[] args) {
        int [] array = new int[]{1,3,4,5,5,7,8,10,13,14};

        int temp;
        int countOfPermutations = 0;

        boolean arrayIsSorted = false;

        while (!arrayIsSorted) {
            arrayIsSorted = true;

            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] < array[i + 1]) {

                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    countOfPermutations++;
                    arrayIsSorted = false;
                }
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(countOfPermutations);
    }
}
