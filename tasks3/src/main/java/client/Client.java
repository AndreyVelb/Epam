package client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    private static final int PORT = 8000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket(HOST, PORT);

                BufferedReader br = ClientsBufferedReader.getBufferedReader();

                try (DataInputStream reader = new DataInputStream(socket.getInputStream());
                     DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {
                    String clientMessage = "";
                    String serverMessage = "";

                    while (clientMessage.equalsIgnoreCase("exit") == false && socket.isClosed() == false) {
                        serverMessage = reader.readUTF();
                        System.out.println(serverMessage);

                        clientMessage = br.readLine();
                        writer.writeUTF(clientMessage);
                        writer.flush();
                    }
                }

        }catch (SocketException e){
            System.out.println("Disconnecting from the server............");
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            ClientsBufferedReader.closeClientBR();
        }
    }
}
