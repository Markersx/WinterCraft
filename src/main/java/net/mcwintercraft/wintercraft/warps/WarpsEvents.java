package net.mcwintercraft.wintercraft.warps;

import net.ess3.api.InvalidNameException;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class WarpsEvents extends WarpsInventory implements Listener{

    @EventHandler
    public void onWarpCommand(PlayerCommandPreprocessEvent e) throws InvalidNameException {
        Player p = e.getPlayer();
        p.sendMessage(e.getMessage());
        String msg = e.getMessage().trim();
        if (msg.equalsIgnoreCase("/warps") || msg.equalsIgnoreCase("/warp")) {
            e.setCancelled(true);
            this.loadInv(p);
        }
    }

    @EventHandler
    public void onWarpClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName() != null && e.getClickedInventory().getName().equals("Warps")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            ItemStack clicked = e.getCurrentItem();
            if (clicked != null && clicked.getType() == Material.WOOL && clicked.getItemMeta().getDisplayName() != "") {
                p.closeInventory();
                Bukkit.dispatchCommand(p, "warp " + ChatColor.stripColor(clicked.getItemMeta().getDisplayName()));
            }
        }
    }
}
///