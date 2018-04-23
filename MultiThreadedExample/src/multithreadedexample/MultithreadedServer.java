/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedexample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Santo_HW432
 */
public class MultithreadedServer {
    private int port;

    public MultithreadedServer(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
    
    public void listen() {
        int poolSize = 100 * Runtime.getRuntime().availableProcessors();
        ExecutorService taskList = Executors.newFixedThreadPool(poolSize);
        try {
            ServerSocket listener = new ServerSocket(port); 
            Socket socket;
            while (true) {
//          Run until killed
            socket = listener.accept();
            taskList.execute(new ConnectionHandler(socket));   
            }
        } catch (IOException ioe){
            System.err.println("IOException: " + ioe);
            ioe.printStackTrace();
        }
    }
    
}
