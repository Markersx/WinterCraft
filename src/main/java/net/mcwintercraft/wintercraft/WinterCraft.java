package net.mcwintercraft.wintercraft;

import net.mcwintercraft.wintercraft.cauldron.CauldronEvents;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsEvents;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsEvents;
import net.mcwintercraft.wintercraft.commands.*;
import net.mcwintercraft.wintercraft.playerwarps.PlayerWarpsEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class WinterCraft extends JavaPlugin implements Listener {
	
	private static WinterCraft plugin;
	
	private WinterCraftConfig playerwarpsconfig;
	private WinterCraftConfig chatcolorsconfig;
	private WinterCraftConfig chatsoundsconfig;

	public void onEnable() {
		
		plugin = this;
		
		playerwarpsconfig = WinterCraftConfig.getConfig("playerwarps");
		chatcolorsconfig = WinterCraftConfig.getConfig("chatcolors");
		chatsoundsconfig = WinterCraftConfig.getConfig("chatsounds");

		//FileConfiguration playerwarpsfile = playerwarpsconfig.getConfig();
		//FileConfiguration chatcolorsfile = chatcolorsconfig.getConfig();
		//FileConfiguration chatsoundsfile = chatsoundsconfig.getConfig();

		getCommand("color").setExecutor(new Command_chatcolor());
		getCommand("mywarp").setExecutor(new Command_mywarp());
		getCommand("vote").setExecutor(new Command_vote());
		getCommand("rank").setExecutor(new Command_rank());
		getCommand("website").setExecutor(new Command_website());
		getCommand("srfw").setExecutor(new Command_srfw());
		getCommand("sound").setExecutor(new Command_chatsound());
		getCommand("test").setExecutor(new Command_test());
		getCommand("fakeop").setExecutor(new Command_fakeop());
		getCommand("fakedeop").setExecutor(new Command_fakedeop());
		
		registerEvents(this, 
				new PlayerWarpsEvents(), 
				new ChatColorsEvents(),
				new ChatSoundsEvents(),
				new PreventCosmetics(),
				new FailMilk(),
				new SlimeBall(),
				new CauldronEvents()
				);
		
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