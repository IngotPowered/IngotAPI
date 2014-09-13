package com.ingotpowered.api.world;

public class ChunkPosition {

    private int x;
    private int z;

    public ChunkPosition(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int hashCode() {
        return (x + ":" + z).hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof ChunkPosition) {
            ChunkPosition pos = (ChunkPosition) o;
            return pos.x == this.x && pos.z == this.z;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}
