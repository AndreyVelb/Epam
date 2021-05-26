import java.util.Scanner;

//14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
//возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
//использовать декомпозицию.

public class AlgorithmizationDecomposition14 {
    public static void main(String[] args) {
        printArmstrongsNumbers();
    }
    private static void printArmstrongsNumbers(){
        int maxValSegment = 12314151;//inputNumber();
        for (int i = 1; i <= maxValSegment; i++){
                if(isArmstrongNumber(i, decompositionNumber(i))){
                    System.out.println(i);
                }
            }
        }

    private static boolean isArmstrongNumber(int num, int[] arrNum){
        int sum = 0;
        for(int i = 0; i < arrNum.length; i++){
            sum += Math.pow(arrNum[i], arrNum.length);
        }
        if(sum == num){
            return true;
        }
        return false;
    }

    private static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int n;
        boolean marker;
        do{
            System.out.println("Write a integer number: ");
            marker = scanner.hasNextInt();
            n = scanner.nextInt();
        }
        while (!marker);
        return n;
    }

    private static int[] decompositionNumber(int num){
        String numAsString = "" + num;
        char[] strAsChars = numAsString.toCharArray();
        int [] numArray = new int[numAsString.length()];

        for (int i = 0; i < numArray.length; i++){
            numArray[i] = Integer.parseInt(String.valueOf(strAsChars[i]));
        }
        return numArray;
    }
}
