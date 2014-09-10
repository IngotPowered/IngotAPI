package com.ingotpowered.api.events;

import com.ingotpowered.api.plugins.Plugin;

import java.lang.reflect.Method;

public class PluginMethodPair {

    private Plugin plugin;
    private Method method;

    public PluginMethodPair(Plugin plugin, Method method) {
        this.plugin = plugin;
        this.method = method;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public Method getMethod() {
        return method;
    }
}
