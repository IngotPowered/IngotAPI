package com.ingotpowered.api.world;

import com.ingotpowered.api.Position;

public interface Block {

    public World getWorld();

    public Position getPosition();

    public String getType();

    public byte getID();

}
