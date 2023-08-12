package org.attgwrat.bossplugin.listeners;

import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class PlayerBreakEventListener implements Listener {

    @EventHandler
    public void playerBreakBlockEvent(BlockBreakEvent e) {
        if(e.isCancelled()) return;
        World breakworld = e.getPlayer().getWorld();
        List<World> mainworlds = Bukkit.getWorlds().subList(0, 3);
        if(!mainworlds.contains(breakworld)) {
            if(e.getPlayer().hasPermission("bp.admin")) {
                if(BossPlugin.getInstance().getPlayerData().get(e.getPlayer().getUniqueId()).isBreakAllow()) return;
                e.getPlayer().sendMessage(ChatColor.RED + "Breaking a block on a custom world might break something! If you know what you're doing type: /breakallow in chat");
            } else {
                e.getPlayer().sendMessage(ChatColor.RED + "You can't break stuff here!");
            }
            e.setCancelled(true);
        }
    }

}
