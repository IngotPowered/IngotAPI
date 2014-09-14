package com.ingotpowered.api.world;

public interface Chunk {

    public World getWorld();

    public ChunkPosition getPosition();

    public int getX();

    public int getZ();

    public Block getBlock(int x, int y, int z);

}
