package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.commands.Villagetp;
import org.attgwrat.bossplugin.listeners.PlayerUseEventListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossPlugin extends JavaPlugin {
    private CustomItemManager itemManager;
    private World village;
    private static BossPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        village = new WorldCreator("village").createWorld();

        itemManager = new CustomItemManager();

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
}
