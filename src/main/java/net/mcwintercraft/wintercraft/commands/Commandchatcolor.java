package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.chatcolors.ChatColorsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandchatcolor extends ChatColorsInventory implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("color") && sender instanceof Player) {
			
			Player p = (Player) sender;
            this.setUser(p);

			if (args.length == 0) {
                this.LoadInv(p);
				return true;
			}
			
			if (args.length == 2) {
				String c = args[0];
				boolean b;
				if (c.equalsIgnoreCase("&0") || c.equalsIgnoreCase("black")) {
					this.setChatColor("BLACK");
					return true;
				}
				if (c.equalsIgnoreCase("&1") || c.equalsIgnoreCase("darkblue")) {
                    this.setChatColor("DARK_BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&2") || c.equalsIgnoreCase("darkgreen")) {
                    this.setChatColor("DARK_GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&3") || c.equalsIgnoreCase("darkaqua")) {
					this.setChatColor("DARK_AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&4") || c.equalsIgnoreCase("darkred")) {
					this.setChatColor("DARK_RED");
					return true;
				}
				if (c.equalsIgnoreCase("&5") || c.equalsIgnoreCase("darkpurple")) {
					this.setChatColor("DARK_PURPLE");
					return true;
				}
				if (c.equalsIgnoreCase("&6") || c.equalsIgnoreCase("gold")) {
					this.setChatColor("GOLD");
					return true;
				}
				if (c.equalsIgnoreCase("&7") || c.equalsIgnoreCase("gray")) {
					this.setChatColor("GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&8") || c.equalsIgnoreCase("darkgray")) {
					this.setChatColor("DARK_GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&9") || c.equalsIgnoreCase("blue")) {
					this.setChatColor("BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&a") || c.equalsIgnoreCase("green")) {
					this.setChatColor("GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&b") || c.equalsIgnoreCase("aqua")) {
					this.setChatColor("AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&c") || c.equalsIgnoreCase("red")) {
					this.setChatColor("RED");
					return true;
				}
				if (c.equalsIgnoreCase("&d") || c.equalsIgnoreCase("lightpurple")) {
					this.setChatColor("LIGHT_PURPLE");
					return true;
				}
				if ( c.equalsIgnoreCase("&e") || c.equalsIgnoreCase("yellow")) {
					this.setChatColor("YELLOW");
					return true;
				}
				if (c.equalsIgnoreCase("&f") || c.equalsIgnoreCase("white")) {
					this.setChatColor("WHITE");
					return true;
				}
				if (c.equalsIgnoreCase("&k") || c.equalsIgnoreCase("magic")) {
					b = this.isChatColorMagic();
                    this.setChatColorStyle("magic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&l") || c.equalsIgnoreCase("bold")) {
					b = this.isChatColorBold();
					this.setChatColorStyle("bold", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&m") || c.equalsIgnoreCase("strike")) {
					b = this.isChatColorStrike();
					this.setChatColorStyle("strike", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&n") || c.equalsIgnoreCase("underline")) {
					b = this.isChatColorUnderline();
					this.setChatColorStyle("underline", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&o") || c.equalsIgnoreCase("italic")) {
					b = this.isChatColorItalic();
					this.setChatColorStyle("italic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("rainbow")) {
					b = this.isChatColorRainbow();
					this.setChatColorStyle("rainbow", !b);
					return true;
				}
				if (c.equalsIgnoreCase("random") || c.equalsIgnoreCase("rand")) {
					b = this.isChatColorRandom();
					this.setChatColorStyle("random", !b);
					return true;
				}
			}
		}
		return false;
	}
}