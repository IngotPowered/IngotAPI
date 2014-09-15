package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerClickEvent extends Cancellable implements Event {

    private Player player;

    public PlayerClickEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
