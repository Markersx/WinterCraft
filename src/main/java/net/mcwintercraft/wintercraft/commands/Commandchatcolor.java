package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandchatcolor implements CommandExecutor {

    private final WinterCraft wc;

    public Commandchatcolor(WinterCraft wc) {
        this.wc = wc;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("color") && sender instanceof Player) {
			
			Player p = (Player) sender;
            UserData user = new UserData(p, wc);
            if (args.length == 0) {
                ChatColorsInventory ccinv = new ChatColorsInventory(wc);
                ccinv.LoadInv(p);
				return true;
			}
			
			if (args.length == 2) {
				String c = args[0];
				boolean b;
                //TODO: FOR LOOP
				if (c.equalsIgnoreCase("&0") || c.equalsIgnoreCase("black")) {
					user.setChatColor("BLACK");
					return true;
				}
				if (c.equalsIgnoreCase("&1") || c.equalsIgnoreCase("darkblue")) {
                    user.setChatColor("DARK_BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&2") || c.equalsIgnoreCase("darkgreen")) {
                    user.setChatColor("DARK_GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&3") || c.equalsIgnoreCase("darkaqua")) {
                    user.setChatColor("DARK_AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&4") || c.equalsIgnoreCase("darkred")) {
                    user.setChatColor("DARK_RED");
					return true;
				}
				if (c.equalsIgnoreCase("&5") || c.equalsIgnoreCase("darkpurple")) {
                    user.setChatColor("DARK_PURPLE");
					return true;
				}
				if (c.equalsIgnoreCase("&6") || c.equalsIgnoreCase("gold")) {
                    user.setChatColor("GOLD");
					return true;
				}
				if (c.equalsIgnoreCase("&7") || c.equalsIgnoreCase("gray")) {
                    user.setChatColor("GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&8") || c.equalsIgnoreCase("darkgray")) {
                    user.setChatColor("DARK_GRAY");
					return true;
				}
				if (c.equalsIgnoreCase("&9") || c.equalsIgnoreCase("blue")) {
                    user.setChatColor("BLUE");
					return true;
				}
				if (c.equalsIgnoreCase("&a") || c.equalsIgnoreCase("green")) {
                    user.setChatColor("GREEN");
					return true;
				}
				if (c.equalsIgnoreCase("&b") || c.equalsIgnoreCase("aqua")) {
                    user.setChatColor("AQUA");
					return true;
				}
				if (c.equalsIgnoreCase("&c") || c.equalsIgnoreCase("red")) {
                    user.setChatColor("RED");
					return true;
				}
				if (c.equalsIgnoreCase("&d") || c.equalsIgnoreCase("lightpurple")) {
                    user.setChatColor("LIGHT_PURPLE");
					return true;
				}
				if ( c.equalsIgnoreCase("&e") || c.equalsIgnoreCase("yellow")) {
                    user.setChatColor("YELLOW");
					return true;
				}
				if (c.equalsIgnoreCase("&f") || c.equalsIgnoreCase("white")) {
                    user.setChatColor("WHITE");
					return true;
				}
				if (c.equalsIgnoreCase("&k") || c.equalsIgnoreCase("magic")) {
					b = user.isChatColorMagic();
                    user.setChatColorStyle("magic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&l") || c.equalsIgnoreCase("bold")) {
					b = user.isChatColorBold();
                    user.setChatColorStyle("bold", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&m") || c.equalsIgnoreCase("strike")) {
					b = user.isChatColorStrike();
                    user.setChatColorStyle("strike", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&n") || c.equalsIgnoreCase("underline")) {
					b = user.isChatColorUnderline();
                    user.setChatColorStyle("underline", !b);
					return true;
				}
				if (c.equalsIgnoreCase("&o") || c.equalsIgnoreCase("italic")) {
					b = user.isChatColorItalic();
                    user.setChatColorStyle("italic", !b);
					return true;
				}
				if (c.equalsIgnoreCase("rainbow")) {
					b = user.isChatColorRainbow();
                    user.setChatColorStyle("rainbow", !b);
					return true;
				}
				if (c.equalsIgnoreCase("random") || c.equalsIgnoreCase("rand")) {
					b = user.isChatColorRandom();
                    user.setChatColorStyle("random", !b);
					return true;
				}
			}
		}
		return false;
	}
}