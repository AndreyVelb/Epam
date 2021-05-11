
//2. В строке вставить после каждого символа 'a' символ 'b'.

public class StringUsStringBuilder2 {
    public static void main(String[] args) {
        String string = "aeeeaaaffcaa";
        System.out.println(insert_b_after_a(string));
    }
    private static String insert_b_after_a(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        for(int i = 0; i < stringBuilder.length(); i++){
            if(stringBuilder.charAt(i) == 'a'){
                stringBuilder.insert(i + 1, 'b');
            }
        }
        String result = stringBuilder.toString();
        return result;
    }
}
