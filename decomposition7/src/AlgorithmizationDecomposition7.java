
//7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9

public class AlgorithmizationDecomposition7 {
    public static void main(String[] args) {
        System.out.println(factorialOfOddNumbers(1,9));
    }
    public static int factorialOfOddNumbers(int first, int last){
        int sum = 0;
        for(int i = first; i <= last; i++){
            if(odd(i)){
                sum += factorial(i);
            }
        }
        return sum;
    }
    public static int factorial(int a){
        if(a == 1) return 1;
        int result = a * factorial(a - 1);
        return result;
    }
    public static boolean odd(int a){
        if(a % 2 != 0)
            return true;
        else return false;

    }
}
