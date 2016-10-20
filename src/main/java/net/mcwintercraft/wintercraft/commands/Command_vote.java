package net.mcwintercraft.wintercraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_vote implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("vote") && sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.AQUA + "MinecraftForum" + "http://www.minecraftforum.net/servers/10081-wintercraft/vote");
			player.sendMessage(ChatColor.AQUA + "MineList" + "http://minelist.net/vote/1435");
			player.sendMessage(ChatColor.AQUA + "MineStatus" + "https://www.minestatus.net/149280-wintercraft");
			player.sendMessage(ChatColor.AQUA + "TopOG" + "http://topg.org/Minecraft/in-442629");
			player.sendMessage(ChatColor.AQUA + "MinecraftServerFinder" + "http://www.minecraftserverfinder.com/vote.php?id=13163");
			player.sendMessage(ChatColor.AQUA + "MinecraftList" + "https://minecraftlist.org/vote/3718");
			player.sendMessage(ChatColor.AQUA + "ServerPact" + "http://www.serverpact.com/vote-34635");
			player.sendMessage(ChatColor.AQUA + "PlanetMinecraft" + "http://www.planetminecraft.com/server/wintercraft-3795381/vote/");
			player.sendMessage(ChatColor.AQUA + "MinecraftMP" + "http://minecraft-mp.com/server/132996/vote/");
			player.sendMessage(ChatColor.AQUA + "MineTrack" + "http://www.minetrack.net/vote/12677/");
			return true;
		}
		return false;
	}
}
