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

package io.JaXn.Cloud.Master.commandmanager;

public interface Command {
    void execute(String[] arg0);
    String getUsage();

}
