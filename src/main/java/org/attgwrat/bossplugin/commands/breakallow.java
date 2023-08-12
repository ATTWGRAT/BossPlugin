package org.attgwrat.bossplugin.commands;

import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class breakallow implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;

        BossPlugin.getInstance().getPlayerData().get(((Player) commandSender).getUniqueId()).setBreakAllow(true);
        commandSender.sendMessage(ChatColor.GREEN + "You now can break blocks on custom worlds!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return Collections.emptyList();
    }
}
