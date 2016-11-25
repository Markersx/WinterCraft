package net.mcwintercraft.wintercraft.commands;

import com.earth2me.essentials.User;
import com.earth2me.essentials.api.IWarps;
import com.earth2me.essentials.commands.WarpNotFoundException;
import com.earth2me.essentials.utils.NumberUtil;
import net.ess3.api.InvalidWorldException;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

import static com.earth2me.essentials.I18n.tl;
import static net.mcwintercraft.wintercraft.WinterCraft.ess;


public class Commandsetwarp implements CommandExecutor {

    private WinterCraft wc;
    private WinterCraftConfig config;

    public Commandsetwarp(WinterCraft wc) {
        this.wc = wc;
        config = new WinterCraftConfig(new File(wc.getDataFolder(), "warps.yml"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                config.load();
                Player p = (Player) sender;
                User user = ess.getUser(p);

                if (NumberUtil.isInt(args[0]) || args[0].isEmpty()) {
                    user.sendMessage(tl("invalidWarpName"));
                    return true;
                }

                final Location loc = p.getLocation();
                final IWarps warps = ess.getWarps();
                Location warpLoc = null;

                try {
                    warpLoc = warps.getWarp(args[0]);
                } catch (WarpNotFoundException | InvalidWorldException ex) {

                }

                if (warpLoc == null || isOwner(p, args[0])) {
                    try {
                        warps.setWarp(args[0], loc);
                        config.set(args[0] + ".visits", 0);
                        config.set(args[0] + ".owner", p.getName());
                        config.save();
                    } catch (Exception e) {
                    }
                } else {
                    user.sendMessage(tl("warpOverwrite"));
                    return true;
                }

                user.sendMessage(tl("warpSet", args[0]));
                return true;
            }
        }
        return false;
    }

    private boolean isOwner(Player p, String s) {
        return config.getString(s) == null || config.getString(s + ".owner").equals(p.getName());
    }
}