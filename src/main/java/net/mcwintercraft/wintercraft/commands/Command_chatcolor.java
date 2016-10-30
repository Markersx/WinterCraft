package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_chatcolor implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("color") && sender instanceof Player) {
			
			Player p = (Player) sender;
			String puuid = p.getUniqueId().toString();
			WinterCraftConfig config = WinterCraftConfig.getConfig("chatsounds");
			
			if (args.length == 0) {				
				ChatColorsInventory.LoadInv(p);
				return true;
			}
			
			if (args.length == 2) {
				String c = args[0];
				boolean b;
				if (c.equalsIgnoreCase("&0") || c.equalsIgnoreCase("black")) {
					config.getConfig().set(puuid + ".color", "BLACK");
					return true;
				}
				if (c.equalsIgnoreCase("&1") || c.equalsIgnoreCase("darkblue")) {
					config.getConfig().set(puuid + ".color", "DARK_BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&2") || c.equalsIgnoreCase("darkgreen")) {
					config.getConfig().set(puuid + ".color", "DARK_GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&3") || c.equalsIgnoreCase("darkaqua")) {
					config.getConfig().set(puuid + ".color", "DARK_AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&4") || c.equalsIgnoreCase("darkred")) {
					config.getConfig().set(puuid + ".color", "DARK_RED");
					return true;
				}
				if (c.equalsIgnoreCase("&5") || c.equalsIgnoreCase("darkpurple")) {
					config.getConfig().set(puuid + ".color", "DARK_PURPLE");
					return true;
				}
				if (c.equalsIgnoreCase("&6") || c.equalsIgnoreCase("gold")) {
					config.getConfig().set(puuid + ".color", "GOLD");
					return true;
				}
				if (c.equalsIgnoreCase("&7") || c.equalsIgnoreCase("gray")) {
					config.getConfig().set(puuid + ".color", "GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&8") || c.equalsIgnoreCase("darkgray")) {
					config.getConfig().set(puuid + ".color", "DARK_GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&9") || c.equalsIgnoreCase("blue")) {
					config.getConfig().set(puuid + ".color", "BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&a") || c.equalsIgnoreCase("green")) {
					config.getConfig().set(puuid + ".color", "GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&b") || c.equalsIgnoreCase("aqua")) {
					config.getConfig().set(puuid + ".color", "AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&c") || c.equalsIgnoreCase("red")) {
					config.getConfig().set(puuid + ".color", "RED");
					return true;
				}
				if (c.equalsIgnoreCase("&d") || c.equalsIgnoreCase("lightpurple")) {
					config.getConfig().set(puuid + ".color", "LIGHT_PURPLE");
					return true;
				}
				if ( c.equalsIgnoreCase("&e") || c.equalsIgnoreCase("yellow")) {
					config.getConfig().set(puuid + ".color", "YELLOW");
					return true;
				}
				if (c.equalsIgnoreCase("&f") || c.equalsIgnoreCase("white")) {
					config.getConfig().set(puuid + ".color", "WHITE");
					return true;
				}
				if (c.equalsIgnoreCase("&k") || c.equalsIgnoreCase("magic")) {
					b = config.getConfig().getBoolean(puuid + ".magic");
					config.getConfig().set(puuid + ".magic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&l") || c.equalsIgnoreCase("bold")) {
					b = config.getConfig().getBoolean(puuid + ".bold");
					config.getConfig().set(puuid + ".bold", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&m") || c.equalsIgnoreCase("strike")) {
					b = config.getConfig().getBoolean(puuid + ".strike");
					config.getConfig().set(puuid + ".strike", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&n") || c.equalsIgnoreCase("underline")) {
					b = config.getConfig().getBoolean(puuid + ".underline");
					config.getConfig().set(puuid + ".underline", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&o") || c.equalsIgnoreCase("italic")) {
					b = config.getConfig().getBoolean(puuid + ".italic");
					config.getConfig().set(puuid + ".italic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("rainbow")) {
					b = config.getConfig().getBoolean(puuid + ".rainbow");
					config.getConfig().set(puuid + ".rainbow", !b);
					return true;
				}
				if (c.equalsIgnoreCase("random") || c.equalsIgnoreCase("rand")) {
					b = config.getConfig().getBoolean(puuid + ".random");
					config.getConfig().set(puuid + ".random", !b);
					return true;
				}
			}
		}
		return false;
	}
}