package com.ingotpowered.api;

import com.ingotpowered.api.entity.Entity;

public interface Player extends Entity {

    public void sendMessage(String message);

    public void sendJSONMessage(String json);

    public void setCompassSpawn(Position compassSpawn);

    public void kick();
    public void kick(String reason);

    public String getUsername();

    public String getUUID();

    public String getBase64EncodedSkin();

    public boolean isOnGround();

    public long getPing();

    public String getLocale();

    public String getHostname();

    public int getPort();

    public Position getCompassSpawnPosition();
}
