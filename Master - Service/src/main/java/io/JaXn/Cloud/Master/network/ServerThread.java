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

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static io.JaXn.Cloud.Master.utils.log.log;

public class ServerThread implements Runnable {

    Server server = null;
    Socket client = null;
    BufferedReader cin;
    PrintStream cout;
    Scanner sc = new Scanner(System.in);
    int id;
    String s;

    ServerThread(Socket client, int count, Server server) throws IOException {

        this.client = client;
        this.server = server;
        this.id = count;
        log("w", "Connection unstable to " + client + " !");

        cin = new BufferedReader(new InputStreamReader(client.getInputStream()));
        cout = new PrintStream(client.getOutputStream());

    }

    @Override
    public void run() {
        int x = 1;
        try {
            while (true) {
                s = cin.readLine();
                String[] prop = s.split(",");
                    log("i", prop[0] + "(" + client.getInetAddress() + ") :" + Crypter.decrypt(prop[1]) + "\n");

                System.out.print("Server : ");
                //s=stdin.readLine();
                s = sc.nextLine();
                if (s.equalsIgnoreCase("bye")) {
                    cout.println("BYE");
                    x = 0;
                    break;
                }
                cout.println(s);
            }


            cin.close();
            client.close();
            cout.close();
            if (x == 0) {
                System.exit(0);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}