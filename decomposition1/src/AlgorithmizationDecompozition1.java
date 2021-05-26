
// Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
//натуральных чисел: НОК(А,В) = А*В/НОД(А,В);

public class AlgorithmizationDecompozition1 {
    public static void main(String[] args) {
        int a = 36;
        int b = 24;
        System.out.println(greatestCommonFactor(a,b));
        System.out.println(leastCommonMultiple(a,b));
    }
    public static int greatestCommonFactor(int a, int b){
        int min = a < b ? a : b;
        for(int i = min; i > 1; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
    public static int leastCommonMultiple(int a, int b){
        int lcm = a*b/greatestCommonFactor(a,b);
        return lcm;
    }
}
