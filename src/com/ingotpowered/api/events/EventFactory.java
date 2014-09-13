package com.ingotpowered.api.events;

import com.ingotpowered.api.Ingot;
import com.ingotpowered.api.plugins.Plugin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EventFactory {

    private ExecutorService threadPool;
    private ConcurrentHashMap<Class<? extends Event>, ArrayList<PluginMethodPair>> eventMap = new ConcurrentHashMap<Class<? extends Event>, ArrayList<PluginMethodPair>>();

    public EventFactory() {
        if (threadPool != null) {
            throw new RuntimeException("threadPool already initialized!");
        }
        threadPool = Executors.newFixedThreadPool(Ingot.getServer().getConfig().getPluginEventThreads());
    }

    public void registerHooks(Plugin plugin, EventHandler handler) {;
        Method[] availableMethods = handler.getClass().getMethods();
        for (int i = 0; i < availableMethods.length; i++) {
            if (availableMethods[i].getName().equals("equals") || availableMethods[i].getName().equals("wait")) {
                continue;
            }
            Class<?>[] parameters = availableMethods[i].getParameterTypes();
            if (parameters.length != 1) {
                continue;
            }
            if (parameters[0].getSuperclass() == Event.class) {
                continue;
            }
            ArrayList<PluginMethodPair> methodList = eventMap.get(parameters[0]);
            if (methodList == null) {
                methodList = new ArrayList<PluginMethodPair>();
                synchronized (eventMap) {
                    eventMap.put((Class<? extends Event>) parameters[0], methodList);
                }
            }
            synchronized (methodList) {
                methodList.add(new PluginMethodPair(plugin, availableMethods[i]));
            }
        }
    }

    public void callEvent(final Event e, final Runnable finished) {
        ArrayList<PluginMethodPair> hooks = eventMap.get(e.getClass());
        if (hooks == null) {
            if (finished != null) {
                threadPool.submit(finished);
            }
            return;
        }
        PluginMethodPair[] methods;
        synchronized (hooks) {
            methods = hooks.toArray(new PluginMethodPair[hooks.size()]);
        }
        final PluginMethodPair[] methodList = methods;
        threadPool.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < methodList.length; i++) {
                    try {
                        methodList[i].getMethod().invoke(methodList[i].getPlugin(), e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                if (finished != null) {
                    finished.run();
                }
            }
        });
    }

    public void destroyThreadPool() {
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1000 * 30, TimeUnit.MILLISECONDS);
            System.out.println("Plugin thread pool has been shut down.");
        } catch (Exception ex) {
            System.out.println("[ WARNING ] Can't shut down plugin threads! Is a plugin blocking on an event?");
        }
    }
}
