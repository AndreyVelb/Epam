
//2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

public class AlgorithmizationDecompozition2 {
    public static void main(String[] args) {
        int a = 60;
        int b = 100;
        int c = 900;
        int d = 40;

        System.out.println(greatestCommonFactor(a,b,c,d));
    }
    public static int greatestCommonFactor(int a, int b, int c, int d){
        for(int i=minFourNumbers(a,b,c,d); i > 1; i--){
            if(a % i ==0){
                if(b % i == 0){
                    if(c % i == 0){
                        if(d % i == 0){
                            return  i;
                        }
                    }
                }
            }
        }
        return 1;
    }
    public static int minFourNumbers(int a, int b,int c, int d){
        int min1 = a < b ? a : b;
        int min2 = c < d ? c : d;
        int min  = min1 < min2 ? min1 : min2;
        return min;
    }

}
