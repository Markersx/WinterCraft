package net.mcwintercraft.wintercraft.chatsounds;

import java.util.ArrayList;

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

import net.mcwintercraft.wintercraft.WinterCraftConfig;

public class ChatSoundsInventory {
	
	static WinterCraftConfig config = WinterCraftConfig.getConfig("chatsounds");
	
	public static Inventory soundinv = Bukkit.createInventory(null, 45, "Sound Options");
	
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////BLOCKS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static Inventory blockinv = Bukkit.createInventory(null, 54, "Block Sounds");
	static ItemStack blockinv_item = new ItemStack(Material.RECORD_8);
	
	public static Inventory blockinv_anvil = Bukkit.createInventory(null, 9, "Anvil Sounds");
	static ItemStack blockinv_anvil_item = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_break = new ItemStack(Material.ANVIL, 1, (byte) 2);
	static ItemStack block_anvil_destroy = new ItemStack(Material.ANVIL, 1, (byte) 1);
	static ItemStack block_anvil_fall = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_hit = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_land = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_place = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_step = new ItemStack(Material.ANVIL);
	static ItemStack block_anvil_use = new ItemStack(Material.ANVIL);
	
	public static Inventory blockinv_chest = Bukkit.createInventory(null, 9, "Chest Sounds");
	static ItemStack blockinv_chest_item = new ItemStack(Material.CHEST);
	static ItemStack block_chest_close = new ItemStack(Material.CHEST);
	static ItemStack block_chest_locked = new ItemStack(Material.TRAPPED_CHEST);
	static ItemStack block_chest_open = new ItemStack(Material.CHEST);
	
	static ItemStack block_chorus_flower_death = new ItemStack(Material.CHORUS_FLOWER);
	static ItemStack block_chorus_flower_grow = new ItemStack(Material.CHORUS_FRUIT_POPPED);
	
	public static Inventory blockinv_cloth = Bukkit.createInventory(null, 9, "Wool Sounds");
	static ItemStack blockinv_cloth_item = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_break = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_fall = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_hit = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_place = new ItemStack(Material.WOOL);
	static ItemStack block_cloth_step = new ItemStack(Material.WOOL);
	
	public static Inventory blockinv_dispenser = Bukkit.createInventory(null, 9, "Dispenser Sounds");
	static ItemStack blockinv_dispenser_item = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_dispense = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_fail = new ItemStack(Material.DISPENSER);
	static ItemStack block_dispenser_launch = new ItemStack(Material.DISPENSER);
	
	static ItemStack block_enderchest_close = new ItemStack(Material.ENDER_CHEST);
	static ItemStack block_enderchest_open = new ItemStack(Material.ENDER_CHEST);

	static ItemStack block_fence_gate_close = new ItemStack(Material.FENCE_GATE);
	static ItemStack block_fence_gate_open = new ItemStack(Material.FENCE_GATE);
	
	static ItemStack block_fire_ambient = new ItemStack(Material.FIRE);
	static ItemStack block_fire_extinguish = new ItemStack(Material.FIRE);
	
	public static Inventory blockinv_glass = Bukkit.createInventory(null, 9, "Glass Sounds");
	static ItemStack blockinv_glass_item = new ItemStack(Material.GLASS);
	static ItemStack block_glass_break = new ItemStack(Material.GLASS);
	static ItemStack block_glass_fall = new ItemStack(Material.GLASS);
	static ItemStack block_glass_hit = new ItemStack(Material.GLASS);
	static ItemStack block_glass_place = new ItemStack(Material.GLASS);
	static ItemStack block_glass_step = new ItemStack(Material.GLASS);
	
	public static Inventory blockinv_grass = Bukkit.createInventory(null, 9, "Grass Sounds");
	static ItemStack blockinv_grass_item = new ItemStack(Material.GRASS);
	static ItemStack block_grass_break = new ItemStack(Material.GRASS);
	static ItemStack block_grass_fall = new ItemStack(Material.GRASS);
	static ItemStack block_grass_hit = new ItemStack(Material.GRASS);
	static ItemStack block_grass_place = new ItemStack(Material.GRASS);
	static ItemStack block_grass_step = new ItemStack(Material.GRASS);
	
	public static Inventory blockinv_gravel = Bukkit.createInventory(null, 9, "Gravel Sounds");
	static ItemStack blockinv_gravel_item = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_break = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_fall = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_hit = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_place = new ItemStack(Material.GRAVEL);
	static ItemStack block_gravel_step = new ItemStack(Material.GRAVEL);
	
