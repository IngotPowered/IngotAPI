package com.ingotpowered.api.entity;

import com.ingotpowered.api.Orientation;
import com.ingotpowered.api.Position;
import com.ingotpowered.api.world.World;

public interface Entity {

    public int getId();

    public Position getPosition();

    public Orientation getOrientation();

    public void moveRelative(double x, double y, double z);
    public void setOrientation(Orientation orientation);
    public void moveRelative(double x, double y, double z, Orientation orientation);

    public void teleport(Position position);
    public void teleport(Position position, World world);
    public void teleport(Position position, Orientation orientation);
    public void teleport(Position position, World world, Orientation orientation);

    public void mount(Rideable rideable);
    public void dismount(Rideable rideable);

    public void sendStatus(EntityAnimation animation);

    public boolean isAlive();
}
