package net.mcwintercraft.wintercraft.cauldron;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Cauldron;

public class CauldronEvents implements Listener{
	
	@EventHandler
	public void onCauldron(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInMainHand().equals(Material.GLASS_BOTTLE)) {
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().equals(Material.CAULDRON)) {
				//add water
			}
		}
	}
	
	//Places water depending on how full the cauldron is
	@EventHandler
	public void onBreakCauldron(BlockBreakEvent e) {
		if (e.getBlock().getType() == Material.CAULDRON) {
			Block a = e.getBlock();
			Cauldron ca = new Cauldron();
			ca.getItemType().getData();
			a.getState().setData(ca);
			a.getLocation().getBlock().setType(Material.WATER);
		}
	}
	
	@EventHandler
	public void onDrink(PlayerItemConsumeEvent e) {
		if (e.getItem().getType() == Material.POTION) {
			
			Player p = e.getPlayer();
			ItemStack dm = p.getInventory().getItemInMainHand();
			
			//set player on fire
			if (dm.getItemMeta().getDisplayName().toString() == "Lava Bottle") {
				p.setFireTicks(20 * 20);
				p.sendMessage(rf());
			}
			
			//extinguish player
			//ADD CHECK IF HAS NO EFFECT
			if (dm.getType() == Material.POTION && p.getFireTicks() > 0) {
				p.setFireTicks(0);
				p.sendMessage("Feel Better?");
			}
			
		}
	}
	
	public String rf() {
		String rf;
		Random r = new Random();
		int rn = r.nextInt(3);
		switch (rn) {
		case 0:
			rf = "How does it tase?";
			break;
		case 1:
			rf = "What did you expect its lava!";
			break;
		case 2:
			rf = "It must taste good!";
			break;
		default:
			rf = "Quick! Drink some water!";
		}
		return rf ;
	}
}
