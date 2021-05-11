
//5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
//Крайние пробелы в строке удалить

public class StringAsCharArr5 {
    public static void main(String[] args) {
        String string = "         I  like    study     the  English         language!   ";
        System.out.println(removeExcessSpaces(string));
    }
    private static String removeExcessSpaces(String string) {
        char[] withSpace = string.toCharArray();
        char[] withoutSpace = new char[withSpace.length];
        boolean markerSomeSpace = false;
        for(int i = withSpace.length - 1, k = 0; i >= 0; i--) {
            if (!Character.isSpaceChar(withSpace[i])){
                withoutSpace[k] = withSpace[i];
                k++;
                markerSomeSpace = true;
            }
            if (markerSomeSpace){
                if(Character.isSpaceChar(withSpace[i])){
                    withoutSpace[k] = withSpace[i];
                    k++;
                    markerSomeSpace = false;
                }
            }
        }
        withoutSpace = reversCharArr(withoutSpace);
        String result = new String(withoutSpace);
        return result;
    }
    private static char[] reversCharArr(char[] array){
        char[] reverseArr = new char[array.length];
        for(int i = array.length - 1, k = 0; i >= 0; i--, k++){
            reverseArr[k] = array[i];
        }
        return reverseArr;
    }
}
