package com.ingotpowered.api.commands;

public abstract class CommandHandler<I> {

    private String commandName;

    public CommandHandler(String commandName) {
        this.commandName = commandName;
    }

    public abstract void execute(I sender, String[] args);

    public String getCommandName() {
        return commandName;
    }
}
