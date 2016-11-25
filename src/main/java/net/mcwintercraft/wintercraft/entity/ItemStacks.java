package net.mcwintercraft.wintercraft.entity;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum ItemStacks {
    COOKED_TURKEY(Material.COOKED_CHICKEN),
    RAW_TURKEY(Material.RAW_CHICKEN),
    TURKEY_EGG(Material.EGG),
    TURKEY_FEATHER(Material.FEATHER);

    private String name;
    private Material type;
    private ItemStack item;

    ItemStacks(Material type) {
        this.type = type;
        this.name = ChatColor.WHITE + WordUtils.capitalizeFully(this.toString().replace("_", " "));
        ItemStack itemStack = new ItemStack(type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(getName());
        itemStack.setItemMeta(itemMeta);
        this.item = itemStack;
    }

    public String getName() {
        return name;
    }

    public Material getType() {
        return type;
    }

    public ItemStack getItem() {
        return item;
    }
}
