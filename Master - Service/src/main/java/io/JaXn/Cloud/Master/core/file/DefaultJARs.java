/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */
package io.JaXn.Cloud.Master.core.file;

import io.JaXn.Cloud.Master.core.proxy.ProxyManager;

import java.io.File;
import java.io.IOException;

import static io.JaXn.Cloud.Master.utils.log.log;

public class DefaultJARs {
    public static void dwlProxy() {
        File proxy = new File("master/proxy/Proxy.jar");

        if(!proxy.exists()) {
                ProxyManager.dwl();
            log("i", "Downloading Proxy, please wait a moment!");
        } else {
            log("i", "Proxy -> Installed -> Starting!");
        }
    }
}
