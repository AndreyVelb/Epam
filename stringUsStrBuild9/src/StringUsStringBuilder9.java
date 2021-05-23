
//9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
//буквы.

public class StringUsStringBuilder9 {
    public static void main(String[] args) {
        String string = "AdfdGdgdGRTRrg ваькпкуьп";
        countLowAndUpperEngLetters(string);
    }
    private static void countLowAndUpperEngLetters(String string){
        int countUpperCaseLetter = 0;
        int countLowerCaseLetter = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) >= 65 && string.charAt(i) <= 90){
                countUpperCaseLetter++;
            }
            else if(string.charAt(i) >= 97 && string.charAt(i) <= 122){
                countLowerCaseLetter++;
            }
        }
        System.out.println("UpperCase letters quanity is : " + countUpperCaseLetter);
        System.out.println("LowerCase letters quanity is : " + countLowerCaseLetter);
    }
}
