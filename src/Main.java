import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started. Waiting for clients...");
            Socket socket = server.accept();
            System.out.println("Client connected.");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String msg;
            while (!(msg = in.nextLine()).equals("end")){
                System.out.println("from client: " + msg);
                out.println("echo: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
