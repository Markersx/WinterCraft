package net.mcwintercraft.wintercraft.enchants;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EnchantmentInventory {

    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
    ItemMeta helmetMeta = helmet.getItemMeta();
    List<Enchantment> helmetEnchants = new ArrayList<>();

    public void loadHInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 18, "Helmet Enchantments");
        List<String> helmetLore = new ArrayList<>();
        for (int i = 0; helmetEnchants.size() > i; i++) {
            helmetLore.add(helmetEnchants.get(i).getName());
        }
        helmetMeta.setLore(helmetLore);
    }

    ItemStack chestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
    ItemMeta chestPlateMeta = chestPlate.getItemMeta();

    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
    ItemMeta leggingsMeta = leggings.getItemMeta();

    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
    ItemMeta bootsMeta = boots.getItemMeta();

    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta swordMeta = sword.getItemMeta();

    ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta axeMeta = axe.getItemMeta();

    ItemStack pickAxe = new ItemStack(Material.DIAMOND_PICKAXE);
    ItemMeta pickAxeMeta = pickAxe.getItemMeta();

    ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
    ItemMeta spadeMeta = spade.getItemMeta();

    ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
    ItemMeta hoeMeta = hoe.getItemMeta();

    ItemStack bow = new ItemStack(Material.BOW);
    ItemMeta bowMeta = bow.getItemMeta();

    ItemStack shield = new ItemStack(Material.SHIELD);
    ItemMeta shieldMeta = shield.getItemMeta();

    ItemStack fishingRod = new ItemStack(Material.FISHING_ROD);
    ItemMeta fishingRodMeta = fishingRod.getItemMeta();

    ItemStack carrotStick = new ItemStack(Material.CARROT_STICK);
    ItemMeta carrotStickMeta = carrotStick.getItemMeta();

    ItemStack flintSteal = new ItemStack(Material.FLINT_AND_STEEL);
    ItemMeta flintStealMeta = flintSteal.getItemMeta();

    ItemStack shears = new ItemStack(Material.SHEARS);
    ItemMeta shearsMeta = shears.getItemMeta();

    ItemStack barding = new ItemStack(Material.DIAMOND_BARDING);
    ItemMeta bardingMeta = barding.getItemMeta();

    ItemStack saddle = new ItemStack(Material.SADDLE);
    ItemMeta saddleMeta = saddle.getItemMeta();

    ItemStack elytra = new ItemStack(Material.ELYTRA);
    ItemMeta elytraMeta = elytra.getItemMeta();

    ItemStack lifeSteal = new ItemStack(Material.ENCHANTED_BOOK);

    public void loadInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 18, "Enchantments");
        inv.addItem(helmet, chestPlate, leggings, boots, sword, axe, pickAxe, spade, hoe, bow, shield, fishingRod, carrotStick, flintSteal, shears, barding, saddle, elytra);
        p.openInventory(inv);
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent e) {
        e.getExpLevelCost();
    }

    @EventHandler
    public void onPreEnchantTest(PrepareItemEnchantEvent e){
        e.getExpLevelCostsOffered()[0] = 1;
        e.getExpLevelCostsOffered()[1] = 15;
        e.getExpLevelCostsOffered()[2] = 30;
    }
}
