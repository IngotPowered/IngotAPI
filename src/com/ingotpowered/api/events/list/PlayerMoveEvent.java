package com.ingotpowered.api.events.list;

import com.ingotpowered.api.Orientation;
import com.ingotpowered.api.Player;
import com.ingotpowered.api.Position;
import com.ingotpowered.api.events.Cancellable;
import com.ingotpowered.api.events.Event;

public class PlayerMoveEvent extends Cancellable implements Event {

    private Player player;
    private Position oldPos;
    private Orientation oldOrientation;
    private Position newPos;
    private Orientation newOrientation;

    public PlayerMoveEvent(Player player, Position oldPos, Orientation oldOrientation, Position newPos, Orientation newOrientation) {
        this.player = player;
        this.oldPos = oldPos;
        this.oldOrientation = oldOrientation;
        this.newPos = newPos;
        this.newOrientation = newOrientation;
    }

    public Player getPlayer() {
        return player;
    }

    public Position getOldPosition() {
        return oldPos;
    }

    public Orientation getOldOrientation() {
        return oldOrientation;
    }

    public Position getNewPosition() {
        return newPos;
    }

    public Orientation getNewOrientation() {
        return newOrientation;
    }
}
