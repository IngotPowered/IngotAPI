package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Event;

public class PlayerLoginEvent implements Event {

    private Player player;
    private String joinMessage;

    public PlayerLoginEvent(Player player) {
        this.player = player;
        this.joinMessage = player.getUsername() + " connected to the server.";
    }

    public Player getPlayer() {
        return player;
    }

    public void setJoinMessage(String joinMessage) {
        this.joinMessage = joinMessage;
    }

    public String getJoinMessage() {
        return joinMessage;
    }
}
