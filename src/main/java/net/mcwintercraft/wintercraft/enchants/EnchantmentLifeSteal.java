package net.mcwintercraft.wintercraft.enchants;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantmentLifeSteal extends CustomEnchantment {

    public EnchantmentLifeSteal(int id) {
        super(id);
    }

    @Override
    public int enchantLevelCost() {
        return 10;
    }

    @Override
    public int chance() {
        return 4;
    }

    @Override
    public boolean incompatible(Map<Enchantment, Integer> map) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack arg0) {
        return isSword(arg0);
    }

    @Override
    public boolean conflictsWith(Enchantment arg0) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public String getName() {
        return "LifeSuck";
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack i = player.getInventory().getItemInMainHand();
            if (i != null && i.hasItemMeta() && i.getItemMeta().hasEnchant(this)) {
                int level = i.getItemMeta().getEnchantLevel(this);
                addHealth(player, level);
            }
        }
    }

    public void addHealth(Player player, int amount) {
        if (player.getHealth() + amount > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        } else {
            player.setHealth(player.getHealth() + amount);
        }
    }

}
