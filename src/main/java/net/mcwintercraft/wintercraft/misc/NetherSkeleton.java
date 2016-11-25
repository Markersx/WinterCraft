package net.mcwintercraft.wintercraft.misc;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NetherSkeleton implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getPlayer().getWorld().getName().equals("world_nether")) {
            if (e.getBlock().getType() == Material.MOB_SPAWNER) {
                if (((CreatureSpawner) e.getBlock().getState()).getSpawnedType() == EntityType.SKELETON) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
