/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master.utils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log {
    static String log_save = "";
    static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    static Date time = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Date date = new Date();


    public static void log(String status, String text) {
        if (status.equalsIgnoreCase("i")) {
            System.out.println("[INFO] " + text + "\n");
            saveLog("[INFO] " + text + "\n", "i");
        }
        if (status.equalsIgnoreCase("w")) {
            System.out.println("[WARNING] " + text + "\n");
            saveLog("[WARNING] " + text + "\n", "w");
        }
        if (status.equalsIgnoreCase("e")) {
            System.out.println("[ERROR] " + text + "\n");
            saveLog("[ERROR] " + text + "\n", "e");
        }
        if (status.equalsIgnoreCase("")) {
            System.out.println(text + "\n");
        }
    }

    public static void saveLog(String logt, String id) {
    }

    private static void readFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            log_save = line;
        }

        br.close();
    }
}
