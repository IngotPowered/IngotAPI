package com.ingotpowered.api;

public class Position {

    public static Position fromLong(long l) {
        Position p = new Position();
        p.x = (int) (l >> 38);
        p.y = (int) (l << 26 >> 52);
        p.z = (int) (l << 38 >> 38);
        return p;
    }

    public static long toLong(Position p) {
        return (p.x & 0x3FFFFFF) << 38 | (p.y & 0xFFF) << 26 | (p.z & 0x3FFFFFF);
    }

    private int x = 0;
    private int y = 0;
    private int z = 0;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private Position() { }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
