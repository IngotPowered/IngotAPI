package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerChatEvent extends Cancellable implements Event {

    private Player player;
    private String message;
    private String format = "<${0}> ${1}";

    public PlayerChatEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
