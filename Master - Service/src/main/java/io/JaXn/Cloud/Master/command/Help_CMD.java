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

import io.JaXn.Cloud.Master.Master;
import io.JaXn.Cloud.Master.commandmanager.Command;

import static io.JaXn.Cloud.Master.utils.log.log;

public class Help_CMD implements Command {
    public void execute(String[] args) {
        if(args[0].equalsIgnoreCase("help")) {
            Master.commands.forEach(command -> {
                if(!(command.getUsage() == null)) {
                    log("i", command.getUsage());
                }
            });
        }
    }

    public String getUsage() {
        return "Help -> See all possible Commands";
    }
}
