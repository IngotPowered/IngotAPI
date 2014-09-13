package com.ingotpowered.api.commands;

import com.ingotpowered.api.Ingot;
import com.ingotpowered.api.Player;

import java.util.concurrent.ConcurrentHashMap;

public class CommandRegistry {

    private ConcurrentHashMap<String, CommandHandler<Player>> playerCommandMap = new ConcurrentHashMap<String, CommandHandler<Player>>();
    private ConcurrentHashMap<String, CommandHandler<Ingot>> serverCommandMap = new ConcurrentHashMap<String, CommandHandler<Ingot>>();

    public void registerPlayerCommand(CommandHandler<Player> command) {
        if(command == null){
            throw new NullPointerException("Command cannot be null.");
        }
        synchronized (playerCommandMap) {
            playerCommandMap.put(command.getCommandName().toLowerCase(), command);
        }
    }

    public void registerServerCommand(CommandHandler<Ingot> command) {
        if(command == null){
            throw new NullPointerException("Command cannot be null.");
        }
        synchronized (serverCommandMap) {
            serverCommandMap.put(command.getCommandName().toLowerCase(), command);
        }
    }

    public boolean runPlayerCommand(Player p, String command, String[] args) {
        CommandHandler<Player> cmd = playerCommandMap.get(command);
        if (cmd == null) {
            return false;
        }
        try {
            cmd.execute(p, args);
        }
        catch(Exception ex){
            ex.printStackTrace();
            try {
                cmd.getPlugin().handleException(ex);
            }
            catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
        return true;
    }

    public boolean runServerCommand(Ingot i, String command, String[] args) {
        CommandHandler<Ingot> cmd = serverCommandMap.get(command);
        if (cmd == null) {
            return false;
        }
        try {
            cmd.execute(i, args);
        }
        catch(Exception ex){
            ex.printStackTrace();
            try{
                cmd.getPlugin().handleException(ex);
            }
            catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
        return true;
    }
}
