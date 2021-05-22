
//4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.

public class StringUsStringBuilder4 {
    public static void main(String[] args) {
        String str1 = "информатика";
        char[] charArr = new char[4];
        str1.getChars(7, 8, charArr, 0);
        str1.getChars(3, 4, charArr, 1);
        str1.getChars(4, 5, charArr, 2);
        str1.getChars(7, 8, charArr, 3);

        String result = new String(charArr);
        System.out.println(result);

        StringBuilder buider = new StringBuilder(str1);
        buider.setCharAt(0, str1.charAt(7));
        buider.setCharAt(1, str1.charAt(3));
        buider.setCharAt(2, str1.charAt(4));
        buider.setCharAt(3, str1.charAt(7));
        buider.delete(4,buider.length());
        System.out.println(buider.toString());

        String tort;
        tort = (String.valueOf(str1.charAt(7)) + String.valueOf(str1.charAt(3)) + String.valueOf(str1.charAt(4)) + String.valueOf(str1.charAt(7)));
        System.out.println(tort);
    }
}
