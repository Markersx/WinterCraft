package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.EnderCrate;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Set;

public class Commandendercrate implements CommandExecutor {

    private WinterCraft wc;
    WinterCraftConfig config;
    EnderCrate ec;

    public Commandendercrate(WinterCraft wc) {
        this.wc = wc;
        ec = new EnderCrate(wc); //TODO: FIX
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("endercrate") && sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                Block b = p.getTargetBlock((Set<Material>) null, 3);
                if (b.getType() == Material.ENDER_PORTAL_FRAME) {
                    switch (args[0]) {
                        case "set":
                            if (p.hasPermission("wintercraft.crate.set")) {
                                if (ec.setCrate(b.getLocation())) {
                                    ArmorStand as = b.getWorld().spawn(b.getLocation().add(0.5, 0, 0.5).subtract(0, 1, 0), ArmorStand.class);
                                    as.setCustomName("ENDER CRATE");
                                    as.setCustomNameVisible(true);
                                    as.setGravity(false);
                                    as.setInvulnerable(true);
                                    p.sendMessage(ChatColor.AQUA + "Crate Set");
                                    return true;
                                } else {
                                    p.sendMessage(ChatColor.RED + "That block is already an EnderCrate!");
                                    return true;
                                }
                            }
                            break;
                        case "remove":
                            if (p.hasPermission("wintercraft.crate.remove")) {
                                if (ec.removeCrate(b.getLocation())) {
                                    for (Entity s : b.getWorld().getNearbyEntities(b.getLocation().add(0.5, 0, 0.5).subtract(0, 1, 0), 0.5, 0.5, 0.5)) {
                                        p.sendMessage(s.getName());
                                        if (s instanceof ArmorStand) {
                                            s.remove();
                                        }
                                    }
                                    p.sendMessage(ChatColor.AQUA + "Crate Removed");
                                    return true;
                                } else {
                                    p.sendMessage(ChatColor.RED + "That block is not an EnderCrate!");
                                    return true;
                                }
                            }
                            break;
                    }
                } else {
                    p.sendMessage(ChatColor.RED  + "You must be looking at an END PORTAL FRAME!");
                    return true;
                }
            }
        }
        return false;
    }
}