	public static Inventory blockinv_iron = Bukkit.createInventory(null, 18, "Iron Sounds");
	static ItemStack blockinv_iron_item = new ItemStack(Material.IRON_BLOCK);
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
	
	public static Inventory blockinv_ladder = Bukkit.createInventory(null, 9, "Ladder Sounds");
	static ItemStack blockinv_ladder_item = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_break = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_fall = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_hit = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_place = new ItemStack(Material.LADDER);
	static ItemStack block_ladder_step = new ItemStack(Material.LADDER);
	
	static ItemStack block_lava_ambient = new ItemStack(Material.LAVA);
	static ItemStack block_lava_extinguish = new ItemStack(Material.LAVA);
	static ItemStack block_lava_pop = new ItemStack(Material.LAVA);
	
	
	public static Inventory blockinv_note = Bukkit.createInventory(null, 9, "Note Sounds");
	static ItemStack blockinv_note_item = new ItemStack(Material.GLASS);
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
	
	
	public static Inventory blockinv_sand = Bukkit.createInventory(null, 9, "San Sounds");
	static ItemStack blockinv_sand_item = new ItemStack(Material.SAND);
	static ItemStack block_sand_break = new ItemStack(Material.SAND);
	static ItemStack block_sand_fall = new ItemStack(Material.SAND);
	static ItemStack block_sand_hit = new ItemStack(Material.SAND);
	static ItemStack block_sand_place = new ItemStack(Material.SAND);
	static ItemStack block_sand_step = new ItemStack(Material.SAND);
	
	public static Inventory blockinv_slime = Bukkit.createInventory(null, 9, "Slime Sounds");
	static ItemStack blockinv_slime_item = new ItemStack(Material.GLASS);
	static ItemStack block_slime_break = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_fall = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_hit = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_place = new ItemStack(Material.SLIME_BLOCK);
	static ItemStack block_slime_step = new ItemStack(Material.SLIME_BLOCK);
	
	public static Inventory blockinv_snow = Bukkit.createInventory(null, 9, "Snow Sounds");
	static ItemStack blockinv_snow_item = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_break = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_fall = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_hit = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_place = new ItemStack(Material.SNOW_BLOCK);
	static ItemStack block_snow_step = new ItemStack(Material.SNOW_BLOCK);
	
	public static Inventory blockinv_stone = Bukkit.createInventory(null, 18, "Glass Sounds");
	static ItemStack blockinv_stone_item = new ItemStack(Material.GLASS);
	static ItemStack block_stone_break = new ItemStack(Material.STONE);
	static ItemStack block_stone_button_click_off = new ItemStack(Material.STONE_BUTTON);
	static ItemStack block_stone_button_click_on = new ItemStack(Material.STONE_BUTTON);
	static ItemStack block_stone_fall = new ItemStack(Material.STONE);
	static ItemStack block_stone_hit = new ItemStack(Material.STONE);
	static ItemStack block_stone_place = new ItemStack(Material.STONE);
	static ItemStack block_stone_pressureplate_click_off = new ItemStack(Material.STONE_PLATE);
	static ItemStack block_stone_pressureplate_click_on = new ItemStack(Material.STONE_PLATE);
	static ItemStack block_stone_step = new ItemStack(Material.STONE_PLATE);
	
	public static Inventory blockinv_tripwire = Bukkit.createInventory(null, 9, "Tripwire Sounds");
	static ItemStack blockinv_tripwire_item = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_attach = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_click_off = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_click_on = new ItemStack(Material.TRIPWIRE_HOOK);
	static ItemStack block_tripwire_detach = new ItemStack(Material.TRIPWIRE_HOOK);
	
	public static Inventory blockinv_wood = Bukkit.createInventory(null, 18, "Wood Sounds");
	static ItemStack blockinv_wood_item = new ItemStack(Material.WOOD);
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
	public static Inventory entityinv = Bukkit.createInventory(null, 54, "Entity Sounds");
	static ItemStack entityinv_item = new ItemStack(Material.RECORD_9);
	
	static ItemStack entity_armorstand_break = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_fall = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_hit = new ItemStack(Material.ARMOR_STAND);
	static ItemStack entity_armorstand_place = new ItemStack(Material.ARMOR_STAND);
	
