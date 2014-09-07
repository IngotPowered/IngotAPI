package com.ingotpowered.api;

public interface Player {

    public String getUsername();

    public String getUUID();

    public void sendMessage(String message);

    public void sendJSONMessage(String json);

    public void kick();
    public void kick(String reason);

    public String getBase64EncodedSkin();
}
