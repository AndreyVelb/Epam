import java.util.Scanner;

//13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
//Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
//решения задачи использовать декомпозицию.

public class AlgorithmizationDecomposition13 {
    public static void main(String[] args) {
        twinNumbers();

    }
    private static void twinNumbers(){
        int[] array = numberLineSegment(inputNumber());
        for (int i = 0; i < array.length-2; i++){
            System.out.println("[" + array[i] + "," + array[i + 2] + "]");
        }
    }

    private static int[] numberLineSegment(int border){
        int [] array = new int[(border * 2 - border) + 1];
        for (int i = 0, j = border; i < array.length; i++, j++){
            array[i] = j;
        }
        return array;
    }

    private static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        boolean marker;
        int num = 0;
        do{

            System.out.println("Write a integer number bigger than 2: ");
            marker = scanner.hasNextInt();
            num = scanner.nextInt();
        }
        while (marker && num <= 2);
        return num;
    }
}
