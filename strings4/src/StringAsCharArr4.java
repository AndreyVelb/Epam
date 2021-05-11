
//4. В строке найти количество чисел.

public class StringAsCharArr4 {
    public static void main(String[] args) {
        String numAndLetters = "1,4t,gr,46,16,gfg5";
        System.out.println(toCountNumInString(numAndLetters));

    }
    private static int toCountNumInString(String string){
        char[] charArr = string.toCharArray();
        int countNum = 0;
        boolean markerNum = true;
        for(int i = 0; i < charArr.length; i++) {
            if (!Character.isDigit(charArr[i])) {
                markerNum = true;
            }
            if (markerNum) {
                if (Character.isDigit(charArr[i])) {
                    countNum++;
                    markerNum = false;
                }
            }
        }
        return countNum;
    }
}
