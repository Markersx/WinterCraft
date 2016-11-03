package net.mcwintercraft.wintercraft.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.I18n;
import com.earth2me.essentials.Trade;
import com.earth2me.essentials.User;
import com.earth2me.essentials.api.IWarps;
import com.earth2me.essentials.commands.EssentialsCommand;
import com.earth2me.essentials.commands.NoChargeException;
import com.earth2me.essentials.utils.NumberUtil;
import com.earth2me.essentials.utils.StringUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import net.ess3.api.IUser;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class Commandwarp extends EssentialsCommand {
    private static final int WARPS_PER_PAGE = 20;

    public Commandwarp() {
        super("warp");
    }

    public void run(Server server, User user, String commandLabel, String[] args) throws Exception {
        if(args.length != 0 && !args[0].matches("[0-9]+")) {
            if(args.length > 0) {
                User otherUser;
                if(args.length != 2 || !user.isAuthorized("essentials.warp.otherplayers") && !user.isAuthorized("essentials.warp.others")) {
                    this.warpUser(user, user, args[0]);
                    throw new NoChargeException();
                } else {
                    otherUser = this.getPlayer(server, user, args, 1);
                    this.warpUser(user, otherUser, args[0]);
                    throw new NoChargeException();
                }
            }
        } else if(!user.isAuthorized("essentials.warp.list")) {
            throw new Exception(I18n.tl("warpListPermission", new Object[0]));
        } else {
            this.warpList(user.getSource(), args, user);
            user.sendMessage("COCK");
            throw new NoChargeException();
        }
    }

    public void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception {
        if(args.length >= 2 && !NumberUtil.isInt(args[0])) {
            User otherUser = this.getPlayer(server, args, 1, true, false);
            otherUser.getTeleport().warp(otherUser, args[0], (Trade)null, TeleportCause.COMMAND);
            throw new NoChargeException();
        } else {
            this.warpList(sender, args, (IUser)null);
            throw new NoChargeException();
        }
    }

    private void warpList(CommandSource sender, String[] args, IUser user) throws Exception {
        IWarps warps = this.ess.getWarps();
        ArrayList warpNameList = new ArrayList(warps.getList());
        if(user != null) {
            Iterator page = warpNameList.iterator();

            while(page.hasNext()) {
                String maxPages = (String)page.next();
                if(this.ess.getSettings().getPerWarpPermission() && !user.isAuthorized("essentials.warps." + maxPages)) {
                    page.remove();
                }
            }
        }

        if(warpNameList.isEmpty()) {
            throw new Exception(I18n.tl("noWarpsDefined", new Object[0]));
        } else {
            int page1 = 1;
            if(args.length > 0 && NumberUtil.isInt(args[0])) {
                page1 = Integer.parseInt(args[0]);
            }

            int maxPages1 = (int)Math.ceil((double)warpNameList.size() / 20.0D);
            if(page1 > maxPages1) {
                page1 = maxPages1;
            }

            int warpPage = (page1 - 1) * 20;
            String warpList = StringUtil.joinList(new Object[]{warpNameList.subList(warpPage, warpPage + Math.min(warpNameList.size() - warpPage, 20))});
            if(warpNameList.size() > 20) {
                sender.sendMessage(I18n.tl("warpsCount", new Object[]{Integer.valueOf(warpNameList.size()), Integer.valueOf(page1), Integer.valueOf(maxPages1)}));
                sender.sendMessage(I18n.tl("warpList", new Object[]{warpList}));
            } else {
                sender.sendMessage(I18n.tl("warps", new Object[]{warpList}));
            }

        }
    }

    private void warpUser(User owner, User user, String name) throws Exception {
        Trade chargeWarp = new Trade("warp-" + name.toLowerCase(Locale.ENGLISH).replace('_', '-'), this.ess);
        Trade chargeCmd = new Trade(this.getName(), this.ess);
        BigDecimal fullCharge = chargeWarp.getCommandCost(user).add(chargeCmd.getCommandCost(user));
        Trade charge = new Trade(fullCharge, this.ess);
        charge.isAffordableFor(owner);
        if(this.ess.getSettings().getPerWarpPermission() && !owner.isAuthorized("essentials.warps." + name)) {
            throw new Exception(I18n.tl("warpUsePermission", new Object[0]));
        } else {
            owner.getTeleport().warp(user, name, charge, TeleportCause.COMMAND);
        }
    }
}