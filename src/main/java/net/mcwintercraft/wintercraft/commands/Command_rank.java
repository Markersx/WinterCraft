package net.mcwintercraft.wintercraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Command_rank implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rank") && sender instanceof Player) {
			Player player = (Player) sender;
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			Bukkit.getServer().dispatchCommand(console, "tellraw " + player.getName() + " [\"\",{\"text\":\"- DONOR RANKS -\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://www.mcwintercraft.net/shop\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"Donor ranks can be\nbought at the website\nClick to visit the shop\"}},{\"text\":\"\\n[SQUIRREL]\\n\",\"bold\":true},{\"text\":\"[PENGUIN]\",\"bold\":true,\"color\":\"gray\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[DOE]\",\"bold\":true,\"color\":\"light_purple\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[BUCK]\",\"bold\":true,\"color\":\"blue\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[WOLF]\",\"bold\":true,\"color\":\"dark_gray\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[FOX]\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[BEAR]\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[OWL]\",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[EAGLE]\",\"bold\":true,\"color\":\"red\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"- SPECIAL RANKS -\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://www.mcwintercraft.net/apply\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"Special ranks canbe gained by applyingClick to apply\"}},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[YT]\",\"bold\":true,\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"- Spectator mode\"}},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[MOD]\",\"bold\":true,\"color\":\"green\"},{\"text\":\"\\n\",\"bold\":true},{\"text\":\"[ADMIN]\",\"bold\":true,\"color\":\"dark_aqua\"}]");
			return true;
		}
		return false;
	}
}