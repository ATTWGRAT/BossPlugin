package org.attgwrat.bossplugin.classes;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Usable {
    void use(Player user, List<Entity> usedOn, Block usedBlock);
    ItemStack getItem();
    double getRange();
    long getCooldown();
}
