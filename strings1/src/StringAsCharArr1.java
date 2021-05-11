
//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

import java.util.Arrays;

public class StringAsCharArr1 {
    public static void main(String[] args) {
        String str1 = "onTheWayToSuccess";
        String str2 = "completeWorksOfPlato";
        String str3 = "wordsAndSings";
        String[] camelCaseArr = new String[]{str1, str2, str3};
        String[] snakeCaseArr = convertCamelToSnake(camelCaseArr);
        System.out.println(Arrays.toString(snakeCaseArr));

    }

    private static String[] convertCamelToSnake(String[] arrayString){
        for(int i = 0; i < arrayString.length; i++){
            char [] arrayLetters = arrayString[i].toCharArray();
            int countUpper = 0;

            for (int j =0; j < arrayLetters.length; j++){
                if(Character.isUpperCase(arrayLetters[j])){
                    countUpper++;
                }
            }

            arrayLetters = expandArray(arrayLetters, countUpper);

            for(int j = arrayLetters.length - 1; j >= 0; j--){
                if(countUpper == 0){
                    break;
                }
                if(Character.isUpperCase(arrayLetters[j])){
                   arrayLetters [j + countUpper] = Character.toLowerCase(arrayLetters[j]);
                   countUpper--;
                   arrayLetters [j + countUpper] = '-';
                }
                else {
                    if(arrayLetters[j] != 0)
                    arrayLetters[j + countUpper] = arrayLetters[j];
                }
            }
            String str = new String(arrayLetters);
         arrayString[i] = str;
        }
        return arrayString;

    }
    private static char[] expandArray(char[] array, int countUpper){
        char[] expendedArray = Arrays.copyOf(array, array.length + countUpper);
        return expendedArray;
    }
}
