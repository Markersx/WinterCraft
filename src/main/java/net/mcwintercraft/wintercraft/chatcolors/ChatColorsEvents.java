package net.mcwintercraft.wintercraft.chatcolors;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftUtil;
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

import java.util.Random;

public class ChatColorsEvents implements Listener {

    private final WinterCraft wc;
    private ChatColorsInventory ccinv;

    public ChatColorsEvents(WinterCraft wc) {
        this.wc = wc;
        this.ccinv = new ChatColorsInventory(wc);
    }

    @EventHandler
	public void onSendMessage(AsyncPlayerChatEvent e) {

		String msg = e.getMessage();
        Player p = e.getPlayer();
        UserData user = new UserData(p, wc);
		String codes = "";
		String color = user.getChatColor();

		if (user.isChatColorBold()) {
			codes = codes + ChatColor.BOLD;
		}

		if (user.isChatColorUnderline()) {
			codes = codes + ChatColor.UNDERLINE;
		}

		if (user.isChatColorStrike()) {
			codes = codes + ChatColor.STRIKETHROUGH;
		}

		if (user.isChatColorMagic()) {
			codes = codes + ChatColor.MAGIC;
		}

		if (user.isChatColorItalic()) {
			codes = codes + ChatColor.ITALIC;
		}

		if (user.isChatColorRandom()) {
			color = rc();
		}

		if (user.isChatColorRainbow()) {
			
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
        UserData user = new UserData(p, wc);
		Inventory inventory = e.getInventory();
		ItemStack clicked = e.getCurrentItem();
		
		if (inventory.getName().equals(ccinv.colorinv.getName())) {
			
			e.setCancelled(true);
			
			if (clicked != null && clicked.getType() == Material.WOOL) {
				
				String cl = clicked.getItemMeta().getDisplayName();
				
				if (cl.equals(gc(cl))) {
                    user.setChatColor(cl.replace(" ", "_").substring(2));
					ench(inventory, clicked);
				}

				if (cl.equals(gs(cl))) {

                    String s = cl.toLowerCase().substring(4);
					Boolean bol = gsb(cl, user);
                    user.setChatColorStyle(s,!bol);

					if (!bol) {
                        WinterCraftUtil.setWoolColor(clicked, DyeColor.LIME);
					} else {
                        WinterCraftUtil.setWoolColor(clicked, DyeColor.WHITE);
                    }
				}
			}
		}
	}

	private String gs(String cl) {
		String ss = null;
		switch (cl.substring(4)) {
		case "BOLD":
			ss = ccinv.bold_name;
			break;
		case "UNDERLINE":
			ss = ccinv.underline_name;
			break;
		case "STRIKETHROUGH":
			ss = ccinv.strike_name;
			break;
		case "MAGIC":
			ss = ccinv.magic_name;
			break;
		case "ITALIC":
			ss = ccinv.italic_name;
			break;
		case "RANDOM":
			ss = ccinv.random_name;
			break;
		case "RAINBOW":
			ss = ccinv.rainbow_name;
			break;
		}
		return ss;
	}

    private boolean gsb(String cl, UserData user) {
        boolean ssb = false;
        switch (cl.substring(4)) {
            case "BOLD":
                ssb = user.isChatColorBold();
                break;
            case "UNDERLINE":
                ssb = user.isChatColorUnderline();
                break;
            case "STRIKETHROUGH":
                ssb = user.isChatColorStrike();
                break;
            case "MAGIC":
                ssb = user.isChatColorMagic();
                break;
            case "ITALIC":
                ssb = user.isChatColorItalic();
                break;
            case "RANDOM":
                ssb = user.isChatColorRainbow();
                break;
            case "RAINBOW":
                ssb = user.isChatColorRainbow();
                break;
        }
        return ssb;
    }

	private String gc(String cl) {
		String cs;
		switch (cl.substring(2)) {
		case "AQUA":
			cs = ccinv.aqua_name;
			break;
		case "BLACK":
			cs = ccinv.black_name;
			break;
		case "BLUE":
			cs = ccinv.blue_name;
			break;
		case "DARK AQUA":
			cs = ccinv.dark_aqua_name;
			break;
		case "DARK BLUE":
			cs = ccinv.dark_blue_name;
			break;
		case "DARK GRAY":
			cs = ccinv.dark_gray_name;
			break;
		case "DARK GREEN":
			cs = ccinv.dark_green_name;
			break;
		case "DARK PURPLE":
			cs = ccinv.dark_purple_name;
			break;
		case "DARK RED":
			cs = ccinv.dark_red_name;
			break;
		case "GOLD":
			cs = ccinv.gold_name;
			break;
		case "GRAY":
			cs = ccinv.gray_name;
			break;
		case "GREEN":
			cs = ccinv.green_name;
			break;
		case "LIGHT PURPLE":
			cs = ccinv.light_purple_name;
			break;
		case "RED":
			cs = ccinv.red_name;
			break;
		case "WHITE":
			cs = ccinv.white_name;
			break;
		case "YELLOW":
			cs = ccinv.yellow_name;
			break;
		default:
			cs = ccinv.white_name;
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
}