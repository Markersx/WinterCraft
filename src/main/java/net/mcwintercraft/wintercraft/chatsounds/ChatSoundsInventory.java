package net.mcwintercraft.wintercraft.chatsounds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.mcwintercraft.wintercraft.WinterCraftConfig;

public class ChatSoundsInventory {
	
	static WinterCraftConfig config = WinterCraftConfig.getConfig("chatsounds");
	
	public static Inventory soundinv = Bukkit.createInventory(null, 45, "Sound Options");
	public static Inventory catselect = Bukkit.createInventory(null, 9, "Select Category");
	public static Inventory joinsoundinv = Bukkit.createInventory(null, 54, "Join Sound");
	public static Inventory quitsoundinv = Bukkit.createInventory(null, 54, "Quit Sound");
	public static Inventory messagesoundinv = Bukkit.createInventory(null, 54, "Message Sound");
	public static Inventory blocksoundsinv = Bukkit.createInventory(null, 54, "Block Sounds");
	public static Inventory entitysoundsinv = Bukkit.createInventory(null, 54, "Entity Sounds");
	public static Inventory itemsoundsinv = Bukkit.createInventory(null, 54, "Item Sounds");
	public static Inventory musicsoundsinv = Bukkit.createInventory(null, 54, "Music Sounds");
	public static Inventory recordsoundsinv = Bukkit.createInventory(null, 54, "Record Sounds");
	public static Inventory weathersoundsinv = Bukkit.createInventory(null, 54, "Weather Sounds");
	public static Inventory ambientsoundsinv = Bukkit.createInventory(null, 54, "Ambient Sounds");
	public static Inventory uisoundsinv = Bukkit.createInventory(null, 54, "UI Sounds");
	
	static ItemStack reset_item = new ItemStack(Material.TNT);
	static ItemStack blocksounds_item = new ItemStack(Material.RECORD_8);
	static ItemStack entitysounds_item = new ItemStack(Material.RECORD_9);
	static ItemStack itemsounds_item = new ItemStack(Material.RECORD_4);
	static ItemStack musicsounds_item = new ItemStack(Material.GOLD_RECORD);
	static ItemStack recordsounds_item = new ItemStack(Material.RECORD_5);
	static ItemStack weathersounds_item = new ItemStack(Material.RECORD_12);
	static ItemStack ambientsounds_item = new ItemStack(Material.RECORD_6);
	static ItemStack ambientcave_item = new ItemStack(Material.STONE);
	static ItemStack uisounds_item = new ItemStack(Material.RECORD_3);
	static ItemStack backbutton_item = new ItemStack(Material.STONE_BUTTON);

