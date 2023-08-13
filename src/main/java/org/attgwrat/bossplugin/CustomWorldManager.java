package org.attgwrat.bossplugin;

import org.attgwrat.bossplugin.tools.FileUtilities;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class CustomWorldManager {
    private final HashMap<String, World> worldMap;

    public CustomWorldManager(BossPlugin plugin) {
        Logger logger = plugin.getLogger();

        logger.info("Copying custom worlds from resources!");

        try {
            FileUtilities.getWorldsFromResources();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }

        worldMap = new HashMap<>();

        List<World> worldList = Bukkit.getWorlds();

        worldMap.put("overworld", worldList.get(0));
        worldMap.put("nether", worldList.get(1));
        worldMap.put("end", worldList.get(2));

        logger.info("Loading new worlds!");

        worldMap.put("village", new WorldCreator("village").createWorld());
        World village = worldMap.get("village");
        village.setDifficulty(Difficulty.PEACEFUL);
        village.setWeatherDuration(1000000000);

    }

    public HashMap<String, World> getWorldMap() {
        return worldMap;
    }

    public void reloadWorld(String worldName) {
        if(!worldMap.containsKey(worldName)) return;
    }

}
