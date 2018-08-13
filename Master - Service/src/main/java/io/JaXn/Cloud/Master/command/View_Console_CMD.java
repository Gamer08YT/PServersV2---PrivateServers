/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 */

package io.JaXn.Cloud.Master.command;

import io.JaXn.Cloud.Master.commandmanager.Command;

import static io.JaXn.Cloud.Master.core.proxy.ProxyManager.proxyConsole;
import static io.JaXn.Cloud.Master.utils.log.log;

public class View_Console_CMD implements Command {
    @Override
    public void execute(String[] arg0) {
        if (arg0[0].equalsIgnoreCase("screen")) {
            if (arg0[1].equalsIgnoreCase("-p")) {
                log("i", "Joining Screen from Server: Proxy-1");
                proxyConsole();
            } else if (arg0[1].equalsIgnoreCase("-g")) {
                log("i", "Joining Screen from Server: " + arg0[2]);
            } else {
                log("e", getUsage());
            }
        }
    }

    @Override
    public String getUsage() {
        return "Screen -> screen <-p (Proxy) / -g (Server - Group)> <ID>";
    }
}
