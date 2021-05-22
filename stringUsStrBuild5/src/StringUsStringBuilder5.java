
//5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.

public class StringUsStringBuilder5 {
    public static void main(String[] args) {
        String str = "ayfyafAAfndkfnn";
        System.out.println(countCharA(str));
    }
    private static int countCharA(String string){
        StringBuilder builder = new StringBuilder(string);
        int countA = 0;
        for(int i = 0; i < builder.length(); i++){
            if(Character.toLowerCase(builder.charAt(i)) == 'a'){
                countA ++;
            }
        }
        return countA;
    }

}
