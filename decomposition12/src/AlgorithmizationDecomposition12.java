import java.util.Arrays;

//12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
//являются числа, сумма цифр которых равна К и которые не большее N.

public class AlgorithmizationDecomposition12 {
    public static void main(String[] args) {
        int k = 14;
        int n = 6;
        printArray(k, n);
    }
    private static void printArray(int k, int n){
        int[] array = createArray(k, n);
        System.out.println(Arrays.toString(array));
    }

    private static int[] createArray(int k, int n){
        if(n > k){
            System.out.println("The method can't be executed");
        }
        int [] array = new int[arrayLength(k, n)];
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(k - sum < n){
                array[i] = k - sum;
                break;
            }
            array[i] = n;
            sum += array[i];
        }
        return array;
    }

    private static int arrayLength(int k, int n){
        int length = (k / n) + 1;
        return  length;
    }
}
