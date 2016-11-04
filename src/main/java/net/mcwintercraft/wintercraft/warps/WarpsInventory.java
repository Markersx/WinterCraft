package net.mcwintercraft.wintercraft.warps;

import com.earth2me.essentials.EssentialsConf;
import com.earth2me.essentials.Warps;
import net.ess3.api.InvalidNameException;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;

public class WarpsInventory {

    private int invSize;

    public void loadInv(Player p) throws InvalidNameException {
        Inventory WarpsInv = Bukkit.createInventory(null, invSize, "Warps");
        Warps w = WinterCraft.ess.getWarps();
        int size = w.getCount();
        if (size > 0) {
            invSize = 9;
        }
        if (size > 9) {
            invSize = 18;
        }
        if (size > 18) {
            invSize = 27;
        }
        if (size > 27) {
            invSize = 36;
        }
        if (size > 36) {
            invSize = 45;
        }
        if (size > 45) {
            invSize = 54;
        }
        int slot = 0;
        for (String s : w.getList()) {
            if (slot < invSize) {
                ItemStack wi = new ItemStack(Material.WOOL);
                ArrayList<String> wl = new ArrayList<>();
                File ex = new File(new File(WinterCraft.ess.getDataFolder(), "warps"), s + ".yml");
                EssentialsConf conf = new EssentialsConf(ex);
                conf.setProperty("visits", 124);
                conf.save();
                wl.add(ChatColor.WHITE + "Visits: " + String.valueOf(conf.getInt("visits")));
                ItemMeta wm = wi.getItemMeta();
                wm.setDisplayName(ChatColor.WHITE + s);
                wm.setLore(wl);
                wi.setItemMeta(wm);
                WarpsInv.setItem(slot, wi);
                slot++;
            }
        }

        p.openInventory(WarpsInv);
    }
}
