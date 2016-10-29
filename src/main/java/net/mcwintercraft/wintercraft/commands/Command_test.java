package net.mcwintercraft.wintercraft.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectTypeWrapper;

import net.md_5.bungee.api.ChatColor;

public class Command_test implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player) {
			Player p = (Player) sender;
			ItemStack i = new ItemStack(Material.POTION);
			PotionMeta pm = (PotionMeta) i.getItemMeta();
			pm.setDisplayName(ChatColor.RESET + "Lava Bottle");
			PotionEffect ef = new PotionEffect(PotionEffectTypeWrapper.FIRE_RESISTANCE, 0, 0);
			pm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pm.addCustomEffect(ef, true);
			i.setItemMeta(pm);
			p.getInventory().addItem(i);
			
			ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().subtract(0, 1, 0).add(0.5, 0, 0.5), EntityType.ARMOR_STAND);
			as.setCollidable(false);
			as.setGravity(false);
			as.setVisible(false);
			as.setInvulnerable(true);
			as.setCustomNameVisible(true);
			as.setRemoveWhenFarAway(false);
			as.setCustomName("EMPTY");
			as.setChestplate(new ItemStack(Material.STONE));
			as.setLeggings(new ItemStack(Material.STONE));
			as.setHelmet(new ItemStack(Material.STONE));
			//REMOVE ENCHANT
			return true;
		}
		return false;
	}
}