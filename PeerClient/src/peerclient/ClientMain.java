 
package peerclient;

import Packet.Filestructure;
import Packet.message;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author anuj
 */
public class ClientMain {
    private final Socket socket;
    public ClientMain(Socket socket)
    {
        this.socket=socket;
    }
    public void send(message m)
    {
        try{
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(m);   
        }
         catch(IOException e)
        {
            Throwable cause = e.getCause();
        }
    }
    public void send(Filestructure file)
    {
        try{
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(file); 
            System.out.println("file sent");
        }
         catch(IOException e)
        {
            Throwable cause = e.getCause();
        }
    }

    public Object receive() throws ClassNotFoundException
    {
        Object m = null;
        try{
        InputStream inputStream=socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        m=objectInputStream.readObject();
       
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return m;   
     }   
    
}
 