package net.mcwintercraft.wintercraft.commands;

import mkremins.fanciful.FancyMessage;
import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandplaytime implements CommandExecutor {
    private final WinterCraft wc;

    public Commandplaytime(WinterCraft wc) {
        this.wc = wc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            switch (args.length) {
                case 0:
                    Player p = (Player) sender;
                    getPlayTime(p);
                    return true;
                case 1:
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target != null) {
                        getPlayTime(target);
                        return true;
                    }
            }
        }
        return false;
    }

    private void getPlayTime(Player player) {
        //TODO: FINISH
        UserData u = new UserData(player, wc);
        FancyMessage m = new FancyMessage(" ====== " + player.getName() + " ====== \n");
        m.then(" - Total: " + u.getTotalTime());
        m.color(ChatColor.AQUA);
        m.style(ChatColor.BOLD);
        m.then(" - Active: " + u.getActiveTime() + "\n");
        m.color(ChatColor.AQUA);
        m.style(ChatColor.BOLD);
        m.then(" - AFK: " + u.getAFKTime());
        m.color(ChatColor.AQUA);
        m.style(ChatColor.BOLD);
        m.send(player);
    }
}
