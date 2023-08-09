package org.attgwrat.bossplugin.items;

import org.attgwrat.bossplugin.BossPlugin;
import org.attgwrat.bossplugin.classes.CustomCraftedItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public final class TeleportCatalyst extends CustomCraftedItem {
    static ItemStack item;
    private final NamespacedKey key;
    private final ShapedRecipe recipe;

    public TeleportCatalyst() {
        key = new NamespacedKey(BossPlugin.getInstance(), "catalyst");
        item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Teleport Catalyst");
        item.setItemMeta(meta);
        recipe = new ShapedRecipe(key, item);
        recipe.shape("XYX", "YZY", "XYX");
        recipe.setIngredient('X', Material.AMETHYST_SHARD);
        recipe.setIngredient('Y', Material.ENDER_EYE);
        recipe.setIngredient('Z', Material.CHORUS_FRUIT);

        Bukkit.addRecipe(recipe);
    }

    @Override
    public String getName() {
        return "catalyst";
    }

    @Override
    public ItemStack getItem() {
        return item;
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
