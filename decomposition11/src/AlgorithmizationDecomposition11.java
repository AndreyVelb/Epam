
//11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class AlgorithmizationDecomposition11 {
    public static void main(String[] args) {
        int a = 41;
        int b = 123;
        compareIntLength(a,b);
    }
    public static void compareIntLength(int a, int b){
        String aLength = convertIntString(a);
        String bLength = convertIntString(b);

        if(aLength.length() == bLength.length()) {
            System.out.println("Numbers are equal.");
            return;
        }

        String output = aLength.length() > bLength.length() ? "Length of number a is bigger than length of number b." :
                                                              "Length of number b is bigger than length of number a.";
        System.out.println(output);
    }
    public static String convertIntString(int a){
        String str = "" + a;
        return str;
    }
}
