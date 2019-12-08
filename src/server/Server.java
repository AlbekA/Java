package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 61333;

    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен!");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Клиент подключился");

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());


                new Thread(() -> {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        while (true) {
                            String message = scanner.nextLine();
                            out.writeUTF(message);
                            if (message.equals("/end")) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

                while (true) {
                    String message = in.readUTF();

                    if (message.equals("/end")) {
                        System.out.println("Клиент отключился");
                        break;
                    }

                    System.out.println("Клиент: " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
