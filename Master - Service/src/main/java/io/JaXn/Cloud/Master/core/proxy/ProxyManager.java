/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 *
 */
package io.JaXn.Cloud.Master.core.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static io.JaXn.Cloud.Master.Launcher.ProxyPort;
import static io.JaXn.Cloud.Master.utils.log.log;

public class ProxyManager {
    public static Process pr;

    //C:\Users\User>taskkill /pid 4896 /F
    public static void startProxy() throws IOException {
        copy(ProxyManager.class.getResourceAsStream("config.yml"), "./master/proxy/config.yml");
        pr = new ProcessBuilder(
                "java",
                "-Xms350M",
                "-jar",
                "Proxy.jar",
                "-DIReallyKnowWhatIAmDoingThisUpdate=true",
                "nogui")
                .directory(new File("master/proxy")) //Set the working directory to ./minecraft/
                .start();
        log("i", "Proxy was successfully started at port: " + ProxyPort);
    }

    public static void stopProxy() {
        pr.destroy();

    }

    public static void killProcess() {
        pr.destroyForcibly();
    }

    public static void proxyConsole() {
        InputStream inputStream = null;
        ByteArrayOutputStream arrayOutputStream = null;

        try {
            inputStream = pr.getInputStream();
            byte[] b = new byte[1024];
            int size = 0;
            arrayOutputStream = new ByteArrayOutputStream();

            while ((size = inputStream.read(b)) != -1) {
                arrayOutputStream.write(b, 0, size);
            }

            System.out.println(new String(arrayOutputStream.toByteArray()));

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (arrayOutputStream != null)
                    arrayOutputStream.close();
            } catch (Exception exception) {
                exception.getStackTrace();
            }
        }
    }


    public static void removeOld() {

    }

    public static boolean copy(InputStream source, String destination) {
        boolean succeess = true;


        try {
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            log("e", ex.getMessage());
            succeess = false;
        }

        return succeess;

    }

    public static final String getBasePathForClass(Class<?> classs) {

        // Local variables
        File file;
        String basePath = "";
        boolean failed = false;

        // Let's give a first try
        try {
            file = new File(classs.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

            if (file.isFile() || file.getPath().endsWith(".jar") || file.getPath().endsWith(".zip")) {
                basePath = file.getParent();
            } else {
                basePath = file.getPath();
            }
            log("i", "Copying default Proxy config!");
        } catch (URISyntaxException ex) {
            failed = true;
            log("e", ex.getMessage());
        }

        // The above failed?
        if (failed) {
            try {
                file = new File(classs.getClassLoader().getResource("").toURI().getPath());
                basePath = file.getAbsolutePath();

                log("i", "Copying default Proxy config with second try!");
            } catch (URISyntaxException ex) {
                log("e", ex.getMessage());
            }
        }

        // fix to run inside eclipse
        if (basePath.endsWith(File.separator + "lib") || basePath.endsWith(File.separator + "bin")
                || basePath.endsWith("bin" + File.separator) || basePath.endsWith("lib" + File.separator)) {
            basePath = basePath.substring(0, basePath.length() - 4);
        }
        // fix to run inside netbeans
        if (basePath.endsWith(File.separator + "build" + File.separator + "classes")) {
            basePath = basePath.substring(0, basePath.length() - 14);
        }
        // end fix
        if (!basePath.endsWith(File.separator)) {
            basePath = basePath + File.separator;
        }
        log("i", "Copying sucess -> Proxy starting!");
        return basePath;
    }

    public static void dwl() {
        copy(ProxyManager.class.getResourceAsStream("Proxy.jar"), "./master/proxy/Proxy.jar");
    }
}
