package net.mcwintercraft.wintercraft.warps;

import com.earth2me.essentials.Warps;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class WarpsInventory {

    private WinterCraft wc;
    private WinterCraftConfig config;
    private int invSize;

    public WarpsInventory(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "warps.yml"));
    }

    //TODO: PAGES, SORT BY NUMBER

    public void loadInv(Player p) {
        Warps w = WinterCraft.ess.getWarps();
        int size = w.getCount();
        if (size > 9) {
            invSize = 18;
        } else {
            invSize = 9;
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
        Inventory WarpsInv = Bukkit.createInventory(null, invSize, "Warps");
        int slot = 0;
        Map<String, Integer> map = new TreeMap<>();
        config.load();
        for (String s : w.getList()) {
            if (!config.isSet(s)) {
                config.setProperty(s + ".visits", 0);
                config.save();
                wc.debug("Set " + s + " visits to 0");
            }
            map.put(s, config.getInt(s + ".visits"));
        }
        for (Map.Entry<String, Integer> warpList : map.entrySet()) {
            if (slot < invSize) {
                ItemStack wi = new ItemStack(Material.WOOL);
                ArrayList<String> wl = new ArrayList<>();
                wl.add(ChatColor.WHITE + "Visits: " + String.valueOf(warpList.getValue()));
                if (config.isSet(warpList.getKey() + ".owner")) {
                    wl.add(ChatColor.WHITE + "Owner: " + config.getProperty(warpList.getKey() + ".owner"));
                }
                ItemMeta wm = wi.getItemMeta();
                wm.setDisplayName(ChatColor.WHITE + warpList.getKey());
                wm.setLore(wl);
                wi.setItemMeta(wm);
                WarpsInv.setItem(slot, wi);
                slot++;
            }
        }

        p.openInventory(WarpsInv);
    }
}
