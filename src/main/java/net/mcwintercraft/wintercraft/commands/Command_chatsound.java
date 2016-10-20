package net.mcwintercraft.wintercraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsInventory;

public class Command_chatsound implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sound") && sender instanceof Player) {
			Player p = (Player) sender;
			String uuid = p.getUniqueId().toString();
			ChatSoundsInventory.LoadInv(p, uuid);
			return true;
		}
		return false;
	}
}