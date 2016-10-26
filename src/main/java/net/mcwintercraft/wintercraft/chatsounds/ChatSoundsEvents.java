package net.mcwintercraft.wintercraft.chatsounds;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import net.mcwintercraft.wintercraft.WinterCraftConfig;

public class ChatSoundsEvents implements Listener {

	WinterCraftConfig config = WinterCraftConfig.getConfig("chatsounds");

	//PLAYERJOIN
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) { 
	   for(Player op : Bukkit.getOnlinePlayers()){
		   
		   String puuid = op.getUniqueId().toString();
		   
		   if (config.getConfig().getString(puuid) == null) {
			   loadchatsoundsconfig(op, puuid);
		   } else {
			   if (op.getName() == config.getConfig().getString(puuid + ".name")) {
				   config.getConfig().set(puuid + ".name", op.getName());
			   }
		   }
		   
		   String js = config.getConfig().getString(puuid + ".playerjoin.sound");
		   boolean jse = config.getConfig().getBoolean(puuid + ".playerjoin.enabled");
		   int jsv = config.getConfig().getInt(puuid + ".playerjoin.volume");
		   int jsp = config.getConfig().getInt(puuid + ".playerjoin.pitch");
		   
		   if (jse) {
			   op.playSound(op.getLocation(), Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
		   }
	   }
	   
	}
	
	//PLAYERQUIT
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent e) {
		for(Player op : Bukkit.getOnlinePlayers()){
			
			String puuid = op.getUniqueId().toString();
			
			String qs = config.getConfig().getString(puuid + ".playerquit.sound");
			boolean qse = config.getConfig().getBoolean(puuid + ".playerquit.enabled");
			int qsv = config.getConfig().getInt(puuid + ".playerquit.volume");
			int qsp = config.getConfig().getInt(puuid + ".playerquit.pitch");
			
			if (qse) {
				op.playSound(op.getLocation(), Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
		    }
		}
	}
	
	//PLAYER MESSAGE
	@EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {		
		for(Player op : Bukkit.getOnlinePlayers()){
			
			String puuid = op.getUniqueId().toString();
			
			if (config.getConfig().getString(puuid) == null) {
				loadchatsoundsconfig(op, puuid);
			}
			
			String ms = config.getConfig().getString(puuid + ".playermessage.sound");
			boolean mse = config.getConfig().getBoolean(puuid + ".playermessage.enabled");
			int msv = config.getConfig().getInt(puuid + ".playermessage.volume");
			int msp = config.getConfig().getInt(puuid + ".playermessage.pitch");
			
			if (mse) {
				op.playSound(op.getLocation(), Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		String puuid = p.getUniqueId().toString();
		ItemStack c = e.getCurrentItem();
		ClickType cl = e.getClick();
		Location ploc = p.getLocation();
		
		String js = config.getConfig().getString(puuid + ".playerjoin.sound");
		//boolean jse = config.getConfig().getBoolean(puuid + ".playerjoin.enabled");
		int jsv = config.getConfig().getInt(puuid + ".playerjoin.volume");
		int jsp = config.getConfig().getInt(puuid + ".playerjoin.pitch");
		
		String qs = config.getConfig().getString(puuid + ".playerquit.sound");
		//boolean qse = config.getConfig().getBoolean(puuid + ".playerquit.enabled");
		int qsv = config.getConfig().getInt(puuid + ".playerquit.volume");
		int qsp = config.getConfig().getInt(puuid + ".playerquit.pitch");
		
		String ms = config.getConfig().getString(puuid + ".playermessage.sound");
		//boolean mse = config.getConfig().getBoolean(puuid + ".playermessage.enabled");
		int msv = config.getConfig().getInt(puuid + ".playermessage.volume");
		int msp = config.getConfig().getInt(puuid + ".playermessage.pitch");
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.soundinv.getName())) {
			
			e.setCancelled(true);
			String n = e.getCurrentItem().getItemMeta().getDisplayName().toString().substring(2);
			
			//SOUNDS
			if(c.getType() == Material.NOTE_BLOCK) {
				if(n.equalsIgnoreCase("Join Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
				if(n.equalsIgnoreCase("Quit Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
				if(n.equalsIgnoreCase("Message Sound")) {
					p.closeInventory();
					p.openInventory(ChatSoundsInventory.catselect);
				}
			}
			
			
			if(c.getType() == Material.WOOL) {
				if (cl.isLeftClick()) {
					
					if (n.equalsIgnoreCase("Join Volume")){
						if (jsv <= 9) {
							config.getConfig().set(puuid + ".playerjoin.volume", jsv + 1);
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp <= 19) {
							config.getConfig().set(puuid + ".playerjoin.pitch", jsp + 1);
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv <= 9) {
							config.getConfig().set(puuid + ".playerquit.volume", qsv + 1);
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp <= 19) {
							config.getConfig().set(puuid + ".playerquit.pitch", qsp + 1);
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv <= 9) {
							config.getConfig().set(puuid + ".playermessage.volume", msv + 1);
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp <= 19) {
							config.getConfig().set(puuid + ".playermessage.pitch", msp + 1);
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msp + 1);
						} else {
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					config.saveConfig();
					config.reloadConfig();
				}
				
				if (cl.isRightClick()) {
					
					if (n.equalsIgnoreCase("Join Volume")) {
						if (jsv >= 1) {
							config.getConfig().set(puuid + ".playerjoin.volume", jsv - 1);
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp >= 1) {
							config.getConfig().set(puuid + ".playerjoin.pitch", jsp - 1);
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv >= 1) {
							config.getConfig().set(puuid + ".playerquit.volume", qsv - 1);
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp >= 1) {
							config.getConfig().set(puuid + ".playerquit.pitch", qsp - 1);
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv >= 1) {
							config.getConfig().set(puuid + ".playermessage.volume", msv - 1);
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp >= 1) {
							config.getConfig().set(puuid + ".playermessage.pitch", msp - 1);
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msp - 1);
						} else {
							p.playSound(ploc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					config.saveConfig();
					config.reloadConfig();
				}
				
				//Enable/Disable
				if (n.equalsIgnoreCase("Player Quit") || n.equalsIgnoreCase("Player Join") || n.equalsIgnoreCase("Player Message")) {
					boolean bol = config.getConfig().getBoolean(puuid + "." + n.toLowerCase().replace(" ", "") + ".enabled");
					config.getConfig().set(puuid + "." + n.toLowerCase().replace(" ", "") + ".enabled", !bol);
					if (!bol) {
						Wool g = new Wool(DyeColor.LIME);
						ItemStack wis = g.toItemStack();
						c.setData(g);
						c.setDurability(wis.getDurability());
					} else {
						Wool w = new Wool(DyeColor.WHITE);
						ItemStack wis = w.toItemStack();
						c.setData(w);
						c.setDurability(wis.getDurability());
					}
					config.saveConfig();
					config.reloadConfig();
				}
			}
			
			//Reset Settings
			if(c.getType() == Material.TNT) {
				loadchatsoundsconfig(p, puuid);
				p.closeInventory();
				ChatSoundsInventory.LoadInv(p, puuid);
			}
		}
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.catselect.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.soundinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_8) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.blockinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_9) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.entityinv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_4) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.iteminv);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_RECORD) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.songinv);
			}
			if (e.getCurrentItem().getType() == Material.RECORD_12) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.miscinv);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.blockinv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.entityinv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.iteminv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.songinv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.miscinv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
	}
	
	private void loadchatsoundsconfig(Player p, String puuid) {
		config.getConfig().set(puuid + ".player", p.getName());
		config.getConfig().set(puuid + ".playerjoin.sound", "ENTITY_EXPERIENCE_ORB_TOUCH");
		config.getConfig().set(puuid + ".playerjoin.enabled", true);
		config.getConfig().set(puuid + ".playerjoin.volume", 10);
		config.getConfig().set(puuid + ".playerjoin.pitch", 10);
		config.getConfig().set(puuid + ".playerquit.sound", "ENTITY_EXPERIENCE_ORB_TOUCH");
		config.getConfig().set(puuid + ".playerquit.enabled", true);
		config.getConfig().set(puuid + ".playerquit.volume", 10);
		config.getConfig().set(puuid + ".playerquit.pitch", 10);
		config.getConfig().set(puuid + ".playermessage.sound", "BLOCK_NOTE_HAT");
		config.getConfig().set(puuid + ".playermessage.enabled", true);
		config.getConfig().set(puuid + ".playermessage.volume", 10);
		config.getConfig().set(puuid + ".playermessage.pitch", 10);
		config.saveConfig();
		config.reloadConfig();
	}
}