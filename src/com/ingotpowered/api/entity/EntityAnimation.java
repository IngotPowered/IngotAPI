package com.ingotpowered.api.entity;

/**
 * Created by Joe on 9/14/2014.
 */
public enum EntityAnimation {

    HURT(2),
    DEAD(3),
    IRON_GOLEM_THROW_UP_ARMS(4),
    TAMING(6),
    TAMED(7),
    WOLF_SHAKING_WATER(8),
    EATING(9),
    SHEEP_EAT_GRASS(10),
    IRON_GOLEM_HAND_ROSE(11),
    VILLAGER_MATING(12),
    ANGRY_VILLAGER(13),
    HAPPY_VILLAGER(14),
    WITCH_MAGIC_PARTICLES(15),
    ZOMBIE_TO_VILLAGER(16),
    FIREWORK_EXPLODE(17),
    ANIMAL_IN_LOVE(18);

    EntityAnimation(int status){
        this.status = (byte) status;
    }


    private byte status;

    public byte getStatus(){
        return status;
    }
}
