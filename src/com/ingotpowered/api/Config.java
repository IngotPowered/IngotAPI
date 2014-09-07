package com.ingotpowered.api;

import java.io.*;
import java.lang.reflect.Field;

public class Config {

    private String generatorSettings = "";
    private String levelName = "world";
    private boolean onlineMode = true;
    private boolean enableQuery = false;
    private boolean allowFlight = false;
    private boolean announcePlayerAchievements = false;
    private int serverPort = 25565;
    private boolean forceGamemode = false;
    private String serverIp = "0.0.0.0";
    private boolean whiteList = false;
    private boolean pvp = true;
    private boolean enableCommandBlocks = false;
    private String serverName = "IngotServer";
    private int playerIdleTimeout = 0;
    private int gamemode = 0;
    private int maxPlayers = 60;
    private int viewDistance = 10;
    private int spawnProtection = 0;
    private boolean computeVerifyToken = true;
    private String motd = "An Ingot IngotServer";

    public void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("server.properties")));
            String in;
            while ((in = br.readLine().trim()) != null) {
                if (in.startsWith("#")) {
                    continue;
                }
                String[] pair = in.split("=");
                if (pair.length != 2) {
                    System.out.println("Unknown while loading config: " + in);
                    continue;
                }
                char[] key = pair[0].toCharArray();
                for (int i = 0; i < key.length; i++) {
                    if (key[i] == '-') {
                        key[++i] = Character.toUpperCase(key[i]);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                String finalKey = sb.toString().replaceAll("-", "");
                Field field = getClass().getDeclaredField(finalKey);
                if (field == null) {
                    System.out.println("Unknown property '" + finalKey + "'!");
                    continue;
                }
                if (field.getType() == int.class) {
                    field.set(this, Integer.parseInt(pair[1]));
                } else if (field.getType() == boolean.class) {
                    field.set(this, Boolean.parseBoolean(pair[1]));
                } else if (field.getType() == String.class) {
                    field.set(this, pair[1]);
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Couldn't read config - generating: " + ex.getMessage());
            saveDefaultConfig();
        }
    }

    private void saveDefaultConfig() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("server.properties")));
            Field[] fields = getClass().getDeclaredFields();
            for (Field f : fields) {
                bw.write(f.getName() + "=" + f.get(this) + "\r\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getGeneratorSettings() {
        return generatorSettings;
    }

    public String getDefaultLevelName() {
        return levelName;
    }

    public boolean isOnlineMode() {
        return onlineMode;
    }

    public boolean isQueryEnabled() {
        return enableQuery;
    }

    public boolean isFlightAllowed() {
        return allowFlight;
    }

    public boolean shouldAnnouncePlayerAchievements() {
        return announcePlayerAchievements;
    }

    public int getServerPort() {
        return serverPort;
    }

    public boolean shouldForceGamemode() {
        return forceGamemode;
    }

    public String getServerIP() {
        return serverIp;
    }

    public boolean isWhitelisted() {
        return whiteList;
    }

    public boolean isPvPEnabled() {
        return pvp;
    }

    public boolean isCommandBlocksEnabled() {
        return enableCommandBlocks;
    }

    public String getServerName() {
        return serverName;
    }

    public int getPlayerIdleTimeout() {
        return playerIdleTimeout;
    }

    public GameMode getGamemode() {
        return GameMode.values()[gamemode];
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public int getSpawnProtection() {
        return spawnProtection;
    }

    public String getMOTD() {
        return motd;
    }

    public boolean shouldComputeVerifyToken() {
        return computeVerifyToken;
    }
}
