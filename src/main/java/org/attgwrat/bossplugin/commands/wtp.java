package org.attgwrat.bossplugin.commands;

import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class wtp implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;

        Player p = (Player) commandSender;

        if(strings.length != 1) return false;

        HashMap<String, World> worldHashMap = BossPlugin.getInstance().getWorldManager().getWorldMap();

        if(!worldHashMap.containsKey(strings[0])) {
            p.sendMessage(ChatColor.RED + "That world doesn't exist!");
            return true;
        }

        World world = worldHashMap.get(strings[0]);

        p.teleport(world.getSpawnLocation());

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            return new ArrayList<>(BossPlugin.getInstance().getWorldManager().getWorldMap().keySet());
        }
        return Collections.emptyList();
    }
}
