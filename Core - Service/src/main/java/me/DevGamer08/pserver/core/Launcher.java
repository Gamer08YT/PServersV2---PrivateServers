package me.DevGamer08.pserver.core;

import me.DevGamer08.pserver.core.module.ModuleHandler;

public class Launcher {
    public static void main(String[] args) {
        ModuleHandler moduleHandler = new ModuleHandler();

        moduleHandler.dir();
        moduleHandler.check();
    }
}
