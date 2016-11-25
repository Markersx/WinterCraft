package net.mcwintercraft.wintercraft.misc;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class DeepSnow implements Listener {
    //TODO: NO DEPRECIATION
    private WinterCraft wc;
    long time = 600L;
    double chance = 0.15;

    public DeepSnow(WinterCraft wc) {
        this.wc = wc;
        wc.getServer().getScheduler().scheduleSyncRepeatingTask(wc, run, time, time);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {

            if (wc.getServer().getWorld("world").hasStorm()) {

                wc.debug("STARTED DEEPENING SNOW");

                for (Chunk c : wc.getServer().getWorld("world").getLoadedChunks()) {

                    int bx = c.getX() << 4;
                    int bz = c.getZ() << 4;

                    for (int xx = bx; xx < bx + 16; xx++) {
                        for (int zz = bz; zz < bz + 16; zz++) {
                            Block b = wc.getServer().getWorld("world").getHighestBlockAt(xx, zz);
                            switch (b.getType()) {
                                case SNOW:
                                    if (Math.random() < chance) {
                                        byte level = b.getData();
                                        if (level < 7) {
                                            b.setData((byte) (level + 1));
                                        } else {
                                            b.getRelative(BlockFace.UP).setType(Material.SNOW);
                                            b.getRelative(BlockFace.UP).setData((byte) 0);
                                        }
                                    }
                                    break;
                                case SNOW_BLOCK:
                                    if (Math.random() < chance) {
                                        b.getRelative(BlockFace.UP).setType(Material.SNOW);
                                        b.getRelative(BlockFace.UP).setData((byte) 0);
                                    }
                            }
                        }
                    }

                }

                wc.debug("FINISHED DEEPENING SNOW");

            }
        }
    };

    @EventHandler
    public void leavesDecay(LeavesDecayEvent e) {
        Block b = e.getBlock();
        snowFall(b);
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        if (b.getType() == Material.SNOW && b.getData() == 7) {
            b.setType(Material.SNOW_BLOCK);
        }
        if (b.getRelative(BlockFace.UP).getType() == Material.SNOW || b.getRelative(BlockFace.UP).getType() == Material.SNOW_BLOCK) {
            snowFall(b);
        }
    }

    @EventHandler
    public void snowPhysics(BlockPhysicsEvent e) {
        if (e.getChangedType() == Material.SNOW) {
            Block b = e.getBlock();
            if (b.getType() == Material.SNOW && b.getData() == 7) {
                b.setType(Material.SNOW_BLOCK);
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void throwSnow(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Snowball) {
            Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getBlockX() + 0.5D, e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ() + 0.5D);
            e.getEntity().getWorld().spawnFallingBlock(loc, Material.SNOW, (byte) 0);
        }
    }

    private void snowFall(Block b) {
        Block above = b.getRelative(BlockFace.UP);
        Byte level = above.getData();
        while(above.getType() == Material.SNOW || above.getType() == Material.SNOW_BLOCK) {
            Material type = above.getType();
            if (type == Material.SNOW && level == 7) {
                type = Material.SNOW_BLOCK;
                level = 0;
            }
            Location l = above.getLocation();
            above.setType(Material.AIR);
            l.getWorld().spawnFallingBlock(l.add(0.5, 0, 0.5), type, level);
            wc.debug("PLACED SNOW");
            above = above.getRelative(BlockFace.UP);
            level = above.getData();
        }
    }
}
