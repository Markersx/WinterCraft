package net.mcwintercraft.wintercraft.cauldron;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class CauldronEvents implements Listener{
	//test
	@EventHandler
	public void onCauldronPlace(BlockPlaceEvent e) {
		if(e.getBlockPlaced().getType() == Material.CAULDRON) {
			Player p = e.getPlayer();
			Block b = e.getBlockPlaced();
			ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(b.getLocation().add(0.5, 0.5, 0.5), EntityType.ARMOR_STAND);
			as.setCollidable(false);
			as.setGravity(false);
			as.setInvulnerable(true);
			as.setSilent(true);
			as.setCustomNameVisible(true);
			as.setRemoveWhenFarAway(false);
			as.setCustomName("EMPTY");
			as.setAI(false);
		}
	}
	
	@EventHandler
	public void onChunkLoad(ChunkLoadEvent e) {
		
		World world = e.getWorld();
		Chunk chunk = e.getChunk();
		
		int bx = chunk.getX()<<4;
		int bz = chunk.getZ()<<4;

		for(int xx = bx; xx < bx+16; xx++) {
		    for(int zz = bz; zz < bz+16; zz++) {
		        for(int yy = 0; yy < 128; yy++) {
		            if(world.getBlockAt(xx, yy, zz).getType() == Material.CAULDRON) {
		                //Check if it exists in file
		            	//If it does do nothing
		            	//if It doesn't put data into file
		            }
		        }
		    }
		}
	}
	
	//Places water depending on how full the cauldron is
	@EventHandler
	public void onBreakCauldron(BlockBreakEvent e) {
		Block a = e.getBlock();
		if (a.getType() == Material.CAULDRON) {
			Player p = e.getPlayer();
			Location pl = p.getLocation();
			Location bl = a.getLocation();
			short c = a.getState().getData().toItemStack().getDurability();
			for (Entity s : a.getWorld().getNearbyEntities(bl.subtract(0, 1, 0), 0.5, 0.5, 0.5)) {
				p.sendMessage(s.getName());
				if (s instanceof ArmorStand) {
					s.remove();
				}
			}
			switch (c) {
			case 0:
				break;
			case 1:
				for (double y = 0.3; y >= 0; y = y - 0.1) {
					for (double z = 0; z <= 1; z = z + 0.1) {
						for (double x = 0; x <= 1; x = x + 0.1) {
							p.spawnParticle(Particle.WATER_SPLASH, x, y, z, 1);
						}
					}
				}
				p.playSound(pl, Sound.ENTITY_GENERIC_SPLASH, 0.5F, 1);
				break;
			case 2:
				for (double y = 0.6; y >= 0; y = y - 0.1) {
					for (double z = 0; z <= 1; z = z + 0.1) {
						for (double x = 0; x <= 1; x = x + 0.1) {
							p.spawnParticle(Particle.WATER_SPLASH, x, y, z, 1);
						}
					}
				}
				p.playSound(pl, Sound.ENTITY_GENERIC_SPLASH, 0.5F, 1);
				break;
			case 3:
				a.setType(Material.WATER);
				p.playSound(pl, Sound.ENTITY_GENERIC_SPLASH, 0.5F, 1);
				break;
			default:
				e.setCancelled(true);
			}
		}
		
	}
	
	//TODO NO DEPRECIATION
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCauldronInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON) {
			
			e.setCancelled(true);
			
			Location loc = e.getClickedBlock().getLocation();
			ItemStack itm = p.getInventory().getItemInMainHand();
			
			if (itm != null && itm.getType() != Material.AIR) {
				
				//POTIONS
				if (p.getInventory().getItemInMainHand().getType() == Material.POTION) {
					
					PotionMeta pm = (PotionMeta) p.getInventory().getItemInMainHand().getItemMeta();
					
					if (pm.getBasePotionData().getType() == PotionType.WATER) {
						
						Block b = e.getClickedBlock();
						short c = e.getClickedBlock().getState().getData().toItemStack().getDurability();
						
						switch (c) {
						case 0:
							e.getPlayer().getInventory().getItemInMainHand().setType(Material.GLASS_BOTTLE);
							b.setData((byte) (e.getClickedBlock().getData() + 1));
							break;
						case 1:
							e.getPlayer().getInventory().getItemInMainHand().setType(Material.GLASS_BOTTLE);
							b.setData((byte) (e.getClickedBlock().getData() + 1));
							break;
						case 2:
							e.getPlayer().getInventory().getItemInMainHand().setType(Material.GLASS_BOTTLE);
							b.setData((byte) (e.getClickedBlock().getData() + 1));
							break;
						default:
							return;
						}
						
					}
				}
				//GLASS BOTTLE
				if (itm.getType() == Material.GLASS_BOTTLE) {
					
				}
				//EMPTY BUCKET
				if (itm.getType() == Material.BUCKET) {
					
				}
				//WATER BUCKET
				if (itm.getType() == Material.WATER_BUCKET) {
					ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(loc.subtract(0, 1, 0).add(0.5, 0, 0.5), EntityType.ARMOR_STAND);
					as.setCustomName("WATER");
				}
				//LAVA BUCKET
				if (p.getInventory().getItemInMainHand().getType() == Material.LAVA_BUCKET) {
					ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(loc.subtract(0, 1, 0).add(0.5, 0, 0.5), EntityType.ARMOR_STAND);
					as.setHelmet(new ItemStack(Material.MAGMA));
					as.setCollidable(false);
					as.setGravity(false);
					as.setVisible(false);
					as.setInvulnerable(true);
					as.setCustomNameVisible(true);
					as.setRemoveWhenFarAway(false);
					as.setCustomName("LAVA");
				}
			}
		}
	}
	
	@EventHandler
	public void onDrink(PlayerItemConsumeEvent e) {
		if (e.getItem().getType() == Material.POTION) {
			
			Player p = e.getPlayer();
			PotionMeta pm = (PotionMeta) p.getInventory().getItemInMainHand().getItemMeta();
			
			//Drinking lava sets player on fire.
			if (pm.getBasePotionData().getType() == PotionType.FIRE_RESISTANCE) {
				if (e.getItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
					p.setFireTicks(20 * 20);
					p.sendMessage(rf());
				}
			}
			
			//Drinking water extinguishes player.
			if (pm.getBasePotionData().getType() == PotionType.WATER) {
				if (p.getFireTicks() > 0) {
					p.setFireTicks(0);
					p.sendMessage("Feel Better?");
				}
			}
			
		}
	}
	
	private String rf() {
		String rf;
		Random r = new Random();
		int rn = r.nextInt(3);
		switch (rn) {
		case 0:
			rf = "How does it taste?";
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