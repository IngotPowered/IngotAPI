package com.ingotpowered.api.events;

public interface Event {

    public boolean isCancelled();

    public void setCancelled(boolean cancelled);
}
