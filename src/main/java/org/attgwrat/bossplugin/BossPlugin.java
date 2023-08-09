package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.classes.PlayerData;
import org.attgwrat.bossplugin.commands.Villagetp;
import org.attgwrat.bossplugin.listeners.PlayerUseEventListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public final class BossPlugin extends JavaPlugin {
    private CustomItemManager itemManager;
    private World village;
    private static BossPlugin instance;
    private HashMap<UUID, PlayerData> playerData;

    @Override
    public void onEnable() {
        instance = this;

        village = new WorldCreator("village").createWorld();

        itemManager = new CustomItemManager();

        playerData = new HashMap<>();

        Arrays.stream(Bukkit.getOfflinePlayers()).forEach(player -> playerData.put(player.getUniqueId(), new PlayerData(player)));

        this.getCommand("villagetp").setExecutor(new Villagetp());

        Bukkit.getPluginManager().registerEvents(new PlayerUseEventListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public CustomItemManager getItemManager() {
        return itemManager;
    }

    public World getVillage() {
        return village;
    }

    public static BossPlugin getInstance() {
        return instance;
    }

    public HashMap<UUID, PlayerData> getPlayerData() {
        return playerData;
    }
}
