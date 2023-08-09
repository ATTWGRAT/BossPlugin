package org.attgwrat.bossplugin.listeners;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.CustomItemManager;
import org.attgwrat.bossplugin.classes.Usable;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.logging.Logger;

public class PlayerUseEventListener implements Listener {
    @EventHandler
    public void onItemUse(PlayerInteractEvent e) {
        if(e.getHand() == EquipmentSlot.OFF_HAND) return;
        if(!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
        CustomItemManager manager = BossPlugin.getInstance().getItemManager();

        if(manager.getUsables().containsKey(e.getItem())) {
            Usable item = manager.getUsables().get(e.getItem());

            long cooldown;

            if((cooldown = BossPlugin
                    .getInstance()
                    .getPlayerData()
                    .get(e.getPlayer().getUniqueId())
                    .checkRemainingCooldown(item)) != 0) {
                e.getPlayer().sendMessage(ChatColor.RED + "This item is still on cooldown! Remaining: " + cooldown + "s");
                e.setCancelled(true);
                return;
            }

            item.use(
                    e.getPlayer(),
                    e.getPlayer().getNearbyEntities(
                            item.getRange(),
                            item.getRange(),
                            item.getRange()),
                    e.getClickedBlock()
            );

            e.setCancelled(true);
        }
    }
}
