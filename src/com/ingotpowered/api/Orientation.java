package com.ingotpowered.api;

public class Orientation {

    private float yaw;
    private float pitch;

    public Orientation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
