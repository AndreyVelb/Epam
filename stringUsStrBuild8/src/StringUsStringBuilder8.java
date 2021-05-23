
//8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
//длинных слов может быть несколько, не обрабатывать.

public class StringUsStringBuilder8 {
    public static void main(String[] args) {
        String string = "Грянувшая Первая мировая война отвлекла литератора от написания путевых рассказов и сказок.";
        System.out.println(longestWord(string));
    }
    private static String longestWord(String string){
        String [] subStrings = string.split(" ");
        int posLongestWord = 0;
        int countLetters = 0;
        for(int i = 0; i < subStrings.length; i++){
            if(subStrings[i].length() >= countLetters){
                countLetters = subStrings[i].length();
                posLongestWord = i;
            }
        }
        return subStrings[posLongestWord];
    }
}
