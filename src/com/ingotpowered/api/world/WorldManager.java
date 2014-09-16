package com.ingotpowered.api.world;

public interface WorldManager {

    public World getDefaultWorld();
    public World getExistingWorld(String name);

    public World createWorldSync(String name);
}
