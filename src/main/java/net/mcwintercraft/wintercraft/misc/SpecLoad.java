package net.mcwintercraft.wintercraft.misc;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SpecLoad implements Listener {

    private Map<UUID, SpecLocData> lox;
    private List<String> commands;
    private boolean init;

    public SpecLoad(WinterCraft wc) {

        init = wc.getConfig().getBoolean("sl-default");

        lox = new HashMap<>();

        commands = wc.getConfig().getStringList("barred-commands");
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent e) {

        Player p = e.getPlayer();

        SpecLocData data = lox.get(p.getUniqueId());

        if(data == null) {
            data = new SpecLocData(init);
            lox.put(p.getUniqueId(), data);
        }

        if(!data.specLoc) return;

        if(e.getNewGameMode().equals(GameMode.SPECTATOR)) {
            data.loc = p.getLocation();
            return;
        }

        if(p.getGameMode().equals(GameMode.SPECTATOR))
            if(data.loc != null) {

                p.teleport(data.loc);
                p.sendMessage(ChatColor.AQUA + "Reverted to previous location.");

            }
            else {

                p.sendMessage(ChatColor.AQUA + "You didn't have a location saved when you enabled spectator reversion, so I can't send you back.");

            }

    }

    @EventHandler
    public void onCommandEntered(PlayerCommandPreprocessEvent e) {

        Player p = e.getPlayer();

        if(p.hasPermission("sl.override") || !p.getGameMode().equals(GameMode.SPECTATOR)) return;

        SpecLocData data = lox.get(p.getUniqueId());

        if(data == null) {
            data = new SpecLocData(init);
            lox.put(p.getUniqueId(), data);
        }

        if(!data.specLoc) return;

        String cmd = e.getMessage();

        int x = cmd.indexOf(' ');
        String parsed;
        if(x < 1)
            parsed = cmd.substring(1);
        else
            parsed = cmd.substring(1, x);

        for(String s : commands)
            if(s.equalsIgnoreCase(parsed)) {

                p.sendMessage(ChatColor.RED + "Command barred while in spectator mode.");
                e.setCancelled(true);
                return;

            }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.SPECTATOR)) {
            SpecLocData data = lox.get(p.getUniqueId());
            if (data.loc != null) {
                p.teleport(data.loc);

            }
        }
    }

    public Map<UUID, SpecLocData> getLox() {
        return lox;
    }
}
