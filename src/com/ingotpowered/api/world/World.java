package com.ingotpowered.api.world;

import com.ingotpowered.api.definitions.Difficulty;
import com.ingotpowered.api.definitions.Dimension;
import com.ingotpowered.api.definitions.LevelType;

public interface World {

    public LevelType getType();

    public Dimension getDimension();

    public Difficulty getDifficulty();

    public void setDifficulty(Difficulty difficulty);

    public String getName();

    public Chunk getChunkAt(ChunkPosition position);

    public Chunk getChunkAt(int x, int z);

}
