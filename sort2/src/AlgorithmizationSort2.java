import java.util.Arrays;

//2. Даны две последовательности
//a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
//Образовать из них новую последовательность
//чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.

public class AlgorithmizationSort2 {
    public static void main(String[] args) {

        int[] array1 = new int[]{2,3,4,5,6,10};
        int[] array2 = new int[]{1,2,5,7,9,15};
        int[] finalArray = new int[array1.length + array2.length];

        int iteratorArray1 = 0;
        int iteratorArray2 = 0;

        for (int i=0; i< finalArray.length; i++){

            if(iteratorArray1 == array1.length && iteratorArray2 == array2.length) {
                break;
            }

            if(iteratorArray1 == array1.length){
                finalArray[i] = array2[iteratorArray2];
                iteratorArray2++;
                continue;
            }

            if(iteratorArray2 == array2.length){
                    finalArray[i] = array1[iteratorArray1];
                    iteratorArray1++;
                continue;
            }

            if(array1[iteratorArray1] <= array2[iteratorArray2]){
                finalArray[i] = array1[iteratorArray1];
                iteratorArray1++;
            }
            else {
                finalArray[i] = array2[iteratorArray2];
                iteratorArray2++;
            }
        }

            System.out.println(Arrays.toString(finalArray));



    }

}
