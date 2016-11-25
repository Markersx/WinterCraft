package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandwebsite implements CommandExecutor {

    private final WinterCraft wc;

    public Commandwebsite(WinterCraft wc) {
        this.wc = wc;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("website") && sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.AQUA + "http://www.mcwintercraft.net");
			return true;
		}
		return false;
	}
}