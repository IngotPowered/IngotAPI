package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.events.Event;

public class PlayerGroundStateEvent implements Event {

    private Player player;
    private boolean oldState;
    private boolean newState;

    public PlayerGroundStateEvent(Player player, boolean oldState, boolean newState) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean wasOnGround() {
        return oldState;
    }

    public boolean isNowOnGround() {
        return newState;
    }
}
