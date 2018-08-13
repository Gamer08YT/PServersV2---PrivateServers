/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 *
 */

package io.JaXn.Cloud.Master.network;/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 *
 */

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    int port;
    ServerSocket server = null;
    Socket client = null;
    ExecutorService pool = null;
    int clientcount = 0;

    public Server(int i) {
        this.port = port;
        pool = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {

        server = new ServerSocket(port);

        while (true) {
            client = server.accept();
            clientcount++;
            ServerThread runnable = new ServerThread(client, clientcount, this);
            pool.execute(runnable);
        }

    }
}