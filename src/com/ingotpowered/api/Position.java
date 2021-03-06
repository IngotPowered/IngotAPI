package com.ingotpowered.api;

public class Position {

    public static Position fromLong(long l) {
        Position p = new Position();
        p.x = ((int) (l >> 38)) / 32;
        p.y = ((int) (l << 26 >> 52)) / 32;
        p.z = ((int) (l << 38 >> 38)) / 32;
        return p;
    }

    public static long toLong(Position p) {
        return (((int) p.x * 32) & 0x3FFFFFF) << 38 | (((int) p.y * 32) & 0xFFF) << 26 | (((int) p.z * 32) & 0x3FFFFFF);
    }

    private double x = 0;
    private double y = 0;
    private double z = 0;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position(double x, double y, double z) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            throw new IllegalArgumentException("x is out of range.");
        }
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            throw new IllegalArgumentException("y is out of range.");
        }
        if(z > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            throw new IllegalArgumentException("z is out of range.");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private Position() { }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position p = (Position) o;
        return p.x == x && p.y == y && p.z == z;
    }

    public int hashCode() {
        return ("" + x + ":" + y + ":" + z).hashCode();
    }
}
