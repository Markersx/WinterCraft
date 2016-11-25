package net.mcwintercraft.wintercraft.chatsounds;

import net.mcwintercraft.wintercraft.UserData;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.mcwintercraft.wintercraft.WinterCraftUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import java.util.ArrayList;

public class ChatSoundsInventory {

    private final WinterCraft wc;

    public ChatSoundsInventory(WinterCraft wc) {
        this.wc = wc;
    }

	public final Inventory soundInv = Bukkit.createInventory(null, 45, "Sound Options");
	
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public final Inventory blockInv = Bukkit.createInventory(null, 54, "Block Sounds");
	private final ItemStack blockInv_item = new ItemStack(Material.RECORD_8);
	
	public Inventory blockInv_anvil = Bukkit.createInventory(null, 9, "Anvil Sounds");
	ItemStack blockInv_anvil_item = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_break = new ItemStack(Material.ANVIL, 1, (byte) 2);
	ItemStack block_anvil_destroy = new ItemStack(Material.ANVIL, 1, (byte) 1);
	ItemStack block_anvil_fall = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_hit = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_land = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_place = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_step = new ItemStack(Material.ANVIL);
	ItemStack block_anvil_use = new ItemStack(Material.ANVIL);
	
	public Inventory blockInv_chest = Bukkit.createInventory(null, 9, "Chest Sounds");
	ItemStack blockInv_chest_item = new ItemStack(Material.CHEST);
	ItemStack block_chest_close = new ItemStack(Material.CHEST);
	ItemStack block_chest_locked = new ItemStack(Material.TRAPPED_CHEST);
	ItemStack block_chest_open = new ItemStack(Material.CHEST);
	
	ItemStack block_chorus_flower_death = new ItemStack(Material.CHORUS_FLOWER);
	ItemStack block_chorus_flower_grow = new ItemStack(Material.CHORUS_FRUIT_POPPED);
	
	public Inventory blockInv_cloth = Bukkit.createInventory(null, 9, "Wool Sounds");
	ItemStack blockInv_cloth_item = new ItemStack(Material.WOOL);
	ItemStack block_cloth_break = new ItemStack(Material.WOOL);
	ItemStack block_cloth_fall = new ItemStack(Material.WOOL);
	ItemStack block_cloth_hit = new ItemStack(Material.WOOL);
	ItemStack block_cloth_place = new ItemStack(Material.WOOL);
	ItemStack block_cloth_step = new ItemStack(Material.WOOL);
	
	public Inventory blockInv_dispenser = Bukkit.createInventory(null, 9, "Dispenser Sounds");
	ItemStack blockInv_dispenser_item = new ItemStack(Material.DISPENSER);
	ItemStack block_dispenser_dispense = new ItemStack(Material.DISPENSER);
	ItemStack block_dispenser_fail = new ItemStack(Material.DISPENSER);
	ItemStack block_dispenser_launch = new ItemStack(Material.DISPENSER);
	
	ItemStack block_enderchest_close = new ItemStack(Material.ENDER_CHEST);
	ItemStack block_enderchest_open = new ItemStack(Material.ENDER_CHEST);

	ItemStack block_fence_gate_close = new ItemStack(Material.FENCE_GATE);
	ItemStack block_fence_gate_open = new ItemStack(Material.FENCE_GATE);
	
	ItemStack block_fire_ambient = new ItemStack(Material.FIRE);
	ItemStack block_fire_extinguish = new ItemStack(Material.FIRE);
	
	public Inventory blockInv_glass = Bukkit.createInventory(null, 9, "Glass Sounds");
	ItemStack blockInv_glass_item = new ItemStack(Material.GLASS);
	ItemStack block_glass_break = new ItemStack(Material.GLASS);
	ItemStack block_glass_fall = new ItemStack(Material.GLASS);
	ItemStack block_glass_hit = new ItemStack(Material.GLASS);
	ItemStack block_glass_place = new ItemStack(Material.GLASS);
	ItemStack block_glass_step = new ItemStack(Material.GLASS);
	
	public Inventory blockInv_grass = Bukkit.createInventory(null, 9, "Grass Sounds");
	ItemStack blockInv_grass_item = new ItemStack(Material.GRASS);
	ItemStack block_grass_break = new ItemStack(Material.GRASS);
	ItemStack block_grass_fall = new ItemStack(Material.GRASS);
	ItemStack block_grass_hit = new ItemStack(Material.GRASS);
	ItemStack block_grass_place = new ItemStack(Material.GRASS);
	ItemStack block_grass_step = new ItemStack(Material.GRASS);
	
	public Inventory blockInv_gravel = Bukkit.createInventory(null, 9, "Gravel Sounds");
	ItemStack blockInv_gravel_item = new ItemStack(Material.GRAVEL);
	ItemStack block_gravel_break = new ItemStack(Material.GRAVEL);
	ItemStack block_gravel_fall = new ItemStack(Material.GRAVEL);
	ItemStack block_gravel_hit = new ItemStack(Material.GRAVEL);
	ItemStack block_gravel_place = new ItemStack(Material.GRAVEL);
	ItemStack block_gravel_step = new ItemStack(Material.GRAVEL);
	
