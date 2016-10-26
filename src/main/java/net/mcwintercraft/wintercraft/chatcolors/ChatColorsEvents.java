package net.mcwintercraft.wintercraft.chatcolors;

import java.util.Random;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsInventory;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

public class ChatColorsEvents implements Listener {
	
	static WinterCraftConfig config = WinterCraftConfig.getConfig("chatcolors");
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		String puuid = p.getUniqueId().toString(); 
		if (config.getConfig().getString(puuid) == null) {
			loadchatcolorsconfig(puuid, p);
		}  else {
			   if (p.getName() == config.getConfig().getString(puuid + ".name")) {
				   config.getConfig().set(puuid + ".name", p.getName());
			   }
		   }
	}
	
	@EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		String puuid = p.getUniqueId().toString();
		String msg = e.getMessage().toString();
		String codes = "";
		String color = config.getConfig().getString(puuid + ".color");
		
		if (config.getConfig().getString(puuid) == null) {
			loadchatcolorsconfig(puuid, p);
		}
		
		if (p.getName().toString() != config.getConfig().getString(puuid + ".name")) {
			config.getConfig().set(puuid + ".name", p.getName().toString());
		}

		if (config.getConfig().getBoolean(puuid + ".bold")) {
			codes = codes + ChatColor.BOLD;
		}

		if (config.getConfig().getBoolean(puuid + ".underline")) {
			codes = codes + ChatColor.UNDERLINE;
		}

		if (config.getConfig().getBoolean(puuid + ".strikethrough")) {
			codes = codes + ChatColor.STRIKETHROUGH;
		}

		if (config.getConfig().getBoolean(puuid + ".magic")) {
			codes = codes + ChatColor.MAGIC;
		}

		if (config.getConfig().getBoolean(puuid + ".italic")) {
			codes = codes + ChatColor.ITALIC;
		}

		if (config.getConfig().getBoolean(puuid + ".random")) {
			color = rc(puuid, p);
		}

		if (config.getConfig().getBoolean(puuid + ".rainbow")) {
			
			String[] ms = msg.split("");
			msg = "";

			for (int i = 0; i < ms.length; i++) {
				if (!ms[i].isEmpty()) {
					ms[i] = ChatColor.valueOf(rc(puuid, p)) + codes + ms[i];
				}

				msg = msg + ms[i];
			}
		}

		e.setMessage(ChatColor.valueOf(color) + codes + msg);
	}

	@EventHandler
	public void onInv(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		String puuid = p.getUniqueId().toString();
		Inventory inventory = e.getInventory();
		ItemStack clicked = e.getCurrentItem();
		
		if (inventory.getTitle().equals(ChatColorsInventory.colorinv.getName())) {
			
			e.setCancelled(true);
			
			if (clicked != null && clicked.getType() == Material.WOOL) {
				
				String cl = clicked.getItemMeta().getDisplayName();
				
				if (cl.equals(gc(cl))) {
					config.getConfig().set(puuid + ".color", cl.toString().replace(" ", "_").substring(2));
					config.saveConfig();
					config.reloadConfig();
					ench(inventory, clicked);
				}

				if (cl.equals(gs(cl))) {
					
					Boolean bol = Boolean.valueOf(config.getConfig().getBoolean(puuid + "." + cl.toString().toLowerCase().substring(4)));
					config.getConfig().set(puuid + "." + cl.toString().toLowerCase().substring(4), Boolean.valueOf(!bol));
					
					if (!bol) {
						Wool g = new Wool(DyeColor.LIME);
						ItemStack wis = g.toItemStack();
						clicked.setData(g);
						clicked.setDurability(wis.getDurability());
					} else {
						Wool w = new Wool(DyeColor.WHITE);
						ItemStack wis = w.toItemStack();
						clicked.setData(w);
						clicked.setDurability(wis.getDurability());
					}
					
					config.saveConfig();
					config.reloadConfig();
				}
			}
		}
	}

	private String gs(String cl) {
		String ss = null;
		switch (cl.toString().substring(4)) {
		case "BOLD":
			ss = ChatColorsInventory.bold_name;
			break;
		case "UNDERLINE":
			ss = ChatColorsInventory.underline_name;
			break;
		case "STRIKETHROUGH":
			ss = ChatColorsInventory.strike_name;
			break;
		case "MAGIC":
			ss = ChatColorsInventory.magic_name;
			break;
		case "ITALIC":
			ss = ChatColorsInventory.italic_name;
			break;
		case "RANDOM":
			ss = ChatColorsInventory.random_name;
			break;
		case "RAINBOW":
			ss = ChatColorsInventory.rainbow_name;
			break;
		}
		return ss;
	}

	private String gc(String cl) {
		String cs;
		switch (cl.toString().substring(2)) {
		case "AQUA":
			cs = ChatColorsInventory.aqua_name;
			break;
		case "BLACK":
			cs = ChatColorsInventory.black_name;
			break;
		case "BLUE":
			cs = ChatColorsInventory.blue_name;
			break;
		case "DARK AQUA":
			cs = ChatColorsInventory.dark_aqua_name;
			break;
		case "DARK BLUE":
			cs = ChatColorsInventory.dark_blue_name;
			break;
		case "DARK GRAY":
			cs = ChatColorsInventory.dark_gray_name;
			break;
		case "DARK GREEN":
			cs = ChatColorsInventory.dark_green_name;
			break;
		case "DARK PURPLE":
			cs = ChatColorsInventory.dark_purple_name;
			break;
		case "DARK RED":
			cs = ChatColorsInventory.dark_red_name;
			break;
		case "GOLD":
			cs = ChatColorsInventory.gold_name;
			break;
		case "GRAY":
			cs = ChatColorsInventory.gray_name;
			break;
		case "GREEN":
			cs = ChatColorsInventory.green_name;
			break;
		case "LIGHT PURPLE":
			cs = ChatColorsInventory.light_purple_name;
			break;
		case "RED":
			cs = ChatColorsInventory.red_name;
			break;
		case "WHITE":
			cs = ChatColorsInventory.white_name;
			break;
		case "YELLOW":
			cs = ChatColorsInventory.yellow_name;
			break;
		default:
			cs = ChatColorsInventory.white_name;
			break;
		}
		return cs;
	}

	private void ench(Inventory inventory, ItemStack clicked) {
		
		ItemStack[] item = inventory.getContents();
		
		if (!clicked.containsEnchantment(Enchantment.SILK_TOUCH)) {
			for (int i = 0; i < item.length; i++) {
			    if(item[i] !=null && item[i].containsEnchantment(Enchantment.SILK_TOUCH)) {
			        item[i].removeEnchantment(Enchantment.SILK_TOUCH);
			    }
			}
			clicked.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
		}		
	}

	private String rc(String puuid, Player p) {
		
		Random rand = new Random();
		String cs;
		
		if (config.getConfig().getString(puuid) == null) {
			loadchatcolorsconfig(puuid, p);
		}		
		
		int rc = rand.nextInt(15);
		
		switch (rc) {
		case 0:
			cs = "AQUA";
			break;
		case 1:
			cs = "BLACK";
			break;
		case 2:
			cs = "BLUE";
			break;
		case 3:
			cs = "DARK_AQUA";
			break;
		case 4:
			cs = "DARK_BLUE";
			break;
		case 5:
			cs = "DARK_GRAY";
			break;
		case 6:
			cs = "DARK_GREEN";
			break;
		case 7:
			cs = "DARK_PURPLE";
			break;
		case 8:
			cs = "DARK_RED";
			break;
		case 9:
			cs = "GOLD";
			break;
		case 10:
			cs = "GRAY";
			break;
		case 11:
			cs = "GREEN";
			break;
		case 12:
			cs = "LIGHT_PURPLE";
			break;
		case 13:
			cs = "RED";
			break;
		case 14:
			cs = "WHITE";
			break;
		case 15:
			cs = "YELLOW";
			break;
		default:
			cs = "WHITE";
		}
		return cs;
	}
	
	public void loadchatcolorsconfig(String puuid, Player p) {
		config.getConfig().set(puuid + ".name", p.getName().toString());
		config.getConfig().set(puuid + ".color", "WHITE");
		config.getConfig().set(puuid + ".bold", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".underline", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".strikethrough", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".magic", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".italic", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".random", Boolean.valueOf(false));
		config.getConfig().set(puuid + ".rainbow", Boolean.valueOf(false));
		config.saveConfig();
		config.reloadConfig();
	}
}