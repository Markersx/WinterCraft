package net.mcwintercraft.wintercraft.chatsounds;

import net.mcwintercraft.wintercraft.UserData;
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

public class ChatSoundsInventory extends UserData {
	
	public static final Inventory soundInv = Bukkit.createInventory(null, 45, "Sound Options");
	
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static final Inventory blockInv = Bukkit.createInventory(null, 54, "Block Sounds");
	private static final ItemStack blockInv_item = new ItemStack(Material.RECORD_8);
	
	public static Inventory blockInv_anvil = Bukkit.createInventory(null, 9, "Anvil Sounds");
	static ItemStack blockInv_anvil_item = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_break = new ItemStack(Material.ANVIL, 1, (byte) 2);
	static ItemStack block_anvil_destroy = new ItemStack(Material.ANVIL, 1, (byte) 1);
	static ItemStack block_anvil_fall = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_hit = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_land = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_place = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_step = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_use = new ItemStack(Material.ANVIL);
	
	public static Inventory blockInv_chest = Bukkit.createInventory(null, 9, "Chest Sounds");
	static ItemStack blockInv_chest_item = new ItemStack(Material.CHEST);
	static ItemStack block_chest_close = new ItemStack(Material.CHEST);
	static ItemStack block_chest_locked = new ItemStack(Material.TRAPPED_CHEST);
	static ItemStack block_chest_open = new ItemStack(Material.CHEST);
	
	static ItemStack block_chorus_flower_death = new ItemStack(Material.CHORUS_FLOWER);
	static ItemStack block_chorus_flower_grow = new ItemStack(Material.CHORUS_FRUIT_POPPED);
	
	public static Inventory blockInv_cloth = Bukkit.createInventory(null, 9, "Wool Sounds");
	static ItemStack blockInv_cloth_item = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_break = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_fall = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_hit = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_place = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_step = new ItemStack(Material.WOOL);
	
	public static Inventory blockInv_dispenser = Bukkit.createInventory(null, 9, "Dispenser Sounds");
	static ItemStack blockInv_dispenser_item = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_dispense = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_fail = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_launch = new ItemStack(Material.DISPENSER);
	
	static ItemStack block_enderchest_close = new ItemStack(Material.ENDER_CHEST);
	static ItemStack block_enderchest_open = new ItemStack(Material.ENDER_CHEST);

	static ItemStack block_fence_gate_close = new ItemStack(Material.FENCE_GATE);
	static ItemStack block_fence_gate_open = new ItemStack(Material.FENCE_GATE);
	
	static ItemStack block_fire_ambient = new ItemStack(Material.FIRE);
	static ItemStack block_fire_extinguish = new ItemStack(Material.FIRE);
	
	public static Inventory blockInv_glass = Bukkit.createInventory(null, 9, "Glass Sounds");
	static ItemStack blockInv_glass_item = new ItemStack(Material.GLASS);
	static ItemStack block_glass_break = new ItemStack(Material.GLASS);
	static ItemStack block_glass_fall = new ItemStack(Material.GLASS);
	static ItemStack block_glass_hit = new ItemStack(Material.GLASS);
	static ItemStack block_glass_place = new ItemStack(Material.GLASS);
	static ItemStack block_glass_step = new ItemStack(Material.GLASS);
	
	public static Inventory blockInv_grass = Bukkit.createInventory(null, 9, "Grass Sounds");
	static ItemStack blockInv_grass_item = new ItemStack(Material.GRASS);
	static ItemStack block_grass_break = new ItemStack(Material.GRASS);
	static ItemStack block_grass_fall = new ItemStack(Material.GRASS);
	static ItemStack block_grass_hit = new ItemStack(Material.GRASS);
	static ItemStack block_grass_place = new ItemStack(Material.GRASS);
	static ItemStack block_grass_step = new ItemStack(Material.GRASS);
	
	public static Inventory blockInv_gravel = Bukkit.createInventory(null, 9, "Gravel Sounds");
	static ItemStack blockInv_gravel_item = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_break = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_fall = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_hit = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_place = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_step = new ItemStack(Material.GRAVEL);
	
