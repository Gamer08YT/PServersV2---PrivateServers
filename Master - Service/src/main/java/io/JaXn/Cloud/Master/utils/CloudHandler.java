/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 *
 */

package io.JaXn.Cloud.Master.utils;

import io.JaXn.Cloud.Master.Launcher;
import io.JaXn.Cloud.Master.Master;
import io.JaXn.Cloud.Master.core.cfg.FileManager;
import io.JaXn.Cloud.Master.core.webserver.WebService;
import io.JaXn.Cloud.Master.network.Server;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static io.JaXn.Cloud.Master.core.cfg.FileManager.service;
import static io.JaXn.Cloud.Master.core.file.DefaultJARs.dwlProxy;
import static io.JaXn.Cloud.Master.core.proxy.ProxyManager.startProxy;
import static io.JaXn.Cloud.Master.utils.log.log;

public class CloudHandler {
    public static void check() throws IOException, ParseException {
        FileManager.filemanager();
        FileManager.setup();

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(service));
        JSONObject jsonObject = (JSONObject) object;

        //Get Objekts for Launcher!!
        Launcher.FirstStart = (boolean) jsonObject.get("Setup.Status");
        Launcher.WebservicePort = (int) (long) jsonObject.get("Webservice.Port");
        Launcher.QuerryPort = (int) (long) jsonObject.get("Querry.Port");
        Launcher.ProxyPort = (int) (long) jsonObject.get("Proxy.Port");

        Launcher.DEV_KEY = (String) jsonObject.get("Dev.Key");
        Launcher.DEV_USER = (String) jsonObject.get("Dev.User");

        if (Launcher.FirstStart == false) {
            WebService.start();
            try {
                Server server = new Server(Launcher.QuerryPort);
                server.startServer();
            } catch (Exception e) {
                log("e", e.getMessage());
            }
            dwlProxy();
            try {
                startProxy();
            } catch (IOException e) {
                log("e", e.getMessage());
            }
            Master.registerCommand();
            log("i", "Type \"help\" for Service Information and Commands");
        } else {

        }
    }
}
