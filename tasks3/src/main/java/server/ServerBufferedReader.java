package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ServerBufferedReader {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    static void closeServerBR(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