	public static Inventory blockInv_iron = Bukkit.createInventory(null, 18, "Iron Sounds");
	static ItemStack blockInv_iron_item = new ItemStack(Material.IRON_BLOCK);
	static ItemStack block_iron_door_close = new ItemStack(Material.IRON_DOOR);
	static ItemStack block_iron_door_open = new ItemStack(Material.IRON_DOOR);
	static ItemStack block_iron_trapdoor_close = new ItemStack(Material.IRON_TRAPDOOR);
	static ItemStack block_iron_trapdoor_open = new ItemStack(Material.IRON_TRAPDOOR);
	static ItemStack block_metal_break = new ItemStack(Material.IRON_BLOCK);
	static ItemStack block_metal_fall = new ItemStack(Material.IRON_BLOCK);
	static ItemStack block_metal_hit = new ItemStack(Material.IRON_BLOCK);
	static ItemStack block_metal_place = new ItemStack(Material.IRON_BLOCK);
	static ItemStack block_metal_pressureplate_click_off = new ItemStack(Material.IRON_PLATE);
	static ItemStack block_metal_pressureplate_click_on = new ItemStack(Material.IRON_PLATE);
	static ItemStack block_metal_step = new ItemStack(Material.IRON_PLATE);
	
	public static Inventory blockInv_ladder = Bukkit.createInventory(null, 9, "Ladder Sounds");
	static ItemStack blockInv_ladder_item = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_break = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_fall = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_hit = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_place = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_step = new ItemStack(Material.LADDER);
	
	static ItemStack block_lava_ambient = new ItemStack(Material.LAVA);
	static ItemStack block_lava_extinguish = new ItemStack(Material.LAVA);
	static ItemStack block_lava_pop = new ItemStack(Material.LAVA);
	
	public static Inventory blockInv_note = Bukkit.createInventory(null, 9, "Note Sounds");
	static ItemStack blockInv_note_item = new ItemStack(Material.GLASS);
	static ItemStack block_note_basedrum = new ItemStack(Material.NOTE_BLOCK);
	static ItemStack block_note_bass = new ItemStack(Material.NOTE_BLOCK);
	static ItemStack block_note_harp = new ItemStack(Material.NOTE_BLOCK);
	static ItemStack block_note_hat = new ItemStack(Material.NOTE_BLOCK);
	static ItemStack block_note_pling = new ItemStack(Material.NOTE_BLOCK);
	static ItemStack block_note_snare = new ItemStack(Material.NOTE_BLOCK);
	
	static ItemStack block_piston_contract = new ItemStack(Material.PISTON_BASE);
	static ItemStack block_piston_extend = new ItemStack(Material.PISTON_EXTENSION);
	
	static ItemStack block_portal_ambient = new ItemStack(Material.PORTAL);
	static ItemStack block_portal_travel = new ItemStack(Material.PORTAL);
	static ItemStack block_portal_trigger = new ItemStack(Material.PORTAL);
	
	public static Inventory blockInv_sand = Bukkit.createInventory(null, 9, "Sand Sounds");
	static ItemStack blockInv_sand_item = new ItemStack(Material.SAND);
	static ItemStack block_sand_break = new ItemStack(Material.SAND);
	static ItemStack block_sand_fall = new ItemStack(Material.SAND);
	static ItemStack block_sand_hit = new ItemStack(Material.SAND);
	static ItemStack block_sand_place = new ItemStack(Material.SAND);
	static ItemStack block_sand_step = new ItemStack(Material.SAND);
	
	public static Inventory blockInv_slime = Bukkit.createInventory(null, 9, "Slime Sounds");
	static ItemStack blockInv_slime_item = new ItemStack(Material.GLASS);
	static ItemStack block_slime_break = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_fall = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_hit = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_place = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_step = new ItemStack(Material.SLIME_BLOCK);
	
	public static Inventory blockInv_snow = Bukkit.createInventory(null, 9, "Snow Sounds");
	static ItemStack blockInv_snow_item = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_break = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_fall = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_hit = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_place = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_step = new ItemStack(Material.SNOW_BLOCK);
	
