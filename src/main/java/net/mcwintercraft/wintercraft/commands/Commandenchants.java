package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.enchants.EnchantmentInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandenchants implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enchants") && sender instanceof Player) {
            Player p = (Player) sender;
            EnchantmentInventory inventory = new EnchantmentInventory();
            inventory.loadInventory(p);
        }
        return false;
    }
}