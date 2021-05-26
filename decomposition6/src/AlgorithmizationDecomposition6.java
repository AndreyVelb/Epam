import java.util.Arrays;

//6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

public class AlgorithmizationDecomposition6 {
    public static void main(String[] args) {

        mutuallySimple(14,15,17);

    }
    public static void mutuallySimple(int a, int b, int c){
        int min = min(a,b,c);
        int [] array = dividers(min);

        if(min == a) {
            for (int i = 0; i < array.length && array[i] != 0; i++) {
                if (b % array[i] == 0 || c % array[i] == 0) {
                    System.out.println("No, numbers are not mutually simple");
                    return;
                }
            }
            System.out.println("Yes, numbers are mutually simple");
            return;
        }

        if(min == b) {
            for (int i = 0; i < array.length && array[i] != 0; i++) {
                if (a % array[i] == 0 || c % array[i] == 0) {
                    System.out.println("No, numbers are not mutually simple");
                    return;
                }
            }
            System.out.println("Yes, numbers are mutually simple");
            return;
        }

        if(min == c) {
            for (int i = 0; i < array.length && array[i] != 0; i++) {
                if (a % array[i] == 0 || b % array[i] == 0) {
                    System.out.println("No, numbers are not mutually simple");
                    return;
                }
            }
            System.out.println("Yes, numbers are mutually simple");
            return;
        }

    }
    public static int[] dividers (int number){
        int[] array = new int[10];
        int countArray = 0;

        for (int i = 2; i <= number; i++){
            if( countArray == array.length - 1){
                array = expendArray(array);
            }
            if(number % i == 0){
                array[countArray] = i;
                countArray++;
            }
        }
        return array;
    }
    public static int [] expendArray (int[] array){
        int[] expendedArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++){
            expendedArray[i] = array[i];
        }
        return expendedArray;
    }
    public static int min (int a, int b, int c){
        int smallest = Math.min(a, Math.min(b,c));
        return smallest;
    }
}
