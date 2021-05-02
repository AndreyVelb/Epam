//16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
//Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию

import java.util.Scanner;

public class AlgorithmizationDecomposition16 {
    public static void main(String[] args) {
        countEvenNumeral();
    }
    private static void countEvenNumeral(){
        int sumOddNum = sumOdd();
        System.out.println("The numbers of odd sum is " + sumOddNum);
        int[] arrayNum = numeralArray(sumOddNum);
        int count = 0;
        for (int i = 0; i < arrayNum.length; i++){
            if(arrayNum[i] % 2 == 0)
                count++;
        }
        System.out.println("The numbers of even count is " + count);
    }

    private static int sumOdd(){
        int exponentNum = inputNumber();
        int startNum = createStartNumeral(exponentNum);
        int finalNum = createFinalNumeral(exponentNum);
        int sum = 0;

        for(int i = startNum; i <= finalNum; i++) {
            if(numIsOdd (numeralArray(i) ) ){
                sum += i;
            }
        }
        return sum;
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

    private static boolean numIsOdd(int[] arrNum){
        for(int i = 0; i < arrNum.length; i++){
            if(arrNum[i] % 2 == 0)
                return false;
        }
        return true;
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
