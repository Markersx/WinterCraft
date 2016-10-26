package net.mcwintercraft.wintercraft;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class FailMilk implements Listener {
	
	@EventHandler
	public void onMilk(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		EntityType ent = e.getRightClicked().getType();
		ItemStack hand = p.getInventory().getItemInMainHand();
		if (hand.getType() == Material.BUCKET && ent != EntityType.COW && ent != EntityType.MUSHROOM_COW) {
			p.sendMessage("You tried to milk the " + e.getRightClicked().getName() + " but failed...");
			return;
		}
	}
}
