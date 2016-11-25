package net.mcwintercraft.wintercraft.entity;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityListener implements Listener {

    private final WinterCraft wc;

    public EntityListener(WinterCraft wc) {
        this.wc = wc;
    }

    private List<Byte> turkeyHatches = new ArrayList<>();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        switch (e.getEntity().getType()) {
            case CHICKEN:
        }
    }

    @EventHandler
    public void onEggBreak(PlayerEggThrowEvent e) {
        if (e.isHatching()) {
            if (e.getEgg().getCustomName() != null && e.getEgg().getCustomName() == ItemStacks.TURKEY_EGG.getName()) {
                turkeyHatches.add(e.getNumHatches());
                e.setHatching(false);
                wc.debug("Turkey Hatches: " + e.getNumHatches());
            }
        }
    }

    @EventHandler
    public void s (ProjectileHitEvent e) {
        if (!turkeyHatches.isEmpty()) {
            int rand = new Random().nextInt(turkeyHatches.size());
            for (int i = turkeyHatches.get(rand); i > 1; i--) {
                Entity ent = new EntityTurkey(((CraftWorld) e.getEntity().getWorld()).getHandle());
                if (ent.getBukkitEntity() instanceof Ageable) {
                    ((Ageable) ent.getBukkitEntity()).setBaby();
                }
                ((CraftWorld) e.getEntity().getWorld()).addEntity(ent, CreatureSpawnEvent.SpawnReason.EGG);
            }
            turkeyHatches.remove(rand);
        }
    }

    @EventHandler
    public void onChickenSpawn(EntitySpawnEvent e) {
        org.bukkit.entity.Entity ent = e.getEntity();
        if (ent instanceof Creature && !(ent instanceof Wither)) {
            ent.setCustomName(ChatColor.WHITE + ent.getClass().toString());
            ent.setCustomNameVisible(true);
            if (ent instanceof Chicken && ((Chicken) ent).isAdult()) {
                if (Math.random() >= 0.5) {
                    e.setCancelled(true);
                    Location loc = e.getLocation();
                    World mcWorld = ((CraftWorld) loc.getWorld()).getHandle();
                    EntityTypes.spawn(new EntityTurkey(mcWorld), loc);
                }
            }
        }
    }
}
