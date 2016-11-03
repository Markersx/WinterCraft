package net.mcwintercraft.wintercraft.chatcolors;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import java.util.Random;

public class ChatColorsEvents extends UserData implements Listener {

    @EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {

        this.setUser(e.getPlayer());
		String msg = e.getMessage();
		String codes = "";
		String color = this.getChatColor();

		if (this.isChatColorBold()) {
			codes = codes + ChatColor.BOLD;
		}

		if (this.isChatColorUnderline()) {
			codes = codes + ChatColor.UNDERLINE;
		}

		if (this.isChatColorStrike()) {
			codes = codes + ChatColor.STRIKETHROUGH;
		}

		if (this.isChatColorMagic()) {
			codes = codes + ChatColor.MAGIC;
		}

		if (this.isChatColorItalic()) {
			codes = codes + ChatColor.ITALIC;
		}

		if (this.isChatColorRandom()) {
			color = rc();
		}

		if (this.isChatColorRainbow()) {
			
			String[] ms = msg.split("");
			msg = "";

			for (int i = 0; i < ms.length; i++) {

				if (!ms[i].isEmpty()) {
					ms[i] = ChatColor.valueOf(rc()) + codes + ms[i];
				}

				msg = msg + ms[i];
			}
		}

		e.setMessage(ChatColor.valueOf(color) + codes + msg);
	}

	@EventHandler
	public void onInv(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();
        this.setUser(p);
		Inventory inventory = e.getInventory();
		ItemStack clicked = e.getCurrentItem();
		
		if (inventory.getTitle().equals(ChatColorsInventory.colorinv.getName())) {
			
			e.setCancelled(true);
			
			if (clicked != null && clicked.getType() == Material.WOOL) {
				
				String cl = clicked.getItemMeta().getDisplayName();
				
				if (cl.equals(gc(cl))) {
                    this.setChatColor(cl.replace(" ", "_").substring(2));
					ench(inventory, clicked);
				}

				if (cl.equals(gs(cl))) {

                    String s = cl.toLowerCase().substring(4);
					Boolean bol = gsb(cl);
                    WinterCraft.ess.getUser(p).setConfigProperty("chatColor" + "." + s,!bol);

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
				}
			}
		}
	}

	private String gs(String cl) {
		String ss = null;
		switch (cl.substring(4)) {
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

    private boolean gsb(String cl) {
        boolean ssb = false;
        switch (cl.substring(4)) {
            case "BOLD":
                ssb = this.isChatColorBold();
                break;
            case "UNDERLINE":
                ssb = this.isChatColorUnderline();
                break;
            case "STRIKETHROUGH":
                ssb = this.isChatColorStrike();
                break;
            case "MAGIC":
                ssb = this.isChatColorMagic();
                break;
            case "ITALIC":
                ssb = this.isChatColorItalic();
                break;
            case "RANDOM":
                ssb = this.isChatColorRainbow();
                break;
            case "RAINBOW":
                ssb = this.isChatColorRainbow();
                break;
        }
        return ssb;
    }

	private String gc(String cl) {
		String cs;
		switch (cl.substring(2)) {
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
            for (ItemStack anItem : item) {
                if (anItem != null && anItem.containsEnchantment(Enchantment.SILK_TOUCH)) {
                    anItem.removeEnchantment(Enchantment.SILK_TOUCH);
                }
            }
			clicked.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
		}		
	}

	private String rc() {
		
		Random rand = new Random();
		String cs;

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
	
	//private void loadchatcolorsconfig(String puuid, Player p) {
	//	config.getConfig().set(puuid + ".name", p.getName());
	//	config.getConfig().set(puuid + ".color", "WHITE");
	//	config.getConfig().set(puuid + ".bold", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".underline", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".strikethrough", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".magic", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".italic", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".random", Boolean.FALSE);
	//	config.getConfig().set(puuid + ".rainbow", Boolean.FALSE);
	//	config.saveConfig();
	//	config.reloadConfig();
	//}
}