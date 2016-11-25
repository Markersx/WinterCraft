package net.mcwintercraft.wintercraft.misc;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FailMilk implements Listener {

    private WinterCraft wc;

    private List<Player> milking = new ArrayList<>();

    public FailMilk(WinterCraft wc) {
        this.wc = wc;
    }

    @EventHandler
	public void onMilk(PlayerInteractEntityEvent e) {
		
		Player p = e.getPlayer();
		EntityType ent = e.getRightClicked().getType();
		ItemStack hand = p.getInventory().getItemInMainHand();

		//trying to milk an entity other than a cow will fail
        if (!milking.contains(p)) {
		    if (hand.getType() == Material.BUCKET && ent != EntityType.COW && ent != EntityType.MUSHROOM_COW) {
                p.sendMessage("You tried to milk the " + e.getRightClicked().getName() + " but failed...");
                e.setCancelled(true);
                milking.add(p);
            }
        } else {
            milking.remove(p);
        }
	}
}
