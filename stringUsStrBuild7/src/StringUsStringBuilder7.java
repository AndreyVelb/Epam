
//7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
//def", то должно быть выведено "abcdef".

public class StringUsStringBuilder7 {
    public static void main(String[] args) {
        String string = "abc anf cacartm";
        System.out.println(removeSpaceAndRepet(string));

    }
    private static String removeSpaceAndRepet(String stringWithSpaceRepet){
        StringBuilder builder = new StringBuilder(stringWithSpaceRepet);

        for(int i = 0; i < builder.length(); i++){
            if(builder.charAt(i) == ' '){
                builder.deleteCharAt(i);
                i--;
                continue;
            }
            for(int j = i+1; j < builder.length(); j++){
                if(builder.charAt(j) == builder.charAt(i)){
                    builder.deleteCharAt(j);
                    j--;
                }
            }
        }
        String result = new String(builder);
        return result;
    }
}
