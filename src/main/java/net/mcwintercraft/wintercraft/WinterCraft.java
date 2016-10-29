package net.mcwintercraft.wintercraft;

import net.mcwintercraft.wintercraft.cauldron.CauldronEvents;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsEvents;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsEvents;
import net.mcwintercraft.wintercraft.commands.Command_chatcolor;
import net.mcwintercraft.wintercraft.commands.Command_mywarp;
import net.mcwintercraft.wintercraft.commands.Command_rank;
import net.mcwintercraft.wintercraft.commands.Command_chatsound;
import net.mcwintercraft.wintercraft.commands.Command_fakedeop;
import net.mcwintercraft.wintercraft.commands.Command_fakeop;
import net.mcwintercraft.wintercraft.commands.Command_srfw;
import net.mcwintercraft.wintercraft.commands.Command_test;
import net.mcwintercraft.wintercraft.commands.Command_vote;
import net.mcwintercraft.wintercraft.commands.Command_website;
import net.mcwintercraft.wintercraft.playerwarps.PlayerWarpsEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class WinterCraft extends JavaPlugin implements Listener {
	
	private static WinterCraft plugin;
	
	WinterCraftConfig playerwarpsconfig;
	WinterCraftConfig chatcolorsconfig;
	WinterCraftConfig chatsoundsconfig;
	
	FileConfiguration playerwarpsfile;
	FileConfiguration chatcolorsfile;
	FileConfiguration chatsoundsfile;
	
	public void onEnable() {
		
		plugin = this;
		
		playerwarpsconfig = WinterCraftConfig.getConfig("playerwarps");
		chatcolorsconfig = WinterCraftConfig.getConfig("chatcolors");
		chatsoundsconfig = WinterCraftConfig.getConfig("chatsounds");
		
		playerwarpsfile = playerwarpsconfig.getConfig();
		chatcolorsfile = chatcolorsconfig.getConfig();
		chatsoundsfile = chatsoundsconfig.getConfig();
		
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
				new CauldronEvents()
				);
		
		this.getLogger().info("WinterCraft Enabled");        
	}

	public void onDisable() {
		
		this.playerwarpsconfig.saveConfig();
		this.chatcolorsconfig.saveConfig();
		
		plugin = null;
		
		this.getLogger().info("WinterCraft Disabled");
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
}