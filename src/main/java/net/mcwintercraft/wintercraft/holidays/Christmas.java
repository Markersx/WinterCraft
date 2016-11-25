package net.mcwintercraft.wintercraft.holidays;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Christmas implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        player.spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation().add(0, 5, 0), 2, 5F, 5F, 5F, 1F);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendTitle(ChatColor.RED + "MERRY", ChatColor.GREEN + "CHRISTMAS");
    }
    //TODO: PRESENTS
}
