package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.tools.FileUtilities;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class CustomWorldManager {

    public static HashMap<String, World> setup(BossPlugin plugin) {
        Logger logger = plugin.getLogger();

        logger.info("Copying custom worlds from resources!");

        try {
            FileUtilities.getWorldsFromResources();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }

        HashMap<String, World> worlds = new HashMap<>();

        List<World> worldList = Bukkit.getWorlds();

        worlds.put("overworld", worldList.get(0));
        worlds.put("nether", worldList.get(1));
        worlds.put("end", worldList.get(2));

        logger.info("Loading new worlds!");

        worlds.put("village", new WorldCreator("village").createWorld());

        return worlds;
    }
}
