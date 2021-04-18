//8.Даны дроби
//p1/q1, p2/q2...pn/qn
//(p,q - натуральные). Составить программу, которая приводит эти дроби к общему
//знаменателю и упорядочивает их в порядке возрастания.

public class AlgorithmizationSort8 {
    public static void main(String[] args) {
        int[] numerators = new int[] {3,5,8,10,2,6};
        sortFraction(numerators);
        int[] denominators = new int[]{17,4,5,7,3,8};

        bringCommonDenom(numerators, denominators);
        printFraction(numerators,denominators);

    }
    public static void printFraction(int[] numerators, int[] denominators){
        for (int i=0; i<numerators.length; i++){
            System.out.println(numerators[i]+"/"+denominators[i]);
        }
    }
    public static void sortFraction(int[] numerators){
        boolean isSorted = false;
        while(!isSorted) {
            isSorted=true;
            for (int i = 0; i < numerators.length-1; i++) {
                if (numerators[i] > numerators[i + 1]) {
                    int temp = numerators[i];
                    numerators[i] = numerators[i + 1];
                    numerators[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
    public static void bringCommonDenom(int[] numerators, int[] denominators) {
        int lcm = leastCommonMultiple(denominators);
        int factor;
        for(int i=0; i<numerators.length; i++){
            factor = lcm / denominators[i];
            numerators[i] = numerators[i] * factor;
            denominators[i] = lcm;
        }
    }
    public static int leastCommonMultiple(int[] array ){
        int lcm = 0;

        int max = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] > max)
                max = array[i];
        }
        boolean lcmIsFound = false;

        while (!lcmIsFound){
            lcm += max;
            lcmIsFound = true;
            for (int i=0; i<array.length; i++){
                if(lcm % array[i] != 0){
                    lcmIsFound = false;
                }
            }
        }
        return lcm;
    }
}
