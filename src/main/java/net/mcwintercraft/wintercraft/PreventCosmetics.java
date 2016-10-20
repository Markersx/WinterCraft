package net.mcwintercraft.wintercraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PreventCosmetics implements Listener {
	
	//Prevent selling cosmetic items signs
	
	@EventHandler
	public void onClick(PlayerInteractEvent ev) {
		Player pl = ev.getPlayer();
		ItemStack itm = pl.getInventory().getItemInMainHand();
        if (ev.getAction() == Action.RIGHT_CLICK_BLOCK && ev.getClickedBlock().getState() instanceof Sign) {
            if (ChatColor.stripColor(((Sign) ev.getClickedBlock().getState()).getLine(0)).equalsIgnoreCase("[Sell]")) {
            	if (itm != null && itm.getType() != Material.AIR && itm.getItemMeta().getLore() != null && itm.getItemMeta().getLore().toString().contains("Gadget")) {
            		ev.setCancelled(true);
            		pl.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "[Cosmetics]" + ChatColor.RESET + ": " + ChatColor.AQUA + "You can't sell your cosmetic item!");
            	}
            }
        }
	}
	
	//Prevent Cosmetic item hats, and selling with /sell
	
    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
      Player p = e.getPlayer();
      int i = p.getInventory().getHeldItemSlot();
      ItemStack item = p.getInventory().getItem(i);
      if (e.getMessage().toLowerCase().startsWith("/hat")) {
    	  if (item != null) {
    		  if (item.getItemMeta().getLore() != null && item.getType() != Material.AIR && item.getItemMeta().getLore().toString().contains("Gadget")) {
    			  e.setCancelled(true);
    			  p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "[Cosmetics]" + ChatColor.RESET + ": " + ChatColor.AQUA + "You can't use your cosmetic items as hats!");
    		  }
    	  }
      }
      if (e.getMessage().toLowerCase().startsWith("/sell")) {
    	  if (item != null) {
    		  if (item.getItemMeta().getLore() != null && item.getType() != Material.AIR && item.getItemMeta().getLore().toString().contains("Gadget")) {
    			  e.setCancelled(true);
    			  p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "[Cosmetics]" + ChatColor.RESET + ": " + ChatColor.AQUA + "You can't sell your cosmetic item!");
    		  	}
    	  } else {
    		  for (ItemStack itm : p.getInventory().getContents()) {
        		  if(itm !=null && itm.getType() != Material.AIR && itm.getItemMeta().getLore() != null && itm.getItemMeta().getLore().toString().contains("Gadget")) {
        			  e.setCancelled(true);
        			  p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "[Cosmetics]" + ChatColor.RESET + ": " + ChatColor.AQUA + "You can't sell your cosmetic item!");
        			  break;
        		  }
    		  }
    	  }
      }
    }	
}