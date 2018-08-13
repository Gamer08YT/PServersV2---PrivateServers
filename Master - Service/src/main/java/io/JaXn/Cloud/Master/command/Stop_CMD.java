/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master.command;

import io.JaXn.Cloud.Master.commandmanager.Command;
import io.JaXn.Cloud.Master.core.proxy.ProxyManager;
import io.JaXn.Cloud.Master.core.webserver.WebService;

import static io.JaXn.Cloud.Master.utils.log.log;

public class Stop_CMD implements Command {
    public void execute(String[] args) {
        if(args[0].equalsIgnoreCase("stop")) {
            ProxyManager.stopProxy();
            log("i", "Stopping Proxy Server... please wait!");
            if(ProxyManager.pr.isAlive()) {
                ProxyManager.killProcess();
                log("i", "Stopping Proxy Server failed, killing procces... please wait!");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebService.stop();
            System.exit(0);
        }
    }

    public String getUsage() {
        return "Stop -> Stop your JaXnCloud Master Service and their Wrapper Services!";
    }
}
