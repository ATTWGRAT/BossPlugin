package org.attgwrat.bossplugin.items;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.classes.CustomCraftedItem;
import org.attgwrat.bossplugin.classes.Usable;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class TeleportScroll extends CustomCraftedItem implements Usable {
    private final ItemStack item;
    private final NamespacedKey key;
    private final ShapedRecipe recipe;

    public TeleportScroll(){
        key = new NamespacedKey(BossPlugin.getInstance(), "teleportscroll");
        item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Village Teleport Scroll");
        item.setItemMeta(meta);
        recipe = new ShapedRecipe(key, item);
        recipe.shape(" Y ", "YZY", " Y ");
        recipe.setIngredient('Z', new RecipeChoice.ExactChoice(TeleportCatalyst.item));
        //THIS IS UNSAFE!! TELEPORT CATALYST CLASS MUST ALWAYS BE CREATED FIRST IN THE CUSTOM ITEM MANAGER!!!
        //OTHERWISE, THIS WILL CAUSE A NULL POINTER EXCEPTION
        recipe.setIngredient('Y', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(recipe);
    }
    @Override
    public String getName() {
        return "teleportscroll";
    }

    @Override
    public void use(Player user, List<Entity> usedOn, Block usedBlock) {
        World village = BossPlugin.getInstance().getVillage();
        if (user.getLocation().getWorld().equals(village)) {
            if (user.getBedSpawnLocation() != null) {
                user.teleport(user.getBedSpawnLocation());
            } else {
                user.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
            }
        } else {
            user.teleport(village.getSpawnLocation());
        }

    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public double getRange() {
        return 0;
    }

    @Override
    public long getCooldown() {
        return 1;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public ShapedRecipe getRecipe() {
        return recipe;
    }
}
