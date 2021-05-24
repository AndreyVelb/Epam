
//1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//алфавиту.

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex1 {
    public static void main(String[] args) {

        String text = "Он ушел из завкома без помощи. Его пеший путь лежал среди лета, по сторонам строили дома и техническое благоустройство — в тех домах будут безмолвно существовать доныне бесприютные массы. Тело Вощева было равнодушно к удобству, он мог жить не изнемогая в открытом месте и томился своим несчастьем во время сытости, в дни покоя на прошлой квартире. Ему еще раз пришлось миновать пригородную пивную, еще раз он посмотрел на место своего ночлега — там осталось что-то общее с его жизнью, и Вощев очутился в пространстве, где был перед ним лишь горизонт и ощущение ветра в склонившееся лицо.\n" +
                  "Через версту стоял дом шоссейного надзирателя. Привыкнув к пустоте, надзиратель громко ссорился с женой, а женщина сидела у открытого окна с ребенком на коленях и отвечала мужу возгласами брани; сам же ребенок молча щипал оборку своей рубашки, понимая, но ничего не говоря.\n" +
                  "Это терпение ребенка ободрило Вощева, он увидел, что мать и отец не чувствуют смысла жизни и раздражены, а ребенок живет без упрека, вырастая себе на мученье. Здесь Вощев решил напрячь свою душу, не жалеть тела на работу ума, с тем чтобы вскоре вернуться к дому дорожного надзирателя и рассказать осмысленному ребенку тайну жизни, все время забываемую его родителями. «Их тело сейчас блуждает автоматически, — наблюдал родителей Вощев, — сущности они не чувствуют».";

        System.out.println(sortParagraphs(text));
        System.out.println(sortWords(text));
        sortLexemes(text);
    }
    private static String sortParagraphs(String text) {
        String[] arrStrings = text.split("\n");
        int[][] sentenceLength = new int[arrStrings.length][2];
        Pattern pattern1 = Pattern.compile("(\\.|\\!|\\?)");

        for (int i = 0; i < arrStrings.length; i++) {
            Matcher matcher = pattern1.matcher(arrStrings[i]);
            sentenceLength[i][0] = (int) matcher.results().count();
            sentenceLength[i][1] = i;
        }
        sortByLength(sentenceLength);

        StringBuilder builder = new StringBuilder(text.length());

        for(int i = 0; i < sentenceLength.length; i++){
            builder.append(arrStrings[sentenceLength[i][1]] + "\n");
        }
        String result = new String(builder);
        return result;
    }
    private static String sortWords(String text){
        String [] arrSentences = text.split("(\\.|\\!|\\?)");
        Pattern pattern2 = Pattern.compile("[а-яёА-ЯЁ]");
        StringBuilder builder = new StringBuilder(text.length());

        for(int i = 0; i < arrSentences.length; i++){
            String [] arrWords = arrSentences[i].split("\\b[^а-яёА-ЯЁ]+");
            int [][] lengthWord = new int[arrWords.length][2];
            for(int j = 0; j < arrWords.length; j++){
                Matcher matcher = pattern2.matcher(arrWords[j]);
                lengthWord[j][0] = (int) matcher.results().count();
                lengthWord[j][1] = j;
            }
            sortByLength(lengthWord);
            for (int k = 0; k < arrWords.length; k++){
                builder.append(arrWords[lengthWord[k][1]] + " ");
            }
            builder.append("."+"\n");
        }
        String result = new String(builder);
        return result;
    }
    private static void sortLexemes(String text){
        String [] arrSentences = text.split("(\\.|\\!|\\?)");

        for(int i = 0; i < arrSentences.length; i++){
            char[] charArray = setChar(arrSentences[i].toCharArray());
            int [][] countCh = new int[charArray.length][2];
            int count = 0;
            for(int j = 0; j < charArray.length; j++){
                for(int k = 0; k < arrSentences[i].length(); k++){
                    if(arrSentences[i].charAt(k) == charArray[j]){
                        count ++;
                    }
                }
                countCh[j][0] = count;
                countCh[j][1] = j;
                count = 0;
            }
            sortByLength(countCh);
            char[] sortedCharArr = sortCountAndAlphabet(countCh,charArray);
            System.out.println("В " + i + " предложении: ");
            for(int p = countCh.length - 1; p >= 0; p -- ){
                System.out.println("Лексема " + sortedCharArr[p] + " употребляется " + countCh[p][0] + " раз(а);");
            }
        }
    }
    private static char[] sortCountAndAlphabet(int [][] countCh, char[] chars){
        char[] sortedCharArr = new char[chars.length];
        for(int i = 0; i < countCh.length; i++){
                sortedCharArr[i] = chars[countCh[i][1]];
        }

        for(int i = 0; i < countCh.length-1; i++){
            if(countCh[i][0] == countCh[i + 1][0]){
                if(sortedCharArr[i] > sortedCharArr[i + 1]){
                    char temp = sortedCharArr[i];
                    sortedCharArr[i] = sortedCharArr[i + 1];
                    sortedCharArr[i + 1] = temp;
                }
            }
        }
        return sortedCharArr;
    }
    private static char [] setChar(char[] charArray){
        Set<Character> set = new HashSet<Character>();
        for(Character c : charArray){
            set.add(c);
        }
        char[] result = new char[set.size()];
        int i = 0;
        for (char c : set){
            result[i] = c;
            i++;
        }
        return result;
    }
    private static int[][] sortByLength(int[][] array){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i][0] > array[i + 1][0]) {
                    int temp1 = array[i][0];
                    int temp2 = array[i][1];
                    array[i][0] = array[i + 1][0];
                    array[i][1] = array[i + 1][1];
                    array[i + 1][0] = temp1;
                    array[i + 1][1] = temp2;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
