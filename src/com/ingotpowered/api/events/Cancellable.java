package com.ingotpowered.api.events;

public abstract class Cancellable {

    private boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
