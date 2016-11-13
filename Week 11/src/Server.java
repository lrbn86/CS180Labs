import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Server.java
 *
 * Program that implements the server side of the communication.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        int portNumber = Integer.parseInt(args[0]);

        try {

            // Create server
            serverSocket = new ServerSocket(portNumber);

            System.out.println("Server Waiting for Connection");

            // Listen for clients
            clientSocket = serverSocket.accept();

            // Send to client
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from client
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            // Client is connecting
            if (clientSocket.isConnected()) {

                System.out.println("Connection is successful and waiting for commands");

                // Get filename and username from client and store it to variables
                String fileName = in.readLine();
                String userName = in.readLine();

                // Prints data collected from client
                System.out.println("Filename: " + fileName + "\n" +
                        "Username: " + userName);

                // Attempt to open file
                File database = new File("/Users/brandonnguyen/Desktop/PurdueStuffs/CS18000/Labs/Week 11/Server/" + fileName);
                File info = new File("/Users/brandonnguyen/Desktop/PurdueStuffs/CS18000/Labs/Week 11/Client/info.txt");
                // If file is not found
                if (database.exists()) {

                    // Open file and get the contents of the file according to username
                    Scanner sc = new Scanner(database);
                    sc.useDelimiter(";");

                    String userNameContent = "", lastNameContent, firstNameContent, marksContent;

                    String information = "";

                    // Read content of the file
                    while (sc.hasNext()) {
                        // Watch for username match
                        // Print LastName, FirstName, and Marks
                        // If username not found, throw InfoNotFoundException
                        userNameContent = sc.next();
                        lastNameContent = sc.next();
                        firstNameContent = sc.next();
                        marksContent = sc.next();

                        information = "LastName: " + lastNameContent + "\n" +
                                "FirstName: " + firstNameContent + "\n" +
                                "Marks: " + marksContent;
                    }

                    if (userNameContent.equals(userName)) {
                        out.println(information);
                    } else {
                        out.println("InfoNotFoundException: Your Information is not in our file");
                    }

                    // Put 'information' into info.txt file
                    PrintWriter outputToFile = new PrintWriter(info);
                    outputToFile.println(information);
                    outputToFile.close();

                    // Close all connections
                    serverSocket.close();
                    clientSocket.close();
                    out.close();
                    in.close();

                } else {
                    throw new FileNotFoundException();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}