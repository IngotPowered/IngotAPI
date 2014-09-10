package com.ingotpowered.api.world;

public class ChunkPosition {

    private int x;
    private int y;

    public ChunkPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return (x + ":" + y).hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof ChunkPosition) {
            ChunkPosition pos = (ChunkPosition) o;
            return pos.x == this.x && pos.y == this.y;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
