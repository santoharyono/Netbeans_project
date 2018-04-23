/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedexample;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Santo_HW432
 */
public class ConnectionHandler implements Runnable{
    private Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            handleConnection(socket);
        } catch (IOException ioe) {
            System.err.println("IOException :" + ioe);
            ioe.printStackTrace();
        }
    }
    
    public void handleConnection(Socket socket) throws IOException{
        
    }
    
    
    
}
