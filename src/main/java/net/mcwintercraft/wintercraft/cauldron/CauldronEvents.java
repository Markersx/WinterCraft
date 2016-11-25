package net.mcwintercraft.wintercraft.cauldron;

import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class CauldronEvents implements Listener {

    private WinterCraft wc;
    private Cauldrons cs;

    public CauldronEvents(WinterCraft wc) {
        this.wc = wc;
        this.cs = new Cauldrons(wc);
    }

    @EventHandler
	public void onCauldronPlace(BlockPlaceEvent e) {
		if(e.getBlockPlaced().getType() == Material.CAULDRON) {
			Player p = e.getPlayer();
			Block b = e.getBlockPlaced();
            if (cs.setCauldron(b.getLocation())) {
                ArmorStand as = p.getWorld().spawn(b.getLocation().add(0.5, 0, 0.5).subtract(0, 1, 0), ArmorStand.class);
                as.setCollidable(false);
                as.setGravity(false);
                as.setInvulnerable(true);
                as.setSilent(true);
                as.setCustomNameVisible(true);
                as.setRemoveWhenFarAway(false);
                as.setCustomName("EMPTY");
            }
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
		Block b = e.getBlock();
		if (b.getType() == Material.CAULDRON) {
            Player p = e.getPlayer();
            Location pl = p.getLocation();
            Location bl = b.getLocation();
            short c = b.getState().getData().toItemStack().getDurability();
            if (cs.removeCauldron(bl)) {
                for (Entity s : b.getWorld().getNearbyEntities(bl.add(0.5, 0, 0.5).subtract(0, 1, 0), 0.5, 0.5, 0.5)) {
                    p.sendMessage(s.getName());
                    if (s instanceof ArmorStand) {
                        s.remove();
                    }
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
                    b.setType(Material.WATER);
                    p.playSound(pl, Sound.ENTITY_GENERIC_SPLASH, 0.5F, 1);
                    break;
            }
        }
		
	}
	
	//TODO: NO DEPRECIATION
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCauldronInteract(PlayerInteractEvent e) {
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON) {
			
			e.setCancelled(true);

            Player p = e.getPlayer();
			
			Location loc = e.getClickedBlock().getLocation();
			ItemStack itm = p.getInventory().getItemInMainHand();
			
			if (itm != null && itm.getType() != Material.AIR) {

                switch (itm.getType()) {
                    case POTION:
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
                    case GLASS_BOTTLE:
                        //FILL WITH TYPE
                    case BUCKET:
                    case WATER_BUCKET:
                        ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(loc.subtract(0, 1, 0).add(0.5, 0, 0.5), EntityType.ARMOR_STAND);
                        as.setCustomName("WATER");
                    case LAVA_BUCKET:
                        ArmorStand as2 = (ArmorStand) p.getWorld().spawnEntity(loc.subtract(0, 1, 0).add(0.5, 0, 0.5), EntityType.ARMOR_STAND);
                        as2.setHelmet(new ItemStack(Material.MAGMA));
                        as2.setCollidable(false);
                        as2.setGravity(false);
                        as2.setVisible(false);
                        as2.setInvulnerable(true);
                        as2.setCustomNameVisible(true);
                        as2.setRemoveWhenFarAway(false);
                        as2.setCustomName("LAVA");
                }
			}
		}
	}
	
	@EventHandler
	public void onDrink(PlayerItemConsumeEvent e) {
		if (e.getItem().getType() == Material.POTION) {
			
			Player p = e.getPlayer();
			PotionMeta pm = (PotionMeta) p.getInventory().getItemInMainHand().getItemMeta();

            switch (pm.getBasePotionData().getType()) {
                case FIRE_RESISTANCE:
                    if (e.getItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
                        p.setFireTicks(20 * 20);
                        p.sendMessage(rf());
                    }
                case WATER:
                    if (p.getFireTicks() > 0) {
                        p.setFireTicks(0);
                        p.sendMessage("Feel Better?");
                    }
            }
		}
	}

	//TODO: FINISH
	@EventHandler
    public void onFill(CauldronLevelChangeEvent e) {
        switch (e.getReason()) {
            case EVAPORATE:
            case UNKNOWN: //RAIN
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