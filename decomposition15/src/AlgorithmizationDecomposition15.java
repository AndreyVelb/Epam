//15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
//последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class AlgorithmizationDecomposition15 {
    public static void main(String[] args) {
        increaseNumeral();
    }
    private static void increaseNumeral(){
        int exponentNum = inputNumber();
        int finalNum = createFinalNumeral(exponentNum);
        int startNum = createStartNumeral(exponentNum);
        for(int i = startNum; i < finalNum; i++){
            if(discardDontIncrease(i)){
                System.out.println(i);
            }
        }
    }
    private static int createFinalNumeral(int num){
        String strNum = String.valueOf(num);
        String resNum = "";
        for (int i = 0; i < strNum.length(); i++){
            resNum = resNum + 9;
        }
        int result = Integer.parseInt(resNum);
        return result;
    }

    private static int createStartNumeral(int num){
        String strNum = String.valueOf(num);
        String resNum = "";
        for (int i = 0; i < strNum.length(); i++){
            resNum = resNum + 1;
        }
        int result = Integer.parseInt(resNum);
        return result;
    }

    private static boolean discardDontIncrease(int num){
        boolean marker = true;
        int[] numArray = numeralArray(num);
        for(int i = 0; i < numArray.length - 1; i++){
            if(numArray[i] != numArray[i + 1] - 1){
                return false;
            }
        }
        return marker;
    }

    private static int[] numeralArray(int num){
        String strNum = String.valueOf(num);
        int[] numArray = new int [strNum.length()];
        for(int i = 0; i < numArray.length; i++){
            numArray[i] = Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
        return numArray;
    }

    private static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String numStr;
        boolean marker;
        do{
            System.out.println("Write a integer number: ");
            marker = scanner.hasNextInt();
            numStr = scanner.nextLine();
        }
        while (!marker);
        int result = Integer.parseInt(numStr);
        return result;
    }
}