	public static Inventory blockInv_stone = Bukkit.createInventory(null, 18, "Glass Sounds");
	static ItemStack blockInv_stone_item = new ItemStack(Material.GLASS);
	static ItemStack block_stone_break = new ItemStack(Material.STONE);
	static ItemStack block_stone_button_click_off = new ItemStack(Material.STONE_BUTTON);
	static ItemStack block_stone_button_click_on = new ItemStack(Material.STONE_BUTTON);
	static ItemStack block_stone_fall = new ItemStack(Material.STONE);
	static ItemStack block_stone_hit = new ItemStack(Material.STONE);
	static ItemStack block_stone_place = new ItemStack(Material.STONE);
	static ItemStack block_stone_pressureplate_click_off = new ItemStack(Material.STONE_PLATE);
	static ItemStack block_stone_pressureplate_click_on = new ItemStack(Material.STONE_PLATE);
	static ItemStack block_stone_step = new ItemStack(Material.STONE_PLATE);
	
	public static Inventory blockInv_tripwire = Bukkit.createInventory(null, 9, "Tripwire Sounds");
	static ItemStack blockInv_tripwire_item = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_attach = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_click_off = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_click_on = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_detach = new ItemStack(Material.TRIPWIRE_HOOK);
	
	public static Inventory blockInv_wood = Bukkit.createInventory(null, 18, "Wood Sounds");
	static ItemStack blockInv_wood_item = new ItemStack(Material.WOOD);
	static ItemStack block_wooden_door_close = new ItemStack(Material.WOOD_DOOR);
	static ItemStack block_wooden_door_open = new ItemStack(Material.WOOD_DOOR);
	static ItemStack block_wooden_trapdoor_close = new ItemStack(Material.TRAP_DOOR);
	static ItemStack block_wooden_trapdoor_open = new ItemStack(Material.TRAP_DOOR);
	static ItemStack block_wood_break = new ItemStack(Material.WOOD);
	static ItemStack block_wood_button_click_off = new ItemStack(Material.WOOD_BUTTON);
	static ItemStack block_wood_button_click_on = new ItemStack(Material.WOOD_BUTTON);
	static ItemStack block_wood_fall = new ItemStack(Material.WOOD);
	static ItemStack block_wood_hit = new ItemStack(Material.WOOD);
	static ItemStack block_wood_place = new ItemStack(Material.WOOD);
	static ItemStack block_wood_pressureplate_click_off = new ItemStack(Material.WOOD_PLATE);
	static ItemStack block_wood_pressureplate_click_on = new ItemStack(Material.WOOD_PLATE);
	static ItemStack block_wood_step = new ItemStack(Material.WOOD_PLATE);	
	
	static ItemStack block_brewing_stand_brew = new ItemStack(Material.BREWING_STAND_ITEM);
	static ItemStack block_comparator_click = new ItemStack(Material.REDSTONE_COMPARATOR);
	static ItemStack block_enchantment_table_use = new ItemStack(Material.ENCHANTMENT_TABLE);
	static ItemStack block_lever_click = new ItemStack(Material.LEVER);
	static ItemStack block_waterlily_place = new ItemStack(Material.WATER_LILY);
	static ItemStack block_water_ambient = new ItemStack(Material.WATER);
	static ItemStack block_redstone_torch_burnout = new ItemStack(Material.REDSTONE_TORCH_OFF);
	static ItemStack block_furnace_fire_crackle = new ItemStack(Material.BURNING_FURNACE);
	static ItemStack block_end_gateway_spawn = new ItemStack(Material.END_GATEWAY);
	
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ENTITY\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static final Inventory entityInv = Bukkit.createInventory(null, 54, "Entity Sounds");
	private static final ItemStack entityInv_item = new ItemStack(Material.RECORD_9);


    public static Inventory entityInv_armorstand = Bukkit.createInventory(null, 9, "Armor Stand Sounds");
    static ItemStack entityInv_armorstand_item = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_break = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_fall = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_hit = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_place = new ItemStack(Material.ARMOR_STAND);

