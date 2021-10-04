import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        String host = "netology.homework";
        int port = 8080;
        String resp = "";
        Scanner scanner = new Scanner(System.in);
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Hello");
            while(true){
                resp = in.readLine();
                System.out.println(resp);
                if(resp.startsWith("Welcome")) break;
                out.println(scanner.nextLine());
            }



        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
