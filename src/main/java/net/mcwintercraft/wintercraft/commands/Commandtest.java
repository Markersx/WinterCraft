package net.mcwintercraft.wintercraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectTypeWrapper;

public class Commandtest implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player && args.length == 0) {

            Player p = (Player) sender;
            ItemStack i = new ItemStack(Material.POTION);
            PotionMeta pm = (PotionMeta) i.getItemMeta();
            pm.setDisplayName(ChatColor.RESET + "Lava Bottle");
            PotionEffect ef = new PotionEffect(PotionEffectTypeWrapper.FIRE_RESISTANCE, 0, 0);
            pm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            pm.addCustomEffect(ef, true);
            i.setItemMeta(pm);
            p.getInventory().addItem(i);

            return true;
        } else {
            return false;
        }
    }
}