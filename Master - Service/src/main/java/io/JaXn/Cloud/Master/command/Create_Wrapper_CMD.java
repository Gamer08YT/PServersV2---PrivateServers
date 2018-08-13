/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master.command;

import io.JaXn.Cloud.Master.commandmanager.Command;
import io.JaXn.Cloud.Master.core.wrapper.WrapperManager;

import static io.JaXn.Cloud.Master.utils.log.log;

public class Create_Wrapper_CMD implements Command {
    @Override
    public void execute(String[] arg0) {
        if(arg0[0].equalsIgnoreCase("createwrapper")) {
            if(arg0.length == 1) {
                log("i", getUsage());
            }
            if(arg0.length==4) {
                String name = arg0[1];
                String adress = arg0[2];
                int port = Integer.parseInt(arg0[3]);
                new WrapperManager(name, adress, port);
            }
        }
    }

    @Override
    public String getUsage() {
        return "Create Wrapper -> createwrapper <Name> <Adress> <Wrapper Port>";
    }
}
