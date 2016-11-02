package net.mcwintercraft.wintercraft.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;


public class mainrecipe {

    private static final ItemStack bottle = new ItemStack(Material.EXP_BOTTLE, 1);

    private static final ShapedRecipe expBottle = new ShapedRecipe(bottle);
    public static void createrecip() {
        expBottle.shape("*%*", "%B%", "*%*");
        expBottle.setIngredient('*', Material.INK_SACK);
        expBottle.setIngredient('%', Material.SUGAR);
        expBottle.setIngredient('B', Material.GLASS_BOTTLE);
        Bukkit.addRecipe(expBottle);
    }
}
