
//5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
//которое меньше максимального элемента массива, но больше всех других элементов).

public class AlgorithmizationDecomposition5 {
    public static void main(String[] args) {
        int [] array = new int[] {3,5,1,7,6,10,11,16,77,51};

        System.out.println(beforeMax(array));
    }
    public static int beforeMax (int [] array){
        int max = maxOfArray(array);
        int preMax = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > preMax && array[i] < max){
                preMax = array[i];
            }
        }
        return preMax;
    }
    public static int maxOfArray(int [] array){
        int max = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
