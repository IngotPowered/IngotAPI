package com.ingotpowered.api;

public class Orientation {

    private final float yaw;
    private final float pitch;

    public Orientation(float yaw, float pitch) {
        this.yaw = yaw%360;
        this.pitch = pitch%360;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
