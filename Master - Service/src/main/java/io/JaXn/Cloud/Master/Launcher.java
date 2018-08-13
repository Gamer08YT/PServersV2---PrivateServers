/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */


package io.JaXn.Cloud.Master;

import static io.JaXn.Cloud.Master.Master.start;

public class Launcher {
    public static int QuerryPort = 5000;
    public static int ProxyPort = 25565;
    public static int WebservicePort = 8086;
    public static boolean FirstStart = false;
    public static String DEV_KEY;
    public static String DEV_USER;

    public static void main(String[] args) {
        start();
    }


}
