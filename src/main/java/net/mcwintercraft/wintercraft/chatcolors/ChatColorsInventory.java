package net.mcwintercraft.wintercraft.chatcolors;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

public class ChatColorsInventory {
	
	private static final WinterCraftConfig config = WinterCraftConfig.getConfig("chatcolors");
	public static final Inventory colorinv = Bukkit.createInventory((InventoryHolder) null, 54, "Color Options");
	
	//CHAT COLORS
	private static final ItemStack black = new ItemStack(Material.WOOL, 1, (short) 15);
	static final String black_name = ChatColor.BLACK + "BLACK";
	private static final ItemMeta black_meta = black.getItemMeta();
	
	private static final ItemStack dark_blue = new ItemStack(Material.WOOL, 1, (short) 11);
	static final String dark_blue_name = ChatColor.DARK_BLUE + "DARK BLUE";
	private static final ItemMeta dark_blue_meta = dark_blue.getItemMeta();
	
	private static final ItemStack dark_green = new ItemStack(Material.WOOL, 1, (short) 13);
	static final String dark_green_name = ChatColor.DARK_GREEN + "DARK GREEN";
	private static final ItemMeta dark_green_meta = dark_green.getItemMeta();
	
	private static final ItemStack dark_aqua = new ItemStack(Material.WOOL, 1, (short) 9);
	static final String dark_aqua_name = ChatColor.DARK_AQUA + "DARK AQUA";
	private static final ItemMeta dark_aqua_meta = dark_aqua.getItemMeta();
	
	private static final ItemStack dark_red = new ItemStack(Material.WOOL, 1, (short) 14);
	static final String dark_red_name = ChatColor.DARK_RED + "DARK RED";
	private static final ItemMeta dark_red_meta = dark_red.getItemMeta();
	
	private static final ItemStack dark_purple = new ItemStack(Material.WOOL, 1, (short) 10);
	static final String dark_purple_name = ChatColor.DARK_PURPLE + "DARK PURPLE";
	private static final ItemMeta dark_purple_meta = dark_purple.getItemMeta();
	
	private static final ItemStack gold = new ItemStack(Material.WOOL, 1, (short) 1);
	static final String gold_name = ChatColor.GOLD + "GOLD";
	private static final ItemMeta gold_meta = gold.getItemMeta();
	
	private static final ItemStack gray = new ItemStack(Material.WOOL, 1, (short) 8);
	static final String gray_name = ChatColor.GRAY + "GRAY";
	private static final ItemMeta gray_meta = gray.getItemMeta();
	
	private static final ItemStack dark_gray = new ItemStack(Material.WOOL, 1, (short) 7);
	static final String dark_gray_name = ChatColor.DARK_GRAY + "DARK GRAY";
	private static final ItemMeta dark_gray_meta = dark_gray.getItemMeta();
	
	private static final ItemStack blue = new ItemStack(Material.WOOL, 1, (short) 11);
	static final String blue_name = ChatColor.BLUE + "BLUE";
	private static final ItemMeta blue_meta = blue.getItemMeta();
	
	private static final ItemStack green = new ItemStack(Material.WOOL, 1, (short) 5);
	static final String green_name = ChatColor.GREEN + "GREEN";
	private static final ItemMeta green_meta = green.getItemMeta();
	
	private static final ItemStack red = new ItemStack(Material.WOOL, 1, (short) 6);
	static final String red_name = ChatColor.RED + "RED";
	private static final ItemMeta red_meta = red.getItemMeta();
	
	private static final ItemStack aqua = new ItemStack(Material.WOOL, 1, (short) 3);
	static final String aqua_name = ChatColor.AQUA + "AQUA";
	private static final ItemMeta aqua_meta = aqua.getItemMeta();
	
	private static final ItemStack light_purple = new ItemStack(Material.WOOL, 1, (short) 2);
	static final String light_purple_name = ChatColor.LIGHT_PURPLE + "LIGHT PURPLE";
	private static final ItemMeta light_purple_meta = light_purple.getItemMeta();
	
