package net.mcwintercraft.wintercraft.warps;

import net.ess3.api.InvalidNameException;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class WarpsEvents implements Listener {

    private final WinterCraft wc;
    private WinterCraftConfig config;

    public WarpsEvents(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "warps.yml"));
    }

    @EventHandler
    public void onWarpCommand(PlayerCommandPreprocessEvent e) throws InvalidNameException {
        Player p = e.getPlayer();
        p.sendMessage(e.getMessage());
        String msg = e.getMessage().trim();
        if (msg.equalsIgnoreCase("/warps") || msg.equalsIgnoreCase("/warp")) {
            e.setCancelled(true);
            WarpsInventory s = new WarpsInventory(wc);
            s.loadInv(p);
        }
    }

    @EventHandler
    public void onWarpClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName() != null && e.getClickedInventory().getName().equals("Warps")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            ItemStack clicked = e.getCurrentItem();
            if (clicked != null && clicked.getItemMeta() != null && clicked.getType() == Material.WOOL) {
                p.closeInventory();
                Bukkit.dispatchCommand(p, "warp " + ChatColor.stripColor(clicked.getItemMeta().getDisplayName()));
                String name = ChatColor.stripColor(clicked.getItemMeta().getDisplayName()) + ".visits";
                config.load();
                int visits = config.getInt(name);
                config.setProperty(name, visits + 1);
                config.save();
            }
        }
    }
}