	public static void LoadInv(Player p, String uuid) {
		
		int playerjoinenablera = config.getConfig().getInt(p.getName() + ".playerjoin.enabled");
		int playerjoinvolumea = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playerjoin.volume")) * 10);
		int playerjoinpitcha = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playerjoin.pitch")) * 10);
		int playerquitenablera = config.getConfig().getInt(p.getName() + ".playerquit.enabled");
		int playerquitvolumea = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playerquit.volume")) * 10);
		int playerquitpitcha = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playerquit.pitch")) * 10);
		int playermessageenablera = config.getConfig().getInt(p.getName() + ".playermessage.enabled");
		int playermessagevolumea = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playermessage.volume")) * 10);
		int playermessagepitcha = (int) (Float.parseFloat(config.getConfig().getString(p.getName() + ".playermessage.pitch")) * 10);
		
		ItemStack playerjoin_item = new ItemStack(Material.SPONGE);
		ItemStack playerjoinenabler_item = new ItemStack(Material.WOOL, 1,(byte) playerjoinenablera);
		ItemStack playerjoinvolume_item = new ItemStack(Material.WOOL, playerjoinvolumea);
		ItemStack playerjoinpitch_item = new ItemStack(Material.WOOL, playerjoinpitcha);
		ItemStack playerquit_item = new ItemStack(Material.SPONGE);
		ItemStack playerquitenabler_item = new ItemStack(Material.WOOL, 1, (byte) playerquitenablera);
		ItemStack playerquitvolume_item = new ItemStack(Material.WOOL, playerquitvolumea);
		ItemStack playerquitpitch_item = new ItemStack(Material.WOOL, playerquitpitcha);
		ItemStack playermessage_item = new ItemStack(Material.SPONGE);
		ItemStack playermessageenabler_item = new ItemStack(Material.WOOL, 1, (byte) playermessageenablera);
		ItemStack playermessagevolume_item = new ItemStack(Material.WOOL, playermessagevolumea);
		ItemStack playermessagepitch_item = new ItemStack(Material.WOOL, playermessagepitcha);
		
		blocksoundsinv.setItem(53, backbutton_item);
		entitysoundsinv.setItem(53, backbutton_item);
		itemsoundsinv.setItem(53, backbutton_item);
		musicsoundsinv.setItem(53, backbutton_item);
		recordsoundsinv.setItem(53, backbutton_item);
		weathersoundsinv.setItem(53, backbutton_item);
		ambientsoundsinv.setItem(53, backbutton_item);
		ambientsoundsinv.setItem(0, ambientcave_item);
		uisoundsinv.setItem(53, backbutton_item);
		
		ArrayList<String> playerjoin_lore = new ArrayList<String>();
		ArrayList<String> playerjoinenabler_lore = new ArrayList<String>();
		ArrayList<String> playerjoinvolume_lore = new ArrayList<String>();
		ArrayList<String> playerjoinpitch_lore = new ArrayList<String>();
		ArrayList<String> playerquit_lore = new ArrayList<String>();
		ArrayList<String> playerquitenabler_lore = new ArrayList<String>();
		ArrayList<String> playerquitvolume_lore = new ArrayList<String>();
		ArrayList<String> playerquitpitch_lore = new ArrayList<String>();
		ArrayList<String> playermessage_lore = new ArrayList<String>();
		ArrayList<String> playermessageenabler_lore = new ArrayList<String>();
		ArrayList<String> playermessagevolume_lore = new ArrayList<String>();
		ArrayList<String> playermessagepitch_lore = new ArrayList<String>();
		ArrayList<String> reset_lore = new ArrayList<String>();
		ArrayList<String> blocksounds_lore = new ArrayList<String>();
		ArrayList<String> entitysounds_lore = new ArrayList<String>();
		ArrayList<String> itemsounds_lore = new ArrayList<String>();
		ArrayList<String> musicsounds_lore = new ArrayList<String>();
		ArrayList<String> recordsounds_lore = new ArrayList<String>();
		ArrayList<String> weathersounds_lore = new ArrayList<String>();
		ArrayList<String> ambientsounds_lore = new ArrayList<String>();
		ArrayList<String> uisounds_lore = new ArrayList<String>();
		ArrayList<String> backbutton_lore = new ArrayList<String>();
		ArrayList<String> ambientcave_lore = new ArrayList<String>();
		
		playerjoin_lore.add(ChatColor.BLUE + "Sound played");
		playerjoin_lore.add(ChatColor.BLUE + "when player joins");
		
		
		//FIX
		playerjoinenabler_lore.add(ChatColor.BLUE + "Click to Disable");
		playerjoinenabler_lore.add(ChatColor.BLUE + "the join sounds");
		
		playerquitenabler_lore.add(ChatColor.BLUE + "Click to Disable");
		playerquitenabler_lore.add(ChatColor.BLUE + "the quit sounds");
		
		playerjoinvolume_lore.add(ChatColor.BLUE + "Left click +1");
		playerjoinvolume_lore.add(ChatColor.BLUE + "Right click -1");
		
		playerquit_lore.add(ChatColor.BLUE + "Sound played");
		playerquit_lore.add(ChatColor.BLUE + "when player quits");
		
		
		
		playermessage_lore.add(ChatColor.BLUE + "Sound played");
		playermessage_lore.add(ChatColor.BLUE + "when player messages");
		
		playermessageenabler_lore.add(ChatColor.BLUE + "Click to Disable");
		playermessageenabler_lore.add(ChatColor.BLUE + "the message sounds");
		
		reset_lore.add(ChatColor.RED + "click to");
		reset_lore.add(ChatColor.RED + "reset settings");
		
		uisounds_lore.add(ChatColor.BLUE + "click to view");
		uisounds_lore.add(ChatColor.BLUE + "all sounds");
		
		ambientcave_lore.add(ChatColor.BLUE + "Left click to select");
		ambientcave_lore.add(ChatColor.BLUE + "Right click to listen");
		
		
		ItemMeta playerjoin_meta = playerjoin_item.getItemMeta();
		ItemMeta playerjoinenabler_meta = playerjoinenabler_item.getItemMeta();
		ItemMeta playerjoinvolume_meta = playerjoinvolume_item.getItemMeta();
		ItemMeta playerjoinpitch_meta = playerjoinpitch_item.getItemMeta();
		ItemMeta playerquit_meta = playerquit_item.getItemMeta();
		ItemMeta playerquitenabler_meta = playerquitenabler_item.getItemMeta();
		ItemMeta playerquitvolume_meta = playerquitvolume_item.getItemMeta();
		ItemMeta playerquitpitch_meta = playerquitpitch_item.getItemMeta();
		ItemMeta playermessage_meta = playermessage_item.getItemMeta();
		ItemMeta playermessageenabler_meta = playermessageenabler_item.getItemMeta();
		ItemMeta playermessagevolume_meta = playermessagevolume_item.getItemMeta();
		ItemMeta playermessagepitch_meta = playermessagepitch_item.getItemMeta();
		ItemMeta reset_meta = reset_item.getItemMeta();
		ItemMeta blocksounds_meta = blocksounds_item.getItemMeta();
		ItemMeta entitysounds_meta = entitysounds_item.getItemMeta();
		ItemMeta itemsounds_meta = itemsounds_item.getItemMeta();
		ItemMeta musicsounds_meta = musicsounds_item.getItemMeta();
		ItemMeta recordsounds_meta = recordsounds_item.getItemMeta();
		ItemMeta weathersounds_meta = weathersounds_item.getItemMeta();
		ItemMeta ambientsounds_meta = ambientsounds_item.getItemMeta();
		ItemMeta uisounds_meta = uisounds_item.getItemMeta();
		ItemMeta backbutton_meta = backbutton_item.getItemMeta();
		ItemMeta ambientcave_meta = ambientcave_item.getItemMeta();
		
		playerjoin_meta.setDisplayName(ChatColor.AQUA + "Player Join Sound");
		playerjoinenabler_meta.setDisplayName(ChatColor.GREEN + "Enabled");
		playerjoinvolume_meta.setDisplayName(ChatColor.AQUA + "Player Join Volume");
		playerjoinpitch_meta.setDisplayName(ChatColor.AQUA + "Player Join Pitch");
		playerquit_meta.setDisplayName(ChatColor.AQUA + "Player Quit Sound");
		playerquitenabler_meta.setDisplayName(ChatColor.GREEN + "Enabled");
		playerquitvolume_meta.setDisplayName(ChatColor.AQUA + "Player Quit Volume");
		playerquitpitch_meta.setDisplayName(ChatColor.AQUA + "Player Quit Pitch");
		playermessage_meta.setDisplayName(ChatColor.AQUA + "Player Message Sound");
		playermessageenabler_meta.setDisplayName(ChatColor.GREEN + "Enabled");
		playermessagevolume_meta.setDisplayName(ChatColor.AQUA + "Player Message Volume");
		playermessagepitch_meta.setDisplayName(ChatColor.AQUA + "Player Message Pitch");
		reset_meta.setDisplayName(ChatColor.RED + "Reset");
		blocksounds_meta.setDisplayName(ChatColor.AQUA + "Block Sounds");
		entitysounds_meta.setDisplayName(ChatColor.AQUA + "Entity Sounds");
		itemsounds_meta.setDisplayName(ChatColor.AQUA + "Item Sounds");
		musicsounds_meta.setDisplayName(ChatColor.AQUA + "Music Sounds");
		recordsounds_meta.setDisplayName(ChatColor.AQUA + "Record Sounds");
		weathersounds_meta.setDisplayName(ChatColor.AQUA + "Weather Sounds");
		ambientsounds_meta.setDisplayName(ChatColor.AQUA + "Ambient Sounds");
		uisounds_meta.setDisplayName(ChatColor.AQUA + "UI Sounds");
		backbutton_meta.setDisplayName(ChatColor.RED + "Click to go back");
		ambientcave_meta.setDisplayName(ChatColor.AQUA + "Cave");
		
		playerjoin_meta.setLore(playerjoin_lore);
		playerjoinenabler_meta.setLore(playerjoinenabler_lore);
		playerjoinvolume_meta.setLore(playerjoinvolume_lore);
		playerjoinpitch_meta.setLore(playerjoinpitch_lore);
		playerquit_meta.setLore(playerquit_lore);
		playerquitenabler_meta.setLore(playerquitenabler_lore);
		playerquitvolume_meta.setLore(playerquitvolume_lore);
		playerquitpitch_meta.setLore(playerquitpitch_lore);
		playermessage_meta.setLore(playermessage_lore);
		playerquitpitch_meta.setLore(playerquitpitch_lore);
		playermessageenabler_meta.setLore(playermessageenabler_lore);
		playermessagevolume_meta.setLore(playermessagevolume_lore);
		playermessagepitch_meta.setLore(playermessagepitch_lore);
		reset_meta.setLore(reset_lore);
		itemsounds_meta.setLore(itemsounds_lore);
		blocksounds_meta.setLore(blocksounds_lore);
		entitysounds_meta.setLore(entitysounds_lore);
		musicsounds_meta.setLore(musicsounds_lore);
		recordsounds_meta.setLore(recordsounds_lore);
		weathersounds_meta.setLore(weathersounds_lore);
		ambientsounds_meta.setLore(ambientsounds_lore);
		uisounds_meta.setLore(uisounds_lore);
		backbutton_meta.setLore(backbutton_lore);
		ambientcave_meta.setLore(ambientcave_lore);
		
		playerjoin_item.setItemMeta(playerjoin_meta);
		playerjoinenabler_item.setItemMeta(playerjoinenabler_meta);
		playerjoinvolume_item.setItemMeta(playerjoinvolume_meta);
		playerjoinpitch_item.setItemMeta(playerjoinpitch_meta);
		playerquit_item.setItemMeta(playerquit_meta);
		playerquitenabler_item.setItemMeta(playerquitenabler_meta);
		playerquitvolume_item.setItemMeta(playerquitvolume_meta);
		playerquitpitch_item.setItemMeta(playerquitpitch_meta);
		playermessage_item.setItemMeta(playermessage_meta);
		playermessageenabler_item.setItemMeta(playermessageenabler_meta);
		playermessagevolume_item.setItemMeta(playermessagevolume_meta);
		playermessagepitch_item.setItemMeta(playermessagepitch_meta);
		
		reset_item.setItemMeta(reset_meta);
		blocksounds_item.setItemMeta(blocksounds_meta);
		entitysounds_item.setItemMeta(entitysounds_meta);
		itemsounds_item.setItemMeta(itemsounds_meta);
		musicsounds_item.setItemMeta(musicsounds_meta);
		recordsounds_item.setItemMeta(recordsounds_meta);
		weathersounds_item.setItemMeta(weathersounds_meta);
		ambientsounds_item.setItemMeta(ambientsounds_meta);
		uisounds_item.setItemMeta(uisounds_meta);
		backbutton_item.setItemMeta(backbutton_meta);
		ambientcave_item.setItemMeta(ambientcave_meta);
		
		soundinv.setItem(11, playerjoin_item); 
		soundinv.setItem(12, playerjoinenabler_item);
		soundinv.setItem(14, playerjoinvolume_item); 
		soundinv.setItem(15, playerjoinpitch_item);
		soundinv.setItem(20, playerquit_item); 
		soundinv.setItem(21, playerquitenabler_item);
		soundinv.setItem(23, playerquitvolume_item); 
		soundinv.setItem(24, playerquitpitch_item);
		soundinv.setItem(29, playermessage_item); 
		soundinv.setItem(30, playermessageenabler_item);
		soundinv.setItem(32, playermessagevolume_item); 
		soundinv.setItem(33, playermessagepitch_item);
		soundinv.setItem(44, reset_item);
		
		catselect.setItem(0, blocksounds_item);
		catselect.setItem(1, entitysounds_item);
		catselect.setItem(2, itemsounds_item);
		catselect.setItem(3, musicsounds_item);
		catselect.setItem(4, recordsounds_item);
		catselect.setItem(5, weathersounds_item);
		catselect.setItem(6, ambientsounds_item);
		catselect.setItem(7, uisounds_item);
		catselect.setItem(8, backbutton_item);
	}
}
