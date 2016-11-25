package net.mcwintercraft.wintercraft.chatcolors;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftUtil;
import net.mcwintercraft.wintercraft.entity.ItemStacks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColorsInventory {

    private WinterCraft wc;

    public ChatColorsInventory(WinterCraft wc) {
        this.wc = wc;
    }

	public final Inventory colorinv = Bukkit.createInventory(null, 54, "Color Options");
	
	//CHAT COLORS
	private final ItemStack black = new ItemStack(Material.WOOL, 1, (short) 15);
	final String black_name = ChatColor.BLACK + "BLACK";
	private final ItemMeta black_meta = black.getItemMeta();

    private final ItemStack dark_blue = new ItemStack(Material.WOOL, 1, (short) 11);
	final String dark_blue_name = ChatColor.DARK_BLUE + "DARK BLUE";
	private final ItemMeta dark_blue_meta = dark_blue.getItemMeta();
	
	private final ItemStack dark_green = new ItemStack(Material.WOOL, 1, (short) 13);
	final String dark_green_name = ChatColor.DARK_GREEN + "DARK GREEN";
	private final ItemMeta dark_green_meta = dark_green.getItemMeta();
	
	private final ItemStack dark_aqua = new ItemStack(Material.WOOL, 1, (short) 9);
	final String dark_aqua_name = ChatColor.DARK_AQUA + "DARK AQUA";
	private final ItemMeta dark_aqua_meta = dark_aqua.getItemMeta();
	
	private final ItemStack dark_red = new ItemStack(Material.WOOL, 1, (short) 14);
	final String dark_red_name = ChatColor.DARK_RED + "DARK RED";
	private final ItemMeta dark_red_meta = dark_red.getItemMeta();
	
	private final ItemStack dark_purple = new ItemStack(Material.WOOL, 1, (short) 10);
	final String dark_purple_name = ChatColor.DARK_PURPLE + "DARK PURPLE";
	private final ItemMeta dark_purple_meta = dark_purple.getItemMeta();
	
	private final ItemStack gold = new ItemStack(Material.WOOL, 1, (short) 1);
	final String gold_name = ChatColor.GOLD + "GOLD";
	private final ItemMeta gold_meta = gold.getItemMeta();
	
	private final ItemStack gray = new ItemStack(Material.WOOL, 1, (short) 8);
	final String gray_name = ChatColor.GRAY + "GRAY";
	private final ItemMeta gray_meta = gray.getItemMeta();
	
	private final ItemStack dark_gray = new ItemStack(Material.WOOL, 1, (short) 7);
	final String dark_gray_name = ChatColor.DARK_GRAY + "DARK GRAY";
	private final ItemMeta dark_gray_meta = dark_gray.getItemMeta();
	
	private final ItemStack blue = new ItemStack(Material.WOOL, 1, (short) 11);
	final String blue_name = ChatColor.BLUE + "BLUE";
	private final ItemMeta blue_meta = blue.getItemMeta();
	
	private final ItemStack green = new ItemStack(Material.WOOL, 1, (short) 5);
	final String green_name = ChatColor.GREEN + "GREEN";
	private final ItemMeta green_meta = green.getItemMeta();
	
	private final ItemStack red = new ItemStack(Material.WOOL, 1, (short) 6);
	final String red_name = ChatColor.RED + "RED";
	private final ItemMeta red_meta = red.getItemMeta();
	
	private final ItemStack aqua = new ItemStack(Material.WOOL, 1, (short) 3);
	final String aqua_name = ChatColor.AQUA + "AQUA";
	private final ItemMeta aqua_meta = aqua.getItemMeta();
	
	private final ItemStack light_purple = new ItemStack(Material.WOOL, 1, (short) 2);
	final String light_purple_name = ChatColor.LIGHT_PURPLE + "LIGHT PURPLE";
	private final ItemMeta light_purple_meta = light_purple.getItemMeta();
	
	private final ItemStack yellow = new ItemStack(Material.WOOL, 1, (short) 4);
	final String yellow_name = ChatColor.YELLOW + "YELLOW";
	private final ItemMeta yellow_meta = yellow.getItemMeta();
	
	private final ItemStack white = new ItemStack(Material.WOOL, 1);
	final String white_name = ChatColor.WHITE + "WHITE";
	private final ItemMeta white_meta = white.getItemMeta();
	
	//CHAT STYLES
	private final ItemStack bold = new ItemStack(Material.WOOL, 1);
	final String bold_name = "" + ChatColor.RESET + ChatColor.BOLD + "BOLD";
	private final ItemMeta bold_meta = bold.getItemMeta();
	
	private final ItemStack magic = new ItemStack(Material.WOOL, 1);
	final String magic_name = "" + ChatColor.RESET + ChatColor.MAGIC + "MAGIC";
	private final ItemMeta magic_meta = magic.getItemMeta();
	
	private final ItemStack underline = new ItemStack(Material.WOOL, 1);
	final String underline_name = "" + ChatColor.RESET + ChatColor.UNDERLINE + "UNDERLINE";
	private final ItemMeta underline_meta = underline.getItemMeta();
	
	private final ItemStack italic = new ItemStack(Material.WOOL, 1);
	final String italic_name = "" + ChatColor.RESET + ChatColor.ITALIC + "ITALIC";
	private final ItemMeta italic_meta = italic.getItemMeta();
	
	private final ItemStack strike = new ItemStack(Material.WOOL, 1);
	final String strike_name = "" + ChatColor.RESET + ChatColor.STRIKETHROUGH + "STRIKETHROUGH";
	private final ItemMeta strike_meta = strike.getItemMeta();
	
	private final ItemStack random = new ItemStack(Material.WOOL, 1);
	final String random_name = "" + ChatColor.RESET + ChatColor.WHITE + "RANDOM";
	private final ItemMeta random_meta = random.getItemMeta();
	
	private final ItemStack rainbow = new ItemStack(Material.WOOL, 1);
	final String rainbow_name = "" + ChatColor.RESET + ChatColor.WHITE + "RAINBOW";
	private final ItemMeta rainbow_meta = rainbow.getItemMeta();

    public void LoadInv(Player p) {
        UserData user = new UserData(p, wc);
		//CHAT COLORS META
		black_meta.setDisplayName(black_name);
		black_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		black.setItemMeta(black_meta);
		
		dark_blue_meta.setDisplayName(dark_blue_name);
		dark_blue_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_blue.setItemMeta(dark_blue_meta);
		
		dark_green_meta.setDisplayName(dark_green_name);
		dark_green_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_green.setItemMeta(dark_green_meta);
		dark_aqua_meta.setDisplayName(dark_aqua_name);
		dark_aqua_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_aqua.setItemMeta(dark_aqua_meta);
		
		dark_red_meta.setDisplayName(dark_red_name);
		dark_red_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_red.setItemMeta(dark_red_meta);
		
		dark_purple_meta.setDisplayName(dark_purple_name);
		dark_purple_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_purple.setItemMeta(dark_purple_meta);
		
		gold_meta.setDisplayName(gold_name);
		gold_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		gold.setItemMeta(gold_meta);
		
		gray_meta.setDisplayName(gray_name);
		gray_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		gray.setItemMeta(gray_meta);
		
		dark_gray_meta.setDisplayName(dark_gray_name);
		dark_gray_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dark_gray.setItemMeta(dark_gray_meta);
		
		blue_meta.setDisplayName(blue_name);
		blue_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		blue.setItemMeta(blue_meta);
		
		green_meta.setDisplayName(green_name);
		green_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		green.setItemMeta(green_meta);
		
		red_meta.setDisplayName(red_name);
		red_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		red.setItemMeta(red_meta);
		
		aqua_meta.setDisplayName(aqua_name);
		aqua_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		aqua.setItemMeta(aqua_meta);
		
		light_purple_meta.setDisplayName(light_purple_name);
		light_purple_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		light_purple.setItemMeta(light_purple_meta);
		
		yellow_meta.setDisplayName(yellow_name);
		yellow_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		yellow.setItemMeta(yellow_meta);
		
		white_meta.setDisplayName(white_name);
		white_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		white.setItemMeta(white_meta);
		
		//CHAT STYLES META
		bold_meta.setDisplayName(bold_name);
		bold.setItemMeta(bold_meta);
		
		magic_meta.setDisplayName(magic_name);
		magic.setItemMeta(magic_meta);
		
		underline_meta.setDisplayName(underline_name);
		underline.setItemMeta(underline_meta);
		
		italic_meta.setDisplayName(italic_name);
		italic.setItemMeta(italic_meta);
		
		strike_meta.setDisplayName(strike_name);
		strike.setItemMeta(strike_meta);
		
		random_meta.setDisplayName(random_name);
		random.setItemMeta(random_meta);
		
		rainbow_meta.setDisplayName(rainbow_name);
		rainbow.setItemMeta(rainbow_meta);
		
		//ADD ENCHANTMENT TO LAST USED COLOR
		if (user.isChatColorRandom() || user.isChatColorRainbow()) {
			
			String color = user.getChatColor();
			Enchantment e = Enchantment.SILK_TOUCH;
			
			switch (color) {
			case "AQUA":
				aqua.addUnsafeEnchantment(e, 1);
				break;
			case "BLACK":
				black.addUnsafeEnchantment(e, 1);
				break;
			case "BLUE":
				blue.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_AQUA":
				dark_aqua.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_BLUE":
				dark_blue.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_GRAY":
				dark_gray.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_GREEN":
				dark_green.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_PURPLE":
				dark_purple.addUnsafeEnchantment(e, 1);
				break;
			case "DARK_RED":
				dark_red.addUnsafeEnchantment(e, 1);
				break;
			case "GOLD":
				gold.addUnsafeEnchantment(e, 1);
				break;
			case "GRAY":
				gray.addUnsafeEnchantment(e, 1);
				break;
			case "GREEN":
				green.addUnsafeEnchantment(e, 1);
				break;
			case "LIGHT_PURPLE":
				light_purple.addUnsafeEnchantment(e, 1);
				break;
			case "RED":
				red.addUnsafeEnchantment(e, 1);
				break;
			case "WHITE":
				white.addUnsafeEnchantment(e, 1);
				break;
			case "YELLOW":
				yellow.addUnsafeEnchantment(e, 1);
				break;
            default:
                white.addUnsafeEnchantment(e, 1);
			}
		}
		
		colorinv.setItem(10, black);
		colorinv.setItem(11, dark_blue);
		colorinv.setItem(12, dark_green);
		colorinv.setItem(13, dark_aqua);
		colorinv.setItem(19, dark_red);
		colorinv.setItem(20, dark_purple);
		colorinv.setItem(21, gold);
		colorinv.setItem(22, gray);
		colorinv.setItem(28, dark_gray);
		colorinv.setItem(29, blue);
		colorinv.setItem(30, green);
		colorinv.setItem(31, red);
		colorinv.setItem(37, aqua);
		colorinv.setItem(38, light_purple);
		colorinv.setItem(39, yellow);
		colorinv.setItem(40, white);
		
		enabled(user.isChatColorBold(), bold);
		enabled(user.isChatColorMagic(), magic);
		enabled(user.isChatColorUnderline(), underline);
		enabled(user.isChatColorItalic(), italic);
		enabled(user.isChatColorStrike(), strike);
		enabled(user.isChatColorRandom(), random);
		enabled(user.isChatColorRainbow(), rainbow);
		
		colorinv.setItem(15, bold);
		colorinv.setItem(42, magic);
		colorinv.setItem(24, underline);
		colorinv.setItem(16, italic);
		colorinv.setItem(33, strike);
		colorinv.setItem(25, random);
		colorinv.setItem(34, rainbow);
		
		p.openInventory(colorinv);
		
	}

	private void enabled(boolean b, ItemStack i) {
		if (b) {
            WinterCraftUtil.setWoolColor(i, DyeColor.LIME);
		} else {
            WinterCraftUtil.setWoolColor(i, DyeColor.WHITE);
		}
	}
}