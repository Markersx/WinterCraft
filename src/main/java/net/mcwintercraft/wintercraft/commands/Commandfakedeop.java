package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandfakedeop implements CommandExecutor {

    private final WinterCraft wc;

    public Commandfakedeop(WinterCraft wc) {
        this.wc = wc;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fakedeop")) {
			// /fakedeop <player>
			if (args.length == 1) {
				if(args[0].equalsIgnoreCase("*")) {
					for (Player op : Bukkit.getOnlinePlayers()) {
						for (Player ap : Bukkit.getOnlinePlayers()) {
							op.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: De-opped " + ap.getName() + "]");
						}
					}
					return true;
				} else {
					for(Player op : Bukkit.getOnlinePlayers()){
						op.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[Server: De-opped " + args[0] + "]");
					}
					return true;
				}
			}
		}
		return false;
	}
}