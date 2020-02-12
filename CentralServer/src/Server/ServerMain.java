
package Server;


/**
 *
 * @author anuj
 */


import Utility.ConnectedSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ServerMain {
     /* Main class of server
    */
    public static void main(String args[]) {
     
        int port =8888;
        try{
        ServerSocket serverSocket = new ServerSocket(port);         //Creation of passive socket from server side
        ConnectedSockets sc=new ConnectedSockets();                 //Object Of connectedSockets class to store username and corresponding socket
        while(true)                                                //infinite loop to accept sockets from client
        {
            Socket clientSocket = serverSocket.accept();            
            System.out.println("Client connected");
            InputStream inputStream = null;
            inputStream = clientSocket.getInputStream(); 
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String user=reader.readLine();  
            sc.addSocket(user, clientSocket.getInetAddress().getHostAddress());
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(sc);  
        }
                
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
