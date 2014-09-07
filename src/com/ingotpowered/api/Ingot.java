package com.ingotpowered.api;

public abstract class Ingot {

    private static Ingot ingot;

    public static void setServer(Ingot instance) {
        if (ingot != null) {
            throw new RuntimeException("Server already exists!");
        }
        ingot = instance;
    }

    public static Ingot getServer() {
        return ingot;
    }

    public abstract void dispatchCommand(String command);

    public abstract void stop();

    public abstract Config getConfig();
}
