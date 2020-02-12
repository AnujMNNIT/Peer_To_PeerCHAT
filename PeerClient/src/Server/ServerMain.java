
package Server;


/**
 *
 * @author anuj
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import peerclient.Front;

public class ServerMain extends Thread{
    private Front front;
    public ServerMain(Front front)
    {
        this.front=front;
    }
 
    public  void run() { 
        int port =9997;
        try{
        ServerSocket serverSocket = new ServerSocket(port);        
        while(true)                                                
        {
            Socket clientSocket = serverSocket.accept();            
            System.out.println("Client connected");
            ServerWorker  sw=new ServerWorker(clientSocket,front);    
            sw.start();
        }
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }  
}
