package com.ingotpowered.api.plugins;

public abstract class Plugin {

    private String name;
    private String version;
    private String jarFilePath;
    private String mainClassPath;

    public abstract void onEnable();

    public abstract void onDisable();

    public final String getName() {
        return name;
    }

    public final String getVersion() {
        return version;
    }

    public final String getJarFilePath() {
        return jarFilePath;
    }

    public final String getMainClassPath() {
        return mainClassPath;
    }
}
