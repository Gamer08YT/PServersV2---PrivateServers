package me.DevGamer08.pserver.core.module;

import java.io.File;
import java.util.ArrayList;

public class ModuleHandler {
    public ArrayList<String> modules = new ArrayList<String>();

    public ModuleHandler() {
    }

    public void dir() {
        File modules = new File("./modules/");
        if (!modules.exists()) {
            modules.mkdir();
            check();
        } else {
            check();
        }
    }

    public void check() {
        File module = new File("./modules/");
        for (File file : module.listFiles()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".module")) {
                    if(!modules.contains(file.getName())) {
                        modules.add(file.getName());
                    }
                }
            }
        }
        System.out.println(modules);
    }
}
