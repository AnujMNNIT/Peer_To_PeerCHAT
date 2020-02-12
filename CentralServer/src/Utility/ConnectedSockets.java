
package Utility;

import java.io.Serializable;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anuj
 */

/* A utility Class to store sockets for connected users. Here Map has been used to map users with corresponding
Sockets like a Telephone Directory*/

public class ConnectedSockets implements Serializable{
    private final Map<String,String> mp ;
    public ConnectedSockets(){
        mp=new HashMap<>();
    }
    public void addSocket(String uname ,String ip)
    {
        mp.put(uname,ip);
        //System.out.println(uname+" "+mp.get(uname).getRemoteSocketAddress().toString());
    }
    
    public String getSocket(String uname)
    {
       // System.out.println(uname+" "+mp.get(uname).getRemoteSocketAddress().toString());
        return mp.get(uname);
    }    
}
