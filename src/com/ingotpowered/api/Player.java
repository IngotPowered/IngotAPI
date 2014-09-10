package com.ingotpowered.api;

public interface Player {

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

    public Position getCompassSpawnPosition();
}
