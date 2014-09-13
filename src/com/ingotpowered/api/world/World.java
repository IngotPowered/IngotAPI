package com.ingotpowered.api.world;

public interface World {

    public Chunk getChunkAt(ChunkPosition position);

    public Chunk getChunkAt(int x, int z);

}
