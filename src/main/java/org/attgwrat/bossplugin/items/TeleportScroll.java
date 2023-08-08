package org.attgwrat.bossplugin.items;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.classes.CustomCraftedItem;
import org.attgwrat.bossplugin.classes.Usable;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TeleportScroll extends CustomCraftedItem implements Usable {
    private ItemStack item;
    private NamespacedKey key;
    private ShapedRecipe recipe;

    public TeleportScroll(){
        key = new NamespacedKey(BossPlugin.getInstance(), "teleportscroll");
        item = new ItemStack(Material.WRITTEN_BOOK);
        ItemMeta
        recipe = new ShapedRecipe(key, )
    }
    @Override
    public String getName() {
        return "teleportscroll";
    }

    @Override
    public void use(Player user, List<Entity> usedOn, Block usedBlock) {

    }

    @Override
    public ItemStack getItem() {
        return null;
    }

    @Override
    public long getCooldown() {
        return 0;
    }

    @Override
    public NamespacedKey getKey() {
        return null;
    }

    @Override
    public ShapedRecipe getRecipe() {
        return null;
    }
}
