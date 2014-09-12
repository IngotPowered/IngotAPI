package com.ingotpowered.api.plugins;

import java.io.File;

public abstract class Plugin {

    private String name;
    private String author;
    private String description;
    private String jarFilePath;
    private File pluginDirectory;

    public abstract void onEnable();

    public abstract void onDisable();

    public final String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public final String getDescription() {
        return description;
    }

    public final String getJarFilePath() {
        return jarFilePath;
    }

    public File getPluginDirectory() {
        return pluginDirectory;
    }
}
