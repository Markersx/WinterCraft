package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Command_mywarp implements CommandExecutor {
	
	private final WinterCraftConfig config = WinterCraftConfig.getConfig("playerwarps");

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mywarp") && sender instanceof Player) {
			Player p = (Player) sender;
			String puuid = p.getUniqueId().toString();
			this.config.reloadConfig();
			int warpsr = this.config.getConfig().getInt(puuid + ".warpsremaining");
			List<String> warps = this.config.getConfig().getStringList(puuid + ".warps");
			if (warps.size() == 0) {
				p.sendMessage(ChatColor.AQUA + "You don\'t have any warps set!");
				return true;
			} else {
				p.sendMessage(ChatColor.AQUA + "YourWarps: " + ChatColor.WHITE
						+ warps.toString().replace("[", "").replace("]", ""));
				if (warpsr > 1 || warpsr < 1) {
					p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
							+ " warps remaining!");
				}

				if (warpsr == 1) {
					p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
							+ " warp remaining!");
				}

				return true;
			}
		} else {
			return false;
		}
	}
}