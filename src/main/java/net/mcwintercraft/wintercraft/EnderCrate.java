package net.mcwintercraft.wintercraft;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EnderCrate implements Listener {

    private List<Location> crates = new ArrayList<>();
    private WinterCraft wc;
    private WinterCraftConfig config;

    public EnderCrate(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "endercrates.yml"));
        loadCrates();
    }

    @EventHandler
    public void use(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME) {
                Block b = e.getClickedBlock();
                for (Entity ent : b.getWorld().getNearbyEntities(b.getLocation(), 0, 1, 0)) {
                    if (ent instanceof ArmorStand) {
                        if (ent.getCustomName() != null && ent.getCustomName().equals("ENDER CRATE")) {
                            if (e.getItem().getType() == Material.EYE_OF_ENDER) {
                                if (e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "ENDER KEY")) {
                                    //TODO: FINISH
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean setCrate(Location loc) {
        if (!crates.contains(loc)) {
            crates.add(loc);
            config.getStringList("world").add(toString(loc));
            config.save();
            wc.debug("SET ENDERCRATE AT " + toString(loc));
            return true;
        }
        return false;
    }

    public boolean removeCrate(Location loc) {
        if (crates.contains(loc)) {
            crates.remove(loc);
            config.getStringList("world").remove(toString(loc));
            config.save();
            wc.debug("REMOVED ENDERCRATE AT " + toString(loc));
            return true;
        }
        return false;
    }

    private void loadCrates() {
        for (String s : config.getStringList("world")) {
            String[] cord = s.split("|");
            double x = Integer.parseInt(cord[0]);
            double y = Integer.parseInt(cord[1]);
            double z = Integer.parseInt(cord[2]);
            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
            if (!crates.contains(loc)) {
                crates.add(loc);
            }
        }
        wc.debug("LOADED " + crates.size() + " CRATES!");
    }

    private String toString(Location loc) {
        return loc.getX() + "|" + loc.getY() + "|" + loc.getZ();
    }

}
