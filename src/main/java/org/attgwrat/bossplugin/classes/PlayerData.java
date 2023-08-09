package org.attgwrat.bossplugin.classes;

import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerData {
    private final UUID id;
    private final HashMap<Usable, Long> cooldowns;
    public PlayerData(OfflinePlayer player) {

        id = player.getUniqueId();

        cooldowns = new HashMap<>();

        BossPlugin.getInstance()
                .getItemManager()
                .getUsables()
                .values()
                .forEach(usable -> cooldowns.put(usable, 0L));

    }

    public UUID getId() {
        return id;
    }

    public HashMap<Usable, Long> getCooldowns() {
        return cooldowns;
    }

    public long checkRemainingCooldown(Usable usable) {
        long time = System.currentTimeMillis();
        if(cooldowns.get(usable) < time) {
            cooldowns.put(usable, time + usable.getCooldown()*1000);
            return 0;
        } else {
            return (long) Math.ceil((double) (cooldowns.get(usable) - time) / 1000);
        }
    }
}
