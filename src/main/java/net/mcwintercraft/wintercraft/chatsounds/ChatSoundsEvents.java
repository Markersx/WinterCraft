package net.mcwintercraft.wintercraft.chatsounds;

import net.mcwintercraft.wintercraft.UserData;
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

public class ChatSoundsEvents extends UserData implements Listener {

    //PLAYER JOIN
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) { 
	   for(Player op : Bukkit.getOnlinePlayers()){
           this.setUser(op);
		   String js = this.getJoinSound();
		   boolean jse = this.isJoinSoundEnabled();
		   int jsv = this.getJoinSoundVolume();
		   int jsp = this.getJoinSoundPitch();
		   
		   if (jse) {
			   op.playSound(op.getLocation(), Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
		   }
	   }
	   
	}
	
	//PLAYER QUIT
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent e) {
		for(Player op : Bukkit.getOnlinePlayers()){
            this.setUser(op);
			String qs = this.getQuitSound();
			boolean qse = this.isQuitSoundEnabled();
			int qsv = this.getQuitSoundVolume();
			int qsp = this.getQuitSoundPitch();
			
			if (qse) {
				op.playSound(op.getLocation(), Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
		    }
		}
	}
	
	//PLAYER MESSAGE
	@EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {		
		for(Player op : Bukkit.getOnlinePlayers()){
            this.setUser(op);
			String ms = this.getMessageSound();
			boolean mse = this.isMessageSoundEnabled();
			int msv = this.getMessageSoundVolume();
            int msp = this.getMessageSoundPitch();

            if (mse) {
				op.playSound(op.getLocation(), Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
        this.setUser(p);
		Inventory inv = e.getInventory();
		ItemStack c = e.getCurrentItem();
		ClickType cl = e.getClick();
        Location loc = p.getLocation();

        String js = this.getJoinSound();
        //boolean jse = this.isJoinSoundEnabled();
        int jsv = this.getJoinSoundVolume();
        int jsp = this.getJoinSoundPitch();

        String qs = this.getQuitSound();
        //boolean qse = this.isQuitSoundEnabled();
        int qsv = this.getQuitSoundVolume();
        int qsp = this.getQuitSoundPitch();

        String ms = this.getMessageSound();
        //boolean mse = this.isMessageSoundEnabled();
        int msv = this.getMessageSoundVolume();
        int msp = this.getMessageSoundPitch();
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.soundInv.getName())) {
			
			e.setCancelled(true);
			String n = e.getCurrentItem().getItemMeta().getDisplayName().substring(2);
			
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
							this.setSoundVolume("join", jsv + 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp <= 19) {
							this.setSoundPitch("join", jsp + 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp + 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv <= 9) {
                            this.setSoundVolume("quit", qsv + 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp <= 19) {
                            this.setSoundPitch("quit", qsp + 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp + 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv <= 9) {
                            this.setSoundVolume("join", msv + 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv + 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp <= 19) {
                            this.setSoundPitch("message", msp + 1);
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
                            this.setSoundVolume("join", jsv - 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Join Pitch")) {
						if (jsp >= 1) {
                            this.setSoundPitch("join", jsp - 1);
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
							c.setAmount(jsp - 1);
						} else {
							p.playSound(loc, Sound.valueOf(js), (float) jsv / 10, (float) jsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Volume")) {
						if (qsv >= 1) {
                            this.setSoundVolume("quit", qsv - 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Quit Pitch")) {
						if (qsp >= 1) {
                            this.setSoundPitch("quit", qsp - 1);
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
							c.setAmount(qsp - 1);
						} else {
							p.playSound(loc, Sound.valueOf(qs), (float) qsv / 10, (float) qsp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Volume")) {
						if (msv >= 1) {
                            this.setSoundVolume("join", msv - 1);
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
							c.setAmount(msv - 1);
						} else {
							p.playSound(loc, Sound.valueOf(ms), (float) msv / 10, (float) msp / 10);
						}
					}
					
					if (n.equalsIgnoreCase("Message Pitch")) {
						if (msp >= 1) {
                            this.setSoundPitch("message", msp - 1);
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
                    boolean bol = config.getBoolean("sounds." + type[1] + ".enabled");
                    this.setSoundEnabled(type[1], !bol);
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
				}
			}
			
			//Reset Settings
			if(c.getType() == Material.TNT) {
				loadChatSoundsConfig();
				p.closeInventory();
                //TODO RE OPEN INVENTORY
			}
		}
		
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.catselect.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.soundInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_8) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.blockInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_9) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.entityInv);
			}
			if(e.getCurrentItem().getType() == Material.RECORD_4) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.itemInv);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_RECORD) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.songInv);
			}
			if (e.getCurrentItem().getType() == Material.RECORD_12) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.miscInv);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.blockInv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.entityInv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.itemInv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.songInv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
		if (c != null && c.getType() != Material.AIR && inv.getName().equals(ChatSoundsInventory.miscInv.getName())){
			e.setCancelled(true);
			if (c.equals(ChatSoundsInventory.backbutton_item)) {
				p.closeInventory();
				p.openInventory(ChatSoundsInventory.catselect);
			}
		}
	}
	
	private void loadChatSoundsConfig() {
        this.setSound("join", "ENTITY_EXPERIENCE_ORB_TOUCH");
        this.setSoundEnabled("join", true);
        this.setSoundVolume("join", 10);
        this.setSoundPitch("join", 10);

        this.setSound("quit", "ENTITY_EXPERIENCE_ORB_TOUCH");
        this.setSoundEnabled("quit", true);
        this.setSoundVolume("quit", 10);
        this.setSoundPitch("quit", 10);

        this.setSound("message", "BLOCK_NOTE_HAT");
        this.setSoundEnabled("message", true);
        this.setSoundVolume("message", 10);
        this.setSoundPitch("message", 10);
	}
}