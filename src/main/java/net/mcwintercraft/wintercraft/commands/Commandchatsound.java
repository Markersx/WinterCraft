package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandchatsound implements CommandExecutor {

    private final WinterCraft wc;

    public Commandchatsound(WinterCraft wc) {
        this.wc = wc;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sound") && sender instanceof Player) {
			Player p = (Player) sender;
            ChatSoundsInventory csinv = new ChatSoundsInventory(wc);
			csinv.loadInventory(p);
			return true;
		}
		return false;
	}
}