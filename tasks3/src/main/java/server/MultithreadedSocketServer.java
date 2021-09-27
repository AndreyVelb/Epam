package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MultithreadedSocketServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            int counter = 0;
            System.out.println("Server started.......");

            ServerController serverController = new ServerController(ServerBufferedReader.getBufferedReader());
            serverController.start();

            while (true) {
                counter++;
                Socket serverClient = serverSocket.accept();
                System.out.println("Client № " + counter + " connected");
                ServerClientThread sct = new ServerClientThread(serverClient, counter);
                sct.start();


            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}