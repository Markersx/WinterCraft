package net.mcwintercraft.wintercraft.playtime;

import com.earth2me.essentials.IUser;
import net.ess3.api.events.AfkStatusChangeEvent;
import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayTime implements Listener {
    //TODO: FINISH
    private WinterCraft wc;

    public PlayTime(WinterCraft wc) {
        this.wc = wc;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //START RECORDING ACTIVE TIME
        Player p = e.getPlayer();
        UserData user = new UserData(p, wc);
        user.setActiveSince(System.currentTimeMillis());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        //STOP RECORDING ACTIVE TIME
        Player p = e.getPlayer();
        IUser iuser = (IUser) p;
        UserData user = new UserData(p, wc);
        if (iuser.isAfk()) {
            user.setAFKTime(user.getAFKTime() + user.getAFKSince() - System.currentTimeMillis());
        } else {
            user.setActiveTime(user.getActiveTime() + user.getActiveSince() - System.currentTimeMillis());
        }
    }

    @EventHandler
    public void onAFK(AfkStatusChangeEvent e) {
        if (!e.isCancelled()) {
            Player p = e.getAffected().getBase();
            UserData user = new UserData(p, wc);
            if (e.getValue()) {
                user.setAFKSince(System.currentTimeMillis());
                user.setActiveTime(user.getActiveTime() + user.getActiveSince() - System.currentTimeMillis());
            } else {
                user.setAFKTime(user.getAFKTime() + user.getAFKSince() - System.currentTimeMillis());
                user.setActiveSince(System.currentTimeMillis());
            }
        }
    }
}
