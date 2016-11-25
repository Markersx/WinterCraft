package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.misc.SpecLoad;
import net.mcwintercraft.wintercraft.misc.SpecLocData;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSL implements CommandExecutor {

    private SpecLoad sl;

    public CommandSL(SpecLoad sl) {
        this.sl = sl;
    }

    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {

        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player)commandSender;

        sl.getLox().putIfAbsent(player.getUniqueId(), new SpecLocData(true));

        String msg;

        if(sl.getLox().get(player.getUniqueId()).specLoc){
            msg = ChatColor.RED + "OFF";
            sl.getLox().get(player.getUniqueId()).specLoc = false;
        } else {
            msg = ChatColor.GREEN + "ON";
            sl.getLox().get(player.getUniqueId()).specLoc = true;
        }

        player.sendMessage(ChatColor.GOLD + "Spectator location reversion set to " + msg);

        return true;

    }

}
