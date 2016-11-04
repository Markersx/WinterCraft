package net.mcwintercraft.wintercraft;

import com.earth2me.essentials.Essentials;
import net.mcwintercraft.wintercraft.cauldron.CauldronEvents;
import net.mcwintercraft.wintercraft.chatcolors.ChatColorsEvents;
import net.mcwintercraft.wintercraft.chatsounds.ChatSoundsEvents;
import net.mcwintercraft.wintercraft.commands.*;
import net.mcwintercraft.wintercraft.warps.WarpsEvents;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class WinterCraft extends JavaPlugin implements Listener {
	
	private static WinterCraft plugin;
    public static Essentials ess = null;

	public void onEnable() {

        Plugin EssentialsX = Bukkit.getPluginManager().getPlugin("Essentials");

        if(EssentialsX instanceof Essentials) {
            ess = (Essentials) EssentialsX;
            this.getLogger().info("Using Essentials!");
        } else {
            this.getLogger().severe("Essentials not found!");
        }
		
		plugin = this;

		getCommand("color").setExecutor(new Commandchatcolor());
		getCommand("vote").setExecutor(new Commandvote());
		getCommand("rank").setExecutor(new Commandrank());
		getCommand("website").setExecutor(new Commandwebsite());
		getCommand("srfw").setExecutor(new Commandsrfw());
		getCommand("sound").setExecutor(new Commandchatsound());
		getCommand("test").setExecutor(new Commandtest());
		getCommand("fakeop").setExecutor(new Commandfakeop());
		getCommand("fakedeop").setExecutor(new Commandfakedeop());
        getCommand("marry").setExecutor(new CommandMarry());
		
		registerEvents(this,
                new Voting(),
                new WarpsEvents(),
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