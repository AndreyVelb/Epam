
//3. Проверить, является ли заданное слово палиндромом.

public class StringUsStringBuilder3 {
    public static void main(String[] args) {
        String string = "TENET";
        polindrom(string);
    }
    private static void polindrom(String string){
        String s = isPalindrome(string) ? "Yes, this sting is palindrome" : "No, this sting is not palindrome";
        System.out.println(s);
    }
    private static boolean isPalindrome(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        if (evenOdd(string)){
            for(int i = 0, f = stringBuilder.length() - 1; f >= i+1; i++, f--){
                if(!(stringBuilder.charAt(i) == stringBuilder.charAt(f))){
                    return false;
                }
            }
            return true;
        }
        else{
            int mid = string.length()/2;
            for (int i = 0; i < mid; i++){
                if(!(stringBuilder.charAt(mid - i) == stringBuilder.charAt(mid + i))){
                    return false;
                }
            }
            return true;
        }
    }
    private static boolean evenOdd(String string){
        if (string.length() % 2 == 0)
            return true; //even
        else return false; //odd
    }
}
