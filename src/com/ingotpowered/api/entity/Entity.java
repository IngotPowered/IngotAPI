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
    public void dismount();

    public void sendStatus(EntityAnimation animation);

    public boolean isAlive();

    /*
    Explanation for the following:
        In order to have a highly customizable server, it may be desired by the end server to modify how the entity behaves.
        Since we are running a cleanroom environment in development, we can not completely replicate the behavior of mobs. In
        some environments, this may not even be desired. The following methods will allow for a clean and safe way to interject into the tick
        sequence of the mob, and control the mechanics. There are already methods to move the mob relative, and to teleport the mobs.
     */

    public EntityTickManager getTickManager();
    public void setTickManager(EntityTickManager manager);
}
