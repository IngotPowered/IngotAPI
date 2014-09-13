package com.ingotpowered.api.commands;

import com.ingotpowered.api.plugins.Plugin;

public abstract class CommandHandler<I> {

    private String commandName;

    private Plugin plugin;

    protected CommandHandler(String commandName, Plugin plugin) {
        if(commandName == null){
            throw new NullPointerException("Command name may not be null.");
        }
        if(plugin == null){
            throw new NullPointerException("Plugin may not be null.");
        }
        this.commandName = commandName;
        this.plugin = plugin;
    }

    public abstract void execute(I sender, String[] args);

    public String getCommandName() {
        return commandName;
    }

    public Plugin getPlugin(){
        return plugin;
    }
}
