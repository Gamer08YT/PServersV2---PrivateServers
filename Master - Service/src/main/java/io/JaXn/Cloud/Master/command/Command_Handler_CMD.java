/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 *
 */

package io.JaXn.Cloud.Master.command;

import io.JaXn.Cloud.Master.Master;
import io.JaXn.Cloud.Master.commandmanager.Command;

import static io.JaXn.Cloud.Master.utils.log.log;

public class Command_Handler_CMD implements Command {
    @Override
    public void execute(String[] arg0) {
        if(arg0[0].equalsIgnoreCase(String.valueOf(Master.commands))) {
            Master.commands.forEach(command -> {
                if (!(command.getUsage() == null)) {
                    log("i", command.getUsage());
                }
            });
        }
    }

    @Override
    public String getUsage() {
        return "";
    }
}
