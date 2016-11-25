package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Commandfreeze implements CommandExecutor {

    private final WinterCraft wc;

    private List<Player> frozen = new ArrayList<>();

    public Commandfreeze(WinterCraft wc) {
        this.wc = wc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target != null) {
                if (frozen.contains(target)) {
                    frozen.remove(target);
                    target.setWalkSpeed(0.1F);
                    target.setInvulnerable(false);
                    target.setGameMode(GameMode.SURVIVAL);
                    if (target.getLocation().add(0,2,0).getBlock().getType() == Material.BEDROCK) {
                        target.getLocation().add(0,2,0).getBlock().setType(Material.AIR);
                    }
                    target.sendMessage(ChatColor.AQUA + "You have been unfrozen by " + sender.getName());
                } else {
                    frozen.add(target);
                    target.setWalkSpeed(0);
                    target.setInvulnerable(true);
                    target.setGameMode(GameMode.ADVENTURE);
                    if (target.getLocation().add(0,2,0).getBlock().getType() == Material.AIR) {
                        target.getLocation().add(0,2,0).getBlock().setType(Material.BEDROCK);
                    }
                    target.sendMessage(ChatColor.AQUA + "You have been frozen by " + sender.getName());
                }
                return true;
            }
        }
        return false;
    }
}
