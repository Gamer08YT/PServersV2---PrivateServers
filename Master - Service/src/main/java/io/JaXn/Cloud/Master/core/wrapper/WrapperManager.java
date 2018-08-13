/*
 *
 *  Creator Jan Heil
 *  (C) 2018 All rights reserved!
 *  Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */

package io.JaXn.Cloud.Master.core.wrapper;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static io.JaXn.Cloud.Master.utils.log.log;

public class WrapperManager {

    public WrapperManager(String name, String Adress, int Port) {
        File key = new File("./master/", "WRAPPER.KEY");
        if (key.exists()) {
            log("e",  "The Wrapper File already exits!");
            log("e",  "Copy \"/master/WRAPPER.KEY\" to your Wrapper!");
        } else {
            File wrapperkey = new File("./master/", "WRAPPER.KEY");
            File authkey = new File("./master/wrapper/key", "WRAPPER.KEY");

            String keytext = UUID.randomUUID().toString() + UUID.randomUUID().toString() + UUID.randomUUID().toString() + UUID.randomUUID().toString() + UUID.randomUUID().toString()+ UUID.randomUUID().toString()+ UUID.randomUUID().toString()+ UUID.randomUUID().toString()+ UUID.randomUUID().toString()+ UUID.randomUUID().toString()+ UUID.randomUUID().toString();
            try {
                PrintWriter printWriter = new PrintWriter(wrapperkey, "UTF-8");
                printWriter.println(keytext);

                PrintWriter printWriter1 = new PrintWriter(authkey, "UTF-8");
                printWriter1.println(keytext);

                printWriter.close();
                printWriter1.close();
            } catch (FileNotFoundException e) {
                log("e", e.getMessage());
            } catch (UnsupportedEncodingException e) {
                log("e", e.getMessage());
            }
            log("i", "Created Wrapper key in \"/master/WRAPPER.KEY\" !");
            log("i", "Copy \"/master/WRAPPER.KEY\" to your Wrapper!");
        }
    }
}
