
//10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
//знаком. Определить количество предложений в строке X.

public class StringUsStringBuilder10 {
    public static void main(String[] args) {
        String string = "Трактат был опубликован в 1843 году под псевдонимом Иоанн Молчальник. " +
                "Как часто бывает у Кьеркегора, книга написана от " +
                "лица вымышленного автора, и, строго говоря, должна рассматриваться как отстранённое выражение религиозной " +
                "жизненной позиции, а не как собственная позиция философа. Жанр определён автором как «диалектическая лирика»!";
        System.out.println(countSentenses(string));
    }
    private static int countSentenses(String string){
        int count = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '.' || string.charAt(i) == '?' || string.charAt(i) == '!'){
                count ++;
            }
        }
        return count;
    }
}
