package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMarry implements CommandExecutor {

    private final WinterCraft wc;

    public CommandMarry(WinterCraft wc) {
        this.wc = wc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("marry") && sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                Player target = (Bukkit.getServer().getPlayer(args[0]));
                if (target != null) {
                    p.sendMessage("You have just married " + args[0]);
                    target.sendMessage(p.getDisplayName() + " Has just married you");
                    return true;
                } else {
                    p.sendMessage(args[0] + " Is not online");
                    return true;
                }
            }
        }
        return false;
    }
}
