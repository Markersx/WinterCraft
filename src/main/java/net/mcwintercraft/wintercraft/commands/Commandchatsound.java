package net.mcwintercraft.wintercraft.commands;

import net.ess3.api.IEssentials;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandchatsound extends ChatSoundsInventory implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sound") && sender instanceof Player) {
			Player p = (Player) sender;
			this.LoadInv(p);
			return true;
		}
		return false;
	}
}