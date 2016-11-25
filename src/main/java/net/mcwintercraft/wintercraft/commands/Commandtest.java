package net.mcwintercraft.wintercraft.commands;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.enchants.EnchantmentGlow;
import net.mcwintercraft.wintercraft.entity.EntityGhostBlock;
import net.mcwintercraft.wintercraft.entity.EntityTurkey;
import net.mcwintercraft.wintercraft.entity.EntityTypes;
import net.minecraft.server.v1_10_R1.BlockStone;
import net.minecraft.server.v1_10_R1.World;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectTypeWrapper;

import java.util.ArrayList;
import java.util.List;

public class Commandtest implements Listener, CommandExecutor {

    private final WinterCraft wc;
    private List<Player> click = new ArrayList<>();

    public Commandtest(WinterCraft wc) {
        this.wc = wc;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player && args.length == 0) {

            Player p = (Player) sender;
            ItemStack i = new ItemStack(Material.POTION);
            PotionMeta pm = (PotionMeta) i.getItemMeta();
            pm.setDisplayName(ChatColor.RESET + "Lava Bottle");
            PotionEffect ef = new PotionEffect(PotionEffectTypeWrapper.FIRE_RESISTANCE, 0, 0);
            pm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            pm.addCustomEffect(ef, true);
            i.setItemMeta(pm);
            p.getInventory().addItem(i);

            ItemStack s = new ItemStack(Material.DIAMOND_BARDING);
            ItemMeta sim = s.getItemMeta();
            sim.setDisplayName(ChatColor.WHITE + "Phys Gun");
            s.setItemMeta(sim);
            p.getInventory().addItem(s);

            ItemStack stick = new ItemStack(Material.STICK);
            ItemMeta stickM = stick.getItemMeta();
            EnchantmentGlow glow = new EnchantmentGlow(700);
            stickM.addEnchant(glow, 1, true);
            stick.setItemMeta(stickM);
            p.getInventory().addItem(stick);
            World mcWorld = ((CraftWorld) p.getWorld()).getHandle();

            EntityTypes.spawn(new EntityTurkey(mcWorld), p.getLocation());
            EntityTypes.spawn(new EntityGhostBlock(mcWorld, new BlockStone(), p.getLocation()), p.getLocation());




            return true;

        } else {
            return false;
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!click.contains(p)) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (p.getInventory().getItemInMainHand().getType() == Material.CARROT_STICK) {
                    e.setCancelled(true);
                    Block b = e.getClickedBlock();
                    p.sendMessage("TYPE: " + b.getType().toString());
                    p.sendMessage("DATA: " + String.valueOf(b.getData()));
                }
            }
        } else {
            click.remove(p);
        }
    }
}