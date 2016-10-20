package net.mcwintercraft.wintercraft.playerwarps;

import java.util.Iterator;
import java.util.List;
import net.mcwintercraft.wintercraft.WinterCraftConfig;
import net.mcwintercraft.wintercraft.WinterCraftUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerWarpsEvents implements Listener {
	
	WinterCraftConfig config = WinterCraftConfig.getConfig("playerwarps");

	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String puuid = p.getUniqueId().toString();
		String[] msg;
		int warpsr;
		List<String> warps;
		List<String> warplist;
		boolean warpowner;
		boolean warpexists;
		String awarp;
		Iterator<String> arg10;
		if (e.getMessage().toLowerCase().startsWith("/setwarp")
				|| e.getMessage().toLowerCase().startsWith("/createwarp")) {
			msg = e.getMessage().toLowerCase().toString().split(" ");
			if ((!msg[0].equalsIgnoreCase("/setwarp") || msg.length != 2 || WinterCraftUtil.isInt(msg[1]))
					&& (!msg[0].equalsIgnoreCase("/createwarp") || msg.length != 2 || WinterCraftUtil.isInt(msg[1]))) {
				e.setCancelled(true);
				p.sendMessage("Creates a new warp.");
				p.sendMessage("/setwarp <warp>");
			} else {
				this.config.reloadConfig();
				this.config.saveConfig();
				if (this.config.getConfig().getString(puuid) == null) {
					this.config.getConfig().set(puuid + ".username", p.getName().toString());
					this.config.getConfig().set(puuid + ".warpsremaining", Integer.valueOf(10));
					this.config.saveConfig();
					this.config.reloadConfig();
				}

				if (this.config.getConfig().getStringList("warplist") == null) {
					this.config.getConfig().set("warplist", "");
				}

				warpsr = this.config.getConfig().getInt(puuid + ".warpsremaining");
				if (warpsr >= 0) {
					warps = this.config.getConfig().getStringList(puuid + ".warps");
					warplist = this.config.getConfig().getStringList("warplist");
					warpowner = false;
					warpexists = false;
					arg10 = warplist.iterator();

					while (arg10.hasNext()) {
						awarp = (String) arg10.next();
						if (msg[1].equalsIgnoreCase(awarp)) {
							warpowner = true;
						}
					}

					if (warpowner) {
						arg10 = warps.iterator();

						while (arg10.hasNext()) {
							awarp = (String) arg10.next();
							if (msg[1].equalsIgnoreCase(awarp)) {
								warpexists = true;
							}
						}
					}

					if ((!warpowner || !warpexists) && warpowner) {
						e.setCancelled(true);
						p.sendMessage(ChatColor.AQUA + "That warp already exits!");
					} else {
						if (!warpexists) {
							warplist.add(msg[1]);
							warps.add(msg[1]);
							this.config.getConfig().set(puuid + ".warps", warps);
							this.config.getConfig().set("warplist", warplist);
							this.config.getConfig().set(puuid + ".warpsremaining", Integer.valueOf(warpsr - 1));
						}

						warpsr = this.config.getConfig().getInt(puuid + ".warpsremaining");
						this.config.saveConfig();
						this.config.reloadConfig();
						if (warpsr > 1 || warpsr < 1) {
							p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
									+ " warps remaining!");
						}

						if (warpsr == 1) {
							p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
									+ " warp remaining!");
						}
					}
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
							+ " warps remaining!");
				}
			}
		}

		if (e.getMessage().toLowerCase().startsWith("/delwarp")) {
			msg = e.getMessage().toLowerCase().toString().split(" ");
			if (msg[0].equalsIgnoreCase("/delwarp") && msg.length == 2) {
				this.config.saveConfig();
				this.config.reloadConfig();
				if (this.config.getConfig().getString(puuid) == null) {
					this.config.getConfig().set(puuid + ".username", p.getName().toString());
					if (p.hasPermission("wintercraft.warp.cow")) {
						this.config.getConfig().set(puuid + ".warpsremaining", Integer.valueOf(10));
					}

					this.config.saveConfig();
					this.config.reloadConfig();
				}

				if (this.config.getConfig().getStringList("warplist") == null) {
					this.config.getConfig().set("warplist", "");
				}

				warpsr = this.config.getConfig().getInt(puuid + ".warpsremaining");
				if (warpsr < 10) {
					warps = this.config.getConfig().getStringList(puuid + ".warps");
					warplist = this.config.getConfig().getStringList("warplist");
					warpowner = false;
					warpexists = false;
					arg10 = warplist.iterator();

					while (arg10.hasNext()) {
						awarp = (String) arg10.next();
						if (msg[1].equalsIgnoreCase(awarp)) {
							warpexists = true;
						}
					}

					if (!warpexists) {
						e.setCancelled(true);
						p.sendMessage(ChatColor.AQUA + "That warp doesn\'t exist!");
						return;
					}

					arg10 = warps.iterator();

					while (arg10.hasNext()) {
						awarp = (String) arg10.next();
						if (msg[1].equalsIgnoreCase(awarp)) {
							warpowner = true;
						}
					}

					if (warpowner && warpexists) {
						warps.remove(msg[1]);
						warplist.remove(msg[1]);
						this.config.getConfig().set(puuid + ".warps", warps);
						this.config.getConfig().set("warplist", warplist);
						this.config.getConfig().set(puuid + ".warpsremaining", Integer.valueOf(warpsr + 1));
						warpsr = this.config.getConfig().getInt(puuid + ".warpsremaining");
						this.config.saveConfig();
						this.config.reloadConfig();
						if (warpsr > 1 || warpsr < 1) {
							p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
									+ " warps remaining!");
						}

						if (warpsr == 1) {
							p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
									+ " warp remaining!");
						}
					} else {
						e.setCancelled(true);
						p.sendMessage(ChatColor.AQUA + "You don\'t own that warp!");
					}
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.AQUA + "You have " + ChatColor.YELLOW + warpsr + ChatColor.AQUA
							+ " warps remaining!");
				}
			} else {
				e.setCancelled(true);
				p.sendMessage("Deletes the specified warp.");
				p.sendMessage("/delwarp <warp>");
			}
		}

	}
}