package net.mcwintercraft.wintercraft.chatsounds;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftUtil;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsInventory;
import org.bukkit.*;
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

public class ChatSoundsEvents implements Listener {

    private final WinterCraft wc;
    ChatSoundsInventory csinv;

    public ChatSoundsEvents(WinterCraft winterCraft) {
        this.wc = winterCraft;
        csinv = new ChatSoundsInventory(wc);
    }

    //PLAYER JOIN
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) { 
	   for(Player op : Bukkit.getOnlinePlayers()){
           UserData user = new UserData(op, wc);
           String js = user.getJoinSound();
		   boolean jse = user.isJoinSoundEnabled();
		   int jsv = user.getJoinSoundVolume();
		   int jsp = user.getJoinSoundPitch();
		   
		   if (jse) {
			   op.playSound(op.getLocation(), Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
		   }
	   }
	   
	}
	
	//PLAYER QUIT
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent e) {
		for(Player op : Bukkit.getOnlinePlayers()){
            UserData user = new UserData(op, wc);
			String qs = user.getQuitSound();
			boolean qse = user.isQuitSoundEnabled();
			int qsv = user.getQuitSoundVolume();
			int qsp = user.getQuitSoundPitch();
			
			if (qse) {
				op.playSound(op.getLocation(), Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
		    }
		}
	}
	
	//PLAYER MESSAGE
	@EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {		
		for(Player op : Bukkit.getOnlinePlayers()){
            UserData user = new UserData(op, wc);
			String ms = user.getMessageSound();
			boolean mse = user.isMessageSoundEnabled();
			int msv = user.getMessageSoundVolume();
            int msp = user.getMessageSoundPitch();

            if (mse) {
				op.playSound(op.getLocation(), Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
        UserData user = new UserData(p, wc);
        user.reloadConfig();
		Inventory inv = e.getInventory();
		ItemStack c = e.getCurrentItem();
		ClickType cl = e.getClick();
        Location loc = p.getLocation();

        String js = user.getJoinSound();
        //boolean jse = user.isJoinSoundEnabled();
        int jsv = user.getJoinSoundVolume();
        int jsp = user.getJoinSoundPitch();

        String qs = user.getQuitSound();
        //boolean qse = user.isQuitSoundEnabled();
        int qsv = user.getQuitSoundVolume();
        int qsp = user.getQuitSoundPitch();

        String ms = user.getMessageSound();
        //boolean mse = user.isMessageSoundEnabled();
        int msv = user.getMessageSoundVolume();
        int msp = user.getMessageSoundPitch();
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.soundInv.getName())) {
			
			e.setCancelled(true);
			String n = e.getCurrentItem().getItemMeta().getDisplayName().substring(2);
			
			//SOUNDS
			if(c.getType() == Material.NOTE_BLOCK) {
				if(n.equalsIgnoreCase("Join Sound")) {
					p.closeInventory();
					p.openInventory(csinv.catselect);
				}
				if(n.equalsIgnoreCase("Quit Sound")) {
					p.closeInventory();
					p.openInventory(csinv.catselect);
				}
				if(n.equalsIgnoreCase("Message Sound")) {
					p.closeInventory();
					p.openInventory(csinv.catselect);
				}
			}
			
			
			if(c.getType() == Material.WOOL) {
				if (cl.isLeftClick()) {
					
					if (n.equalsIgnoreCase("Join Volume")){
						if (jsv <= 9) {
                            user.setSoundVolume("join", jsv + 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp <= 19) {
                            user.setSoundPitch("join", jsp + 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp + 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv <= 9) {
                            user.setSoundVolume("quit", qsv + 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp <= 19) {
                            user.setSoundPitch("quit", qsp + 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp + 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv <= 9) {
                            user.setSoundVolume("join", msv + 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp <= 19) {
                            user.setSoundPitch("message", msp + 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msp + 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}

				}
				
				if (cl.isRightClick()) {
					
					if (n.equalsIgnoreCase("Join Volume")) {
						if (jsv >= 1) {
                            user.setSoundVolume("join", jsv - 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp >= 1) {
                            user.setSoundPitch("join", jsp - 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp - 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv >= 1) {
                            user.setSoundVolume("quit", qsv - 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp >= 1) {
                            user.setSoundPitch("quit", qsp - 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp - 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv >= 1) {
                            user.setSoundVolume("join", msv - 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp >= 1) {
                            user.setSoundPitch("message", msp - 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msp - 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}

				}
				
				//Enable/Disable
				if (n.equalsIgnoreCase("Player Quit") || n.equalsIgnoreCase("Player Join") || n.equalsIgnoreCase("Player Message")) {
                    String[] type = n.toLowerCase().split(" ");
                    boolean bol = user.getConfig().getBoolean("sounds." + type[1] + ".enabled");
                    user.setSoundEnabled(type[1], !bol);
					if (!bol) {
                        WinterCraftUtil.setWoolColor(c, DyeColor.LIME);
					} else {
						WinterCraftUtil.setWoolColor(c, DyeColor.WHITE);
					}
				}
			}
			
			//Reset Settings
			if(c.getType() == Material.TNT) {
				loadChatSoundsConfig(user);
                csinv.loadInventory(p);
            }
		}
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.catselect.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(csinv.soundInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_8) {
				p.closeInventory();
				p.openInventory(csinv.blockInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_9) {
				p.closeInventory();
				p.openInventory(csinv.entityInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_4) {
				p.closeInventory();
				p.openInventory(csinv.itemInv);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_RECORD) {
				p.closeInventory();
				p.openInventory(csinv.songInv);
			}
			if (e.getCurrentItem().getType() == Material.RECORD_12) {
				p.closeInventory();
				p.openInventory(csinv.miscInv);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.blockInv.getName())){
			e.setCancelled(true);
			if (c.equals(csinv.backbutton_item)) {
				p.closeInventory();
				p.openInventory(csinv.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.entityInv.getName())){
			e.setCancelled(true);
			if (c.equals(csinv.backbutton_item)) {
				p.closeInventory();
				p.openInventory(csinv.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.itemInv.getName())){
			e.setCancelled(true);
			if (c.equals(csinv.backbutton_item)) {
				p.closeInventory();
				p.openInventory(csinv.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.songInv.getName())){
			e.setCancelled(true);
			if (c.equals(csinv.backbutton_item)) {
				p.closeInventory();
				p.openInventory(csinv.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(csinv.miscInv.getName())){
			e.setCancelled(true);
			if (c.equals(csinv.backbutton_item)) {
				p.closeInventory();
				p.openInventory(csinv.catselect);
			}
		}
	}
	
	private void loadChatSoundsConfig(UserData user) {
        user.setSound("join", "ENTITY_EXPERIENCE_ORB_TOUCH");
        user.setSoundEnabled("join", true);
        user.setSoundVolume("join", 10);
        user.setSoundPitch("join", 10);

        user.setSound("quit", "ENTITY_EXPERIENCE_ORB_TOUCH");
        user.setSoundEnabled("quit", true);
        user.setSoundVolume("quit", 10);
        user.setSoundPitch("quit", 10);

        user.setSound("message", "BLOCK_NOTE_HAT");
        user.setSoundEnabled("message", true);
        user.setSoundVolume("message", 10);
        user.setSoundPitch("message", 10);
	}
}