package io.JaXn.Cloud.Master.core.cfg;
/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

import io.JaXn.Cloud.Master.Launcher;
import io.JaXn.Cloud.Master.Master;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import static io.JaXn.Cloud.Master.utils.log.log;

public class FileManager {
    public static File service = new File("./master/services/services.json");

    public static void filemanager() {
        File log = new File("./master/log");
        log.mkdirs();

        File web = new File("./master/services/webservice/bin");
        web.mkdirs();

        File dircfg = new File("./master/config");
        dircfg.mkdirs();

        File autkey = new File("./master/wrapper/key");
        autkey.mkdirs();

        File dirsign = new File("./master/sign");
        dirsign.mkdirs();

        File dirproxy = new File("./master/proxy");
        dirproxy.mkdirs();

        File dirdata = new File("./master/database");
        dirdata.mkdirs();

        File servercfg = new File("./master/");
        if (!servercfg.exists()) {
            try {
                servercfg.createNewFile();
            } catch (IOException e) {
                log("e", e.getMessage());
            }
        }
    }

    public static void setup() {


        if (!service.exists()) {
            JSONObject object = new JSONObject();
            object.put("Querry.Port", 4312);
            object.put("Proxy.Port", 25565);
            object.put("Webservice.Port", 8086);
            object.put("Setup.Status", true);

            String randomeKey = UUID.randomUUID().toString() + UUID.randomUUID().toString();
            String randomeUser = "admin";

            object.put("Dev.Key", randomeKey);
            object.put("Dev.User", randomeUser);

            try (FileWriter fileWriter = new FileWriter(service)) {
                fileWriter.write(object.toJSONString());
                fileWriter.flush();
            } catch (IOException e) {
                log("e", e.getMessage());
            }
            Launcher.FirstStart = true;
            log("i", "Please enter the querry port for your master service: (4312)");
        }

    }
}