	static ItemStack entity_arrow_hit = new ItemStack(Material.ARROW);
	static ItemStack entity_arrow_hit_player = new ItemStack(Material.ARROW);
	static ItemStack entity_arrow_shoot = new ItemStack(Material.ARROW);
	
	//BAT
	static ItemStack entity_bat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_loop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	static ItemStack entity_bat_takeoff = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	
	static ItemStack entity_blaze_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_burn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_death = new ItemStack(Material.BLAZE_POWDER);
	static ItemStack entity_blaze_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	static ItemStack entity_blaze_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 61);
	
	static ItemStack entity_bobber_splash = new ItemStack(Material.FISHING_ROD);
	static ItemStack entity_bobber_throw = new ItemStack(Material.FISHING_ROD);
	
	static ItemStack entity_cat_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_hiss = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_purr = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	static ItemStack entity_cat_purreow = new ItemStack(Material.MONSTER_EGG, 1, (byte) 98);
	
	static ItemStack entity_chicken_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_egg = new ItemStack(Material.EGG);
	static ItemStack entity_chicken_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	static ItemStack entity_chicken_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	
	static ItemStack entity_cow_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	static ItemStack entity_cow_death = new ItemStack(Material.LEATHER);
	static ItemStack entity_cow_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	static ItemStack entity_cow_milk = new ItemStack(Material.MILK_BUCKET);
	static ItemStack entity_cow_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	
	//MAKE GUN POWDER
	static ItemStack entity_creeper_death = new ItemStack(Material.INK_SACK);
	static ItemStack entity_creeper_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	static ItemStack entity_creeper_primed = new ItemStack(Material.SKULL_ITEM, 1, (byte) 4);
	
	static ItemStack entity_donkey_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_angry = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_chest = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_donkey_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	
	static ItemStack entity_egg_throw = new ItemStack(Material.EGG);
	
	static ItemStack entity_elder_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_curse = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_elder_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	
	static ItemStack entity_enderdragon_ambient = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_death = new ItemStack(Material.DRAGONS_BREATH);
	static ItemStack entity_enderdragon_fireball_explode = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_flap = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_growl = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_hurt = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	static ItemStack entity_enderdragon_shoot = new ItemStack(Material.SKULL_ITEM, 1, (byte) 5);
	
	static ItemStack entity_endereye_launch = new ItemStack(Material.EYE_OF_ENDER);
	
	static ItemStack entity_endermen_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_stare = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	static ItemStack entity_endermen_teleport = new ItemStack(Material.MONSTER_EGG, 1, (byte) 58);
	
	static ItemStack entity_endermite_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	static ItemStack entity_endermite_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 67);
	
	static ItemStack entity_enderpearl_throw = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_bottle_throw = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_orb_pickup = new ItemStack(Material.EXP_BOTTLE);
	static ItemStack entity_experience_orb_touch = new ItemStack(Material.EXP_BOTTLE);
	
	static ItemStack entity_firework_blast = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_blast_far = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_large_blast = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_large_blast_far = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_launch = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_shoot = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_twinkle = new ItemStack(Material.FIREWORK);
	static ItemStack entity_firework_twinkle_far = new ItemStack(Material.FIREWORK);
	
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
	
	static ItemStack entity_ghast_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_scream = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_shoot = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	static ItemStack entity_ghast_warn = new ItemStack(Material.MONSTER_EGG, 1, (byte) 56);
	
	static ItemStack entity_guardian_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_ambient_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_death_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_flop = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	static ItemStack entity_guardian_hurt_land = new ItemStack(Material.MONSTER_EGG, 1, (byte) 68);
	
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
	
	static ItemStack entity_hostile_big_fall = new ItemStack(Material.DIAMOND_BOOTS);
	static ItemStack entity_hostile_death = new ItemStack(Material.STRUCTURE_VOID);
	static ItemStack entity_hostile_hurt = new ItemStack(Material.CACTUS);
	static ItemStack entity_hostile_small_fall = new ItemStack(Material.FEATHER);
	static ItemStack entity_hostile_splash = new ItemStack(Material.WATER);
	static ItemStack entity_hostile_swim = new ItemStack(Material.BOAT);
	
	static ItemStack entity_husk_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_husk_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	
	static ItemStack entity_irongolem_attack = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_death = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_hurt = new ItemStack(Material.RED_ROSE);
	static ItemStack entity_irongolem_step = new ItemStack(Material.RED_ROSE);
	
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
	
	static ItemStack entity_lingeringpotion_throw = new ItemStack(Material.LINGERING_POTION);
	
	static ItemStack entity_magmacube_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_magmacube_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_magmacube_jump = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	static ItemStack entity_magmacube_squish = new ItemStack(Material.MONSTER_EGG, 1, (byte) 62);
	
	static ItemStack entity_minecart_inside = new ItemStack(Material.MINECART);
	static ItemStack entity_minecart_riding = new ItemStack(Material.MINECART);
	
	static ItemStack entity_mooshroom_shear = new ItemStack(Material.MONSTER_EGG, 1, (byte) 96);
	
	static ItemStack entity_mule_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_mule_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_mule_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	
	static ItemStack entity_painting_break = new ItemStack(Material.PAINTING);
	static ItemStack entity_painting_place = new ItemStack(Material.PAINTING);
	
	static ItemStack entity_pig_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	static ItemStack entity_pig_saddle = new ItemStack(Material.SADDLE);
	static ItemStack entity_pig_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	
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
	
	static ItemStack entity_polar_bear_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_baby_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	static ItemStack entity_polar_bear_warning = new ItemStack(Material.MONSTER_EGG, 1, (byte) 102);
	
	static ItemStack entity_rabbit_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_attack = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 101);
	static ItemStack entity_rabbit_jump = new ItemStack(Material.RABBIT_FOOT);
	
	static ItemStack entity_sheep_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	static ItemStack entity_sheep_shear = new ItemStack(Material.SHEARS);
	static ItemStack entity_sheep_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 91);
	
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
	
	static ItemStack entity_silverfish_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	static ItemStack entity_silverfish_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 60);
	
	static ItemStack entity_skeleton_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_horse_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_horse_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_horse_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	static ItemStack entity_skeleton_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_skeleton_shoot = new ItemStack(Material.BOW);
	static ItemStack entity_skeleton_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	
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
	
	static ItemStack entity_snowball_throw = new ItemStack(Material.SNOW_BALL);
	
	static ItemStack entity_snowman_ambient = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_death = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_hurt = new ItemStack(Material.PUMPKIN);
	static ItemStack entity_snowman_shoot = new ItemStack(Material.SNOW_BALL);
	
	static ItemStack entity_spider_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	static ItemStack entity_spider_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	
	static ItemStack entity_splash_potion_break = new ItemStack(Material.SPLASH_POTION);
	static ItemStack entity_splash_potion_throw = new ItemStack(Material.SPLASH_POTION);
	
	static ItemStack entity_squid_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	static ItemStack entity_squid_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	static ItemStack entity_squid_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 94);
	
	static ItemStack entity_stray_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	static ItemStack entity_stray_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	
	static ItemStack entity_tnt_primed = new ItemStack(Material.TNT);
	
	static ItemStack entity_villager_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_no = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_trading = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	static ItemStack entity_villager_yes = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
	
	//CHANGE POTION TYPE
	static ItemStack entity_witch_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_drink = new ItemStack(Material.POTION);
	static ItemStack entity_witch_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 66);
	static ItemStack entity_witch_throw = new ItemStack(Material.SPLASH_POTION);
	
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
	
	static ItemStack entity_wolf_ambient = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_death = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_growl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_howl = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_hurt = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_pant = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_shake = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_step = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	static ItemStack entity_wolf_whine = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	
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
	
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////////////////ITEM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static Inventory iteminv = Bukkit.createInventory(null, 54, "Item Sounds");
	static ItemStack iteminv_item = new ItemStack(Material.RECORD_4);
	
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
	public static Inventory songinv = Bukkit.createInventory(null, 54, "Music Sounds");
	static ItemStack songinv_item = new ItemStack(Material.GOLD_RECORD);
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
	public static Inventory miscinv = Bukkit.createInventory(null, 9, "Misc Sounds");
	static ItemStack miscinv_item = new ItemStack(Material.RECORD_12);
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
	
	public static Inventory catselect = Bukkit.createInventory(null, 9, "Select Category");	
	
	static ItemStack backbutton_item = new ItemStack(Material.STONE_BUTTON);
	static ItemStack reset_item = new ItemStack(Material.TNT);
	
	public static void LoadInv(Player p, String puuid) {
		
		boolean jse = config.getConfig().getBoolean(puuid + ".playerjoin.enabled");
		int jsv = config.getConfig().getInt(puuid + ".playerjoin.volume");
		int jsp = config.getConfig().getInt(puuid + ".playerjoin.pitch");
		boolean qse = config.getConfig().getBoolean(puuid + ".playerquit.enabled");
		int qsv = config.getConfig().getInt(puuid + ".playerquit.volume");
		int qsp = config.getConfig().getInt(puuid + ".playerquit.pitch");
		boolean mse = config.getConfig().getBoolean(puuid + ".playermessage.enabled");
		int msv = config.getConfig().getInt(puuid + ".playermessage.volume");
		int msp = config.getConfig().getInt(puuid + ".playermessage.pitch");
		
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
		
		
		blockinv.setItem(53, backbutton_item);
		entityinv.setItem(53, backbutton_item);
		iteminv.setItem(53, backbutton_item);
		songinv.setItem(53, backbutton_item);
		miscinv.setItem(8, backbutton_item);
		
		ArrayList<String> ctt = new ArrayList<String>();
		ctt.add(ChatColor.WHITE + "Click to toggle");
		
		ArrayList<String> cts = new ArrayList<String>();
		cts.add(ChatColor.WHITE + "Click to select");
		
		ArrayList<String> lcrc = new ArrayList<String>();
		lcrc.add(ChatColor.WHITE + "Left click +1");
		lcrc.add(ChatColor.WHITE + "Right click -1");
		
		ArrayList<String> ctvas = new ArrayList<String>();
		ctvas.add(ChatColor.WHITE + "click to view");
		ctvas.add(ChatColor.WHITE + "all sounds");
		
		ArrayList<String> ls = new ArrayList<String>();
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
		
		ItemMeta blockinv_meta = blockinv_item.getItemMeta();
		ItemMeta entityinv_meta = entityinv_item.getItemMeta();
		ItemMeta iteminv_meta = iteminv_item.getItemMeta();
		ItemMeta songinv_meta = songinv_item.getItemMeta();
		ItemMeta miscinv_meta = miscinv_item.getItemMeta();
		
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
		
		blockinv_meta.setDisplayName(ChatColor.AQUA + "Block Sounds");
		entityinv_meta.setDisplayName(ChatColor.AQUA + "Entity Sounds");
		iteminv_meta.setDisplayName(ChatColor.AQUA + "Item Sounds");
		songinv_meta.setDisplayName(ChatColor.AQUA + "Song Sounds");
		miscinv_meta.setDisplayName(ChatColor.AQUA + "Misc Sounds");
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
		
		iteminv_meta.setLore(ctvas);
		iteminv_meta.addItemFlags(ItemFlag.values());
		blockinv_meta.setLore(ctvas);
		blockinv_meta.addItemFlags(ItemFlag.values());
		entityinv_meta.setLore(ctvas);
		entityinv_meta.addItemFlags(ItemFlag.values());
		songinv_meta.setLore(ctvas);
		songinv_meta.addItemFlags(ItemFlag.values());
		miscinv_meta.setLore(ctvas);
		miscinv_meta.addItemFlags(ItemFlag.values());
		
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
		blockinv_item.setItemMeta(blockinv_meta);
		entityinv_item.setItemMeta(entityinv_meta);
		iteminv_item.setItemMeta(iteminv_meta);
		songinv_item.setItemMeta(songinv_meta);
		miscinv_item.setItemMeta(miscinv_meta);
		backbutton_item.setItemMeta(backbutton_meta);
		
		soundinv.setItem(11, jsi); 
		soundinv.setItem(12, jsei);
		soundinv.setItem(14, jsvi); 
		soundinv.setItem(15, jspi);
		
		soundinv.setItem(20, qsi); 
		soundinv.setItem(21, qsei);
		soundinv.setItem(23, qsvi); 
		soundinv.setItem(24, qspi);
		
		soundinv.setItem(29, msi); 
		soundinv.setItem(30, msei);
		soundinv.setItem(32, msvi); 
		soundinv.setItem(33, mspi);
		
		soundinv.setItem(44, reset_item);
		
		catselect.setItem(0, blockinv_item);
		catselect.setItem(1, entityinv_item);
		catselect.setItem(2, iteminv_item);
		catselect.setItem(3, songinv_item);
		catselect.setItem(4, miscinv_item);
		catselect.setItem(8, backbutton_item);
		
		p.openInventory(soundinv);
	}
	
	static void enabled(boolean b, ItemStack i) {
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
