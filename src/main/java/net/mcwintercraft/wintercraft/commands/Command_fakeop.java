package net.mcwintercraft.wintercraft.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_fakeop implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fakeop")) {
			// /fakeop <player>
			if (args.length == 1) {
				if(args[0].equalsIgnoreCase("*")) {
					for (Player op : Bukkit.getOnlinePlayers()) {
						for (Player ap : Bukkit.getOnlinePlayers()) {
							op.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: Opped " + ap.getName() + "]");
						}
					}
					return true;
				} else {
					for(Player op : Bukkit.getOnlinePlayers()){
						op.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: Opped " + args[0] + "]");
					}
					return true;
				}
			}
		}
		return false;
	}
}