package net.mcwintercraft.wintercraft;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

class SlimeBall implements Listener {
	
	private final List<String> m = new ArrayList<>();
	
	@EventHandler
	public void onName(PlayerInteractEntityEvent e) {
        
		Entity ent = e.getRightClicked();
		if (ent instanceof Slime) {
			Player p = e.getPlayer();
			if(m.contains(ent.getUniqueId().toString())) {
				p.sendMessage("p");
				double speed = 0.8;
				ent.setVelocity(new Vector(p.getLocation().getDirection().multiply(speed).getX(), 0, p.getLocation().getDirection().multiply(speed).getZ()));
			}
			if(ent.getCustomName() != null && ent.getCustomName().equals("Ball_")) {
				ent.setGravity(false);
				ent.setInvulnerable(true);
				ent.setGlowing(true);
				ent.setCustomName(null);
				ent.setCustomNameVisible(false);
				ent.setSilent(true);
				((Slime) ent).setAI(false);
				((Slime) ent).setRemoveWhenFarAway(false);
				((Slime) ent).setSize(2);
				m.add(ent.getUniqueId().toString());
			}
		}
	}
	
	@EventHandler
	public void onDie(EntityDeathEvent e) {
		String uuid = e.getEntity().getUniqueId().toString();
		if (m.contains(uuid)) {
			e.getDrops().clear();
			e.setDroppedExp(0);
		}
	}
	
	@EventHandler
	public void onSplit(SlimeSplitEvent e) {
		String uuid = e.getEntity().getUniqueId().toString();
		if (m.contains(uuid)) {
			e.setCancelled(true);
			m.remove(uuid);
		}
	}
}
