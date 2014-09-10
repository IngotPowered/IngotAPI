package com.ingotpowered.api.definitions;

public enum LevelType {

    DEFAULT("default"), FLAT("flat"), LARGE_BIOMES("largeBiomes"), AMPLIFIED("amplified"), DEFAULT_1_1("default_1_1");

    private String name;

    private LevelType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
