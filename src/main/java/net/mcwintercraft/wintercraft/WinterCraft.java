package net.mcwintercraft.wintercraft;

import net.mcwintercraft.wintercraft.cauldron.CauldronEvents;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsEvents;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsEvents;
import net.mcwintercraft.wintercraft.commands.*;
import net.mcwintercraft.wintercraft.recipes.mainrecipe;
import net.mcwintercraft.wintercraft.warps.warps;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class WinterCraft extends JavaPlugin implements Listener {
	
	private static WinterCraft plugin;
    private static final Logger LOGGER = Logger.getLogger("WinterCraft");
	
	private WinterCraftConfig playerwarpsconfig;
	private WinterCraftConfig chatcolorsconfig;
	private WinterCraftConfig chatsoundsconfig;

	public void onEnable() {
		
		plugin = this;
		
		playerwarpsconfig = WinterCraftConfig.getConfig("playerwarps");
		chatcolorsconfig = WinterCraftConfig.getConfig("chatcolors");
		chatsoundsconfig = WinterCraftConfig.getConfig("chatsounds");

        this.saveDefaultConfig();

		//FileConfiguration playerwarpsfile = playerwarpsconfig.getConfig();
		//FileConfiguration chatcolorsfile = chatcolorsconfig.getConfig();
		//FileConfiguration chatsoundsfile = chatsoundsconfig.getConfig();

		getCommand("color").setExecutor(new Commandchatcolor());
		getCommand("mywarp").setExecutor(new Commandmywarp());
		getCommand("vote").setExecutor(new Commandvote());
		getCommand("rank").setExecutor(new Commandrank());
		getCommand("website").setExecutor(new Commandwebsite());
		getCommand("srfw").setExecutor(new Commandsrfw());
		getCommand("sound").setExecutor(new Commandchatsound());
		getCommand("fakeop").setExecutor(new Commandfakeop());
		getCommand("fakedeop").setExecutor(new Commandfakedeop());
		
		registerEvents(this, 
				new warps(),
				new ChatColorsEvents(),
				new ChatSoundsEvents(),
				new PreventCosmetics(),
				new FailMilk(),
				new SlimeBall(),
				new CauldronEvents()
				);

        mainrecipe.createrecip();

		this.getLogger().info("WinterCraft Enabled");
	}

	public void onDisable() {
		
		this.playerwarpsconfig.saveConfig();
		this.chatcolorsconfig.saveConfig();
        this.chatsoundsconfig.saveConfig();
		
		plugin = null;
		
		this.getLogger().info("WinterCraft Disabled");
	}

    private static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
}