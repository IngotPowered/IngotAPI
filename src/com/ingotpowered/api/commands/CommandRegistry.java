package com.ingotpowered.api.commands;

import com.ingotpowered.api.Ingot;
import com.ingotpowered.api.Player;

import java.util.concurrent.ConcurrentHashMap;

public class CommandRegistry {

    private ConcurrentHashMap<String, CommandHandler<Player>> playerCommandMap = new ConcurrentHashMap<String, CommandHandler<Player>>();
    private ConcurrentHashMap<String, CommandHandler<Ingot>> serverCommandMap = new ConcurrentHashMap<String, CommandHandler<Ingot>>();

    public void registerPlayerCommand(CommandHandler<Player> command) {
        synchronized (playerCommandMap) {
            playerCommandMap.put(command.getCommandName().toLowerCase(), command);
        }
    }

    public void registerServerCommand(CommandHandler<Ingot> command) {
        synchronized (serverCommandMap) {
            serverCommandMap.put(command.getCommandName().toLowerCase(), command);
        }
    }

    public boolean runPlayerCommand(Player p, String command, String[] args) {
        CommandHandler<Player> cmd = playerCommandMap.get(command);
        if (cmd == null) {
            return false;
        }
        cmd.execute(p, args);
        return true;
    }

    public boolean runServerCommand(Ingot i, String command, String[] args) {
        CommandHandler<Ingot> cmd = serverCommandMap.get(command);
        if (cmd == null) {
            return false;
        }
        cmd.execute(i, args);
        return true;
    }
}
