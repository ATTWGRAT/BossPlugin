package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.classes.PlayerData;
import org.attgwrat.bossplugin.commands.breakallow;
import org.attgwrat.bossplugin.commands.wtp;
import org.attgwrat.bossplugin.listeners.PlayerBreakEventListener;
import org.attgwrat.bossplugin.listeners.PlayerUseEventListener;
import org.attgwrat.bossplugin.tools.SetupHelper;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public final class BossPlugin extends JavaPlugin {
    private CustomWorldManager worldManager;
    private CustomItemManager itemManager;
    private static BossPlugin instance;
    private HashMap<UUID, PlayerData> playerData;

    @Override
    public void onEnable() {
        instance = this;

        itemManager = new CustomItemManager();

        playerData = new HashMap<>();

        worldManager = new CustomWorldManager(this);

        Arrays.stream(Bukkit.getOfflinePlayers()).forEach(player -> playerData.put(player.getUniqueId(), new PlayerData(player)));

        SetupHelper.setupCommands(this);

        SetupHelper.setupEvents(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public CustomItemManager getItemManager() {
        return itemManager;
    }

    public CustomWorldManager getWorldManager() {
        return worldManager;
    }

    public static BossPlugin getInstance() {
        return instance;
    }

    public HashMap<UUID, PlayerData> getPlayerData() {
        return playerData;
    }
}
