/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master.command;

import io.JaXn.Cloud.Master.commandmanager.Command;

import static io.JaXn.Cloud.Master.utils.log.log;

public class Create_Proxy_CMD implements Command {
    @Override
    public void execute(String[] arg0) {
        if(arg0[0].equalsIgnoreCase("createproxy")) {
            if(arg0.length <=4) {
                log("i", getUsage());
            }
        }
    }

    @Override
    public String getUsage() {
        return "Create Proxy -> createproxy <Wrapper> <Port> <Max Player> <Max Ram> -> Create End Server";
    }
}
