
//1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

public class StringUsStringBuilder1 {
    public static void main(String[] args) {
        String string = "   I  like study   English   language!     ";
        System.out.println(greatestCountSpace(string));
    }
    private static int greatestCountSpace(String string){
        StringBuilder strWithSpaces = new StringBuilder(string);
        int count = 0;
        int maxCountSpaces = 0;
        for (int i = 0; i < strWithSpaces.length(); i++){
            if( ! Character.isSpaceChar(strWithSpaces.charAt(i))){
                if(count > maxCountSpaces)
                    maxCountSpaces = count;
                count = 0;
            }
            if(Character.isSpaceChar(strWithSpaces.charAt(i))){
                count++;
            }
            if(i == strWithSpaces.length() - 1){
                if(count > maxCountSpaces)
                    maxCountSpaces = count;
            }
        }
        return maxCountSpaces;
    }
}
