package net.mcwintercraft.wintercraft.enchants;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class CustomEnchantment extends Enchantment {

    public CustomEnchantment(int id) {
        super(id);
    }

    public abstract int enchantLevelCost();

    public abstract int chance();

    public abstract boolean incompatible(Map<Enchantment, Integer> map);

    public void Enchant(ItemStack item, int level) {
        int chance = new Random().nextInt(chance());
        if (chance == 0 && level != 0) {
            if (item.getType() != Material.BOOK
                    && canEnchantItem(item)) {
                if (level > this.getMaxLevel()) {
                    level = this.getMaxLevel();
                }
                Random rand = new Random();
                if (rand.nextInt(2) == 0 && level > 1) {
                    level = level - 1;
                }
                item.addEnchantment(this, level);
                ItemMeta m = item.getItemMeta();
                List<String> lore;
                if (m.hasLore()) {
                    lore = m.getLore();
                } else {
                    lore = new ArrayList<>();
                }
                lore.add(ChatColor.GRAY + this.getName() + " " + numeral(level));
                m.setLore(lore);
                item.setItemMeta(m);
            }
        }
    }

    public String numeral(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                return "";
        }
    }

    public boolean isArmor(ItemStack item) {
        return false;
    }

    public boolean isWeapon(ItemStack item) {
        return false;
    }

    public boolean isTool(ItemStack item) {
        return isPickAxe(item) || isShovel(item) || isAxe(item);
    }

    public boolean isHelmet(ItemStack item) {
        return false;
    }

    public boolean isChestPlate(ItemStack item) {
        return false;
    }

    public boolean isLegging(ItemStack item) {
        return false;
    }

    public boolean isBoot(ItemStack item) {
        return false;
    }

    public boolean isSword(ItemStack item) {
        return false;
    }

    public boolean isBow(ItemStack item) {
        return false;
    }

    public boolean isShield(ItemStack item) {
        return false;
    }

    public boolean isPickAxe(ItemStack item) {

        return false;
    }

    public boolean isAxe(ItemStack item) {
        return false;
    }

    public boolean isShovel(ItemStack item) {
        return false;
    }

    public boolean isHoe(ItemStack item) {
        return false;
    }

    public boolean isBook(ItemStack item) {
        return item.getType() == Material.BOOK;
    }

    public boolean hasEnchantment(ItemStack i) {
        return false;
    }

    public int getEnchantment(ItemStack i) {
        if (hasEnchantment(i)) {
            return i.getItemMeta().getEnchantLevel(this);
        }
        return 0;
    }

    public void giveEnchantmentBook(Player p, Enchantment enchant, int level) {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        meta.addStoredEnchant(enchant, level, false);
        book.setItemMeta(meta);
    }
}
