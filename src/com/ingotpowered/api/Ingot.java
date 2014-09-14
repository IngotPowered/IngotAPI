package com.ingotpowered.api;

import com.ingotpowered.api.commands.CommandRegistry;
import com.ingotpowered.api.events.EventFactory;

public abstract class Ingot {

    public static final String VERSION_NAME = "1.8.Ingot";
    public static final int PROTOCOL_VERSION = 47;

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

    public abstract Player getPlayer(String name);

    public abstract void stop();

    public abstract Config getConfig();

    public abstract EventFactory getEventFactory();

    public abstract CommandRegistry getCommandRegistry();

    public abstract void broadcastMessage(String message);
}
