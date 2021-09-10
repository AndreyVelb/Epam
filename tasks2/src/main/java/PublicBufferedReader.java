import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PublicBufferedReader {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void closeReader(){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
