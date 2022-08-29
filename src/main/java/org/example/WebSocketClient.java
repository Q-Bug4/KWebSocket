package org.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class WebSocketClient {
    Socket socket;
    String url;
    int port;

    public WebSocketClient(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public void send(String msg) throws IOException {
        socket = new Socket(url, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(msg);
    }
}
