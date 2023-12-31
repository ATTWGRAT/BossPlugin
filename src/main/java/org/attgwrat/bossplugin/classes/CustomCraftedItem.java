package org.attgwrat.bossplugin.classes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class CustomCraftedItem {
    public abstract String getName();
    public abstract ItemStack getItem();
    public abstract NamespacedKey getKey();
    public abstract ShapedRecipe getRecipe();
}
