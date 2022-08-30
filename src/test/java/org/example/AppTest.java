package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebSocketServer server;
    WebSocketClient client;
    @Before
    public void before() throws IOException {
        server = new WebSocketServer(9090);
        client = new WebSocketClient("localhost", 9090);
    }

    @Test
    public void socket_test() throws IOException, ClassNotFoundException, InterruptedException {
        final String STR1 = "hello";
        final String STR2 = "I am Q-Bug";
        client.send(STR1);
        client.send(STR2);
        Assert.assertEquals(STR1, server.read());
        Assert.assertEquals(STR2, server.read());
    }

    @Test
    public void serverSend_test() throws IOException, ClassNotFoundException {
        final String STR1 = "I am Q-Bug";
        new Thread(() -> {
            try {
                server.send(STR1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Assert.assertEquals(STR1, client.read());
    }
}
