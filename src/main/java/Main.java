import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        final int PORT = 8080;

        try (ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection with message: " + in.readLine());
            out.println("Write your name");
            final String NAME = in.readLine();
            out.println("Are you child? (yes/no)");
            final String CHILD = in.readLine();

            if(CHILD.equals("yes")){
                out.println(String.format("Welcome to the kids area, %s! Let's play!", NAME));
            }else if(CHILD.equals("no")){
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", NAME));
            }else{
                out.println("Вас сюда не звали");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
