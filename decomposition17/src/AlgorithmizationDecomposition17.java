//17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
//действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class AlgorithmizationDecomposition17 {
    public static void main(String[] args) {
        System.out.println(countStepsToZero(inputNumber()));

    }
    private static int countStepsToZero(int num){
        int count = 1;
        if(num - sumNumeral(arrayNum(num)) == 0){
            return count;
        }
        count = count + countStepsToZero(num - sumNumeral(arrayNum(num)));
        return count;
    }

    private static int sumNumeral(int[] arrNum){
        int sum = 0;
        for(int i = 0; i < arrNum.length; i++){
            sum += arrNum[i];
        }
        return sum;
    }

    private static int[] arrayNum (int num){
        String strNum = String.valueOf(num);
        int[] arrayNum = new int[strNum.length()];
        for(int i = 0; i < arrayNum.length; i++){
            arrayNum[i] = Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
        return arrayNum;
    }

    private static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String strNum;
        boolean marker;
        do{
            System.out.println("Write a integer number: ");
            marker = scanner.hasNextInt();
            strNum = scanner.nextLine();
        }
        while (!marker);
        int result = Integer.parseInt(strNum);
        return result;
    }
}
