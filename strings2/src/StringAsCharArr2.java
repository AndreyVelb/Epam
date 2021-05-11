
//2. Замените в строке все вхождения 'word' на 'letter'.

public class StringAsCharArr2 {
    public static void main(String[] args) {
        String string = "word, number, word? letter. words, WoRDS";
        String stringWithotWord = string.replace("word", "letter");
        System.out.println(stringWithotWord);
    }
}
