package miqhtie.huntervsspeedrunner;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

public class Utils {
    public static void createWorldBorder(Player player, double size){
        World world = player.getWorld();
        WorldBorder border = world.getWorldBorder();

        border.setSize(size);
        border.setCenter(world.getSpawnLocation().getBlockX(), world.getSpawnLocation().getBlockZ());
    }
}
