package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Player;
import com.ingotpowered.api.Position;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerClickEvent extends Cancellable implements Event {

    private Player player;
    private Position clickedPosition;
    private byte blockFace;

    public PlayerClickEvent(Player player, Position clickedPosition, byte blockFace) {
        this.player = player;
        this.clickedPosition = clickedPosition;
        this.blockFace = blockFace;
    }

    public Player getPlayer() {
        return player;
    }

    public Position getClickedPosition() {
        return clickedPosition;
    }

    public byte getBlockFace() {
        return blockFace;
    }
}
