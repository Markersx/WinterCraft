package net.mcwintercraft.wintercraft.chatsounds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import net.mcwintercraft.wintercraft.WinterCraftConfig;

public class ChatSoundsEvents implements Listener {
	//
	// Going to redo most of this.
	//
	WinterCraftConfig config = WinterCraftConfig.getConfig("chatsounds");

	//PLAYERJOIN
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		
	   Player p = e.getPlayer();
	   String puuid = p.getUniqueId().toString();
	   
	   if (config.getConfig().getString(puuid) == null) {
		   loadchatsoundsconfig(p, puuid);
	   }
	   
	   String js = config.getConfig().getString(puuid + ".playerjoin.sound");
	   boolean jse = config.getConfig().getBoolean(puuid + ".playerjoin.enabled");
	   float jsv = (float) config.getConfig().getDouble(puuid + ".playerjoin.volume");
	   float jsp = (float) config.getConfig().getDouble(puuid + ".playerjoin.pitch");
	   
	   for(Player op : Bukkit.getOnlinePlayers()){
		   if (jse) {
			   op.playSound(op.getLocation(), Sound.valueOf(js), jsv, jsp);
		   }
	   }
	   
	}
	
	//PLAYERQUIT
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		String puuid = p.getUniqueId().toString();
		
		String qs = config.getConfig().getString(puuid + ".playerquit.sound");
		boolean qse = config.getConfig().getBoolean(puuid + ".playerquit.enabled");
		float qsv = (float) config.getConfig().getDouble(puuid + ".playerquit.volume");
		float qsp = (float) config.getConfig().getDouble(puuid + ".playerquit.pitch");
		
		for(Player op : Bukkit.getOnlinePlayers()){
			if (qse) {
				op.playSound(op.getLocation(), Sound.valueOf(qs), qsv, qsp);
		    }
		}
	}
	
	//PLAYER MESSAGE
	@EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		String puuid = p.getUniqueId().toString();
		
		String ms = config.getConfig().getString(puuid + ".playermessage.sound");
		boolean mse = config.getConfig().getBoolean(puuid + ".playermessage.enabled");
		float msv = (float) config.getConfig().getDouble(puuid + ".playermessage.volume");
		float msp = (float) config.getConfig().getDouble(puuid + ".playermessage.pitch");
		
		for(Player op : Bukkit.getOnlinePlayers()){
			if (mse) {
				op.playSound(op.getLocation(), Sound.valueOf(ms), msv, msp);
			}
		}
	}
	
	@SuppressWarnings("unused")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		String puuid = p.getUniqueId().toString();
		Location loc = p.getLocation();
		
		String js = config.getConfig().getString(puuid + ".playerjoin.sound");
		boolean jse = config.getConfig().getBoolean(puuid + ".playerjoin.enabled");
		float jsv = (float) config.getConfig().getDouble(puuid + ".playerjoin.volume");
		float jsp = (float) config.getConfig().getDouble(puuid + ".playerjoin.pitch");
		String qs = config.getConfig().getString(puuid + ".playerquit.sound");
		boolean qse = config.getConfig().getBoolean(puuid + ".playerquit.enabled");
		float qsv = (float) config.getConfig().getDouble(puuid + ".playerquit.volume");
		float qsp = (float) config.getConfig().getDouble(puuid + ".playerquit.pitch");
		String ms = config.getConfig().getString(puuid + ".playermessage.sound");
		boolean mse = config.getConfig().getBoolean(puuid + ".playermessage.enabled");
		float msv = (float) config.getConfig().getDouble(puuid + ".playermessage.volume");
		float msp = (float) config.getConfig().getDouble(puuid + ".playermessage.pitch");
		
		if (inv.getName().equals(ChatSoundsInventory.catselect.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.soundinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_8) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.blocksoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_9) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.entitysoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_4) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.itemsoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_RECORD) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.musicsoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_5) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.recordsoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_12) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.weathersoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_6) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.ambientsoundsinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_3) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.uisoundsinv);
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.blocksoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
	
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(loc, Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.entitysoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.itemsoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.musicsoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.recordsoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.weathersoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.ambientsoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
			if(e.getClick().isLeftClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.closeInventory();
					p.sendMessage("CAVE SOUND SELECTED");
					config.getConfig().set(p.getName() + ".playerjoin.sound", "AMBIENT_CAVE");
				}
			}
			if(e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
					p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.uisoundsinv.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
				if(e.getClick().isLeftClick()) {
					
				}
				if(e.getClick().isRightClick()) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Cave")) {
						p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, jsv, jsp);
					}
				}
			}
		}
		if (inv.getName().equals(ChatSoundsInventory.soundinv.getName())) {
			
			e.setCancelled(true);
			
			if(e.getCurrentItem().getType() == Material.WOOL) {
				if (e.getClick().isLeftClick()) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Join Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((jsv + 1)/10));
						p.closeInventory();
						p.openInventory(ChatSoundsInventory.soundinv);
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Join Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((jsp + 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Quit Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((qsv + 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Quit Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((qsp + 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Message Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((msv + 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Message Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((msp + 1)/10));
						p.updateInventory();
					}
				}
				if (e.getClick().isRightClick()) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Join Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((jsv - 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Join Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((jsp - 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Quit Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((qsv - 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Quit Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((qsp - 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Message Volume")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((msv - 1)/10));
						p.updateInventory();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Message Pitch")) {
						config.getConfig().set((p.getName() + ".playermessage.pitch"), Float.toString((msp - 1)/10));
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.SPONGE) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Join Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Quit Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Player Message Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
			}
			if(e.getCurrentItem().getType() == Material.TNT) {
				config.getConfig().set((p.getName() + "player.playerjoin.enabled"), "5");
				config.getConfig().set((p.getName() + "player.playerjoin.volume"), "1");
				config.getConfig().set((p.getName() + "player.playerjoin.pitch"), "1");
				config.getConfig().set((p.getName() + "player.playerquit.enabled"), "5");
				config.getConfig().set((p.getName() + "player.playerquit.volume"), "1");
				config.getConfig().set((p.getName() + "player.playerquit.pitch"), "1");
				config.getConfig().set((p.getName() + "player.playermessage.enabled"), "5");
				config.getConfig().set((p.getName() + "player.playermessage.volume"), "1");
				config.getConfig().set((p.getName() + "player.playermessage.pitch"), "1");
				}
			}
		}
	
	private void loadchatsoundsconfig(Player p, String puuid) {
		config.getConfig().set(puuid + ".player", p.getName());
		config.getConfig().set(puuid + ".playerjoin.sound", "ENTITY_EXPERIENCE_ORB_TOUCH");
		config.getConfig().set(puuid + ".playerjoin.enabled", true);
		config.getConfig().set(puuid + ".playerjoin.volume", "1");
		config.getConfig().set(puuid + ".playerjoin.pitch", "1");
		config.getConfig().set(puuid + ".playerquit.sound", "ENTITY_EXPERIENCE_ORB_TOUCH");
		config.getConfig().set(puuid + ".playerquit.enabled", true);
		config.getConfig().set(puuid + ".playerquit.volume", "1");
		config.getConfig().set(puuid + ".playerquit.pitch", "1");
		config.getConfig().set(puuid + ".playermessage.sound", "BLOCK_NOTE_HAT");
		config.getConfig().set(puuid + ".playermessage.enabled", true);
		config.getConfig().set(puuid + ".playermessage.volume", "1");
		config.getConfig().set(puuid + ".playermessage.pitch", "1");
	}
}