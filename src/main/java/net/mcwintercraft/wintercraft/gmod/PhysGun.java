package net.mcwintercraft.wintercraft.gmod;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class PhysGun implements Listener {

    private final Map<Player, Entity> control = new HashMap<>();

    private WinterCraft wc;

    public PhysGun(WinterCraft wc) {
        this.wc = wc;
    }

    @EventHandler
    public void changeDistance(PlayerItemHeldEvent e) {
        if (control.containsKey(e.getPlayer())) {
            e.setCancelled(true);
            int from = e.getPreviousSlot();
            int to = e.getNewSlot();

            if (from >= 8 && to <= 1) {
                to = 9;
            }
            if (from <= 1 && to >= 8) {
                to = -1;
            }

            final boolean decrease = to > from;
            final boolean increase = to < from;

            handleScroll(increase, decrease, e.getPlayer().isSneaking());
        }
    }

    private float amount = 3;

    @EventHandler
    public void onUseEntity(PlayerInteractEntityEvent e) {

        Player p = e.getPlayer();
        ItemStack hand = p.getInventory().getItemInMainHand();

        if (!control.containsKey(p) && !p.isSneaking() && isPhysGun(hand)) {

            control.put(p, e.getRightClicked());
            Entity ent = control.get(p);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (control.size() > 0) {
                        for (Map.Entry<Player, Entity> tp : control.entrySet()) {
                            Entity ent = tp.getValue();
                            Player p = tp.getKey();
                            ent.teleport(p.getLocation().toVector().add(p.getLocation().getDirection().multiply(amount)).toLocation(p.getWorld()));
                            wc.debug("TP");
                        }
                    } else {
                        wc.debug("CANCELED TP");
                        this.cancel();
                    }
                }
            }.runTaskTimer(wc, 0, 3L);

            if (ent instanceof Player) {
                Player pe = (Player) ent;
                pe.setGlowing(true);
                pe.setGravity(false);
                pe.setInvulnerable(true);
                pe.setGameMode(GameMode.ADVENTURE);
                pe.sendMessage("You are being handled by " + p.getName());
                return;
            }

            if (ent instanceof Creature && !(ent instanceof Wither)) {
                ent.setGravity(false);
                ent.setInvulnerable(true);
                ent.setGlowing(true);
                ent.setSilent(true);
                ((Creature) ent).setAI(false);
            }
        }

        if (control.containsKey(p) && p.isSneaking() && isPhysGun(hand)) {

            Entity ent = control.get(p);
            remove(ent, p);
            wc.debug("Removed entity");
        }
    }

    @EventHandler
    public void onUseBlock(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && !p.isSneaking() && !control.containsKey(p) && isPhysGun(e.getItem())) {
            for (String s : wc.getConfig().getStringList("phys-blocked")) {
                Block b = e.getClickedBlock();
                if (!s.equalsIgnoreCase(b.getType().toString())) {
                    Location loc = b.getLocation().add(0.5, 0, 0.5);
                    Entity ent = b.getWorld().spawnFallingBlock(b.getLocation().add(0.5, 0, 0.5), b.getType(), b.getData());
                    b.setType(Material.AIR);
                    ent.setGravity(false);
                    ent.setInvulnerable(true);
                    ent.setGlowing(true);
                    control.put(p, ent);
                }
            }
        }
    }

    @EventHandler
    public void onBlockDrop(EntityChangeBlockEvent e) {
        if (control.containsValue(e.getEntity())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        if (control.containsKey(p)) {

            Entity ent = control.get(p);
            remove(ent, p);

        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (control.containsValue(e.getEntity())) {
            for (Map.Entry<Player, Entity> player : control.entrySet()) {
                if (control.get(player.getKey()) == e.getEntity()) {
                    remove(player.getValue(), player.getKey());
                }
            }
        }
    }

    private void remove(Entity ent, Player p) {
        if (ent.getType() == null) {
            return;
        }
        control.remove(p, ent);
        switch (ent.getType()) {
            case FALLING_BLOCK:
                FallingBlock fb = (FallingBlock) ent;
                fb.setGravity(true);
                fb.setGlowing(false);
                fb.setInvulnerable(false);
                return;
            case PLAYER:
                Player pe = (Player) ent;
                pe.setGlowing(false);
                pe.setGravity(true);
                pe.setInvulnerable(false);
                pe.setGameMode(GameMode.SURVIVAL);
                pe.sendMessage("You are no longer being handled by " + p.getName());
                return;
        }
        ent.setGravity(true);
        ent.setInvulnerable(false);
        ent.setGlowing(false);
        ent.setSilent(false);
    }

    //TODO: DOESN'T WORK WELL WITH FALLING BLOCKS


    //TODO: MAKE AMOUNT UNIQUE PER PLAYER
    public void handleScroll(boolean increase, boolean decrease, boolean sneaking) {
        if (amount > 1.5) {
            if (decrease) {
                amount -= 0.5;
            }
            if (increase) {
                amount += 0.5;
            }
        }
    }

    public boolean isPhysGun(ItemStack item) {
        return item != null && (item.hasItemMeta() && (item.getItemMeta().hasDisplayName() && (item.getType() == Material.DIAMOND_BARDING && item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Phys Gun"))));
    }
}
