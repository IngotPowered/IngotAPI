package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerCommandEvent extends Cancellable implements Event {

    private Player player;
    private String command;
    private String[] args;

    public PlayerCommandEvent(Player player, String command, String[] args) {
        this.player = player;
        this.command = command;
        this.args = args;
    }

    public Player getPlayer() {
        return player;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }
}
