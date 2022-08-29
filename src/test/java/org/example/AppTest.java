package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void socket_test() throws IOException, ClassNotFoundException, InterruptedException {
        WebSocketServer server = new WebSocketServer(9090);
        WebSocketClient client = new WebSocketClient("localhost", 9090);
        final String STR1 = "hello";
        final String STR2 = "I am Q-Bug";
        client.send(STR1);
        client.send(STR2);
        Assert.assertEquals(STR1, server.read());
        Assert.assertEquals(STR2, server.read());
    }
}
