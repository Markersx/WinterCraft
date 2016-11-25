package net.mcwintercraft.wintercraft.misc;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TNTMine implements Listener {

    private List<Location> mines = new ArrayList<>();
    private WinterCraft wc;
    private WinterCraftConfig config;

    public TNTMine(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "tntmines.yml"));
        loadMines();
    }

    public boolean setMine(Location loc) {
        if (!mines.contains(loc)) {
            mines.add(loc);
            config.getStringList("world").add(toString(loc));
            config.save();
            wc.debug("SET TNTMINE AT " + toString(loc));
            return true;
        }
        return false;
    }

    public boolean removeMine(Location loc) {
        if (mines.contains(loc)) {
            mines.remove(loc);
            config.getStringList("world").remove(toString(loc));
            config.save();
            wc.debug("REMOVED TNTMINE AT " + toString(loc));
            return true;
        }
        return false;
    }

    private void loadMines() {
        for (String s : config.getStringList("world")) {
            String[] cord = s.split("|");
            double x = Integer.parseInt(cord[0]);
            double y = Integer.parseInt(cord[1]);
            double z = Integer.parseInt(cord[2]);
            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
            if (!mines.contains(loc)) {
                mines.add(loc);
            }
        }
        wc.debug("LOADED " + mines.size() + " MINES!");
    }

    private String toString(Location loc) {
        return loc.getX() + "|" + loc.getY() + "|" + loc.getZ();
    }

    @EventHandler
    public void armTNT(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR) && p.getInventory().getItemInMainHand().getType().equals(Material.TNT)) {
            if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) && p.isSneaking()) {
                Location loc = e.getClickedBlock().getLocation();
                if (loc.getBlock().getRelative(BlockFace.UP).getType() == Material.AIR) {
                    if (setMine(loc)) {
                        ArmorStand tnt = loc.getWorld().spawn(loc.add(0.5, 0.05, 0.5), ArmorStand.class);
                        tnt.setGravity(false);
                        tnt.setSmall(true);
                        tnt.setVisible(false);
                        tnt.setHelmet(new ItemStack(Material.TNT));
                        tnt.setCustomName("MINE");
                        tnt.setCustomNameVisible(false);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDisarm(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof ArmorStand) {
            ArmorStand as = (ArmorStand) e.getEntity();
            if (as.getCustomName() != null && as.getCustomName() == "MINE" && !as.isVisible() && as.isSmall()) {
                as.remove();
            }
        }
    }

    @EventHandler
    public void onStep(PlayerMoveEvent e) {
        Location l = e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getLocation();
        if (removeMine(l)) {
            e.getPlayer().getWorld().createExplosion(l, 4F);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Location l = e.getBlock().getLocation();
        if (removeMine(l)) {
            e.getPlayer().getWorld().createExplosion(l, 4F);
        }
    }
}
