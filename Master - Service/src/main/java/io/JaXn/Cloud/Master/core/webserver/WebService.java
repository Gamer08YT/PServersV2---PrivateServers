/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 */

package io.JaXn.Cloud.Master.core.webserver;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import io.JaXn.Cloud.Master.Launcher;

import java.io.IOException;
import java.net.InetSocketAddress;

import static io.JaXn.Cloud.Master.utils.log.log;

public class WebService {
    static HttpServer server = null;
    public static void start() {
        try {
             server = HttpServer.create(new InetSocketAddress(Launcher.WebservicePort), 0);
             log("i", "Starting Webservice at port: " + Launcher.WebservicePort + " !");
        } catch (IOException e) {
            log("e", e.getMessage());
        }

        server.createContext("/", new WebManager());
        HttpContext hc1 = server.createContext("/dev", new CloudService());
        hc1.getFilters().remove("admin");
        hc1.setAuthenticator(new BasicAuthenticator("get") {
            @Override
            public boolean checkCredentials(String user, String pw) {
                return user.equals(Launcher.DEV_USER) && pw.equals(Launcher.DEV_KEY);
            }
        });
        server.setExecutor(null);
        server.start();
    }
    public static void stop() {
        server.stop(0);
    }

}
