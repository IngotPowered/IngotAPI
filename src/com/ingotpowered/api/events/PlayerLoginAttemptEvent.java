package com.ingotpowered.api.events;

public class PlayerLoginAttemptEvent implements Event {

    private boolean cancelled = false;
    private String username;
    private String hostname;
    private short port;
    private String disconnectMessage = "Disconnected";

    public PlayerLoginAttemptEvent(String username, String hostname, short port) {
        this.username = username;
        this.hostname = hostname;
        this.port = port;
    }

    public String getDisconnectMessage() {
        return disconnectMessage;
    }

    public void setDisconnectMessage(String disconnectMessage) {
        this.disconnectMessage = disconnectMessage;
    }

    public String getUsername() {
        return username;
    }

    public String getHostname() {
        return hostname;
    }

    public short getPort() {
        return port;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
