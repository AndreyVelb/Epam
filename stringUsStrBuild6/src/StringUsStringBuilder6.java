
//6. Из заданной строки получить новую, повторив каждый символ дважды

public class StringUsStringBuilder6 {
    public static void main(String[] args) {
        String string = "atdtfdtf";
        System.out.println(doublingLine(string));
    }
    private static String doublingLine(String singleStr){
        StringBuilder builder = new StringBuilder(singleStr);
        for(int i = 0; i < builder.length(); i = i + 2){
            builder.insert(i, builder.charAt(i));
        }
        String doublingStr = new String(builder);
        return doublingStr;
    }
}
