package net.mcwintercraft.wintercraft;

import net.mcwintercraft.wintercraft.enchants.EnchantmentGlow;
import org.bukkit.DyeColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import java.lang.reflect.Field;
import java.util.Calendar;

public class WinterCraftUtil {

    static Calendar cal = Calendar.getInstance();
    static Calendar today = Calendar.getInstance();
    private static int YEAR = cal.get(Calendar.YEAR);

    public static void setWoolColor(ItemStack item, DyeColor color) {
        Wool w = new Wool(color);
        ItemStack is = w.toItemStack();
        item.setData(w);
        item.setDurability(is.getDurability());
    }

    public static void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EnchantmentGlow glow = new EnchantmentGlow(700);
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Calendar timeFourthJuly() {
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    public static Calendar timeThanksGiving() {
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.WEEK_OF_MONTH, 4);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    public static Calendar timeEaster() {
        //TODO: CALCULATE AUTOMATICALLY
        cal.set(Calendar.DATE, 16);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    public static Calendar timeHalloween() {
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    public static Calendar timeChristmas() {
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    public static Calendar timeNewYear() {
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.YEAR, YEAR);
        setYear();
        return cal;
    }

    private static void setYear() {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        if (today.after(cal)) {
            cal.set(Calendar.YEAR, YEAR + 1);
        }
    }
}
