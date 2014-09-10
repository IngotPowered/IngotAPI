package com.ingotpowered.api.events;

import com.ingotpowered.api.Ingot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventFactory {

    private ExecutorService threadPool;

    public EventFactory() {
        if (threadPool != null) {
            throw new RuntimeException("threadPool already initialized!");
        }
        threadPool = Executors.newFixedThreadPool(Ingot.getServer().getConfig().getPluginEventThreads());
    }
}
