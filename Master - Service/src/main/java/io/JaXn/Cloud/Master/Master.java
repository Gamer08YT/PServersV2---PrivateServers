/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master;

import io.JaXn.Cloud.Master.command.*;
import io.JaXn.Cloud.Master.commandmanager.Command;
import io.JaXn.Cloud.Master.core.cfg.FileManager;
import io.JaXn.Cloud.Master.core.webserver.WebService;
import io.JaXn.Cloud.Master.network.Server;
import io.JaXn.Cloud.Master.utils.CloudHandler;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static io.JaXn.Cloud.Master.core.file.DefaultJARs.dwlProxy;
import static io.JaXn.Cloud.Master.core.proxy.ProxyManager.startProxy;
import static io.JaXn.Cloud.Master.utils.log.log;

public class Master {
    public static List<Command> commands = new ArrayList<>();
    public static Server server;

    public static void start() {

        log("i", "JaXnCloud - \"Master\" is starting...");
        System.out.println("                )                                   \n" +
                "             ( /(          (    (              (    \n" +
                "   (      )  )\\())         )\\   )\\        (    )\\ ) \n" +
                "   )\\  ( /( ((_)\\   (    (((_) ((_) (    ))\\  (()/( \n" +
                "  ((_) )(_))__((_)  )\\ ) )\\___  _   )\\  /((_)  ((_))\n" +
                " _ | |((_)_ \\ \\/ / _(_/(((/ __|| | ((_)(_))(   _| | \n" +
                "| || |/ _` | >  < | ' \\))| (__ | |/ _ \\| || |/ _` | \n" +
                " \\__/ \\__,_|/_/\\_\\|_||_|  \\___||_|\\___/ \\_,_|\\__,_| \n" +
                "                                                    \n");
        log("i", "Cloud Version V0.1.0 by Jan H. / Gamer08");
        try {CloudHandler.check();} catch (IOException e) {log("e", e.getMessage());} catch (ParseException e) {log("e", e.getMessage());}
    }

    public static void registerCommand() {
        addCommand(new Stop_CMD());
        addCommand(new Help_CMD());
        addCommand(new Create_Server_CMD());
        addCommand(new Create_Wrapper_CMD());
        addCommand(new Create_Proxy_CMD());
        addCommand(new View_Console_CMD());

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() != 0) {
                    for (Command command : commands) {
                        command.execute(line.split(" "));
                    }
                }
            }
        } catch (Exception ex) {
            log("e", ex.getMessage());
        }
    }

    public static void addCommand(Command command) {
        commands.add(command);
    }
}
