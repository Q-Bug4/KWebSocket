package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocketServer {
    ServerSocket server;

    public WebSocketServer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void send(String msg) throws IOException {
        Socket socket = server.accept();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(msg);
    }

    public String read() throws IOException, ClassNotFoundException {
        Socket socket = server.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String msg = (String) ois.readObject();
        return msg;
    }
}
