package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.classes.CustomCraftedItem;
import org.attgwrat.bossplugin.classes.Usable;
import org.attgwrat.bossplugin.items.TeleportCatalyst;
import org.attgwrat.bossplugin.items.TeleportScroll;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class CustomItemManager {
    private final HashMap<ItemStack, Usable> usables = new HashMap<>();
    private final List<CustomCraftedItem> items = new ArrayList<>();
    public CustomItemManager() {
        //ALWAYS CREATE TELEPORT CATALYST FIRST
        //THIS SHOULD ONLY BE A TEMPORARY SOLUTION!
        TeleportCatalyst teleportCatalyst = new TeleportCatalyst();
        items.add(teleportCatalyst);
        TeleportScroll teleportScroll = new TeleportScroll();
        items.add(teleportScroll);
        usables.put(teleportScroll.getItem(), teleportScroll);
    }

    public HashMap<ItemStack, Usable> getUsables() {
        return usables;
    }

    public List<CustomCraftedItem> getItems() {
        return items;
    }
}
