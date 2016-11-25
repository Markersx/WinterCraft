package net.mcwintercraft.wintercraft.commands;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import mkremins.fanciful.FancyMessage;
import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

import static com.earth2me.essentials.utils.DateUtil.formatDateDiff;

public class Commandvote implements CommandExecutor, Listener {

    private final WinterCraft wc;
    private FileConfiguration config;
    List<String> links;
    private final long tf = 86400000;

    public Commandvote(WinterCraft wc) {
        this.wc = wc;
        config = wc.getConfig();
        links = config.getStringList("vote-links");
    }

    //TODO: SOME VOTES RESET AFTER 12 HOURS

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("vote") && sender instanceof Player) {
			Player p = (Player) sender;
            UserData user = new UserData(p, wc);
            FancyMessage fm = new FancyMessage("- VOTE LINKS -");
            fm.color(ChatColor.GREEN);
            fm.style(ChatColor.BOLD);
            fm.link("http://www.mcwintercraft.net/vote");
            fm.send(p);
            for(String s : links) {
                String[] address = s.split("\\.");
                FancyMessage vl = new FancyMessage("[" + address[1].toUpperCase() + "]");
                vl.color(ChatColor.AQUA);
                vl.style(ChatColor.BOLD);
                vl.link(s);
                if (user.getVoteTimer(address[1]) >= System.currentTimeMillis()) {
                    vl.tooltip(ChatColor.BOLD + "CLICK TO VOTE NOW!");
                } else {
                    vl.tooltip(ChatColor.BOLD + formatDateDiff(user.getVoteTimer(address[1])));
                }
                vl.send(p);
            }
            FancyMessage tv = new FancyMessage("TOTAL VOTES: " + String.valueOf(user.getTotalVotes()));
            tv.color(ChatColor.AQUA);
            tv.style(ChatColor.BOLD);
            tv.send(p);
            return true;
		}
		return false;
	}

    @EventHandler
    public void onVote(VotifierEvent e) {
        Vote vote = e.getVote();
        String pn = vote.getUsername();
        String[] address = vote.getAddress().split("\\.");
        Long time = System.currentTimeMillis() + tf;
        UserData s = new UserData(Bukkit.getPlayer(pn), wc);
        s.setVotesTimer(address[1], time);
        s.setTotalVotes(s.getTotalVotes() + 1);
        wc.getServer().getScheduler().runTaskLater(wc, new Runnable() {
            public void run() {
                Player p = Bukkit.getPlayer(pn);
                if (p.isOnline()) {
                    FancyMessage vote = new FancyMessage("[" + address[1].toUpperCase() + "]");
                    vote.color(ChatColor.AQUA);
                    vote.style(ChatColor.BOLD);
                    for (String s : links) {
                        if (s.contains(address[1])) {
                            vote.link(s);
                        }
                    }
                    vote.tooltip(ChatColor.BOLD + "CLICK TO VOTE NOW!");
                    vote.send(p);
                    p.playSound(p.getLocation(), s.getMessageSound(), s.getMessageSoundVolume(), s.getMessageSoundPitch());
                }
            }
        }, tf);
    }
}
