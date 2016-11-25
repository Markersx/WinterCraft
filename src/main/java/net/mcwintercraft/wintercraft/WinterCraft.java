/*
Location - loc
Block - b
Player - p
WinterCraft - wc
ItemMeta - im
Inventory - inv
Event - e
Exception - ex
World - w
Chunk - c
*/

package net.mcwintercraft.wintercraft;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.earth2me.essentials.Essentials;
import net.mcwintercraft.wintercraft.cauldron.CauldronEvents;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsEvents;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsEvents;
import net.mcwintercraft.wintercraft.commands.*;
import net.mcwintercraft.wintercraft.entity.EntityListener;
import net.mcwintercraft.wintercraft.entity.EntityTypes;
import net.mcwintercraft.wintercraft.gmod.PhysGun;
import net.mcwintercraft.wintercraft.holidays.*;
import net.mcwintercraft.wintercraft.misc.*;
import net.mcwintercraft.wintercraft.playtime.PlayTime;
import net.mcwintercraft.wintercraft.warps.WarpsEvents;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Calendar;
import java.util.logging.Level;

import static com.earth2me.essentials.utils.DateUtil.formatDateDiff;

public class WinterCraft extends JavaPlugin implements Listener {

	public static WinterCraft instance;
    private SpecLoad sl;
    public static Essentials ess = null;
    private static ProtocolManager protocolManager;
    public boolean debug;
    public BukkitScheduler schedule;
    private Calendar now;

    public void onEnable() {

        now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);

        Plugin EssentialsX = Bukkit.getPluginManager().getPlugin("Essentials");
        protocolManager = ProtocolLibrary.getProtocolManager();

        if(EssentialsX instanceof Essentials) {
            ess = (Essentials) EssentialsX;
            this.getLogger().info("Using Essentials!");
        } else {
            this.getLogger().severe("Essentials not found!");
        }
		
		instance = this;
        sl = new SpecLoad(this);
        schedule = this.getServer().getScheduler();
        debug = this.getConfig().getBoolean("debug");

        registerCustomEntities();

		getCommand("color").setExecutor(new Commandchatcolor(this));
		getCommand("vote").setExecutor(new Commandvote(this));
		getCommand("rank").setExecutor(new Commandrank(this));
		getCommand("website").setExecutor(new Commandwebsite(this));
		getCommand("srfw").setExecutor(new Commandsrfw(this));
		getCommand("sound").setExecutor(new Commandchatsound(this));
		getCommand("test").setExecutor(new Commandtest(this));
		getCommand("fakeop").setExecutor(new Commandfakeop(this));
		getCommand("fakedeop").setExecutor(new Commandfakedeop(this));
        getCommand("marry").setExecutor(new CommandMarry(this));
        getCommand("freeze").setExecutor(new Commandfreeze(this));
        getCommand("playtime").setExecutor(new Commandplaytime(this));
        getCommand("endercrate").setExecutor(new Commandendercrate(this));
        getCommand("enchants").setExecutor(new Commandenchants());
        getCommand("setwarp").setExecutor(new Commandsetwarp(this));
        getCommand("sl").setExecutor(new CommandSL(sl));

        WinterCraftUtil.registerGlow();

		registerEvents(this,
                new Commandvote(this),
                new Commandtest(this),
                new WarpsEvents(this),
				new ChatColorsEvents(this),
				new ChatSoundsEvents(this),
				new PreventCosmetics(this),
				new FailMilk(this),
				new CauldronEvents(this),
                new PhysGun(this),
                new WornPath(this),
                new TNTMine(this),
                new PlayTime(this),
                new EnderCrate(this),
                new NetherSkeleton(),
                new DeepSnow(this),
                new EntityListener(this),
                sl
				);

        registerFourthJuly(WinterCraftUtil.timeFourthJuly());
        registerEaster(WinterCraftUtil.timeEaster());
        registerHalloween(WinterCraftUtil.timeHalloween());
        registerThanksGiving(WinterCraftUtil.timeThanksGiving());
        registerChristmas(WinterCraftUtil.timeChristmas());
        registerNewYear(WinterCraftUtil.timeNewYear());

        this.getLogger().info("WinterCraft Enabled");
	}

    public void onDisable() {

        //unregisterCustomEntities();

        this.saveConfig();

        instance = null;

        this.getLogger().info("WinterCraft Disabled");

    }

	private void registerCustomEntities() {
        for (EntityTypes types: EntityTypes.values()) {
            types.register(types.getName(), types.getId(), types.getCustomClass());
        }
    }

    private void unregisterCustomEntities() {
        for (EntityTypes types: EntityTypes.values()) {
            types.unregister(types.getName(), types.getId(), types.getCustomClass());
        }
    }

    private void registerFourthJuly(Calendar cal) {
        long time = getTime(cal);
        debug("Activating FourthJuly on " + getDate(cal));
        new BukkitRunnable() {
              @Override
              public void run() {
                  registerEvents(instance, new FourthJuly());
                  debug("~~~~~~ Fourth of July ~~~~~~");
              }
        }.runTaskLater(instance, time);
    }

    private void registerThanksGiving(Calendar cal) {
        long time = getTime(cal);
        debug("Activating ThanksGiving on " + getDate(cal));
        new BukkitRunnable() {
            @Override
            public void run() {
                registerEvents(instance, new ThanksGiving());
                debug("~~~~~~ ThanksGiving ~~~~~~");
            }
        }.runTaskLater(instance, time);
    }

    private long getTime(Calendar cal) {
        long time = ((cal.getTimeInMillis() - now.getTimeInMillis()) / 1000) * 20;
        if (time <= 0) {
            return 20L;
        } else {
            return time;
        }
    }

    private void registerEaster(Calendar cal) {
        long time = getTime(cal);
        debug("Activating Easter on " + getDate(cal));
        new BukkitRunnable() {
            @Override
            public void run() {
                registerEvents(instance, new Easter());
                debug("~~~~~~ Easter ~~~~~~");
            }
        }.runTaskLater(instance, time);
    }

    private void registerHalloween(Calendar cal) {
        long time = getTime(cal);
        debug("Activating Halloween on " + getDate(cal));
        new BukkitRunnable() {
            @Override
            public void run() {
                registerEvents(instance, new Halloween());
                debug("~~~~~~ Halloween ~~~~~~");
            }
        }.runTaskLater(instance, time);
    }

    private void registerChristmas(Calendar cal) {
        long time = getTime(cal);
        debug("Activating Christmas on " + getDate(cal));
        new BukkitRunnable() {
            @Override
            public void run() {
                registerEvents(instance, new Christmas());
                debug("~~~~~~ Christmas ~~~~~~");
            }
        }.runTaskLater(instance, time);
    }

    private void registerNewYear(Calendar cal) {
        long time = getTime(cal);
        debug("Activating NewYear on " + getDate(cal));
        new BukkitRunnable() {
            @Override
            public void run() {
                registerEvents(instance, new NewYear());
                debug("~~~~~~ New Year ~~~~~~");
            }
        }.runTaskLater(instance, time);
    }
	
	private void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

    public void debug(String message) {
        if (debug) {
            this.getLogger().log(Level.INFO, message);
        }
    }

    public String getDate(Calendar cal) {
        return cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR) + " ~ " + formatDateDiff(cal.getTimeInMillis());
    }

    public Plugin getPlugin() {
		return instance;
	}
	
	public static ProtocolManager getProtocolManager() {
        return protocolManager;
	}
}