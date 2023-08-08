package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.classes.CustomCraftedItem;
import org.attgwrat.bossplugin.classes.Usable;
import org.attgwrat.bossplugin.items.TeleportScroll;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class CustomItemManager {
    private final HashMap<ItemStack, Usable> usables = new HashMap<>();
    private final List<CustomCraftedItem> items = new ArrayList<>();
    public CustomItemManager() {
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