	public Inventory blockInv_iron = Bukkit.createInventory(null, 18, "Iron Sounds");
	ItemStack blockInv_iron_item = new ItemStack(Material.IRON_BLOCK);
	ItemStack block_iron_door_close = new ItemStack(Material.IRON_DOOR);
	ItemStack block_iron_door_open = new ItemStack(Material.IRON_DOOR);
	ItemStack block_iron_trapdoor_close = new ItemStack(Material.IRON_TRAPDOOR);
	ItemStack block_iron_trapdoor_open = new ItemStack(Material.IRON_TRAPDOOR);
	ItemStack block_metal_break = new ItemStack(Material.IRON_BLOCK);
	ItemStack block_metal_fall = new ItemStack(Material.IRON_BLOCK);
	ItemStack block_metal_hit = new ItemStack(Material.IRON_BLOCK);
	ItemStack block_metal_place = new ItemStack(Material.IRON_BLOCK);
	ItemStack block_metal_pressureplate_click_off = new ItemStack(Material.IRON_PLATE);
	ItemStack block_metal_pressureplate_click_on = new ItemStack(Material.IRON_PLATE);
	ItemStack block_metal_step = new ItemStack(Material.IRON_PLATE);
	
	public Inventory blockInv_ladder = Bukkit.createInventory(null, 9, "Ladder Sounds");
	ItemStack blockInv_ladder_item = new ItemStack(Material.LADDER);
	ItemStack block_ladder_break = new ItemStack(Material.LADDER);
	ItemStack block_ladder_fall = new ItemStack(Material.LADDER);
	ItemStack block_ladder_hit = new ItemStack(Material.LADDER);
	ItemStack block_ladder_place = new ItemStack(Material.LADDER);
	ItemStack block_ladder_step = new ItemStack(Material.LADDER);
	
	ItemStack block_lava_ambient = new ItemStack(Material.LAVA);
	ItemStack block_lava_extinguish = new ItemStack(Material.LAVA);
	ItemStack block_lava_pop = new ItemStack(Material.LAVA);
	
	public Inventory blockInv_note = Bukkit.createInventory(null, 9, "Note Sounds");
	ItemStack blockInv_note_item = new ItemStack(Material.GLASS);
	ItemStack block_note_basedrum = new ItemStack(Material.NOTE_BLOCK);
	ItemStack block_note_bass = new ItemStack(Material.NOTE_BLOCK);
	ItemStack block_note_harp = new ItemStack(Material.NOTE_BLOCK);
	ItemStack block_note_hat = new ItemStack(Material.NOTE_BLOCK);
	ItemStack block_note_pling = new ItemStack(Material.NOTE_BLOCK);
	ItemStack block_note_snare = new ItemStack(Material.NOTE_BLOCK);
	
	ItemStack block_piston_contract = new ItemStack(Material.PISTON_BASE);
	ItemStack block_piston_extend = new ItemStack(Material.PISTON_EXTENSION);
	
	ItemStack block_portal_ambient = new ItemStack(Material.PORTAL);
	ItemStack block_portal_travel = new ItemStack(Material.PORTAL);
	ItemStack block_portal_trigger = new ItemStack(Material.PORTAL);
	
	public Inventory blockInv_sand = Bukkit.createInventory(null, 9, "Sand Sounds");
	ItemStack blockInv_sand_item = new ItemStack(Material.SAND);
	ItemStack block_sand_break = new ItemStack(Material.SAND);
	ItemStack block_sand_fall = new ItemStack(Material.SAND);
	ItemStack block_sand_hit = new ItemStack(Material.SAND);
	ItemStack block_sand_place = new ItemStack(Material.SAND);
	ItemStack block_sand_step = new ItemStack(Material.SAND);
	
	public Inventory blockInv_slime = Bukkit.createInventory(null, 9, "Slime Sounds");
	ItemStack blockInv_slime_item = new ItemStack(Material.GLASS);
	ItemStack block_slime_break = new ItemStack(Material.SLIME_BLOCK);
	ItemStack block_slime_fall = new ItemStack(Material.SLIME_BLOCK);
	ItemStack block_slime_hit = new ItemStack(Material.SLIME_BLOCK);
	ItemStack block_slime_place = new ItemStack(Material.SLIME_BLOCK);
	ItemStack block_slime_step = new ItemStack(Material.SLIME_BLOCK);
	
	public Inventory blockInv_snow = Bukkit.createInventory(null, 9, "Snow Sounds");
	ItemStack blockInv_snow_item = new ItemStack(Material.SNOW_BLOCK);
	ItemStack block_snow_break = new ItemStack(Material.SNOW_BLOCK);
	ItemStack block_snow_fall = new ItemStack(Material.SNOW_BLOCK);
	ItemStack block_snow_hit = new ItemStack(Material.SNOW_BLOCK);
	ItemStack block_snow_place = new ItemStack(Material.SNOW_BLOCK);
	ItemStack block_snow_step = new ItemStack(Material.SNOW_BLOCK);
	
	public Inventory blockInv_stone = Bukkit.createInventory(null, 18, "Glass Sounds");
	ItemStack blockInv_stone_item = new ItemStack(Material.GLASS);
	ItemStack block_stone_break = new ItemStack(Material.STONE);
	ItemStack block_stone_button_click_off = new ItemStack(Material.STONE_BUTTON);
	ItemStack block_stone_button_click_on = new ItemStack(Material.STONE_BUTTON);
	ItemStack block_stone_fall = new ItemStack(Material.STONE);
	ItemStack block_stone_hit = new ItemStack(Material.STONE);
	ItemStack block_stone_place = new ItemStack(Material.STONE);
	ItemStack block_stone_pressureplate_click_off = new ItemStack(Material.STONE_PLATE);
	ItemStack block_stone_pressureplate_click_on = new ItemStack(Material.STONE_PLATE);
	ItemStack block_stone_step = new ItemStack(Material.STONE_PLATE);
	
