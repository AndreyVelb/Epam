
//3. В строке найти количество цифр.

public class StringAsCharArr3 {
    public static void main(String[] args) {
        String numAndLetters = "1,4t,gr,46,16,gfg5";
        System.out.println(toCountDigitInString(numAndLetters));

    }
    private static int toCountDigitInString(String string){
        char[] charArr = string.toCharArray();
        int countDigit = 0;
        for(int i = 0; i < charArr.length; i++){
            if(Character.isDigit(charArr[i])){
                countDigit++;
            }
        }
        return countDigit;
    }
}
