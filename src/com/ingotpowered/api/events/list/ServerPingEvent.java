package com.ingotpowered.api.events.list;

import com.ingotpowered.api.events.Event;

public class ServerPingEvent implements Event {

    private String versionName;
    private int protocol;
    private int onlinePlayers;
    private int maxPlayers;
    private String motd;

    public ServerPingEvent(String versionName, int protocol, int onlinePlayers, int maxPlayers, String motd) {
        this.versionName = versionName;
        this.protocol = protocol;
        this.onlinePlayers = onlinePlayers;
        this.maxPlayers = maxPlayers;
        this.motd = motd;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getOnlinePlayersDisplayCount() {
        return onlinePlayers;
    }

    public void overrideOnlinePlayersDisplayCount(int players) {
        this.onlinePlayers = players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers() {
        this.maxPlayers = maxPlayers;
    }

    public String getMOTD() {
        return motd;
    }

    public void setMOTD(String motd) {
        this.motd = motd;
    }
}
