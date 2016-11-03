package net.mcwintercraft.wintercraft.commands;

import com.earth2me.essentials.utils.NumberUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class Commandsrfw implements CommandExecutor {
	
	private static final Random random = new Random();
	private int srfws = 0;
	private int srfws2 = 0;
	private int radius = 0;
		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
		if (cmd.getName().equalsIgnoreCase("srfw")) {
			
			//shoot 1 random firework for everyone
			if (args.length < 1) {
				radius = 0;
				srfws++;
				srfws();
				return true;
			}
			
			//shoot random firework for everyone amount and radius
			if (args.length > 0) {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				if (args.length == 3){
					// /srfw <player> <amount> <radius>
					if (target != null && NumberUtil.isInt(args[1]) && NumberUtil.isInt(args[2])) {
						srfws2 = Integer.parseInt(args[1]);
						radius = Integer.parseInt(args[2]);
						srfws2(target);
						return true;
					} else {
						return false;
					}
				}
				if (args.length == 2) {
					// /srfw <player> <amount>
					if (target != null && NumberUtil.isInt(args[1])) {
						radius = 0;
						srfws2 = Integer.parseInt(args[1]);
						srfws2(target);
						return true;
					}
					// /srfw <amount> <radius>
					if (NumberUtil.isInt(args[0]) && NumberUtil.isInt(args[1])) {
						srfws = Integer.parseInt(args[0]);
						radius = Integer.parseInt(args[1]);
						srfws();
						return true;
					}
					return false;
				}
				
				if (args.length == 1) {
					// /srfw <amount>
					if (NumberUtil.isInt(args[0])) {
						radius = 0;
						srfws = Integer.parseInt(args[0]);
						srfws();
						return true;
					}
					// /srfw <player>
					if (target != null) {
						radius = 0;
						srfws2++;
						srfws2(target);
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}
	    
	//shoots random firework for every player
    private void srfws() {
		while (srfws > 0) {
			for(Player p : Bukkit.getOnlinePlayers()){
				Location loc = p.getLocation();
				if (radius != 0) {
                    loc.add(random.nextInt(radius), 0, random.nextInt(radius));
                    loc.subtract(random.nextInt(radius), 0, random.nextInt(radius));
				}
				shootRandomFirework(loc, 1);
			}
			srfws--;
		}
	}
	
	//shoots random firework for 1 player
    private void srfws2(Player target) {
		while (srfws2 > 0) {
            Location loc = target.getLocation();
			if (radius > 0) {
				loc.add(random.nextInt(radius), 0, random.nextInt(radius));
                loc.subtract(random.nextInt(radius), 0, random.nextInt(radius));
			}
			shootRandomFirework(loc, 1);
			srfws2--;
		}
	}

	//Create random firework
	private static void shootRandomFirework(Location loc, int height) {
		Firework f = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta fm = f.getFireworkMeta();
		fm.setPower(height);
		int effectAmount = random.nextInt(3) + 1;
		for(int i = 0; i < effectAmount; i++) {
			Builder b = FireworkEffect.builder();
			int colorAmount = random.nextInt(3) + 1;
			for(int ii = 0; ii < colorAmount; ii++) {
				b.withColor(Color.fromBGR(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			}
			b.with(Type.values()[random.nextInt(Type.values().length)]);
			b.flicker(random.nextInt(2) != 0);
			b.trail(random.nextInt(2) != 0);
			fm.addEffect(b.build());
		}
		f.setFireworkMeta(fm);
	}
}