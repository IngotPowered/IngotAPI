package com.ingotpowered.api;

public class Velocity {

    private Velocity(){}

    public Velocity(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Velocity fromLong(long l) {
        Velocity v = new Velocity();
        v.x = ((int) (l >> 38)) / 32;
        v.y = ((int) (l << 26 >> 52)) / 32;
        v.z = ((int) (l << 38 >> 38)) / 32;
        return v;
    }

    public static long toLong(Velocity v) {
        return (((int) v.x * 32) & 0x3FFFFFF) << 38 | (((int) v.y * 32) & 0xFFF) << 26 | (((int) v.z * 32) & 0x3FFFFFF);
    }

    private double x = 0;
    private double y = 0;
    private double z = 0;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Velocity)) {
            return false;
        }
        Velocity v = (Velocity) o;
        return v.x == x && v.y == y && v.z == z;
    }

    public int hashCode() {
        return ("" + x + ":" + y + ":" + z).hashCode();
    }
}
