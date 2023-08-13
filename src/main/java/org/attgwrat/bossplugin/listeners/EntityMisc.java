package org.attgwrat.bossplugin.listeners;

import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityMisc implements Listener {
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        if(e.isCancelled()) return;
        if(e.getLocation().getWorld().equals(BossPlugin.getInstance().getWorldManager().getWorldMap().get("village")) && !(e.getEntityType().equals(EntityType.PLAYER) || e.getEntityType().equals(EntityType.VILLAGER))) e.setCancelled(true);
    }
}
