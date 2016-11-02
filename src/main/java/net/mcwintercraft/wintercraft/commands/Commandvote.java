package net.mcwintercraft.wintercraft.commands;

import mkremins.fanciful.FancyMessage;
import net.mcwintercraft.wintercraft.WinterCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Commandvote implements CommandExecutor {

    private static Commandvote instance;
    private long votetimer;
    private int votes;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("vote") && sender instanceof Player) {
            if (args.length > 0) {
                long twentyfourhour = 86400000;
                this.votetimer = System.currentTimeMillis() + twentyfourhour;
                return true;
            }
            FileConfiguration config = WinterCraft.getPlugin().getConfig();
            List<String> links = config.getStringList("vote-links");
			Player p = (Player) sender;
            FancyMessage fm = new FancyMessage("- VOTE LINKS -");
            fm.color(ChatColor.GREEN);
            fm.style(ChatColor.BOLD);
            fm.link("http://www.mcwintercraft.net/vote");
            fm.send(p);
            for(String s : links) {
                String[] linkname;
                linkname = s.split("\\.");
                FancyMessage vl = new FancyMessage("[" + linkname[1].toUpperCase() + "]");
                vl.color(ChatColor.AQUA);
                vl.style(ChatColor.BOLD);
                vl.link(s);
                String as;
                as = formatDateDiff(votetimer());
                vl.tooltip(ChatColor.BOLD + as);
                vl.send(p);
            }
            FancyMessage tv = new FancyMessage(String.valueOf(this.votes));
            tv.color(ChatColor.AQUA);
            tv.style(ChatColor.BOLD);
            tv.then(" total votes");
            tv.color(ChatColor.AQUA);
            tv.style(ChatColor.BOLD);
            tv.send(p);
            return true;
		}
		return false;
	}

    private static String formatDateDiff(long date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeInMillis(date);
        GregorianCalendar now = new GregorianCalendar();
        return formatDateDiff(now, c);
    }

    private static String formatDateDiff(Calendar fromDate, Calendar toDate) {
        boolean future = false;
        if(toDate.equals(fromDate)) {
            return "now";
        } else {
            if(toDate.after(fromDate)) {
                future = true;
            }

            StringBuilder sb = new StringBuilder();
            int[] types = new int[]{1, 2, 5, 11, 12, 13};
            String[] names = new String[]{"year", "years", "month", "months", "day", "days", "hour","hours", "minute", "minutes", "second", "seconds"};
            int accuracy = 0;

            for(int i = 0; i < types.length && accuracy <= 2; ++i) {
                int diff = dateDiff(types[i], fromDate, toDate, future);
                if(diff > 0) {
                    ++accuracy;
                    sb.append(" ").append(diff).append(" ").append(names[i * 2 + (diff > 1?1:0)]);
                }
            }

            return sb.length() == 0?"now":sb.toString().trim();
        }
    }

    private static int dateDiff(int type, Calendar fromDate, Calendar toDate, boolean future) {
        byte year = 1;
        int fromYear = fromDate.get(year);
        int toYear = toDate.get(year);
        if(Math.abs(fromYear - toYear) > 100000) {
            toDate.set(year, fromYear + (future?100000:-100000));
        }

        int diff = 0;

        long savedDate;
        for(savedDate = fromDate.getTimeInMillis(); future && !fromDate.after(toDate) || !future && !fromDate.before(toDate); ++diff) {
            savedDate = fromDate.getTimeInMillis();
            fromDate.add(type, future?1:-1);
        }

        --diff;
        fromDate.setTimeInMillis(savedDate);
        return diff;
    }

    private long votetimer() {
        return this.votetimer;
    }
}
