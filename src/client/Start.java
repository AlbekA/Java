package client;

public class Start {
    public static void main(String[] args) {
        final int CLIENT_PORT = 61333;
        final String CLIENT_ADDR = "localhost";

        Client client = new Client(CLIENT_PORT, CLIENT_ADDR);
    }
}
