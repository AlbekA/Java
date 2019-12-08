package client;

import com.sun.corba.se.spi.activation.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static DataInputStream in;
    private static DataOutputStream out;

    public Client(int port, String addr) {
        try (Socket socket = new Socket(addr, port)) {
            System.out.println("Подключен");

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
                    System.out.println("Отключился");
                    out.writeUTF(message);
                    break;
                }
                System.out.println("Сервер: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
