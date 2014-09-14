package com.ingotpowered.api.world;

import com.ingotpowered.api.Position;
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

    public Block getBlock(int x, int y, int z);

    public Block getBlock(double x, double y, double z);

    public Block getBlock(Position position);
}
