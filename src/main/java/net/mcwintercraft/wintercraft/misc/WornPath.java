package net.mcwintercraft.wintercraft.misc;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WornPath implements Listener {

    private WinterCraft wc;

    public WornPath(WinterCraft wc) {
        this.wc = wc;
    }

    //TODO: NO DEPRECIATION! PLAY SOUNDS?

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        if (e.getFrom().getBlock().equals(e.getTo().getBlock())) {
            return;
        }

        Player p = e.getPlayer();
        Location loc = p.getLocation();
        Block standing = loc.getBlock();
        Block below = loc.subtract(0, 1, 0).getBlock();

        if (standing != null && standing.getType() != Material.AIR) {
            double probability = Math.random() - (p.getFallDistance() / 50);
            switch (standing.getType()) {
                case LONG_GRASS:
                    if (probability <= 0.10) {
                        standing.breakNaturally();
                    }
                    return;
                case DOUBLE_PLANT:
                    if (probability <= 0.12) {
                        standing.setType(Material.LONG_GRASS);
                        if (standing.getData() == 2) {
                            standing.setData((byte) 1);
                        }
                    }
                    return;
                case DEAD_BUSH:
                    if (probability <= 0.10) {
                        standing.breakNaturally();
                    }
                    return;
                case YELLOW_FLOWER:
                    if (probability <= 0.10) {
                        standing.breakNaturally();
                    }
                    return;
                case RED_ROSE:
                    if (probability <= 0.10) {
                        standing.breakNaturally();
                    }
                    return;
                case SNOW:
                    if (probability <= 0.45) {
                        if (standing.getData() > 0) {
                            standing.setData((byte) (standing.getData() - 1));
                        } else {
                            standing.setType(Material.AIR);
                        }
                    }
                    return;
            }
        }

        if (below != null) {
            double probability = Math.random();
            switch (below.getType()) {
                case SNOW_BLOCK:
                    if (probability <= 0.45) {
                        below.setType(Material.SNOW);
                        below.setData((byte) 6);
                    }
                    return;
                case GRASS:
                    if (probability <= 0.08) {
                        below.setType(Material.DIRT);
                    }
                    return;
                case DIRT:
                    if (probability <= 0.02) {
                        below.setData((byte) 1);
                    }
                    return;
                case STONE:
                    if (probability <= 0.04) {
                        below.setType(Material.COBBLESTONE);
                    }
                    return;
                case SMOOTH_BRICK:
                    if (probability <= 0.01) {
                        below.setData((byte) 2);
                    }
                case WATER_LILY:
                    if (probability <= 0.3) {
                        below.breakNaturally();
                    }
            }
        }
    }
}

