package org.attgwrat.bossplugin.listeners;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.classes.PlayerData;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerMisc implements Listener {
    @EventHandler
    public void playerJoinEventListener(PlayerJoinEvent e) {
        if(BossPlugin.getInstance()
                .getPlayerData()
                .containsKey(e.getPlayer().getUniqueId())) return;

        BossPlugin.getInstance()
                .getPlayerData()
                .put(e.getPlayer().getUniqueId(), new PlayerData(e.getPlayer()));
    }

    @EventHandler
    public void entityDamageEntity(EntityDamageEvent e) {
        if(e.isCancelled()) return;
        if(e.getEntity().getLocation().getWorld().equals(BossPlugin.getInstance().getWorldManager().getWorldMap().get("village"))) {
            e.setCancelled(true);
        }
    }
}