	public Inventory blockInv_tripwire = Bukkit.createInventory(null, 9, "Tripwire Sounds");
	ItemStack blockInv_tripwire_item = new ItemStack(Material.TRIPWIRE_HOOK);
	ItemStack block_tripwire_attach = new ItemStack(Material.TRIPWIRE_HOOK);
	ItemStack block_tripwire_click_off = new ItemStack(Material.TRIPWIRE_HOOK);
	ItemStack block_tripwire_click_on = new ItemStack(Material.TRIPWIRE_HOOK);
	ItemStack block_tripwire_detach = new ItemStack(Material.TRIPWIRE_HOOK);
	
	public Inventory blockInv_wood = Bukkit.createInventory(null, 18, "Wood Sounds");
	ItemStack blockInv_wood_item = new ItemStack(Material.WOOD);
	ItemStack block_wooden_door_close = new ItemStack(Material.WOOD_DOOR);
	ItemStack block_wooden_door_open = new ItemStack(Material.WOOD_DOOR);
	ItemStack block_wooden_trapdoor_close = new ItemStack(Material.TRAP_DOOR);
	ItemStack block_wooden_trapdoor_open = new ItemStack(Material.TRAP_DOOR);
	ItemStack block_wood_break = new ItemStack(Material.WOOD);
	ItemStack block_wood_button_click_off = new ItemStack(Material.WOOD_BUTTON);
	ItemStack block_wood_button_click_on = new ItemStack(Material.WOOD_BUTTON);
	ItemStack block_wood_fall = new ItemStack(Material.WOOD);
	ItemStack block_wood_hit = new ItemStack(Material.WOOD);
	ItemStack block_wood_place = new ItemStack(Material.WOOD);
	ItemStack block_wood_pressureplate_click_off = new ItemStack(Material.WOOD_PLATE);
	ItemStack block_wood_pressureplate_click_on = new ItemStack(Material.WOOD_PLATE);
	ItemStack block_wood_step = new ItemStack(Material.WOOD_PLATE);	
	
	ItemStack block_brewing_stand_brew = new ItemStack(Material.BREWING_STAND_ITEM);
	ItemStack block_comparator_click = new ItemStack(Material.REDSTONE_COMPARATOR);
	ItemStack block_enchantment_table_use = new ItemStack(Material.ENCHANTMENT_TABLE);
	ItemStack block_lever_click = new ItemStack(Material.LEVER);
	ItemStack block_waterlily_place = new ItemStack(Material.WATER_LILY);
	ItemStack block_water_ambient = new ItemStack(Material.WATER);
	ItemStack block_redstone_torch_burnout = new ItemStack(Material.REDSTONE_TORCH_OFF);
	ItemStack block_furnace_fire_crackle = new ItemStack(Material.BURNING_FURNACE);
	ItemStack block_end_gateway_spawn = new ItemStack(Material.END_GATEWAY);
	
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public final Inventory entityInv = Bukkit.createInventory(null, 54, "Entity Sounds");
	private final ItemStack entityInv_item = new ItemStack(Material.RECORD_9);


    public Inventory entityInv_armorstand = Bukkit.createInventory(null, 9, "Armor Stand Sounds");
    ItemStack entityInv_armorstand_item = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_armorstand_break = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_armorstand_fall = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_armorstand_hit = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_armorstand_place = new ItemStack(Material.ARMOR_STAND);

    public Inventory entityInv_arrow = Bukkit.createInventory(null, 9, "Arrow Sounds");
    ItemStack entityInv_arrow_item = new ItemStack(Material.ARROW);
	ItemStack entity_arrow_hit = new ItemStack(Material.ARROW);
	ItemStack entity_arrow_hit_player = new ItemStack(Material.ARROW);
	ItemStack entity_arrow_shoot = new ItemStack(Material.ARROW);

