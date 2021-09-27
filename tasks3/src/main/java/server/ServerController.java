package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController extends Thread{
    private String serverAdminMessage;
    private BufferedReader bufferedReader;

    ServerController(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;

    }

    @Override
    public void run(){
        serverAdminMessage = inputAdminMessage();

        if (serverAdminMessage.equalsIgnoreCase("exit")){
            closeServer();
        }
    }

    private void closeServer(){
        System.exit(0);
    }

    private String inputAdminMessage(){
        serverAdminMessage = "";
        try {
            serverAdminMessage = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverAdminMessage;
    }
}
