package org.attgwrat.bossplugin.listeners;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.CustomItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerUseEventListener implements Listener {
    @EventHandler
    public void onItemUse(PlayerInteractEvent e) {
        if(e.isCancelled()) return;
        if(!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;

        CustomItemManager manager = BossPlugin.getInstance().getItemManager();

        if(manager.getUsables().containsKey(e.getItem())) {

            manager.getUsables().get(e.getItem()).use(
                    e.getPlayer(),
                    e.getPlayer().getNearbyEntities(5, 5, 5),
                    e.getClickedBlock()
            );

            e.setCancelled(true);
        }
    }
}
