import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client.java
 *
 * Program that implements the client side of the communication.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Client {

    public static void main(String[] args) {


        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {

            // Connect to server
            clientSocket = new Socket(hostName, portNumber);

            // Send to server
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from server
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            if (clientSocket.isConnected()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Filename: ");
                String fileName = sc.nextLine();
                System.out.println("Enter Username: ");
                String userName = sc.nextLine();

                // Sends data to server
                out.println(fileName);
                out.println(userName);

                // Read server's responses
                String serverMessage;
                for (serverMessage = in.readLine(); serverMessage != null; serverMessage = in.readLine()) {

                    System.out.println(serverMessage);
                }

            }

            // Close all connections
            clientSocket.close();
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}