    public static Inventory entityInv_arrow = Bukkit.createInventory(null, 9, "Arrow Sounds");
    static ItemStack entityInv_arrow_item = new ItemStack(Material.ARROW);
	static ItemStack entity_arrow_hit = new ItemStack(Material.ARROW);
	static ItemStack entity_arrow_hit_player = new ItemStack(Material.ARROW);
	static ItemStack entity_arrow_shoot = new ItemStack(Material.ARROW);

    public static Inventory entityInv_bat = Bukkit.createInventory(null, 9, "Bat Sounds");
    static ItemStack entityInv_bat_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_loop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_takeoff = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);

    public static Inventory entityInv_blaze = Bukkit.createInventory(null, 9, "Blaze Sounds");
    static ItemStack entityInv_blaze_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_burn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_death = new ItemStack(Material.BLAZE_POWDER);
	static ItemStack entity_blaze_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	
	static ItemStack entity_bobber_splash = new ItemStack(Material.FISHING_ROD);
	static ItemStack entity_bobber_throw = new ItemStack(Material.FISHING_ROD);

    public static Inventory entityInv_cat = Bukkit.createInventory(null, 9, "Cat Sounds");
    static ItemStack entityInv_cat_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_hiss = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_purr = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_purreow = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);

    public static Inventory entityInv_chicken = Bukkit.createInventory(null, 9, "Chicken Sounds");
    static ItemStack entityInv_chicken_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_egg = new ItemStack(Material.EGG);
	static ItemStack entity_chicken_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);

    public static Inventory entityInv_cow = Bukkit.createInventory(null, 9, "Cow Sounds");
    static ItemStack entityInv_cow_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	static ItemStack entity_cow_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	static ItemStack entity_cow_death = new ItemStack(Material.LEATHER);
	static ItemStack entity_cow_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	static ItemStack entity_cow_milk = new ItemStack(Material.MILK_BUCKET);
	static ItemStack entity_cow_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	
	//MAKE GUN POWDER
    public static Inventory entityInv_creeper = Bukkit.createInventory(null, 9, "Creeper Sounds");
    static ItemStack entityInv_creeper_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	static ItemStack entity_creeper_death = new ItemStack(Material.INK_SACK);
	static ItemStack entity_creeper_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	static ItemStack entity_creeper_primed = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);

    public static Inventory entityInv_donkey = Bukkit.createInventory(null, 9, "Donkey Sounds");
    static ItemStack entityInv_donkey_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_chest = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);

    public static Inventory entityInv_elder = Bukkit.createInventory(null, 9, "Elder Guardian Sounds");
    static ItemStack entityInv_elder_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_curse = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);

    public static Inventory entityInv_enderdragon = Bukkit.createInventory(null, 9, "Enderdragon Sounds");
    static ItemStack entityInv_enderdragon_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_death = new ItemStack(Material.DRAGONS_BREATH);
	static ItemStack entity_enderdragon_fireball_explode = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_flap = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_growl = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_shoot = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	

    public static Inventory entityInv_endermen = Bukkit.createInventory(null, 9, "Endermen Sounds");
    static ItemStack entityInv_endermen_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_stare = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_teleport = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);

    public static Inventory entityInv_endermite = Bukkit.createInventory(null, 9, "Endermite Sounds");
    static ItemStack entityInv_endermite_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);



    public static Inventory entityInv_experience = Bukkit.createInventory(null, 9, "Experience Sounds");
    static ItemStack entityInv_experience_item = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_bottle_throw = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_orb_pickup = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_orb_touch = new ItemStack(Material.EXP_BOTTLE);

    //Make them "cool"
    public static Inventory entityInv_firework = Bukkit.createInventory(null, 9, "Firework Sounds");
    static ItemStack entityInv_firework_item = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_blast = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_blast_far = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_large_blast = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_large_blast_far = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_launch = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_shoot = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_twinkle = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_twinkle_far = new ItemStack(Material.FIREWORK);

    public static Inventory entityInv_generic = Bukkit.createInventory(null, 18, "Generic Sounds");
    static ItemStack entityInv_generic_item = new ItemStack(Material.SAPLING);
	static ItemStack entity_generic_big_fall = new ItemStack(Material.DIAMOND_BOOTS);
	static ItemStack entity_generic_burn = new ItemStack(Material.FIRE);
	static ItemStack entity_generic_death = new ItemStack(Material.STRUCTURE_VOID);
	static ItemStack entity_generic_drink = new ItemStack(Material.POTION);
	static ItemStack entity_generic_eat = new ItemStack(Material.CAKE);
	static ItemStack entity_generic_explode = new ItemStack(Material.TNT);
	static ItemStack entity_generic_extinguish_fire = new ItemStack(Material.FIRE);
	static ItemStack entity_generic_hurt = new ItemStack(Material.CACTUS);
	static ItemStack entity_generic_small_fall = new ItemStack(Material.FEATHER);
	static ItemStack entity_generic_splash = new ItemStack(Material.WATER);
	static ItemStack entity_generic_swim = new ItemStack(Material.BOAT);

    public static Inventory entityInv_ghast = Bukkit.createInventory(null, 9, "Ghast Sounds");
    static ItemStack entityInv_ghast_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_warn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);

    public static Inventory entityInv_guardian = Bukkit.createInventory(null, 9, "Guardian Sounds");
    static ItemStack entityInv_guardian_item = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_flop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);

    public static Inventory entityInv_horse = Bukkit.createInventory(null, 18, "Horese Sounds");
    static ItemStack entityInv_horse_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_armor = new ItemStack(Material.DIAMOND_BARDING);
	static ItemStack entity_horse_breathe = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_eat = new ItemStack(Material.HAY_BLOCK);
	static ItemStack entity_horse_gallop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_saddle = new ItemStack(Material.SADDLE);
	static ItemStack entity_horse_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_horse_step_wood = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);

    public static Inventory entityInv_hostile = Bukkit.createInventory(null, 9, "Hostile Sounds");
    static ItemStack entityInv_hostile_item = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_hostile_big_fall = new ItemStack(Material.DIAMOND_BOOTS);
	static ItemStack entity_hostile_death = new ItemStack(Material.STRUCTURE_VOID);
	static ItemStack entity_hostile_hurt = new ItemStack(Material.CACTUS);
	static ItemStack entity_hostile_small_fall = new ItemStack(Material.FEATHER);
	static ItemStack entity_hostile_splash = new ItemStack(Material.WATER);
	static ItemStack entity_hostile_swim = new ItemStack(Material.BOAT);

    public static Inventory entityInv_husk = Bukkit.createInventory(null, 9, "Husk Sounds");
    static ItemStack entityInv_husk_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public static Inventory entityInv_irongolem = Bukkit.createInventory(null, 9, "Irongolem Sounds");
    static ItemStack entityInv_irongolem_item = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_attack = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_death = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_hurt = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_step = new ItemStack(Material.RED_ROSE);

    public static Inventory entityInv_itemframe = Bukkit.createInventory(null, 9, "Item Frame Sounds");
    static ItemStack entityInv_itemframe_item = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_itemframe_add_item = new ItemStack(Material.ITEM_FRAME);
	static ItemStack entity_itemframe_break = new ItemStack(Material.ITEM_FRAME);
	static ItemStack entity_itemframe_place = new ItemStack(Material.ITEM_FRAME);
	static ItemStack entity_itemframe_remove_item = new ItemStack(Material.ITEM_FRAME);
	static ItemStack entity_itemframe_rotate_item = new ItemStack(Material.ITEM_FRAME);
	
	//SET DURABILITY LOW
	static ItemStack entity_item_break = new ItemStack(Material.DIAMOND_SWORD);
	static ItemStack entity_item_pickup = new ItemStack(Material.APPLE);
	
	static ItemStack entity_leashknot_break = new ItemStack(Material.LEASH);
	static ItemStack entity_leashknot_place = new ItemStack(Material.LEASH);
	
	static ItemStack entity_lightning_impact = new ItemStack(Material.END_ROD);
	static ItemStack entity_lightning_thunder = new ItemStack(Material.END_ROD);
	
	static ItemStack entity_minecart_inside = new ItemStack(Material.MINECART);
	static ItemStack entity_minecart_riding = new ItemStack(Material.MINECART);

    //MULE
	static ItemStack entity_mule_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_mule_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_mule_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	
	static ItemStack entity_painting_break = new ItemStack(Material.PAINTING);
	static ItemStack entity_painting_place = new ItemStack(Material.PAINTING);

    public static Inventory entityInv_pig = Bukkit.createInventory(null, 9, "Pig Sounds");
    static ItemStack entityInv_pig_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_saddle = new ItemStack(Material.SADDLE);
	static ItemStack entity_pig_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);

    public static Inventory entityInv_player = Bukkit.createInventory(null, 18, "Player Sounds");
    static ItemStack entityInv_player_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_crit = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_knockback = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_nodamage = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_strong = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_sweep = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_attack_weak = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_big_fall = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_breath = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_burp = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_levelup = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_small_fall = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_splash = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	static ItemStack entity_player_swim = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);

    public static Inventory entityInv_polarbear = Bukkit.createInventory(null, 9, "Polar Bear Sounds");
    static ItemStack entityInv_polarbear_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_baby_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_warning = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);

    public static Inventory entityInv_rabbit = Bukkit.createInventory(null, 9, "Rabbit Sounds");
    static ItemStack entityInv_rabbit_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_jump = new ItemStack(Material.RABBIT_FOOT);

    public static Inventory entityInv_sheep = Bukkit.createInventory(null, 9, "Sheep Sounds");
    static ItemStack entityInv_sheep_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_shear = new ItemStack(Material.SHEARS);
	static ItemStack entity_sheep_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);

    public static Inventory entityInv_shulker = Bukkit.createInventory(null, 18, "Shulker Sounds");
    static ItemStack entityInv_shulker_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_bullet_hit = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_bullet_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_close = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_hurt_closed = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_open = new ItemStack(Material.MONSTER_EGG, 1, (byte) 69);
	static ItemStack entity_shulker_shoot = new ItemStack(Material.BOW);
	static ItemStack entity_shulker_teleport = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public static Inventory entityInv_silverfish = Bukkit.createInventory(null, 9, "Silverfish Sounds");
    static ItemStack entityInv_silverfish_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);

    public static Inventory entityInv_skeleton = Bukkit.createInventory(null, 9, "Skeleton Sounds");
    static ItemStack entityInv_skeleton_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_horse_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_horse_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_horse_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_shoot = new ItemStack(Material.BOW);
	static ItemStack entity_skeleton_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);

    public static Inventory entityInv_slimes = Bukkit.createInventory(null, 9, "Slime Sounds");
    static ItemStack entityInv_slimes_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_slime_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_slime_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_slime_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_slime_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_slime_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	static ItemStack entity_small_magmacube_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_small_magmacube_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_small_magmacube_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_small_slime_death = new ItemStack(Material.SLIME_BALL);
	static ItemStack entity_small_slime_hurt = new ItemStack(Material.SLIME_BALL);
	static ItemStack entity_small_slime_jump = new ItemStack(Material.SLIME_BALL);
	static ItemStack entity_small_slime_squish = new ItemStack(Material.SLIME_BALL);
    static ItemStack entity_magmacube_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    static ItemStack entity_magmacube_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    static ItemStack entity_magmacube_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
    static ItemStack entity_magmacube_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);

    public static Inventory entityInv_snowman = Bukkit.createInventory(null, 9, "Snowman Sounds");
    static ItemStack entityInv_snowman_item = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_ambient = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_death = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_hurt = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_shoot = new ItemStack(Material.SNOW_BALL);

    public static Inventory entityInv_spider = Bukkit.createInventory(null, 9, "Spider Sounds");
    static ItemStack entityInv_spider_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);


    public static Inventory entityInv_squid = Bukkit.createInventory(null, 9, "Squid Sounds");
    static ItemStack entityInv_squid_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	static ItemStack entity_squid_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	static ItemStack entity_squid_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	static ItemStack entity_squid_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);

    public static Inventory entityInv_stray = Bukkit.createInventory(null, 9, "Stray Sounds");
    static ItemStack entityInv_stray_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	

    public static Inventory entityInv_villager = Bukkit.createInventory(null, 9, "Villager Sounds");
    static ItemStack entityInv_villager_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_no = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_trading = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_yes = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	
	//CHANGE POTION TYPE
    public static Inventory entityInv_witch = Bukkit.createInventory(null, 9, "Witch Sounds");
    static ItemStack entityInv_witch_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_drink = new ItemStack(Material.POTION);
	static ItemStack entity_witch_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_throw = new ItemStack(Material.SPLASH_POTION);

    //
    public static Inventory entityInv_wither = Bukkit.createInventory(null, 18, "Wither Sounds");
    static ItemStack entityInv_wither_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_break_block = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_shoot = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_skeleton_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_skeleton_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_skeleton_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_skeleton_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
	static ItemStack entity_wither_spawn = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);

    public static Inventory entityInv_wolf = Bukkit.createInventory(null, 18, "Wolf Sounds");
    static ItemStack entityInv_wolf_item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_growl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_howl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_pant = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_shake = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_whine = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);

    public static Inventory entityInv_zombie = Bukkit.createInventory(null, 27, "Zombie Sounds");
    static ItemStack entityInv_zombie_item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_attack_door_wood = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_attack_iron_door = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_break_door_wood = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_horse_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_horse_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_horse_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_infect = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_pig_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	static ItemStack entity_zombie_pig_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	static ItemStack entity_zombie_pig_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	static ItemStack entity_zombie_pig_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 57);
	static ItemStack entity_zombie_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_converted = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_cure = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_death = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
	static ItemStack entity_zombie_villager_step = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);

    static ItemStack entity_tnt_primed = new ItemStack(Material.TNT);
    static ItemStack entity_splash_potion_break = new ItemStack(Material.SPLASH_POTION);
    static ItemStack entity_splash_potion_throw = new ItemStack(Material.SPLASH_POTION);
    static ItemStack entity_endereye_launch = new ItemStack(Material.EYE_OF_ENDER);
    static ItemStack entity_lingeringpotion_throw = new ItemStack(Material.LINGERING_POTION);
    static ItemStack entity_egg_throw = new ItemStack(Material.EGG);
    static ItemStack entity_enderpearl_throw = new ItemStack(Material.ENDER_PEARL);
    static ItemStack entity_mooshroom_shear = new ItemStack(Material.MONSTER_EGG, 1, (byte) 96);
    static ItemStack entity_snowball_throw = new ItemStack(Material.SNOW_BALL);

	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static final Inventory itemInv = Bukkit.createInventory(null, 54, "Item Sounds");
	private static final ItemStack itemInv_item = new ItemStack(Material.RECORD_4);
	
	static ItemStack item_armor_equip_chain = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	static ItemStack item_armor_equip_diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	static ItemStack item_armor_equip_generic = new ItemStack(Material.LEATHER);
	static ItemStack item_armor_equip_gold = new ItemStack(Material.GOLD_CHESTPLATE);
	static ItemStack item_armor_equip_iron = new ItemStack(Material.IRON_CHESTPLATE);
	static ItemStack item_armor_equip_leather = new ItemStack(Material.LEATHER_CHESTPLATE);
	
	static ItemStack item_bottle_fill = new ItemStack(Material.POTION);
	static ItemStack item_bottle_fill_dragonbreath = new ItemStack(Material.DRAGONS_BREATH);
	
	static ItemStack item_bucket_empty = new ItemStack(Material.BUCKET);
	static ItemStack item_bucket_empty_lava = new ItemStack(Material.BUCKET);
	static ItemStack item_bucket_fill = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack item_bucket_fill_lava = new ItemStack(Material.LAVA_BUCKET);
	
	static ItemStack item_chorus_fruit_teleport = new ItemStack(Material.CHORUS_FRUIT_POPPED);
	
	static ItemStack item_elytra_flying = new ItemStack(Material.ELYTRA);
	
	static ItemStack item_firecharge_use = new ItemStack(Material.FIREBALL);
	
	static ItemStack item_flintandsteel_use = new ItemStack(Material.FLINT_AND_STEEL);
	
	static ItemStack item_hoe_till = new ItemStack(Material.DIAMOND_HOE);
	
	static ItemStack item_shield_block = new ItemStack(Material.SHIELD);
	
	static ItemStack item_shield_break = new ItemStack(Material.SHIELD);
	
	static ItemStack item_shovel_flatten = new ItemStack(Material.DIAMOND_SPADE);
	
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////SONG\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static final Inventory songInv = Bukkit.createInventory(null, 54, "Music Sounds");
	private static final ItemStack songInv_item = new ItemStack(Material.GOLD_RECORD);
	static ItemStack music_creative = new ItemStack(Material.JUKEBOX);
	static ItemStack music_credits = new ItemStack(Material.JUKEBOX);
	static ItemStack music_dragon = new ItemStack(Material.JUKEBOX);
	static ItemStack music_end = new ItemStack(Material.JUKEBOX);
	static ItemStack music_game = new ItemStack(Material.JUKEBOX);
	static ItemStack music_menu = new ItemStack(Material.JUKEBOX);
	static ItemStack music_nether = new ItemStack(Material.JUKEBOX);

	static ItemStack record_11 = new ItemStack(Material.RECORD_11);
	static ItemStack record_13 = new ItemStack(Material.GOLD_RECORD);
	static ItemStack record_blocks = new ItemStack(Material.RECORD_3);
	static ItemStack record_cat = new ItemStack(Material.GREEN_RECORD);
	static ItemStack record_chirp = new ItemStack(Material.RECORD_4);
	static ItemStack record_far = new ItemStack(Material.RECORD_5);
	static ItemStack record_mall = new ItemStack(Material.RECORD_6);
	static ItemStack record_mellohi = new ItemStack(Material.RECORD_7);
	static ItemStack record_stal = new ItemStack(Material.RECORD_8);
	static ItemStack record_strad = new ItemStack(Material.RECORD_9);
	static ItemStack record_wait = new ItemStack(Material.RECORD_12);
	static ItemStack record_ward = new ItemStack(Material.RECORD_10);
	
	
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////MISC\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static final Inventory miscInv = Bukkit.createInventory(null, 9, "Misc Sounds");
	private static final ItemStack miscInv_item = new ItemStack(Material.RECORD_12);
	//WEATHER
	static ItemStack weather_rain = new ItemStack(Material.WATER_BUCKET);
	static ItemStack weather_rain_above = new ItemStack(Material.WATER_BUCKET);
	//UI
	static ItemStack ui_button_click = new ItemStack(Material.STONE_BUTTON);
	//MAKE IT THORNS
	static ItemStack enchant_thorns_hit = new ItemStack(Material.ENCHANTED_BOOK);
	//AMBIENT
	static ItemStack ambient_cave = new ItemStack(Material.STONE);
	/////////////////////////////////////////////////////////////////////////
	
	public static final Inventory catselect = Bukkit.createInventory(null, 9, "Select Category");
	
	static final ItemStack backbutton_item = new ItemStack(Material.STONE_BUTTON);
	private static final ItemStack reset_item = new ItemStack(Material.TNT);

    protected ChatSoundsInventory() {
        super();
    }

    public void LoadInv(Player p) {

        this.setUser(p);

        boolean jse = this.isJoinSoundEnabled();
        int jsv = this.getJoinSoundVolume();
        int jsp = this.getJoinSoundPitch();

        boolean qse = this.isQuitSoundEnabled();
        int qsv = this.getQuitSoundVolume();
        int qsp = this.getQuitSoundPitch();

        boolean mse = this.isMessageSoundEnabled();
        int msv = this.getMessageSoundVolume();
        int msp = this.getMessageSoundPitch();
		
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
	
	private static void enabled(boolean b, ItemStack i) {
		if (b) {
			Wool g = new Wool(DyeColor.LIME);
			ItemStack gis = g.toItemStack();
			i.setData(g);
			i.setDurability(gis.getDurability());
		} else {
			Wool w = new Wool(DyeColor.WHITE);
			ItemStack wis = w.toItemStack();
			i.setData(w);
			i.setDurability(wis.getDurability());
		}
	}
}
