import java.util.Arrays;
import java.util.Scanner;

//10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
//являются цифры числа N.

public class AlgorithmizationDecomposition10 {
    public static void main(String[] args) {

        int[] array = conversionIntArray(inputNumber());
        System.out.println(Arrays.toString(array));

    }
    public static int [] conversionIntArray(String str){
        char[] charArray = str.toCharArray();
        int[] intArray = new int[str.length()];
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
        }
        return intArray;
    }
    public static String inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String n;
        boolean marker;

        do{
            System.out.println("Write a number for array creating: ");
            marker = scanner.hasNextLong();
            n = scanner.nextLine();

        }
        while(!marker);

        return n;
    }
}
