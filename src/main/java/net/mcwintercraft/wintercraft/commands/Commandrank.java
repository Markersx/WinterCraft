package net.mcwintercraft.wintercraft.commands;

import mkremins.fanciful.FancyMessage;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandrank implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rank") && sender instanceof Player) {
			Player p = (Player) sender;

			FancyMessage fm = new FancyMessage("- DONOR RANKS -\n");
			fm.color(ChatColor.GREEN);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Donor Ranks can be\n" + 
					ChatColor.BOLD + "bought at the shop\n" + 
					ChatColor.BOLD + "click to visit");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[SQUIRREL]\n");
			fm.color(ChatColor.WHITE);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 1\n" + 
					ChatColor.BOLD + "Homes: 1\n" + 
					ChatColor.BOLD + "Warps: 1");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[PENGUIN]\n");
			fm.color(ChatColor.GRAY);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "- Nickname\n" + 
					ChatColor.BOLD + "- Hat\n" + 
					ChatColor.BOLD + "- Colors\n" +
					ChatColor.BOLD + "Chests: 2\n" + 
					ChatColor.BOLD + "Homes: 2\n" + 
					ChatColor.BOLD + "Warps: 2");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[DOE]\n");
			fm.color(ChatColor.LIGHT_PURPLE);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 3\n" + 
					ChatColor.BOLD + "Homes: 3\n" + 
					ChatColor.BOLD + "Warps: 3");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[BUCK]\n");
			fm.color(ChatColor.BLUE);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 4\n" + 
					ChatColor.BOLD + "Homes: 4\n" + 
					ChatColor.BOLD + "Warps: 4");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[WOLF]\n");
			fm.color(ChatColor.DARK_GRAY);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 5\n" + 
					ChatColor.BOLD + "Homes: 5\n" + 
					ChatColor.BOLD + "Warps: 5");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[FOX]\n");
			fm.color(ChatColor.YELLOW);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 6\n" + 
					ChatColor.BOLD + "Homes: 6\n" + 
					ChatColor.BOLD + "Warps: 6");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[BEAR]\n");
			fm.color(ChatColor.GOLD);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 7\n" + 
					ChatColor.BOLD + "Homes: 7\n" + 
					ChatColor.BOLD + "Warps: 7");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[OWL]\n");
			fm.color(ChatColor.AQUA);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 8\n" + 
					ChatColor.BOLD + "Homes: 8\n" + 
					ChatColor.BOLD + "Warps: 8");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("[EAGLE]\n");
			fm.color(ChatColor.RED);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Chests: 9\n" + 
					ChatColor.BOLD + "Homes: 9\n" + 
					ChatColor.BOLD + "Warps: 9");
			fm.link("http://www.mcwintercraft.net/shop");
			
			fm.then("- SPECIAL RANKS -\n");
			fm.color(ChatColor.GREEN);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "Special Ranks can be\n" + 
					ChatColor.BOLD + "obtained by applying\n" + 
					ChatColor.BOLD + "click to apply");
			fm.link("http://www.mcwintercraft.net/apply");
			
			fm.then("[YT]\n");
			fm.color(ChatColor.RED);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "- Spectate");
			fm.link("http://www.mcwintercraft.net/apply");
			
			fm.then("[MOD]\n");
			fm.color(ChatColor.GREEN);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "- Mute\n" + 
					ChatColor.BOLD + "- Jail\n" + 
					ChatColor.BOLD + "- Kick\n" +
					ChatColor.BOLD + "- Spectate");
			fm.link("http://www.mcwintercraft.net/apply");
			
			fm.then("[ADMIN]");
			fm.color(ChatColor.RED);
			fm.style(ChatColor.BOLD);
			fm.tooltip(ChatColor.BOLD + "- Teleport\n" + 
					ChatColor.BOLD + "- Ban Hammer\n" + 
					ChatColor.BOLD + "- Vanish");
			fm.link("http://www.mcwintercraft.net/apply");

            fm.then("- CURRENT RANK -");
            fm.color(ChatColor.GREEN);
            fm.style(ChatColor.BOLD);
            fm.then(WinterCraft.ess.getUser(p).getGroup().toUpperCase());
            fm.style(ChatColor.BOLD);

			fm.send(p);
			return true;
		} else {
			sender.sendMessage("Lol no");
			return true;
		}
	}
}