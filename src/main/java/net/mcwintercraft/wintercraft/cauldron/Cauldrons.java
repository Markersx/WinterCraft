package net.mcwintercraft.wintercraft.cauldron;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Cauldrons {

    private List<Location> cauldrons = new ArrayList<>();
    private WinterCraft wc;
    private WinterCraftConfig config;

    public Cauldrons(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "cauldrons.yml"));
        loadCauldrons();
    }

    public boolean setCauldron(Location loc) {
        if (!cauldrons.contains(loc)) {
            cauldrons.add(loc);
            config.getStringList("world").add(toString(loc));
            config.save();
            wc.debug("SET CAULDRON AT " + toString(loc));
            return true;
        }
        return false;
    }

    public boolean removeCauldron(Location loc) {
        if (cauldrons.contains(loc)) {
            cauldrons.remove(loc);
            config.getStringList("world").remove(toString(loc));
            config.save();
            wc.debug("REMOVED CAULDRON AT " + toString(loc));
            return true;
        }
        return false;
    }

    private void loadCauldrons() {
        config.load();
        for (String s : config.getStringList("world")) {
            String[] cord = s.split("|");
            double x = Integer.parseInt(cord[0]);
            double y = Integer.parseInt(cord[1]);
            double z = Integer.parseInt(cord[2]);
            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
            if (!cauldrons.contains(loc)) {
                cauldrons.add(loc);
            }
        }
        wc.debug("LOADED " + cauldrons.size() + " CAULDRONS!");
    }

    private String toString(Location loc) {
        return loc.getX() + "|" + loc.getY() + "|" + loc.getZ();
    }
}