    public Inventory entityInv_bat = Bukkit.createInventory(null, 9, "Bat Sounds");
    ItemStack entityInv_bat_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	ItemStack entity_bat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	ItemStack entity_bat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	ItemStack entity_bat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	ItemStack entity_bat_loop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	ItemStack entity_bat_takeoff = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);

    public Inventory entityInv_blaze = Bukkit.createInventory(null, 9, "Blaze Sounds");
    ItemStack entityInv_blaze_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	ItemStack entity_blaze_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	ItemStack entity_blaze_burn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	ItemStack entity_blaze_death = new ItemStack(Material.BLAZE_POWDER);
	ItemStack entity_blaze_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	ItemStack entity_blaze_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	
	ItemStack entity_bobber_splash = new ItemStack(Material.FISHING_ROD);
	ItemStack entity_bobber_throw = new ItemStack(Material.FISHING_ROD);

    public Inventory entityInv_cat = Bukkit.createInventory(null, 9, "Cat Sounds");
    ItemStack entityInv_cat_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_hiss = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_purr = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	ItemStack entity_cat_purreow = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);

    public Inventory entityInv_chicken = Bukkit.createInventory(null, 9, "Chicken Sounds");
    ItemStack entityInv_chicken_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	ItemStack entity_chicken_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	ItemStack entity_chicken_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	ItemStack entity_chicken_egg = new ItemStack(Material.EGG);
	ItemStack entity_chicken_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	ItemStack entity_chicken_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);

    public Inventory entityInv_cow = Bukkit.createInventory(null, 9, "Cow Sounds");
    ItemStack entityInv_cow_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	ItemStack entity_cow_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	ItemStack entity_cow_death = new ItemStack(Material.LEATHER);
	ItemStack entity_cow_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	ItemStack entity_cow_milk = new ItemStack(Material.MILK_BUCKET);
	ItemStack entity_cow_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	
	//MAKE GUN POWDER
    public Inventory entityInv_creeper = Bukkit.createInventory(null, 9, "Creeper Sounds");
    ItemStack entityInv_creeper_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	ItemStack entity_creeper_death = new ItemStack(Material.INK_SACK);
	ItemStack entity_creeper_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	ItemStack entity_creeper_primed = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);

    public Inventory entityInv_donkey = Bukkit.createInventory(null, 9, "Donkey Sounds");
    ItemStack entityInv_donkey_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_donkey_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_donkey_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_donkey_chest = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_donkey_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_donkey_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);

    public Inventory entityInv_elder = Bukkit.createInventory(null, 9, "Elder Guardian Sounds");
    ItemStack entityInv_elder_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_curse = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_elder_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);

    public Inventory entityInv_enderdragon = Bukkit.createInventory(null, 9, "Enderdragon Sounds");
    ItemStack entityInv_enderdragon_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_death = new ItemStack(Material.DRAGONS_BREATH);
	ItemStack entity_enderdragon_fireball_explode = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_flap = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_growl = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	ItemStack entity_enderdragon_shoot = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	

    public Inventory entityInv_endermen = Bukkit.createInventory(null, 9, "Endermen Sounds");
    ItemStack entityInv_endermen_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_stare = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	ItemStack entity_endermen_teleport = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);

    public Inventory entityInv_endermite = Bukkit.createInventory(null, 9, "Endermite Sounds");
    ItemStack entityInv_endermite_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	ItemStack entity_endermite_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	ItemStack entity_endermite_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	ItemStack entity_endermite_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	ItemStack entity_endermite_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);



    public Inventory entityInv_experience = Bukkit.createInventory(null, 9, "Experience Sounds");
    ItemStack entityInv_experience_item = new ItemStack(Material.EXP_BOTTLE);
	ItemStack entity_experience_bottle_throw = new ItemStack(Material.EXP_BOTTLE);
	ItemStack entity_experience_orb_pickup = new ItemStack(Material.EXP_BOTTLE);
	ItemStack entity_experience_orb_touch = new ItemStack(Material.EXP_BOTTLE);

    //Make them "cool"
    public Inventory entityInv_firework = Bukkit.createInventory(null, 9, "Firework Sounds");
    ItemStack entityInv_firework_item = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_blast = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_blast_far = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_large_blast = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_large_blast_far = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_launch = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_shoot = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_twinkle = new ItemStack(Material.FIREWORK);
	ItemStack entity_firework_twinkle_far = new ItemStack(Material.FIREWORK);

    public Inventory entityInv_generic = Bukkit.createInventory(null, 18, "Generic Sounds");
    ItemStack entityInv_generic_item = new ItemStack(Material.SAPLING);
	ItemStack entity_generic_big_fall = new ItemStack(Material.DIAMOND_BOOTS);
	ItemStack entity_generic_burn = new ItemStack(Material.FIRE);
	ItemStack entity_generic_death = new ItemStack(Material.STRUCTURE_VOID);
	ItemStack entity_generic_drink = new ItemStack(Material.POTION);
	ItemStack entity_generic_eat = new ItemStack(Material.CAKE);
	ItemStack entity_generic_explode = new ItemStack(Material.TNT);
	ItemStack entity_generic_extinguish_fire = new ItemStack(Material.FIRE);
	ItemStack entity_generic_hurt = new ItemStack(Material.CACTUS);
	ItemStack entity_generic_small_fall = new ItemStack(Material.FEATHER);
	ItemStack entity_generic_splash = new ItemStack(Material.WATER);
	ItemStack entity_generic_swim = new ItemStack(Material.BOAT);

    public Inventory entityInv_ghast = Bukkit.createInventory(null, 9, "Ghast Sounds");
    ItemStack entityInv_ghast_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	ItemStack entity_ghast_warn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);

    public Inventory entityInv_guardian = Bukkit.createInventory(null, 9, "Guardian Sounds");
    ItemStack entityInv_guardian_item = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_flop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	ItemStack entity_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);

    public Inventory entityInv_horse = Bukkit.createInventory(null, 18, "Horese Sounds");
    ItemStack entityInv_horse_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_armor = new ItemStack(Material.DIAMOND_BARDING);
	ItemStack entity_horse_breathe = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_eat = new ItemStack(Material.HAY_BLOCK);
	ItemStack entity_horse_gallop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_saddle = new ItemStack(Material.SADDLE);
	ItemStack entity_horse_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_horse_step_wood = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);

    public Inventory entityInv_hostile = Bukkit.createInventory(null, 9, "Hostile Sounds");
    ItemStack entityInv_hostile_item = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_hostile_big_fall = new ItemStack(Material.DIAMOND_BOOTS);
	ItemStack entity_hostile_death = new ItemStack(Material.STRUCTURE_VOID);
	ItemStack entity_hostile_hurt = new ItemStack(Material.CACTUS);
	ItemStack entity_hostile_small_fall = new ItemStack(Material.FEATHER);
	ItemStack entity_hostile_splash = new ItemStack(Material.WATER);
	ItemStack entity_hostile_swim = new ItemStack(Material.BOAT);

    public Inventory entityInv_husk = Bukkit.createInventory(null, 9, "Husk Sounds");
    ItemStack entityInv_husk_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_husk_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_husk_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_husk_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_husk_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public Inventory entityInv_irongolem = Bukkit.createInventory(null, 9, "Irongolem Sounds");
    ItemStack entityInv_irongolem_item = new ItemStack(Material.RED_ROSE);
	ItemStack entity_irongolem_attack = new ItemStack(Material.RED_ROSE);
	ItemStack entity_irongolem_death = new ItemStack(Material.RED_ROSE);
	ItemStack entity_irongolem_hurt = new ItemStack(Material.RED_ROSE);
	ItemStack entity_irongolem_step = new ItemStack(Material.RED_ROSE);

    public Inventory entityInv_itemframe = Bukkit.createInventory(null, 9, "Item Frame Sounds");
    ItemStack entityInv_itemframe_item = new ItemStack(Material.ARMOR_STAND);
	ItemStack entity_itemframe_add_item = new ItemStack(Material.ITEM_FRAME);
	ItemStack entity_itemframe_break = new ItemStack(Material.ITEM_FRAME);
	ItemStack entity_itemframe_place = new ItemStack(Material.ITEM_FRAME);
	ItemStack entity_itemframe_remove_item = new ItemStack(Material.ITEM_FRAME);
	ItemStack entity_itemframe_rotate_item = new ItemStack(Material.ITEM_FRAME);
	
	//SET DURABILITY LOW
	ItemStack entity_item_break = new ItemStack(Material.DIAMOND_SWORD);
	ItemStack entity_item_pickup = new ItemStack(Material.APPLE);
	
	ItemStack entity_leashknot_break = new ItemStack(Material.LEASH);
	ItemStack entity_leashknot_place = new ItemStack(Material.LEASH);
	
	ItemStack entity_lightning_impact = new ItemStack(Material.END_ROD);
	ItemStack entity_lightning_thunder = new ItemStack(Material.END_ROD);
	
	ItemStack entity_minecart_inside = new ItemStack(Material.MINECART);
	ItemStack entity_minecart_riding = new ItemStack(Material.MINECART);

    //MULE
	ItemStack entity_mule_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_mule_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_mule_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	
	ItemStack entity_painting_break = new ItemStack(Material.PAINTING);
	ItemStack entity_painting_place = new ItemStack(Material.PAINTING);

    public Inventory entityInv_pig = Bukkit.createInventory(null, 9, "Pig Sounds");
    ItemStack entityInv_pig_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	ItemStack entity_pig_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	ItemStack entity_pig_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	ItemStack entity_pig_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	ItemStack entity_pig_saddle = new ItemStack(Material.SADDLE);
	ItemStack entity_pig_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);

    public Inventory entityInv_player = Bukkit.createInventory(null, 18, "Player Sounds");
    ItemStack entityInv_player_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_crit = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_knockback = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_nodamage = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_strong = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_sweep = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_attack_weak = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_big_fall = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_breath = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_burp = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_levelup = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_small_fall = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_splash = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	ItemStack entity_player_swim = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);

    public Inventory entityInv_polarbear = Bukkit.createInventory(null, 9, "Polar Bear Sounds");
    ItemStack entityInv_polarbear_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_baby_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	ItemStack entity_polar_bear_warning = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);

    public Inventory entityInv_rabbit = Bukkit.createInventory(null, 9, "Rabbit Sounds");
    ItemStack entityInv_rabbit_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	ItemStack entity_rabbit_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	ItemStack entity_rabbit_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	ItemStack entity_rabbit_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	ItemStack entity_rabbit_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	ItemStack entity_rabbit_jump = new ItemStack(Material.RABBIT_FOOT);

    public Inventory entityInv_sheep = Bukkit.createInventory(null, 9, "Sheep Sounds");
    ItemStack entityInv_sheep_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	ItemStack entity_sheep_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	ItemStack entity_sheep_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	ItemStack entity_sheep_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	ItemStack entity_sheep_shear = new ItemStack(Material.SHEARS);
	ItemStack entity_sheep_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);

    public Inventory entityInv_shulker = Bukkit.createInventory(null, 18, "Shulker Sounds");
    ItemStack entityInv_shulker_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_bullet_hit = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_bullet_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_close = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_hurt_closed = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_open = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	ItemStack entity_shulker_shoot = new ItemStack(Material.BOW);
	ItemStack entity_shulker_teleport = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public Inventory entityInv_silverfish = Bukkit.createInventory(null, 9, "Silverfish Sounds");
    ItemStack entityInv_silverfish_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	ItemStack entity_silverfish_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	ItemStack entity_silverfish_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	ItemStack entity_silverfish_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	ItemStack entity_silverfish_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);

    public Inventory entityInv_skeleton = Bukkit.createInventory(null, 9, "Skeleton Sounds");
    ItemStack entityInv_skeleton_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_skeleton_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_skeleton_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_skeleton_horse_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_skeleton_horse_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_skeleton_horse_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	ItemStack entity_skeleton_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_skeleton_shoot = new ItemStack(Material.BOW);
	ItemStack entity_skeleton_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public Inventory entityInv_slimes = Bukkit.createInventory(null, 9, "Slime Sounds");
    ItemStack entityInv_slimes_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_slime_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_slime_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_slime_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_slime_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_slime_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	ItemStack entity_small_magmacube_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	ItemStack entity_small_magmacube_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	ItemStack entity_small_magmacube_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	ItemStack entity_small_slime_death = new ItemStack(Material.SLIME_BALL);
	ItemStack entity_small_slime_hurt = new ItemStack(Material.SLIME_BALL);
	ItemStack entity_small_slime_jump = new ItemStack(Material.SLIME_BALL);
	ItemStack entity_small_slime_squish = new ItemStack(Material.SLIME_BALL);
    ItemStack entity_magmacube_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    ItemStack entity_magmacube_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    ItemStack entity_magmacube_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    ItemStack entity_magmacube_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);

    public Inventory entityInv_snowman = Bukkit.createInventory(null, 9, "Snowman Sounds");
    ItemStack entityInv_snowman_item = new ItemStack(Material.PUMPKIN);
	ItemStack entity_snowman_ambient = new ItemStack(Material.PUMPKIN);
	ItemStack entity_snowman_death = new ItemStack(Material.PUMPKIN);
	ItemStack entity_snowman_hurt = new ItemStack(Material.PUMPKIN);
	ItemStack entity_snowman_shoot = new ItemStack(Material.SNOW_BALL);

    public Inventory entityInv_spider = Bukkit.createInventory(null, 9, "Spider Sounds");
    ItemStack entityInv_spider_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	ItemStack entity_spider_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	ItemStack entity_spider_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	ItemStack entity_spider_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	ItemStack entity_spider_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);


    public Inventory entityInv_squid = Bukkit.createInventory(null, 9, "Squid Sounds");
    ItemStack entityInv_squid_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	ItemStack entity_squid_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	ItemStack entity_squid_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	ItemStack entity_squid_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);

    public Inventory entityInv_stray = Bukkit.createInventory(null, 9, "Stray Sounds");
    ItemStack entityInv_stray_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_stray_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_stray_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_stray_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	ItemStack entity_stray_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	

    public Inventory entityInv_villager = Bukkit.createInventory(null, 9, "Villager Sounds");
    ItemStack entityInv_villager_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_no = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_trading = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	ItemStack entity_villager_yes = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	
	//CHANGE POTION TYPE
    public Inventory entityInv_witch = Bukkit.createInventory(null, 9, "Witch Sounds");
    ItemStack entityInv_witch_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	ItemStack entity_witch_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	ItemStack entity_witch_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	ItemStack entity_witch_drink = new ItemStack(Material.POTION);
	ItemStack entity_witch_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	ItemStack entity_witch_throw = new ItemStack(Material.SPLASH_POTION);

    //
    public Inventory entityInv_wither = Bukkit.createInventory(null, 18, "Wither Sounds");
    ItemStack entityInv_wither_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_break_block = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_shoot = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_skeleton_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_skeleton_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_skeleton_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_skeleton_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	ItemStack entity_wither_spawn = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);

    public Inventory entityInv_wolf = Bukkit.createInventory(null, 18, "Wolf Sounds");
    ItemStack entityInv_wolf_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_growl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_howl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_pant = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_shake = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	ItemStack entity_wolf_whine = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);

    public Inventory entityInv_zombie = Bukkit.createInventory(null, 27, "Zombie Sounds");
    ItemStack entityInv_zombie_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_attack_door_wood = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_attack_iron_door = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_break_door_wood = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_horse_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_horse_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_horse_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_infect = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_pig_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	ItemStack entity_zombie_pig_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	ItemStack entity_zombie_pig_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	ItemStack entity_zombie_pig_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	ItemStack entity_zombie_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_converted = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_cure = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	ItemStack entity_zombie_villager_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);

    ItemStack entity_tnt_primed = new ItemStack(Material.TNT);
    ItemStack entity_splash_potion_break = new ItemStack(Material.SPLASH_POTION);
    ItemStack entity_splash_potion_throw = new ItemStack(Material.SPLASH_POTION);
    ItemStack entity_endereye_launch = new ItemStack(Material.EYE_OF_ENDER);
    ItemStack entity_lingeringpotion_throw = new ItemStack(Material.LINGERING_POTION);
    ItemStack entity_egg_throw = new ItemStack(Material.EGG);
    ItemStack entity_enderpearl_throw = new ItemStack(Material.ENDER_PEARL);
    ItemStack entity_mooshroom_shear = new ItemStack(Material.MONSTER_EGG, 1, (byte) 96);
    ItemStack entity_snowball_throw = new ItemStack(Material.SNOW_BALL);

	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public final Inventory itemInv = Bukkit.createInventory(null, 54, "Item Sounds");
	private final ItemStack itemInv_item = new ItemStack(Material.RECORD_4);
	
	ItemStack item_armor_equip_chain = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	ItemStack item_armor_equip_diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemStack item_armor_equip_generic = new ItemStack(Material.LEATHER);
	ItemStack item_armor_equip_gold = new ItemStack(Material.GOLD_CHESTPLATE);
	ItemStack item_armor_equip_iron = new ItemStack(Material.IRON_CHESTPLATE);
	ItemStack item_armor_equip_leather = new ItemStack(Material.LEATHER_CHESTPLATE);
	
	ItemStack item_bottle_fill = new ItemStack(Material.POTION);
	ItemStack item_bottle_fill_dragonbreath = new ItemStack(Material.DRAGONS_BREATH);
	
	ItemStack item_bucket_empty = new ItemStack(Material.BUCKET);
	ItemStack item_bucket_empty_lava = new ItemStack(Material.BUCKET);
	ItemStack item_bucket_fill = new ItemStack(Material.LAVA_BUCKET);
	ItemStack item_bucket_fill_lava = new ItemStack(Material.LAVA_BUCKET);
	
	ItemStack item_chorus_fruit_teleport = new ItemStack(Material.CHORUS_FRUIT_POPPED);
	
	ItemStack item_elytra_flying = new ItemStack(Material.ELYTRA);
	
	ItemStack item_firecharge_use = new ItemStack(Material.FIREBALL);
	
	ItemStack item_flintandsteel_use = new ItemStack(Material.FLINT_AND_STEEL);
	
	ItemStack item_hoe_till = new ItemStack(Material.DIAMOND_HOE);
	
	ItemStack item_shield_block = new ItemStack(Material.SHIELD);
	
	ItemStack item_shield_break = new ItemStack(Material.SHIELD);
	
	ItemStack item_shovel_flatten = new ItemStack(Material.DIAMOND_SPADE);
	
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public final Inventory songInv = Bukkit.createInventory(null, 54, "Music Sounds");
	private final ItemStack songInv_item = new ItemStack(Material.GOLD_RECORD);
	ItemStack music_creative = new ItemStack(Material.JUKEBOX);
	ItemStack music_credits = new ItemStack(Material.JUKEBOX);
	ItemStack music_dragon = new ItemStack(Material.JUKEBOX);
	ItemStack music_end = new ItemStack(Material.JUKEBOX);
	ItemStack music_game = new ItemStack(Material.JUKEBOX);
	ItemStack music_menu = new ItemStack(Material.JUKEBOX);
	ItemStack music_nether = new ItemStack(Material.JUKEBOX);

	ItemStack record_11 = new ItemStack(Material.RECORD_11);
	ItemStack record_13 = new ItemStack(Material.GOLD_RECORD);
	ItemStack record_blocks = new ItemStack(Material.RECORD_3);
	ItemStack record_cat = new ItemStack(Material.GREEN_RECORD);
	ItemStack record_chirp = new ItemStack(Material.RECORD_4);
	ItemStack record_far = new ItemStack(Material.RECORD_5);
	ItemStack record_mall = new ItemStack(Material.RECORD_6);
	ItemStack record_mellohi = new ItemStack(Material.RECORD_7);
	ItemStack record_stal = new ItemStack(Material.RECORD_8);
	ItemStack record_strad = new ItemStack(Material.RECORD_9);
	ItemStack record_wait = new ItemStack(Material.RECORD_12);
	ItemStack record_ward = new ItemStack(Material.RECORD_10);
	
	
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public final Inventory miscInv = Bukkit.createInventory(null, 9, "Misc Sounds");
	private final ItemStack miscInv_item = new ItemStack(Material.RECORD_12);
	//WEATHER
	ItemStack weather_rain = new ItemStack(Material.WATER_BUCKET);
	ItemStack weather_rain_above = new ItemStack(Material.WATER_BUCKET);
	//UI
	ItemStack ui_button_click = new ItemStack(Material.STONE_BUTTON);
	//MAKE IT THORNS
	ItemStack enchant_thorns_hit = new ItemStack(Material.ENCHANTED_BOOK);
	//AMBIENT
	ItemStack ambient_cave = new ItemStack(Material.STONE);
	/////////////////////////////////////////////////////////////////////////
	
	public final Inventory catselect = Bukkit.createInventory(null, 9, "Select Category");
	
	final ItemStack backbutton_item = new ItemStack(Material.STONE_BUTTON);
	private final ItemStack reset_item = new ItemStack(Material.TNT);

    public void loadInventory(Player p) {

        UserData user = new UserData(p, wc);

        boolean jse = user.isJoinSoundEnabled();
        int jsv = user.getJoinSoundVolume();
        int jsp = user.getJoinSoundPitch();

        boolean qse = user.isQuitSoundEnabled();
        int qsv = user.getQuitSoundVolume();
        int qsp = user.getQuitSoundPitch();

        boolean mse = user.isMessageSoundEnabled();
        int msv = user.getMessageSoundVolume();
        int msp = user.getMessageSoundPitch();
		
		ItemStack jsi = new ItemStack(Material.NOTE_BLOCK);
		ItemStack jsei = new ItemStack(Material.WOOL, 1);
		ItemStack jsvi = new ItemStack(Material.WOOL, jsv);
		ItemStack jspi = new ItemStack(Material.WOOL, jsp);
		
		ItemStack qsi = new ItemStack(Material.NOTE_BLOCK);
		ItemStack qsei = new ItemStack(Material.WOOL, 1);
		ItemStack qsvi = new ItemStack(Material.WOOL, qsv);
		ItemStack qspi = new ItemStack(Material.WOOL, qsp);
		
		ItemStack msi = new ItemStack(Material.NOTE_BLOCK);
		ItemStack msei = new ItemStack(Material.WOOL, 1);
		ItemStack msvi = new ItemStack(Material.WOOL, msv);
		ItemStack mspi = new ItemStack(Material.WOOL, msp);
		
		
		blockInv.setItem(53, backbutton_item);
		entityInv.setItem(53, backbutton_item);
		itemInv.setItem(53, backbutton_item);
		songInv.setItem(53, backbutton_item);
		miscInv.setItem(8, backbutton_item);
		
		ArrayList<String> ctt = new ArrayList<>();
		ctt.add(ChatColor.WHITE + "Click to toggle");
		
		ArrayList<String> cts = new ArrayList<>();
		cts.add(ChatColor.WHITE + "Click to select");
		
		ArrayList<String> lcrc = new ArrayList<>();
		lcrc.add(ChatColor.WHITE + "Left click +1");
		lcrc.add(ChatColor.WHITE + "Right click -1");
		
		ArrayList<String> ctvas = new ArrayList<>();
		ctvas.add(ChatColor.WHITE + "click to view");
		ctvas.add(ChatColor.WHITE + "all sounds");
		
		ArrayList<String> ls = new ArrayList<>();
		ls.add(ChatColor.WHITE + "Left click to select");
		ls.add(ChatColor.WHITE + "Right click to listen");
		
		
		ItemMeta jsm = jsi.getItemMeta();
		ItemMeta jsem = jsei.getItemMeta();
		ItemMeta jsvm = jsvi.getItemMeta();
		ItemMeta jspm = jspi.getItemMeta();
		
		ItemMeta qsm = qsi.getItemMeta();
		ItemMeta qsem = qsei.getItemMeta();
		ItemMeta qsvm = qsvi.getItemMeta();
		ItemMeta qspm = qspi.getItemMeta();
		
		ItemMeta msm = msi.getItemMeta();
		ItemMeta msem = msei.getItemMeta();
		ItemMeta msvm = msvi.getItemMeta();
		ItemMeta mspm = mspi.getItemMeta();
		
		ItemMeta blockInv_meta = blockInv_item.getItemMeta();
		ItemMeta entityInv_meta = entityInv_item.getItemMeta();
		ItemMeta itemInv_meta = itemInv_item.getItemMeta();
		ItemMeta songInv_meta = songInv_item.getItemMeta();
		ItemMeta miscInv_meta = miscInv_item.getItemMeta();
		
		ItemMeta reset_meta = reset_item.getItemMeta();
		ItemMeta backbutton_meta = backbutton_item.getItemMeta();
		
		jsm.setDisplayName(ChatColor.AQUA + "Join Sound");
		jsem.setDisplayName(ChatColor.GREEN + "Player Join");
		jsvm.setDisplayName(ChatColor.AQUA + "Join Volume");
		jspm.setDisplayName(ChatColor.AQUA + "Join Pitch");
		
		qsm.setDisplayName(ChatColor.AQUA + "Quit Sound");
		qsem.setDisplayName(ChatColor.GREEN + "Player Quit");
		qsvm.setDisplayName(ChatColor.AQUA + "Quit Volume");
		qspm.setDisplayName(ChatColor.AQUA + "Quit Pitch");
		
		msm.setDisplayName(ChatColor.AQUA + "Message Sound");
		msem.setDisplayName(ChatColor.GREEN + "Player Message");
		msvm.setDisplayName(ChatColor.AQUA + "Message Volume");
		mspm.setDisplayName(ChatColor.AQUA + "Message Pitch");
		
		reset_meta.setDisplayName(ChatColor.RED + "Reset Settings");
		
		blockInv_meta.setDisplayName(ChatColor.AQUA + "Block Sounds");
		entityInv_meta.setDisplayName(ChatColor.AQUA + "Entity Sounds");
		itemInv_meta.setDisplayName(ChatColor.AQUA + "Item Sounds");
		songInv_meta.setDisplayName(ChatColor.AQUA + "Song Sounds");
		miscInv_meta.setDisplayName(ChatColor.AQUA + "Misc Sounds");
		backbutton_meta.setDisplayName(ChatColor.RED + "Click to go back");
		
		jsm.setLore(cts);
		jsem.setLore(ctt);
		jsvm.setLore(lcrc);
		jspm.setLore(lcrc);
		
		qsm.setLore(cts);
		qsem.setLore(ctt);
		qsvm.setLore(lcrc);
		qspm.setLore(lcrc);
		
		msm.setLore(cts);
		msem.setLore(ctt);
		msvm.setLore(lcrc);
		mspm.setLore(lcrc);
		
		itemInv_meta.setLore(ctvas);
		itemInv_meta.addItemFlags(ItemFlag.values());
		blockInv_meta.setLore(ctvas);
		blockInv_meta.addItemFlags(ItemFlag.values());
		entityInv_meta.setLore(ctvas);
		entityInv_meta.addItemFlags(ItemFlag.values());
		songInv_meta.setLore(ctvas);
		songInv_meta.addItemFlags(ItemFlag.values());
		miscInv_meta.setLore(ctvas);
		miscInv_meta.addItemFlags(ItemFlag.values());
		
		enabled(jse, jsei);
		enabled(qse, qsei);	
		enabled(mse, msei);
		
		jsi.setItemMeta(jsm);
		jsei.setItemMeta(jsem);
		jsvi.setItemMeta(jsvm);
		jspi.setItemMeta(jspm);
		
		qsi.setItemMeta(qsm);
		qsei.setItemMeta(qsem);
		qsvi.setItemMeta(qsvm);
		qspi.setItemMeta(qspm);
		
		msi.setItemMeta(msm);
		msei.setItemMeta(msem);
		msvi.setItemMeta(msvm);
		mspi.setItemMeta(mspm);
		
		reset_item.setItemMeta(reset_meta);
		blockInv_item.setItemMeta(blockInv_meta);
		entityInv_item.setItemMeta(entityInv_meta);
		itemInv_item.setItemMeta(itemInv_meta);
		songInv_item.setItemMeta(songInv_meta);
		miscInv_item.setItemMeta(miscInv_meta);
		backbutton_item.setItemMeta(backbutton_meta);
		
		soundInv.setItem(11, jsi); 
		soundInv.setItem(12, jsei);
		soundInv.setItem(14, jsvi); 
		soundInv.setItem(15, jspi);
		
		soundInv.setItem(20, qsi); 
		soundInv.setItem(21, qsei);
		soundInv.setItem(23, qsvi); 
		soundInv.setItem(24, qspi);
		
		soundInv.setItem(29, msi); 
		soundInv.setItem(30, msei);
		soundInv.setItem(32, msvi); 
		soundInv.setItem(33, mspi);
		
		soundInv.setItem(44, reset_item);
		
		catselect.setItem(0, blockInv_item);
		catselect.setItem(1, entityInv_item);
		catselect.setItem(2, itemInv_item);
		catselect.setItem(3, songInv_item);
		catselect.setItem(4, miscInv_item);
		catselect.setItem(8, backbutton_item);
		
		p.openInventory(soundInv);
	}
	
	private void enabled(boolean b, ItemStack i) {
		if (b) {
            WinterCraftUtil.setWoolColor(i, DyeColor.LIME);
		} else {
			WinterCraftUtil.setWoolColor(i, DyeColor.WHITE);
		}
	}
}
