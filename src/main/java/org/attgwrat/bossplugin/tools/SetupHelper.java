package org.attgwrat.bossplugin.tools;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.commands.breakallow;
import org.attgwrat.bossplugin.commands.wtp;
import org.attgwrat.bossplugin.listeners.PlayerBreakEventListener;
import org.attgwrat.bossplugin.listeners.PlayerUseEventListener;
import org.bukkit.Bukkit;

public class SetupHelper {
    public static void setupCommands(BossPlugin plugin) {
        plugin.getCommand("wtp").setExecutor(new wtp());
        plugin.getCommand("breakallow").setExecutor(new breakallow());
    }

    public static void setupEvents(BossPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new PlayerUseEventListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerBreakEventListener(), plugin);
    }
}