	private static final ItemStack yellow = new ItemStack(Material.WOOL, 1, (short) 4);
	static final String yellow_name = ChatColor.YELLOW + "YELLOW";
	private static final ItemMeta yellow_meta = yellow.getItemMeta();
	
	private static final ItemStack white = new ItemStack(Material.WOOL, 1);
	static final String white_name = ChatColor.WHITE + "WHITE";
	private static final ItemMeta white_meta = white.getItemMeta();
	
	//CHAT STYLES
	private static final ItemStack bold = new ItemStack(Material.WOOL, 1);
	static final String bold_name = "" + ChatColor.RESET + ChatColor.BOLD + "BOLD";
	private static final ItemMeta bold_meta = bold.getItemMeta();
	
	private static final ItemStack magic = new ItemStack(Material.WOOL, 1);
	static final String magic_name = "" + ChatColor.RESET + ChatColor.MAGIC + "MAGIC";
	private static final ItemMeta magic_meta = magic.getItemMeta();
	
	private static final ItemStack underline = new ItemStack(Material.WOOL, 1);
	static final String underline_name = "" + ChatColor.RESET + ChatColor.UNDERLINE + "UNDERLINE";
	private static final ItemMeta underline_meta = underline.getItemMeta();
	
	private static final ItemStack italic = new ItemStack(Material.WOOL, 1);
	static final String italic_name = "" + ChatColor.RESET + ChatColor.ITALIC + "ITALIC";
	private static final ItemMeta italic_meta = italic.getItemMeta();
	
	private static final ItemStack strike = new ItemStack(Material.WOOL, 1);
	static final String strike_name = "" + ChatColor.RESET + ChatColor.STRIKETHROUGH + "STRIKETHROUGH";
	private static final ItemMeta strike_meta = strike.getItemMeta();
	
	private static final ItemStack random = new ItemStack(Material.WOOL, 1);
	static final String random_name = "" + ChatColor.RESET + ChatColor.WHITE + "RANDOM";
	private static final ItemMeta random_meta = random.getItemMeta();
	
	private static final ItemStack rainbow = new ItemStack(Material.WOOL, 1);
	static final String rainbow_name = "" + ChatColor.RESET + ChatColor.WHITE + "RAINBOW";
	private static final ItemMeta rainbow_meta = rainbow.getItemMeta();
	
	private static final Wool g = new Wool(DyeColor.LIME);
	private static final Wool w = new Wool(DyeColor.WHITE);
	private static final ItemStack gis = g.toItemStack();
	private static final ItemStack wis = w.toItemStack();
	
	public static void LoadInv(Player p) {
		config.saveConfig();
		config.reloadConfig();
		
		String puuid = p.getUniqueId().toString();
		
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
		if (!config.getConfig().getBoolean(puuid + ".random") && !config.getConfig().getBoolean(puuid + ".rainbow")) {
			
			String color = config.getConfig().getString(puuid + ".color");
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
		
		enabled(config.getConfig().getBoolean(puuid + ".bold"), bold);
		enabled(config.getConfig().getBoolean(puuid + ".magic"), magic);	
		enabled(config.getConfig().getBoolean(puuid + ".underline"), underline);
		enabled(config.getConfig().getBoolean(puuid + ".italic"), italic);		
		enabled(config.getConfig().getBoolean(puuid + ".strikethrough"), strike);
		enabled(config.getConfig().getBoolean(puuid + ".random"), random);	
		enabled(config.getConfig().getBoolean(puuid + ".rainbow"), rainbow);
		
		colorinv.setItem(15, bold);
		colorinv.setItem(42, magic);
		colorinv.setItem(24, underline);
		colorinv.setItem(16, italic);
		colorinv.setItem(33, strike);
		colorinv.setItem(25, random);
		colorinv.setItem(34, rainbow);
		
		p.openInventory(ChatColorsInventory.colorinv);
		
	}
	
	private static void enabled(boolean b, ItemStack i) {
		if (b) {
			i.setData(g);
			i.setDurability(gis.getDurability());
		} else {
			i.setData(w);
			i.setDurability(wis.getDurability());
		}
	}
}