package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerKickEvent extends Cancellable implements Event {

    private Player player;
    private String kickMessage;

    public PlayerKickEvent(Player player, String kickMessage) {
        this.player = player;
        this.kickMessage = kickMessage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setKickMessage(String kickMessage) {
        this.kickMessage = kickMessage;
    }

    public String getKickMessage() {
        return kickMessage;
    }
}
