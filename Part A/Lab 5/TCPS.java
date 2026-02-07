/* Using TCP/IP sockets, write a client – server program to make the 
client send the file name and to make the server send back the contents 
of the requested file if present*/


 /*Server side*/
import java.io.*;
import java.net.*;

// Server program: accepts a filename from the client and returns file contents

public class TCPS {

    public static void main(String[] args) throws Exception {
        // Create a server socket listening on port 4000
        ServerSocket socket = new ServerSocket(4000);

        System.out.println("Server ready for connection");
        // Wait and accept a client connection
        Socket clientSocket = socket.accept();

        System.out.println("Connection Is successful and waiting for the client request");

        // Get input stream from the client to read the requested filename
        InputStream istream = clientSocket.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
        
        // Read filename sent by the client
        String fname = fileRead.readLine();
        // Open the requested file for reading
        BufferedReader ContentRead = new BufferedReader(new FileReader(fname));

        // Get output stream to send file contents back to client
        OutputStream ostream = clientSocket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        String str;

        // Send file content line-by-line to client
        while ((str = ContentRead.readLine()) != null) {
            pwrite.println(str);
        }

        // Cleaning up resources: close client socket, server socket and readers/writers
        clientSocket.close();
        socket.close();
        pwrite.close();
        fileRead.close();
        ContentRead.close();
    }
}
