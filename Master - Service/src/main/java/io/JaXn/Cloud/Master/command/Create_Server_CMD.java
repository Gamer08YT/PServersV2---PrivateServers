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

public class Create_Server_CMD implements Command {
    @Override
    public void execute(String[] args) {
        if (args[0].equalsIgnoreCase("createserver")) {
            if (args.length <= 6) {
                log("i", getUsage());
                return;
            }
        }

    }

    @Override
    public String getUsage() {
        return "Create Server -> createserver <Wrapper> <Server> <Group> <Max Ram> <Max Player> <Mode> -> Create End Server";
    }
}
