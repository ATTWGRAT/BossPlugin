package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.commands.Villagetp;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossPlugin extends JavaPlugin {
    private World village;
    private static BossPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        village = new WorldCreator("village").createWorld();

        this.getCommand("villagetp").setExecutor(new Villagetp());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public World getVillage() {
        return village;
    }

    public static BossPlugin getInstance() {
        return instance;
    }
}
