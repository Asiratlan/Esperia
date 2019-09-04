/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemBeeArmor;
import net.esperia.item.ItemBlockSpecialCake;
import net.esperia.item.ItemBucket;
import net.esperia.item.ItemCard;
import net.esperia.item.ItemChain;
import net.esperia.item.ItemChessPiece;
import net.esperia.item.ItemClothSheet;
import net.esperia.item.ItemContainer;
import net.esperia.item.ItemDice;
import net.esperia.item.ItemDiceGlass;
import net.esperia.item.ItemDirty;
import net.esperia.item.ItemDrinkSimple;
import net.esperia.item.ItemFoodDish;
import net.esperia.item.ItemFoodSimple;
import net.esperia.item.ItemGourd;
import net.esperia.item.ItemJewelry;
import net.esperia.item.ItemKey;
import net.esperia.item.ItemKeyRing;
import net.esperia.item.ItemPlank;
import net.esperia.item.ItemRepairWheel;
import net.esperia.item.ItemRockHammer;
import net.esperia.item.ItemSerrure;
import net.esperia.item.ItemSignEsperia;
import net.esperia.item.ItemSimple;
import net.esperia.item.ItemSimpleBow;
import net.esperia.item.ItemSimpleColor;
import net.esperia.item.ItemSimpleMoney;
import net.esperia.item.ItemSimpleShield;
import net.esperia.item.ItemSimpleTool;
import net.esperia.item.cep.ItemCepGrapes;
import net.esperia.item.cep.ItemCepTomato;
import net.esperia.item.seed.ItemSeedBarley;
import net.esperia.item.seed.ItemSeedFlax;
import net.esperia.item.seed.ItemSeedFoodTurnip;
import net.esperia.item.seed.ItemSeedHemp;
import net.esperia.item.seed.ItemSeedLettuce;
import net.esperia.item.tools.ItemSimpleAxe;
import net.esperia.item.tools.ItemSimpleClean;
import net.esperia.item.tools.ItemSimpleHoe;
import net.esperia.item.tools.ItemSimplePickaxe;
import net.esperia.item.tools.ItemSimpleSpade;
import net.esperia.item.tools.ItemSimpleSword;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

/**
 *
 * @author Tiago
 */
public class ItemsRegistry {
//Material

    public static final Item.ToolMaterial bronzeToolMaterial = EnumHelper.addToolMaterial("BRONZE", 2, 175, 4.0F, 1.0F, 5);

    // Espers
    public static ItemSimpleMoney ef = new ItemSimpleMoney("ef");
    public static ItemSimpleMoney eo = new ItemSimpleMoney("eo");
    public static ItemSimpleMoney el = new ItemSimpleMoney("el");
    public static ItemSimpleMoney ed = new ItemSimpleMoney("ed");
    public static ItemSimpleMoney coin_copper = new ItemSimpleMoney("coin_copper");
    public static ItemSimpleMoney coin_silver = new ItemSimpleMoney("coin_silver");
    public static ItemSimpleMoney coin_gold_1 = new ItemSimpleMoney("coin_gold_1");
    public static ItemSimpleMoney coin_gold_2 = new ItemSimpleMoney("coin_gold_2");
    //Epervies

    // Récipients
    public static ItemSimple glass_jar_empty = new ItemSimple("glass_jar_empty");
    public static ItemSimple glass_jar_bee = new ItemSimple("glass_jar_bee");
    public static ItemSimple glass_bottle_empty = new ItemSimple("glass_bottle_empty");
    public static ItemSimple glass_bottle_rum_empty = new ItemSimple("glass_bottle_rum_empty");
    public static ItemSimple clay_mug_empty = new ItemSimple("clay_mug_empty");
    public static ItemSimple glass_mug_empty = new ItemSimple("glass_mug_empty");
    public static ItemSimple glass_tumbler_empty = new ItemSimple("glass_tumbler_empty");
    public static ItemSimple teapot = new ItemSimple("teapot");

    // Items sales
    public static ItemDirty glass_tumbler_dirty = new ItemDirty("glass_tumbler_dirty");
    public static ItemDirty glass_mug_dirty = new ItemDirty("glass_mug_dirty");
    public static ItemDirty clay_mug_dirty = new ItemDirty("clay_mug_dirty");

    // Boissons
    public static ItemGourd gourd_empty = new ItemGourd("gourd_empty");
    public static ItemDrinkSimple gourd = new ItemDrinkSimple("gourd", 2, 0.0F, gourd_empty, 5);
    public static ItemDrinkSimple glass_jar_water = new ItemDrinkSimple("glass_jar_water", 2, 0.0F, glass_jar_empty, 3);
    public static ItemDrinkSimple glass_jar_milk = new ItemDrinkSimple("glass_jar_milk", 2, 0.0F, glass_jar_empty, 3);
    //Teapot 418
    public static ItemDrinkSimple teapot_water = new ItemDrinkSimple("teapot_water", 2, 0.0F, teapot, 5);
    public static ItemDrinkSimple teapot_hotwater = new ItemDrinkSimple("teapot_hotwater", 2, 0.0F, teapot, 5);
    public static ItemDrinkSimple teapot_milk = new ItemDrinkSimple("teapot_milk", 2, 0.0F, teapot, 5);
    public static ItemDrinkSimple teapot_hotmilk = new ItemDrinkSimple("teapot_hotmilk", 2, 0.0F, teapot, 5);
//// Chope en terre
    public static ItemDrinkSimple clay_mug_beer = new ItemDrinkSimple("clay_mug_beer", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_mead = new ItemDrinkSimple("clay_mug_mead", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_milk = new ItemDrinkSimple("clay_mug_milk", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_water = new ItemDrinkSimple("clay_mug_water", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_hotcocoa = new ItemDrinkSimple("clay_mug_hotcocoa", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_hotmilk = new ItemDrinkSimple("clay_mug_hotmilk", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_hottea = new ItemDrinkSimple("clay_mug_hottea", 2, 0.0F, clay_mug_dirty);
    public static ItemDrinkSimple clay_mug_hotwater = new ItemDrinkSimple("clay_mug_hotwater", 2, 0.0F, clay_mug_dirty);
    //// Bouteille en verre
    public static ItemDrinkSimple glass_bottle_water = new ItemDrinkSimple("glass_bottle_water", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_milk = new ItemDrinkSimple("glass_bottle_milk", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_apple = new ItemDrinkSimple("glass_bottle_apple", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_cider = new ItemDrinkSimple("glass_bottle_cider", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_grapes = new ItemDrinkSimple("glass_bottle_grapes", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_vine = new ItemDrinkSimple("glass_bottle_vine", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_sugarcane = new ItemDrinkSimple("glass_bottle_sugarcane", 2, 0.0F, glass_bottle_empty, 5);
    public static ItemDrinkSimple glass_bottle_rum = new ItemDrinkSimple("glass_bottle_rum", 2, 0.0F, glass_bottle_rum_empty, 5);
    public static ItemDrinkSimple glass_bottle_mead = new ItemDrinkSimple("glass_bottle_mead", 2, 0.0F, glass_bottle_rum_empty, 5);
    public static ItemDrinkSimple glass_bottle_beer = new ItemDrinkSimple("glass_bottle_beer", 2, 0.0F, glass_bottle_rum_empty, 5);

    //// Choppe en verre
    public static ItemDrinkSimple glass_mug_beer = new ItemDrinkSimple("glass_mug_beer", 2, 0.0F, glass_mug_dirty);
    public static ItemDrinkSimple glass_mug_mead = new ItemDrinkSimple("glass_mug_mead", 2, 0.0F, glass_mug_dirty);
    //// Verre à pied
    public static ItemDrinkSimple glass_tumbler_apple = new ItemDrinkSimple("glass_tumbler_apple", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_cider = new ItemDrinkSimple("glass_tumbler_cider", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_grapes = new ItemDrinkSimple("glass_tumbler_grapes", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_vine = new ItemDrinkSimple("glass_tumbler_vine", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_milk = new ItemDrinkSimple("glass_tumbler_milk", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_sugarcane = new ItemDrinkSimple("glass_tumbler_sugarcane", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_rum = new ItemDrinkSimple("glass_tumbler_rum", 2, 0.0F, glass_tumbler_dirty);
    public static ItemDrinkSimple glass_tumbler_water = new ItemDrinkSimple("glass_tumbler_water", 2, 0.0F, glass_tumbler_dirty);

    //// Seaux
    public static ItemSimple metal_bucket_apple = new ItemSimple("metal_bucket_apple");
    public static ItemSimple metal_bucket_cider = new ItemSimple("metal_bucket_cider");
    public static ItemSimple metal_bucket_barley = new ItemSimple("metal_bucket_barley");
    public static ItemSimple metal_bucket_beer = new ItemSimple("metal_bucket_beer");
    public static ItemSimple metal_bucket_grapes = new ItemSimple("metal_bucket_grapes");
    public static ItemSimple metal_bucket_vine = new ItemSimple("metal_bucket_vine");
    public static ItemSimple metal_bucket_honey = new ItemSimple("metal_bucket_honey");
    public static ItemSimple metal_bucket_mead = new ItemSimple("metal_bucket_mead");
    public static ItemSimple metal_bucket_sugarcane = new ItemSimple("metal_bucket_sugarcane");
    public static ItemSimple metal_bucket_rum = new ItemSimple("metal_bucket_rum");
    public static ItemSimple metal_bucket_goatmilk = new ItemSimple("metal_bucket_goat_milk");

    public static ItemBucket wooden_bucket = new ItemBucket(net.minecraft.init.Blocks.AIR, "wooden_bucket");
    public static ItemBucket wooden_bucket_water = (ItemBucket) new ItemBucket(net.minecraft.init.Blocks.FLOWING_WATER, "wooden_bucket_water").setContainerItem(wooden_bucket);
    public static ItemSimple wooden_bucket_milk = new ItemSimple("wooden_bucket_milk");
    public static ItemSimple wooden_bucket_apple = new ItemSimple("wooden_bucket_apple");
    public static ItemSimple wooden_bucket_cider = new ItemSimple("wooden_bucket_cider");
    public static ItemSimple wooden_bucket_barley = new ItemSimple("wooden_bucket_barley");
    public static ItemSimple wooden_bucket_beer = new ItemSimple("wooden_bucket_beer");
    public static ItemSimple wooden_bucket_grapes = new ItemSimple("wooden_bucket_grapes");
    public static ItemSimple wooden_bucket_vine = new ItemSimple("wooden_bucket_vine");
    public static ItemSimple wooden_bucket_honey = new ItemSimple("wooden_bucket_honey");
    public static ItemSimple wooden_bucket_mead = new ItemSimple("wooden_bucket_mead");
    public static ItemSimple wooden_bucket_sugarcane = new ItemSimple("wooden_bucket_sugarcane");
    public static ItemSimple wooden_bucket_rum = new ItemSimple("wooden_bucket_rum");
    public static ItemSimple wooden_bucket_goatmilk = new ItemSimple("wooden_bucket_goat_milk");

    // Nourriture
    public static ItemSimple flour = new ItemSimple("flour");
    public static ItemSimple dough = new ItemSimple("dough");
    public static ItemFoodSimple biscuit_chocolate = new ItemFoodSimple("biscuit_chocolate", 2, 0.1F, false);
    public static ItemFoodSimple boarchop_raw = new ItemFoodSimple("boarchop_raw", 3, 0.3F, true);
    public static ItemFoodSimple boarchop_cooked = new ItemFoodSimple("boarchop_cooked", 8, 0.8F, true);
    public static ItemFoodSimple cake_slice = new ItemFoodSimple("cake_slice", 3, 0.3F, false);
    public static ItemFoodSimple pumpkin_pie_slice = new ItemFoodSimple("pumpkin_pie_slice", 3, 0.3F, false);
    public static ItemBlockSpecialCake cheese;
    public static ItemBlockSpecialCake bluecheese;
    public static ItemFoodSimple cheese_slice = new ItemFoodSimple("cheese_slice", 3, 0.3F, false);
    public static ItemFoodSimple bluecheese_slice = new ItemFoodSimple("bluecheese_slice", 3, 0.3F, false);
    public static ItemFoodSimple chocolate = new ItemFoodSimple("chocolate", 2, 0.1F, false);
    public static ItemFoodSimple egg_boiled = new ItemFoodSimple("egg_boiled", 4, 0.4F, false);
    public static ItemFoodSimple egg_fried = new ItemFoodSimple("egg_fried", 4, 0.4F, false);
    public static ItemFoodSimple esper_chocolate = new ItemFoodSimple("esper_chocolate", 4, 0.5F, false);
    public static ItemFoodSimple fish_herring_raw = new ItemFoodSimple("fish_herring_raw", 3, 0.3F, false);
    public static ItemFoodSimple fish_herring_cooked = new ItemFoodSimple("fish_herring_cooked", 8, 0.8F, false);
    public static ItemFoodSimple fish_sardine_raw = new ItemFoodSimple("fish_sardine_raw", 1, 0.1F, false);
    public static ItemFoodSimple fish_sardine_cooked = new ItemFoodSimple("fish_sardine_cooked", 4, 0.4F, false);
    public static ItemFoodSimple fish_trout_raw = new ItemFoodSimple("fish_trout_raw", 2, 0.2F, false);
    public static ItemFoodSimple fish_trout_cooked = new ItemFoodSimple("fish_trout_cooked", 6, 0.6F, false);
    public static ItemFoodSimple fish_soup = new ItemFoodDish("fish_soup", 8, 1.2F, Item.getByNameOrId("minecraft:bowl"), false);
    public static ItemFoodSimple llama_raw = new ItemFoodSimple("llama_raw", 3, 0.3F, false);
    public static ItemFoodSimple llama_cooked = new ItemFoodSimple("llama_cooked", 8, 0.8F, false);
    public static ItemFoodSimple bear_raw = new ItemFoodSimple("bear_raw", 3, 0.3F, false);
    public static ItemFoodSimple bear_cooked = new ItemFoodSimple("bear_cooked", 8, 0.8F, false);
    public static ItemFoodSimple goat_raw = new ItemFoodSimple("goat_raw", 3, 0.3F, false);
    public static ItemFoodSimple goat_cooked = new ItemFoodSimple("goat_cooked", 8, 0.8F, false);
    public static ItemFoodSimple duck_raw = new ItemFoodSimple("duck_raw", 3, 0.3F, false);
    public static ItemFoodSimple duck_cooked = new ItemFoodSimple("duck_cooked", 8, 0.8F, false);
    public static ItemFoodSimple deer_raw = new ItemFoodSimple("deer_raw", 3, 0.3F, false);
    public static ItemFoodSimple deer_cooked = new ItemFoodSimple("deer_cooked", 8, 0.8F, false);
    public static ItemFoodSimple honey = new ItemFoodSimple("honey", 4, 0.3F, false);
    public static ItemFoodSimple horse_raw = new ItemFoodSimple("horse_raw", 3, 0.3F, false);
    public static ItemFoodSimple horse_cooked = new ItemFoodSimple("horse_cooked", 8, 0.8F, false);
    public static ItemFoodSimple larva_raw = new ItemFoodSimple("larva_raw", 2, 0.1F, false);
    public static ItemFoodSimple larva_cooked = new ItemFoodSimple("larva_cooked", 4, 0.2F, false);
    public static ItemFoodSimple pumpkin_soup = new ItemFoodDish("pumpkin_soup", 8, 0.8F, Item.getByNameOrId("minecraft:bowl"), false);
    public static ItemFoodSimple squid_raw = new ItemFoodSimple("squid_raw", 2, 0.2F, false);
    public static ItemFoodSimple squid_cooked = new ItemFoodSimple("squid_cooked", 6, 0.6F, false);
    public static ItemDrinkSimple glass_jar_marmalade_apple = new ItemDrinkSimple("glass_jar_marmalade_apple", 5, 0.5F, glass_jar_empty, 5);
    public static ItemDrinkSimple glass_jar_marmalade_grapes = new ItemDrinkSimple("glass_jar_marmalade_grapes", 5, 0.5F, glass_jar_empty, 5);

    //Nourriture avariée
    public static ItemFoodSimple rotten_fish = (ItemFoodSimple) new ItemFoodSimple("rotten_fish", 2, 0.1F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    public static ItemFoodSimple rotten_vegetable = (ItemFoodSimple) new ItemFoodSimple("rotten_vegetable", 2, 0.1F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    public static ItemFoodSimple rotten_fruit = (ItemFoodSimple) new ItemFoodSimple("rotten_fruit", 2, 0.1F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    public static ItemFoodSimple rotten_starchy = (ItemFoodSimple) new ItemFoodSimple("rotten_starchy", 2, 0.1F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    public static ItemFoodSimple rotten_egg = (ItemFoodSimple) new ItemFoodSimple("rotten_egg", 2, 0.1F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    public static ItemDrinkSimple rotten_drink = (ItemDrinkSimple) new ItemDrinkSimple("rotten_drink", 2, 0.1F, glass_bottle_empty, 5).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    // Peluches
    public static ItemSimpleColor plush_bear = new ItemSimpleColor("plush_bear");
    public static ItemSimpleColor plush_sheep = new ItemSimpleColor("plush_sheep");
    public static ItemSimpleColor doll = new ItemSimpleColor("doll");

    // V�tements  
    public static ItemSimpleColor cloth_boots = new ItemSimpleColor("cloth_boots");
    public static ItemSimpleColor cloth_shirt = new ItemSimpleColor("cloth_shirt");
    public static ItemSimpleColor cloth_gloves = new ItemSimpleColor("cloth_gloves");
    public static ItemSimpleColor cloth_skirt = new ItemSimpleColor("cloth_skirt");
    public static ItemSimpleColor cloth_longcoat = new ItemSimpleColor("cloth_longcoat");
    public static ItemSimpleColor cloth_coat = new ItemSimpleColor("cloth_coat");
    public static ItemSimpleColor cloth_trousers = new ItemSimpleColor("cloth_trousers");
    public static ItemSimpleColor cloth_habit = new ItemSimpleColor("cloth_habit");
    public static ItemSimpleColor cloth_robe = new ItemSimpleColor("cloth_robe");
    public static ItemSimpleColor cloth_underwear_m = new ItemSimpleColor("cloth_underwear_m");
    public static ItemSimpleColor cloth_underwear_f = new ItemSimpleColor("cloth_underwear_f");

    // Matériels
    public static ItemSimple cocoa = new ItemSimple("cocoa");
    public static ItemSimple butter = new ItemSimple("butter");
    public static ItemSimple salt = new ItemSimple("salt");
    public static ItemSimple wax = new ItemSimple("wax");
    public static ItemSimple roll_blank = new ItemSimple("roll_blank");
    public static ItemSimple diamond_raw = new ItemSimple("diamond_raw");
    public static ItemSimple emerald_raw = new ItemSimple("emerald_raw");
    public static ItemSimple ink_sack = new ItemSimple("ink_sack");
    public static ItemSimple lapis_lazuli_raw = new ItemSimple("lapis_lazuli_raw");
    public static ItemSimple lapis_lazuli = new ItemSimple("lapis_lazuli");

    public static ItemSimple slate_shard = new ItemSimple("slate_shard");
    public static ItemSimple salt_shard = new ItemSimple("salt_shard");
    public static ItemSimple alun_shard = new ItemSimple("alun_shard");
    public static ItemSimple stone_pebble = new ItemSimple("stone_pebble");

    public static ItemSimple andesite_pebble = new ItemSimple("andesite_pebble");
    public static ItemSimple granite_pebble = new ItemSimple("granite_pebble");
    public static ItemSimple diorite_pebble = new ItemSimple("diorite_pebble");
    public static ItemSimple sandstone_pebble = new ItemSimple("sandstone_pebble");
    public static ItemSimple red_sandstone_pebble = new ItemSimple("red_sandstone_pebble");

    public static ItemSimple stone_brick = new ItemSimple("stone_brick");
    public static ItemSimple andesite_brick = new ItemSimple("andesite_brick");
    public static ItemSimple granite_brick = new ItemSimple("granite_brick");
    public static ItemSimple diorite_brick = new ItemSimple("diorite_brick");
    public static ItemSimple sandstone_brick = new ItemSimple("sandstone_brick");
    public static ItemSimple red_sandstone_brick = new ItemSimple("red_sandstone_brick");
    public static ItemSimple quartz_brick = new ItemSimple("quartz_brick");

    public static ItemSimple teapot_raw = new ItemSimple("teapot_raw");
    public static ItemSimple clay_mug_raw = new ItemSimple("clay_mug_raw");

    public static ItemSimple plank_oak = new ItemPlank("plank_oak");
    public static ItemSimple plank_birch = new ItemPlank("plank_birch");
    public static ItemSimple plank_spruce = new ItemPlank("plank_spruce");
    public static ItemSimple plank_jungle = new ItemPlank("plank_jungle");
    public static ItemSimple plank_big_oak = new ItemPlank("plank_big_oak");
    public static ItemSimple plank_acacia = new ItemPlank("plank_acacia");
    public static ItemSimple stick_birch = new ItemSimple("stick_birch");
    public static ItemSimple stick_spruce = new ItemSimple("stick_spruce");
    public static ItemSimple stick_jungle = new ItemSimple("stick_jungle");
    public static ItemSimple stick_big_oak = new ItemSimple("stick_big_oak");
    public static ItemSimple stick_acacia = new ItemSimple("stick_acacia");
    public static ItemSimple handle = new ItemSimple("handle");
    public static ItemSimple shaft = new ItemSimple("shaft");
    public static ItemSimple pole = new ItemSimple("pole");

    public static ItemSimple flower_pot_raw = new ItemSimple("flower_pot_raw");
    public static ItemSimple molten_glass = new ItemSimple("molten_glass");
    public static ItemSimple paper_wet = new ItemSimple("paper_wet");
    public static ItemSimple paper_paste = new ItemSimple("paper_paste");

    public static ItemSimple flux = new ItemSimple("flux");
    public static ItemDrinkSimple tanning_oil = new ItemDrinkSimple("tanning_oil", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple varnish = new ItemDrinkSimple("varnish", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple yeast = new ItemDrinkSimple("yeast", -2, 0.0F, glass_jar_empty, 8);

    // Metal
    public static ItemSimple copper_raw = new ItemSimple("copper_raw");
    public static ItemSimple lead_raw = new ItemSimple("lead_raw");
    public static ItemSimple silver_raw = new ItemSimple("silver_raw");
    public static ItemSimple tin_raw = new ItemSimple("tin_raw");
    public static ItemSimple iron_raw = new ItemSimple("iron_raw");
    public static ItemSimple gold_raw = new ItemSimple("gold_raw");
    public static ItemSimple steel_nugget = new ItemSimple("steel_nugget");
    public static ItemSimple copper_nugget = new ItemSimple("copper_nugget");
    public static ItemSimple lead_nugget = new ItemSimple("lead_nugget");
    public static ItemSimple silver_nugget = new ItemSimple("silver_nugget");
    public static ItemSimple tin_nugget = new ItemSimple("tin_nugget");
    public static ItemSimple bronze_nugget = new ItemSimple("bronze_nugget");
    public static ItemSimple ingot_steel = new ItemSimple("ingot_steel");
    public static ItemSimple ingot_copper = new ItemSimple("ingot_copper");
    public static ItemSimple ingot_lead = new ItemSimple("ingot_lead");
    public static ItemSimple ingot_silver = new ItemSimple("ingot_silver");
    public static ItemSimple ingot_tin = new ItemSimple("ingot_tin");
    public static ItemSimple ingot_bronze = new ItemSimple("ingot_bronze");

    public static ItemSimple plate_bronze = new ItemSimple("plate_bronze");
    public static ItemSimple plate_iron = new ItemSimple("plate_iron");
    public static ItemSimple plate_silver = new ItemSimple("plate_silver");
    public static ItemSimple plate_gold = new ItemSimple("plate_gold");
    public static ItemSimple plate_copper = new ItemSimple("plate_copper");
    public static ItemSimple plate_steel = new ItemSimple("plate_steel");
    public static ItemSimple plate_tin = new ItemSimple("plate_tin");
    public static ItemSimple plate_lead = new ItemSimple("plate_lead");

    public static ItemSimple stick_bronze = new ItemSimple("stick_bronze");
    public static ItemSimple stick_iron = new ItemSimple("stick_iron");
    public static ItemSimple stick_silver = new ItemSimple("stick_silver");
    public static ItemSimple stick_gold = new ItemSimple("stick_gold");
    public static ItemSimple stick_copper = new ItemSimple("stick_copper");
    public static ItemSimple stick_steel = new ItemSimple("stick_steel");
    public static ItemSimple stick_tin = new ItemSimple("stick_tin");
    public static ItemSimple stick_lead = new ItemSimple("stick_lead");

    // Trésors
    public static ItemSimple book_old = new ItemSimple("book_old");
    public static ItemSimple book_wet = new ItemSimple("book_wet");
    public static ItemSimple boot = new ItemSimple("boot");
    public static ItemSimple pearl = new ItemSimple("pearl");
    public static ItemSimple youkounkoun = new ItemSimple("youkounkoun");

    // Misc
    public static ItemDice dice_6f = new ItemDice("dice_6f", 6);
    public static ItemSimple item_hrp = new ItemSimple("item_hrp");
    public static ItemKeyRing keychain_empty = new ItemKeyRing("keychain_empty", 9);
    public static ItemSimpleColor token_stone = new ItemSimpleColor("token_stone");
    public static ItemSimple token_stone_blank = new ItemSimple("token_stone_blank");
    public static ItemSimple cloth_sheet_white = new ItemClothSheet("cloth_sheet_white", EnumDyeColor.WHITE);
    public static ItemSimple cloth_sheet_orange = new ItemClothSheet("cloth_sheet_orange", EnumDyeColor.ORANGE);
    public static ItemSimple cloth_sheet_magenta = new ItemClothSheet("cloth_sheet_magenta", EnumDyeColor.MAGENTA);
    public static ItemSimple cloth_sheet_light_blue = new ItemClothSheet("cloth_sheet_light_blue", EnumDyeColor.LIGHT_BLUE);
    public static ItemSimple cloth_sheet_yellow = new ItemClothSheet("cloth_sheet_yellow", EnumDyeColor.YELLOW);
    public static ItemSimple cloth_sheet_lime = new ItemClothSheet("cloth_sheet_lime", EnumDyeColor.LIME);
    public static ItemSimple cloth_sheet_pink = new ItemClothSheet("cloth_sheet_pink", EnumDyeColor.PINK);
    public static ItemSimple cloth_sheet_gray = new ItemClothSheet("cloth_sheet_gray", EnumDyeColor.GRAY);
    public static ItemSimple cloth_sheet_silver = new ItemClothSheet("cloth_sheet_silver", EnumDyeColor.SILVER);
    public static ItemSimple cloth_sheet_cyan = new ItemClothSheet("cloth_sheet_cyan", EnumDyeColor.CYAN);
    public static ItemSimple cloth_sheet_purple = new ItemClothSheet("cloth_sheet_purple", EnumDyeColor.PURPLE);
    public static ItemSimple cloth_sheet_blue = new ItemClothSheet("cloth_sheet_blue", EnumDyeColor.BLUE);
    public static ItemSimple cloth_sheet_brown = new ItemClothSheet("cloth_sheet_brown", EnumDyeColor.BROWN);
    public static ItemSimple cloth_sheet_green = new ItemClothSheet("cloth_sheet_green", EnumDyeColor.GREEN);
    public static ItemSimple cloth_sheet_red = new ItemClothSheet("cloth_sheet_red", EnumDyeColor.RED);
    public static ItemSimple cloth_sheet_black = new ItemClothSheet("cloth_sheet_black", EnumDyeColor.BLACK);
    public static ItemSimple wool_raw = new ItemSimple("wool_raw");
    public static ItemSimple woolen_thread = new ItemSimple("woolen_thread");
    public static ItemSimple hempen_thread = new ItemSimple("hempen_thread");
    public static ItemSimple linen_thread = new ItemSimple("linen_thread");
    public static ItemSimple leather_scrap = new ItemSimple("leather_scrap");
    public static ItemSimple cinder = new ItemSimple("cinder");
    public static ItemSimple sawdust = new ItemSimple("sawdust");
    public static ItemSimple plant_fiber = new ItemSimple("plant_fiber");

    public static ItemSimple cog = new ItemSimple("cog");
    public static ItemSimple simple_mecanism = new ItemSimple("simple_mecanism");
    public static ItemSimple complex_mecanism = new ItemSimple("complex_mecanism");
    public static ItemSimple sophisticated_mecanism = new ItemSimple("sophisticated_mecanism");

    // Armes
    public static ItemSimpleSword pointed_stick = new ItemSimpleSword("pointed_stick", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword bronze_dagger = new ItemSimpleSword("bronze_dagger", bronzeToolMaterial);
    public static ItemSimpleSword bronze_waraxe = new ItemSimpleSword("bronze_waraxe", bronzeToolMaterial);
    public static ItemSimpleSword bronze_mace = new ItemSimpleSword("bronze_mace", bronzeToolMaterial);
    public static ItemSimpleSword bronze_battlesword = new ItemSimpleSword("bronze_battlesword", bronzeToolMaterial);
    public static ItemSimpleSword bronze_battleaxe = new ItemSimpleSword("bronze_battleaxe", bronzeToolMaterial);
    public static ItemSimpleSword bronze_battlehammer = new ItemSimpleSword("bronze_battlehammer", bronzeToolMaterial);
    public static ItemSimpleSword bronze_spear = new ItemSimpleSword("bronze_spear", bronzeToolMaterial);
    public static ItemSimpleSword bronze_halberd = new ItemSimpleSword("bronze_halberd", bronzeToolMaterial);
    public static ItemSimpleHoe bronze_scythe = new ItemSimpleHoe("bronze_scythe", bronzeToolMaterial);
    public static ItemSimpleSword bronze_saber = new ItemSimpleSword("bronze_saber", bronzeToolMaterial);
    public static ItemSimpleSword bronze_sword = new ItemSimpleSword("bronze_sword", bronzeToolMaterial);
    public static ItemSimpleSword bronze_fork = new ItemSimpleSword("bronze_fork", bronzeToolMaterial);

    public static ItemSimpleSword wood_dagger = new ItemSimpleSword("wood_dagger", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_waraxe = new ItemSimpleSword("wood_waraxe", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_mace = new ItemSimpleSword("wood_mace", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_battlesword = new ItemSimpleSword("wood_battlesword", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_battleaxe = new ItemSimpleSword("wood_battleaxe", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_battlehammer = new ItemSimpleSword("wood_battlehammer", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_spear = new ItemSimpleSword("wood_spear", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_halberd = new ItemSimpleSword("wood_halberd", Item.ToolMaterial.WOOD);
    public static ItemSimpleHoe wood_scythe = new ItemSimpleHoe("wood_scythe", Item.ToolMaterial.WOOD);
    public static ItemSimpleSword wood_saber = new ItemSimpleSword("wood_saber", Item.ToolMaterial.WOOD);

    public static ItemSimpleSword stone_dagger = new ItemSimpleSword("stone_dagger", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_waraxe = new ItemSimpleSword("stone_waraxe", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_mace = new ItemSimpleSword("stone_mace", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_battlesword = new ItemSimpleSword("stone_battlesword", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_battleaxe = new ItemSimpleSword("stone_battleaxe", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_battlehammer = new ItemSimpleSword("stone_battlehammer", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_spear = new ItemSimpleSword("stone_spear", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_halberd = new ItemSimpleSword("stone_halberd", Item.ToolMaterial.STONE);
    public static ItemSimpleHoe stone_scythe = new ItemSimpleHoe("stone_scythe", Item.ToolMaterial.STONE);
    public static ItemSimpleSword stone_saber = new ItemSimpleSword("stone_saber", Item.ToolMaterial.STONE);

    public static ItemSimpleSword iron_dagger = new ItemSimpleSword("iron_dagger", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_waraxe = new ItemSimpleSword("iron_waraxe", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_mace = new ItemSimpleSword("iron_mace", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_battlesword = new ItemSimpleSword("iron_battlesword", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_battleaxe = new ItemSimpleSword("iron_battleaxe", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_battlehammer = new ItemSimpleSword("iron_battlehammer", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_spear = new ItemSimpleSword("iron_spear", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_halberd = new ItemSimpleSword("iron_halberd", Item.ToolMaterial.IRON);
    public static ItemSimpleHoe iron_scythe = new ItemSimpleHoe("iron_scythe", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_saber = new ItemSimpleSword("iron_saber", Item.ToolMaterial.IRON);
    public static ItemSimpleSword iron_fork = new ItemSimpleSword("iron_fork", Item.ToolMaterial.IRON);

    public static ItemSimpleSword gold_dagger = new ItemSimpleSword("gold_dagger", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_waraxe = new ItemSimpleSword("gold_waraxe", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_mace = new ItemSimpleSword("gold_mace", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_battlesword = new ItemSimpleSword("gold_battlesword", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_battleaxe = new ItemSimpleSword("gold_battleaxe", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_battlehammer = new ItemSimpleSword("gold_battlehammer", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_spear = new ItemSimpleSword("gold_spear", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_halberd = new ItemSimpleSword("gold_halberd", Item.ToolMaterial.GOLD);
    public static ItemSimpleHoe gold_scythe = new ItemSimpleHoe("gold_scythe", Item.ToolMaterial.GOLD);
    public static ItemSimpleSword gold_saber = new ItemSimpleSword("gold_saber", Item.ToolMaterial.GOLD);

    public static ItemSimpleSword diamond_dagger = new ItemSimpleSword("diamond_dagger", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_waraxe = new ItemSimpleSword("diamond_waraxe", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_mace = new ItemSimpleSword("diamond_mace", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_battlesword = new ItemSimpleSword("diamond_battlesword", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_battleaxe = new ItemSimpleSword("diamond_battleaxe", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_battlehammer = new ItemSimpleSword("diamond_battlehammer", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_spear = new ItemSimpleSword("diamond_spear", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_halberd = new ItemSimpleSword("diamond_halberd", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleHoe diamond_scythe = new ItemSimpleHoe("diamond_scythe", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_saber = new ItemSimpleSword("diamond_saber", Item.ToolMaterial.DIAMOND);
    public static ItemSimpleSword diamond_fork = new ItemSimpleSword("diamond_fork", Item.ToolMaterial.DIAMOND);

    //Boucliers
    public static ItemSimpleShield wood_shield = new ItemSimpleShield("wood_shield");
    public static ItemSimpleShield stone_shield = new ItemSimpleShield("stone_shield");
    public static ItemSimpleShield iron_shield = new ItemSimpleShield("iron_shield");
    public static ItemSimpleShield gold_shield = new ItemSimpleShield("gold_shield");
    public static ItemSimpleShield diamond_shield = new ItemSimpleShield("diamond_shield");
    public static ItemSimpleShield diamond_shield_full = new ItemSimpleShield("diamond_shield_full");
    //Arcs
    public static ItemSimpleBow longbow = new ItemSimpleBow("longbow");

    public static ItemSimple bronze_pickaxe_head = new ItemSimple("bronze_pickaxe_head");
    public static ItemSimple iron_pickaxe_head = new ItemSimple("iron_pickaxe_head");
    public static ItemSimple steel_pickaxe_head = new ItemSimple("steel_pickaxe_head");
    public static ItemSimple gold_pickaxe_head = new ItemSimple("gold_pickaxe_head");
    public static ItemSimple pickaxe_mold = new ItemSimple("pickaxe_mold");
    public static ItemSimple bronze_shovel_head = new ItemSimple("bronze_shovel_head");
    public static ItemSimple iron_shovel_head = new ItemSimple("iron_shovel_head");
    public static ItemSimple steel_shovel_head = new ItemSimple("steel_shovel_head");
    public static ItemSimple gold_shovel_head = new ItemSimple("gold_shovel_head");
    public static ItemSimple shovel_mold = new ItemSimple("shovel_mold");
    public static ItemSimple bronze_hoe_head = new ItemSimple("bronze_hoe_head");
    public static ItemSimple iron_hoe_head = new ItemSimple("iron_hoe_head");
    public static ItemSimple steel_hoe_head = new ItemSimple("steel_hoe_head");
    public static ItemSimple gold_hoe_head = new ItemSimple("gold_hoe_head");
    public static ItemSimple hoe_mold = new ItemSimple("hoe_mold");
    public static ItemSimple bronze_axe_head = new ItemSimple("bronze_axe_head");
    public static ItemSimple iron_axe_head = new ItemSimple("iron_axe_head");
    public static ItemSimple steel_axe_head = new ItemSimple("steel_axe_head");
    public static ItemSimple gold_axe_head = new ItemSimple("gold_axe_head");
    public static ItemSimple axe_mold = new ItemSimple("axe_mold");
    public static ItemSimple bronze_knife_head = new ItemSimple("bronze_knife_head");
    public static ItemSimple iron_knife_head = new ItemSimple("iron_knife_head");
    public static ItemSimple steel_knife_head = new ItemSimple("steel_knife_head");
    public static ItemSimple gold_knife_head = new ItemSimple("gold_knife_head");
    public static ItemSimple knife_mold = new ItemSimple("knife_mold");
    public static ItemSimple bronze_hammer_head = new ItemSimple("bronze_hammer_head");
    public static ItemSimple iron_hammer_head = new ItemSimple("iron_hammer_head");
    public static ItemSimple steel_hammer_head = new ItemSimple("steel_hammer_head");
    public static ItemSimple gold_hammer_head = new ItemSimple("gold_hammer_head");
    public static ItemSimple hammer_mold = new ItemSimple("hammer_mold");
    public static ItemSimple bronze_scythe_head = new ItemSimple("bronze_scythe_head");
    public static ItemSimple iron_scythe_head = new ItemSimple("iron_scythe_head");
    public static ItemSimple steel_scythe_head = new ItemSimple("steel_scythe_head");
    public static ItemSimple gold_scythe_head = new ItemSimple("gold_scythe_head");
    public static ItemSimple scythe_mold = new ItemSimple("scythe_mold");

    public static ItemSimple bronze_sword_head = new ItemSimple("bronze_sword_head");
    public static ItemSimple iron_sword_head = new ItemSimple("iron_sword_head");
    public static ItemSimple steel_sword_head = new ItemSimple("steel_sword_head");
    public static ItemSimple gold_sword_head = new ItemSimple("gold_sword_head");
    public static ItemSimple sword_mold = new ItemSimple("sword_mold");
    public static ItemSimple bronze_saber_head = new ItemSimple("bronze_saber_head");
    public static ItemSimple iron_saber_head = new ItemSimple("iron_saber_head");
    public static ItemSimple steel_saber_head = new ItemSimple("steel_saber_head");
    public static ItemSimple gold_saber_head = new ItemSimple("gold_saber_head");
    public static ItemSimple saber_mold = new ItemSimple("saber_mold");
    public static ItemSimple bronze_spear_head = new ItemSimple("bronze_spear_head");
    public static ItemSimple iron_spear_head = new ItemSimple("iron_spear_head");
    public static ItemSimple steel_spear_head = new ItemSimple("steel_spear_head");
    public static ItemSimple gold_spear_head = new ItemSimple("gold_spear_head");
    public static ItemSimple spear_mold = new ItemSimple("spear_mold");
    public static ItemSimple bronze_dagger_head = new ItemSimple("bronze_dagger_head");
    public static ItemSimple iron_dagger_head = new ItemSimple("iron_dagger_head");
    public static ItemSimple steel_dagger_head = new ItemSimple("steel_dagger_head");
    public static ItemSimple gold_dagger_head = new ItemSimple("gold_dagger_head");
    public static ItemSimple dagger_mold = new ItemSimple("dagger_mold");
    public static ItemSimple bronze_warhammer_head = new ItemSimple("bronze_warhammer_head");
    public static ItemSimple iron_warhammer_head = new ItemSimple("iron_warhammer_head");
    public static ItemSimple steel_warhammer_head = new ItemSimple("steel_warhammer_head");
    public static ItemSimple gold_warhammer_head = new ItemSimple("gold_warhammer_head");
    public static ItemSimple warhammer_mold = new ItemSimple("warhammer_mold");
    public static ItemSimple bronze_halberd_head = new ItemSimple("bronze_halberd_head");
    public static ItemSimple iron_halberd_head = new ItemSimple("iron_halberd_head");
    public static ItemSimple steel_halberd_head = new ItemSimple("steel_halberd_head");
    public static ItemSimple gold_halberd_head = new ItemSimple("gold_halberd_head");
    public static ItemSimple halberd_mold = new ItemSimple("halberd_mold");
    public static ItemSimple bronze_waraxe_head = new ItemSimple("bronze_waraxe_head");
    public static ItemSimple iron_waraxe_head = new ItemSimple("iron_waraxe_head");
    public static ItemSimple steel_waraxe_head = new ItemSimple("steel_waraxe_head");
    public static ItemSimple gold_waraxe_head = new ItemSimple("gold_waraxe_head");
    public static ItemSimple waraxe_mold = new ItemSimple("waraxe_mold");
    public static ItemSimple bronze_mace_head = new ItemSimple("bronze_mace_head");
    public static ItemSimple iron_mace_head = new ItemSimple("iron_mace_head");
    public static ItemSimple steel_mace_head = new ItemSimple("steel_mace_head");
    public static ItemSimple gold_mace_head = new ItemSimple("gold_mace_head");
    public static ItemSimple mace_mold = new ItemSimple("mace_mold");
    public static ItemSimple bronze_battlesword_head = new ItemSimple("bronze_battlesword_head");
    public static ItemSimple iron_battlesword_head = new ItemSimple("iron_battlesword_head");
    public static ItemSimple steel_battlesword_head = new ItemSimple("steel_battlesword_head");
    public static ItemSimple gold_battlesword_head = new ItemSimple("gold_battlesword_head");
    public static ItemSimple battlesword_mold = new ItemSimple("battlesword_mold");

    public static ItemSimple bronze_chef_knife_head = new ItemSimple("bronze_chef_knife_head");
    public static ItemSimple iron_chef_knife_head = new ItemSimple("iron_chef_knife_head");
    public static ItemSimple steel_chef_knife_head = new ItemSimple("steel_chef_knife_head");
    public static ItemSimple chef_knife_mold = new ItemSimple("chef_knife_mold");
    public static ItemSimple bronze_sickle_head = new ItemSimple("bronze_sickle_head");
    public static ItemSimple iron_sickle_head = new ItemSimple("iron_sickle_head");
    public static ItemSimple steel_sickle_head = new ItemSimple("steel_sickle_head");
    public static ItemSimple sickle_mold = new ItemSimple("sickle_mold");
    public static ItemSimple bronze_lime_head = new ItemSimple("bronze_lime_head");
    public static ItemSimple iron_lime_head = new ItemSimple("iron_lime_head");
    public static ItemSimple steel_lime_head = new ItemSimple("steel_lime_head");
    public static ItemSimple lime_mold = new ItemSimple("lime_mold");
    public static ItemSimple bronze_saw_head = new ItemSimple("bronze_saw_head");
    public static ItemSimple iron_saw_head = new ItemSimple("iron_saw_head");
    public static ItemSimple steel_saw_head = new ItemSimple("steel_saw_head");
    public static ItemSimple saw_mold = new ItemSimple("saw_mold");
    public static ItemSimple bronze_chisel_head = new ItemSimple("bronze_chisel_head");
    public static ItemSimple iron_chisel_head = new ItemSimple("iron_chisel_head");
    public static ItemSimple steel_chisel_head = new ItemSimple("steel_chisel_head");
    public static ItemSimple chisel_mold = new ItemSimple("chisel_mold");

    public static ItemSimple amethyst_gemstone = new ItemSimple("amethyst_gemstone");
    public static ItemSimple amethyst_cut = new ItemSimple("amethyst_cut");
    public static ItemSimple aquamarine_gemstone = new ItemSimple("aquamarine_gemstone");
    public static ItemSimple aquamarine_cut = new ItemSimple("aquamarine_cut");
    public static ItemSimple charoite_gemstone = new ItemSimple("charoite_gemstone");
    public static ItemSimple charoite_cut = new ItemSimple("charoite_cut");
    public static ItemSimple citrine_gemstone = new ItemSimple("citrine_gemstone");
    public static ItemSimple citrine_cut = new ItemSimple("citrine_cut");
    public static ItemSimple coraline_gemstone = new ItemSimple("coraline_gemstone");
    public static ItemSimple coraline_cut = new ItemSimple("coraline_cut");
    public static ItemSimple hematite_gemstone = new ItemSimple("hematite_gemstone");
    public static ItemSimple hematite_cut = new ItemSimple("hematite_cut");
    public static ItemSimple malachite_gemstone = new ItemSimple("malachite_gemstone");
    public static ItemSimple malachite_cut = new ItemSimple("malachite_cut");
    public static ItemSimple opale_gemstone = new ItemSimple("opale_gemstone");
    public static ItemSimple opale_cut = new ItemSimple("opale_cut");
    public static ItemSimple quartz_gemstone = new ItemSimple("quartz_gemstone");
    public static ItemSimple quartz_cut = new ItemSimple("quartz_cut");
    public static ItemSimple quartzrose_gemstone = new ItemSimple("quartzrose_gemstone");
    public static ItemSimple quartzrose_cut = new ItemSimple("quartzrose_cut");
    public static ItemSimple ruby_gemstone = new ItemSimple("ruby_gemstone");
    public static ItemSimple ruby_cut = new ItemSimple("ruby_cut");
    public static ItemSimple tigereye_gemstone = new ItemSimple("tigereye_gemstone");
    public static ItemSimple tigereye_cut = new ItemSimple("tigereye_cut");
    public static ItemSimple tourmaline_gemstone = new ItemSimple("tourmaline_gemstone");
    public static ItemSimple tourmaline_cut = new ItemSimple("tourmaline_cut");
    public static ItemSimple turquoise_gemstone = new ItemSimple("turquoise_gemstone");
    public static ItemSimple turquoise_cut = new ItemSimple("turquoise_cut");

    // Outils
    public static ItemSimpleClean broom = new ItemSimpleClean("broom");
    public static ItemSimpleSpade bronze_spade = new ItemSimpleSpade("bronze_spade", bronzeToolMaterial);
    public static ItemSimpleAxe bronze_axe = new ItemSimpleAxe("bronze_axe", bronzeToolMaterial);
    public static ItemSimplePickaxe bronze_pickaxe = new ItemSimplePickaxe("bronze_pickaxe", bronzeToolMaterial);
    public static ItemSimpleHoe bronze_hoe = new ItemSimpleHoe("bronze_hoe", bronzeToolMaterial);
    public static ItemSimpleTool bronze_knife = new ItemSimpleTool("bronze_knife", 125);
    public static ItemSimpleTool bronze_hammer = new ItemSimpleTool("bronze_hammer", 125);
    public static ItemSimpleTool wood_knife = new ItemSimpleTool("wood_knife", 32);
    public static ItemSimpleTool wood_hammer = new ItemSimpleTool("wood_hammer", 32);
    public static ItemSimpleTool stone_knife = new ItemSimpleTool("stone_knife", 64);
    public static ItemSimpleTool stone_hammer = new ItemSimpleTool("stone_hammer", 64);
    public static ItemSimpleTool iron_knife = new ItemSimpleTool("iron_knife", 192);
    public static ItemSimpleTool iron_hammer = new ItemSimpleTool("iron_hammer", 250);
    public static ItemSimpleTool gold_knife = new ItemSimpleTool("gold_knife", 32);
    public static ItemSimpleTool gold_hammer = new ItemSimpleTool("gold_hammer", 32);
    public static ItemSimpleTool diamond_knife = new ItemSimpleTool("diamond_knife", 320);
    public static ItemSimpleTool diamond_hammer = new ItemSimpleTool("diamond_hammer", 500);
    public static ItemSimpleTool bronze_chef_knife = new ItemSimpleTool("bronze_chef_knife", 125);
    public static ItemSimpleTool iron_chef_knife = new ItemSimpleTool("iron_chef_knife", 192);
    public static ItemSimpleTool steel_chef_knife = new ItemSimpleTool("steel_chef_knife", 320);
    public static ItemSimpleTool bronze_lime = new ItemSimpleTool("bronze_lime", 125);
    public static ItemSimpleTool iron_lime = new ItemSimpleTool("iron_lime", 250);
    public static ItemSimpleTool steel_lime = new ItemSimpleTool("steel_lime", 500);
    public static ItemSimpleTool bronze_sickle = new ItemSimpleTool("bronze_sickle", 125);
    public static ItemSimpleTool iron_sickle = new ItemSimpleTool("iron_sickle", 192);
    public static ItemSimpleTool steel_sickle = new ItemSimpleTool("steel_sickle", 320);
    public static ItemSimpleTool bronze_saw = new ItemSimpleTool("bronze_saw", 125);
    public static ItemSimpleTool iron_saw = new ItemSimpleTool("iron_saw", 192);
    public static ItemSimpleTool steel_saw = new ItemSimpleTool("steel_saw", 320);
    public static ItemSimpleTool bronze_chisel = new ItemSimpleTool("bronze_chisel", 125);
    public static ItemSimpleTool iron_chisel = new ItemSimpleTool("iron_chisel", 192);
    public static ItemSimpleTool steel_chisel = new ItemSimpleTool("steel_chisel", 320);
    public static ItemRockHammer bronze_rock_hammer = new ItemRockHammer("bronze_rock_hammer", ToolMaterial.STONE);
    public static ItemRockHammer iron_rock_hammer = new ItemRockHammer("iron_rock_hammer", ToolMaterial.IRON);
    public static ItemRockHammer steel_rock_hammer = new ItemRockHammer("steel_rock_hammer", ToolMaterial.DIAMOND);
    public static ItemSimpleTool brush = new ItemSimpleTool("brush", 64);

    // Agriculture
    public static ItemSeedBarley barley_seeds;
    public static ItemSeedLettuce lettuce_seeds;
    public static ItemSimple barley = new ItemSimple("barley");
    public static ItemFoodSimple lettuce = new ItemFoodSimple("lettuce", 4, 0.3F, false);
    public static ItemSeedFoodTurnip turnip;
    public static ItemSeedFlax flax_seeds;
    public static ItemSimple flax = new ItemSimple("flax");
    public static ItemSeedHemp hemp_seeds;
    public static ItemSimple hemp = new ItemSimple("hemp");
    public static ItemCepGrapes grapes_ceps;
    public static ItemSimple grapes_seeds = new ItemSimple("grapes_seeds");
    public static ItemFoodSimple grapes = new ItemFoodSimple("grapes", 4, 0.3F, false);
    public static ItemCepTomato tomato_ceps;
    public static ItemSimple tomato_seeds = new ItemSimple("tomato_seeds");
    public static ItemFoodSimple tomato = new ItemFoodSimple("tomato", 4, 0.3F, false);

    // Items seulement, manque les pousses
    public static ItemSimple tea_grounded = new ItemSimple("tea_grounded");
    public static ItemFoodSimple walnut = new ItemFoodSimple("walnut", 4, 0.3F, false);
    public static ItemFoodSimple apricot = new ItemFoodSimple("apricot", 4, 0.3F, false);
    public static ItemFoodSimple garlic = new ItemFoodSimple("garlic", 4, 0.3F, false);
    public static ItemFoodSimple almonds = new ItemFoodSimple("almonds", 4, 0.3F, false);
    public static ItemFoodSimple pineapple = new ItemFoodSimple("pineapple", 4, 0.3F, false);
    public static ItemFoodSimple eggplant = new ItemFoodSimple("eggplant", 4, 0.3F, false);
    public static ItemFoodSimple avocado = new ItemFoodSimple("avocado", 4, 0.3F, false);
    public static ItemFoodSimple banana = new ItemFoodSimple("banana", 4, 0.3F, false);
    public static ItemFoodSimple broccoli = new ItemFoodSimple("broccoli", 4, 0.3F, false);
    public static ItemFoodSimple cassis = new ItemFoodSimple("cassis", 4, 0.3F, false);
    public static ItemFoodSimple chestnut = new ItemFoodSimple("chestnut", 4, 0.3F, false);
    public static ItemFoodSimple cherry = new ItemFoodSimple("cherry", 4, 0.3F, false);
    public static ItemFoodSimple cauliflower = new ItemFoodSimple("cauliflower", 4, 0.3F, false);
    public static ItemFoodSimple cabbage = new ItemFoodSimple("cabbage", 4, 0.3F, false);
    public static ItemFoodSimple dates = new ItemFoodSimple("dates", 4, 0.3F, false);
    public static ItemFoodSimple endive = new ItemFoodSimple("endive", 4, 0.3F, false);
    public static ItemFoodSimple bean = new ItemFoodSimple("bean", 4, 0.3F, false);
    public static ItemFoodSimple fig = new ItemFoodSimple("fig", 4, 0.3F, false);
    public static ItemFoodSimple strawberry = new ItemFoodSimple("strawberry", 4, 0.3F, false);
    public static ItemFoodSimple raspberry = new ItemFoodSimple("raspberry", 4, 0.3F, false);
    public static ItemFoodSimple grapes_white = new ItemFoodSimple("grapes_white", 4, 0.3F, false);
    public static ItemFoodSimple grapes_red = new ItemFoodSimple("grapes_red", 4, 0.3F, false);
    public static ItemFoodSimple pomegranate = new ItemFoodSimple("pomegranate", 4, 0.3F, false);
    public static ItemFoodSimple beans_white = new ItemFoodSimple("beans_white", 4, 0.3F, false);
    public static ItemFoodSimple beans_red = new ItemFoodSimple("beans_red", 4, 0.3F, false);
    public static ItemFoodSimple blackberry = new ItemFoodSimple("blackberry", 4, 0.3F, false);
    public static ItemFoodSimple blueberry = new ItemFoodSimple("blueberry", 4, 0.3F, false);
    public static ItemFoodSimple onion = new ItemFoodSimple("onion", 4, 0.3F, false);
    public static ItemFoodSimple olives_black = new ItemFoodSimple("olives_black", 4, 0.3F, false);
    public static ItemFoodSimple olives_green = new ItemFoodSimple("olives_green", 4, 0.3F, false);
    public static ItemFoodSimple orange = new ItemFoodSimple("orange", 4, 0.3F, false);
    public static ItemFoodSimple peach = new ItemFoodSimple("peach", 4, 0.3F, false);
    public static ItemFoodSimple pear = new ItemFoodSimple("pear", 4, 0.3F, false);
    public static ItemFoodSimple leek = new ItemFoodSimple("leek", 4, 0.3F, false);
    public static ItemFoodSimple pepper_red = new ItemFoodSimple("pepper_red", 4, 0.3F, false);
    public static ItemFoodSimple pepper_yellow = new ItemFoodSimple("pepper_yellow", 4, 0.3F, false);
    public static ItemFoodSimple pepper_green = new ItemFoodSimple("pepper_green", 4, 0.3F, false);
    public static ItemFoodSimple pepper_chilli = new ItemFoodSimple("pepper_chilli", 4, 0.3F, false);
    public static ItemFoodSimple prunes = new ItemFoodSimple("prunes", 4, 0.3F, false);
    public static ItemFoodSimple radish = new ItemFoodSimple("radish", 4, 0.3F, false);
    public static ItemFoodSimple jerusalem_artichoke = new ItemFoodSimple("jerusalem_artichoke", 4, 0.3F, false);
    public static ItemFoodSimple salsify = new ItemFoodSimple("salsify", 4, 0.3F, false);
    public static ItemFoodSimple plums = new ItemFoodSimple("plums", 4, 0.3F, false);
    public static ItemFoodSimple lemon = new ItemFoodSimple("lemon", 4, 0.3F, false);

    // Animal Stuff
    public static ItemSimple fat_animal = new ItemSimple("fat_animal");
    public static ItemSimple bear_fur = new ItemSimple("bear_fur");
    public static ItemSimple wolf_fur = new ItemSimple("wolf_fur");
    public static ItemSimple fox_fur = new ItemSimple("fox_fur");
    public static ItemSimple deer_leather = new ItemSimple("deer_leather");
    public static ItemSimple boar_leather = new ItemSimple("boar_leather");
    public static ItemSimple tanned_leather = new ItemSimple("tanned_leather");
    public static ItemSimple tanned_skin = new ItemSimple("tanned_skin");

    // Epices / Spice
    public static ItemDrinkSimple spice_cinnamon = new ItemDrinkSimple("spice_cinnamon", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_capers = new ItemDrinkSimple("spice_capers", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_curcuma = new ItemDrinkSimple("spice_curcuma", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_ginger = new ItemDrinkSimple("spice_ginger", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_clove = new ItemDrinkSimple("spice_clove", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_carrogia_herbs = new ItemDrinkSimple("spice_carrogia_herbs", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_manigette = new ItemDrinkSimple("spice_manigette", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_nutmeg = new ItemDrinkSimple("spice_nutmeg", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_paprika = new ItemDrinkSimple("spice_paprika", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_poppy = new ItemDrinkSimple("spice_poppy", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_pepper = new ItemDrinkSimple("spice_pepper", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_saffron = new ItemDrinkSimple("spice_saffron", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_truffle = new ItemDrinkSimple("spice_truffle", -2, 0.0F, glass_jar_empty, 8);
    public static ItemDrinkSimple spice_vanilla = new ItemDrinkSimple("spice_vanilla", -2, 0.0F, glass_jar_empty, 8);

    public static ItemSimpleTool blow_pin = new ItemSimpleTool("blow_pin", 125);
    public static ItemSimpleTool pliers = new ItemSimpleTool("pliers", 125);
    public static ItemSimple ingot_mold = new ItemSimple("ingot_mold");
    public static ItemSimpleTool magnifying_glass = new ItemSimpleTool("magnifying_glass", 64);
    public static ItemSimpleTool stone_pestle_mortar = new ItemSimpleTool("wooden_pestle_mortar", 125);
    public static ItemSimpleTool wooden_pestle_mortar = new ItemSimpleTool("stone_pestle_mortar", 250);
    public static Item rock_hammer;
    public static ItemSimpleTool weaver_tools = new ItemSimpleTool("weaver_tools", 125);
    public static ItemSimple nails = new ItemSimple("nails");
    // TODO SAW

    // apiculture
    public static ItemBeeArmor bee_helmet = new ItemBeeArmor(ItemBeeArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.HEAD, "beekeeper_helmet");
    public static ItemBeeArmor bee_chest = new ItemBeeArmor(ItemBeeArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "beekeeper_chest");
    public static ItemBeeArmor bee_legging = new ItemBeeArmor(ItemBeeArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "beekeeper_legging");
    public static ItemBeeArmor bee_boots = new ItemBeeArmor(ItemBeeArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.FEET, "beekeeper_boots");
    public static ItemChain arm_chain = new ItemChain(ItemBeeArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "arm_chain");
    public static ItemChain feet_chain = new ItemChain(ItemBeeArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.FEET, "feet_chain");

    // serrures & clefs
    public static ItemSerrure lock_copper = new ItemSerrure("lock_copper");
    public static ItemSerrure lock_iron = new ItemSerrure("lock_iron");
    public static ItemSerrure lock_steel = new ItemSerrure("lock_steel");
    public static ItemSerrure lock_gold = new ItemSerrure("lock_gold");
    public static ItemSimple lockpick_iron = new ItemSimple("lockpick_iron");
    public static ItemSimple lockpick_steel = new ItemSimple("lockpick_steel");
    public static ItemSimple lockpick_gold = new ItemSimple("lockpick_gold");
    public static ItemKey key_copper = new ItemKey("key_copper");
    public static ItemKey key_iron = new ItemKey("key_iron");
    public static ItemKey key_steel = new ItemKey("key_steel");
    public static ItemKey key_gold = new ItemKey("key_gold");
    public static ItemSimple nude_key_copper = new ItemSimple("nude_key_copper");
    public static ItemSimple nude_key_iron = new ItemSimple("nude_key_iron");
    public static ItemSimple nude_key_steel = new ItemSimple("nude_key_steel");
    public static ItemSimple nude_key_gold = new ItemSimple("nude_key_gold");

    // tableau
    //public static Item item_tableau_esperia;
    // bourse
    public static ItemContainer purse_cloth = new ItemContainer("purse_cloth", 2);
    public static ItemContainer purse_leather = new ItemContainer("purse_leather", 3);
    public static ItemContainer purse_decorated = new ItemContainer("purse_decorated", 4);
    public static ItemContainer basket = new ItemContainer("basket", 4);
    public static ItemBackpack backpack = new ItemBackpack(ItemBackpack.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "backpack");

    public static ItemSimple pipe_ornate = new ItemSimple("pipe_ornate");
    //pancartes
    //public static ItemWallNoteEsperia wall_note_item = new ItemWallNoteEsperia("wall_note_item", Material.WOOD);
    public static ItemSignEsperia sign_hrp_item = new ItemSignEsperia("sign_hrp", Material.WOOD);
    public static ItemSignEsperia sign_stone_item = new ItemSignEsperia("sign_stone", Material.ROCK);
    
    public static ItemDice dice_4f = new ItemDice("dice_4f", 4);
    public static ItemDice dice_8f = new ItemDice("dice_8f", 8);
    public static ItemDice dice_10f = new ItemDice("dice_10f", 10);
    public static ItemDice dice_12f = new ItemDice("dice_12f", 12);
    public static ItemDice dice_20f = new ItemDice("dice_20f", 20);
    
    public static ItemDiceGlass dice_glass = new ItemDiceGlass("dice_glass", 6);
    
    public static ItemSimple rook = new ItemChessPiece("rook", 0x88684d);
    public static ItemSimple knight = new ItemChessPiece("knight", 0x88684d);
    public static ItemSimple bishop = new ItemChessPiece("bishop", 0x88684d);
    public static ItemSimple king = new ItemChessPiece("king", 0x88684d);
    public static ItemSimple queen = new ItemChessPiece("queen", 0x88684d);
    public static ItemSimple pawn = new ItemChessPiece("pawn", 0x88684d);
    
    public static ItemCard ace_heart = new ItemCard("ace_heart");
    public static ItemCard two_heart = new ItemCard("two_heart");
    public static ItemCard three_heart = new ItemCard("three_heart");
    public static ItemCard four_heart = new ItemCard("four_heart");
    public static ItemCard five_heart = new ItemCard("five_heart");
    public static ItemCard six_heart = new ItemCard("six_heart");
    public static ItemCard seven_heart = new ItemCard("seven_heart");
    public static ItemCard eight_heart = new ItemCard("eight_heart");
    public static ItemCard nine_heart = new ItemCard("nine_heart");
    public static ItemCard ten_heart = new ItemCard("ten_heart");
    public static ItemCard jack_heart = new ItemCard("jack_heart");
    public static ItemCard queen_heart = new ItemCard("queen_heart");
    public static ItemCard king_heart = new ItemCard("king_heart");
    public static ItemCard ace_diamond = new ItemCard("ace_diamond");
    public static ItemCard two_diamond = new ItemCard("two_diamond");
    public static ItemCard three_diamond = new ItemCard("three_diamond");
    public static ItemCard four_diamond = new ItemCard("four_diamond");
    public static ItemCard five_diamond = new ItemCard("five_diamond");
    public static ItemCard six_diamond = new ItemCard("six_diamond");
    public static ItemCard seven_diamond = new ItemCard("seven_diamond");
    public static ItemCard eight_diamond = new ItemCard("eight_diamond");
    public static ItemCard nine_diamond = new ItemCard("nine_diamond");
    public static ItemCard ten_diamond = new ItemCard("ten_diamond");
    public static ItemCard jack_diamond = new ItemCard("jack_diamond");
    public static ItemCard queen_diamond = new ItemCard("queen_diamond");
    public static ItemCard king_diamond = new ItemCard("king_diamond");
    public static ItemCard ace_club = new ItemCard("ace_club");
    public static ItemCard two_club = new ItemCard("two_club");
    public static ItemCard three_club = new ItemCard("three_club");
    public static ItemCard four_club = new ItemCard("four_club");
    public static ItemCard five_club = new ItemCard("five_club");
    public static ItemCard six_club = new ItemCard("six_club");
    public static ItemCard seven_club = new ItemCard("seven_club");
    public static ItemCard eight_club = new ItemCard("eight_club");
    public static ItemCard nine_club = new ItemCard("nine_club");
    public static ItemCard ten_club = new ItemCard("ten_club");
    public static ItemCard jack_club = new ItemCard("jack_club");
    public static ItemCard queen_club = new ItemCard("queen_club");
    public static ItemCard king_club = new ItemCard("king_club");
    public static ItemCard ace_spade = new ItemCard("ace_spade");
    public static ItemCard two_spade = new ItemCard("two_spade");
    public static ItemCard three_spade = new ItemCard("three_spade");
    public static ItemCard four_spade = new ItemCard("four_spade");
    public static ItemCard five_spade = new ItemCard("five_spade");
    public static ItemCard six_spade = new ItemCard("six_spade");
    public static ItemCard seven_spade = new ItemCard("seven_spade");
    public static ItemCard eight_spade = new ItemCard("eight_spade");
    public static ItemCard nine_spade = new ItemCard("nine_spade");
    public static ItemCard ten_spade = new ItemCard("ten_spade");
    public static ItemCard jack_spade = new ItemCard("jack_spade");
    public static ItemCard queen_spade = new ItemCard("queen_spade");
    public static ItemCard king_spade = new ItemCard("king_spade");    
    public static ItemSimple petanque_iron_ball = new ItemSimple("petanque_iron_ball");
    public static ItemSimple petanque_bronze_ball = new ItemSimple("petanque_bronze_ball");
    public static ItemSimpleColor petanque_pork_ball = new ItemSimpleColor("petanque_pork_ball", 9268533);
    
    public static ItemSimple oak_block = new ItemSimple("oak_block");
    public static ItemSimple birch_block = new ItemSimple("birch_block");
    public static ItemSimple spruce_block = new ItemSimple("spruce_block");
    public static ItemSimple jungle_block = new ItemSimple("jungle_block");
    public static ItemSimple dark_oak_block = new ItemSimple("dark_oak_block");
    public static ItemSimple acacia_block = new ItemSimple("acacia_block");
    
    public static ItemRepairWheel rock_wheel = new ItemRepairWheel("rock_wheel");
    
    public static ItemJewelry gold_amethyst_jewelry = new ItemJewelry("gold_amethyst_jewelry");
    public static ItemJewelry gold_aquamarine_jewelry = new ItemJewelry("gold_aquamarine_jewelry");
    public static ItemJewelry gold_charoite_jewelry = new ItemJewelry("gold_charoite_jewelry");
    public static ItemJewelry gold_citrine_jewelry = new ItemJewelry("gold_citrine_jewelry");
    public static ItemJewelry gold_coraline_jewelry = new ItemJewelry("gold_coraline_jewelry");
    public static ItemJewelry gold_diamond_jewelry = new ItemJewelry("gold_diamond_jewelry");
    public static ItemJewelry gold_emerald_jewelry = new ItemJewelry("gold_emerald_jewelry");
    public static ItemJewelry gold_hematite_jewelry = new ItemJewelry("gold_hematite_jewelry");
    public static ItemJewelry gold_lapis_jewelry = new ItemJewelry("gold_lapis_jewelry");
    public static ItemJewelry gold_malachite_jewelry = new ItemJewelry("gold_malachite_jewelry");
    public static ItemJewelry gold_opale_jewelry = new ItemJewelry("gold_opale_jewelry");
    public static ItemJewelry gold_quartz_jewelry = new ItemJewelry("gold_quartz_jewelry");
    public static ItemJewelry gold_quartzrose_jewelry = new ItemJewelry("gold_quartzrose_jewelry");
    public static ItemJewelry gold_ruby_jewelry = new ItemJewelry("gold_ruby_jewelry");
    public static ItemJewelry gold_tigereye_jewelry = new ItemJewelry("gold_tigereye_jewelry");
    public static ItemJewelry gold_tourmaline_jewelry = new ItemJewelry("gold_tourmaline_jewelry");
    public static ItemJewelry gold_turquoise_jewelry = new ItemJewelry("gold_turquoise_jewelry");
    public static ItemJewelry silver_amethyst_jewelry = new ItemJewelry("silver_amethyst_jewelry");
    public static ItemJewelry silver_aquamarine_jewelry = new ItemJewelry("silver_aquamarine_jewelry");
    public static ItemJewelry silver_charoite_jewelry = new ItemJewelry("silver_charoite_jewelry");
    public static ItemJewelry silver_citrine_jewelry = new ItemJewelry("silver_citrine_jewelry");
    public static ItemJewelry silver_coraline_jewelry = new ItemJewelry("silver_coraline_jewelry");
    public static ItemJewelry silver_diamond_jewelry = new ItemJewelry("silver_diamond_jewelry");
    public static ItemJewelry silver_emerald_jewelry = new ItemJewelry("silver_emerald_jewelry");
    public static ItemJewelry silver_hematite_jewelry = new ItemJewelry("silver_hematite_jewelry");
    public static ItemJewelry silver_lapis_jewelry = new ItemJewelry("silver_lapis_jewelry");
    public static ItemJewelry silver_malachite_jewelry = new ItemJewelry("silver_malachite_jewelry");
    public static ItemJewelry silver_opale_jewelry = new ItemJewelry("silver_opale_jewelry");
    public static ItemJewelry silver_quartz_jewelry = new ItemJewelry("silver_quartz_jewelry");
    public static ItemJewelry silver_quartzrose_jewelry = new ItemJewelry("silver_quartzrose_jewelry");
    public static ItemJewelry silver_ruby_jewelry = new ItemJewelry("silver_ruby_jewelry");
    public static ItemJewelry silver_tigereye_jewelry = new ItemJewelry("silver_tigereye_jewelry");
    public static ItemJewelry silver_tourmaline_jewelry = new ItemJewelry("silver_tourmaline_jewelry");
    public static ItemJewelry silver_turquoise_jewelry = new ItemJewelry("silver_turquoise_jewelry");
    public static ItemJewelry copper_jewelry = new ItemJewelry("copper_jewelry");
    public static ItemJewelry silver_jewelry = new ItemJewelry("silver_jewelry");
    public static ItemJewelry gold_jewelry = new ItemJewelry("gold_jewelry");
    
    public static ItemSimple blue_slate_shard = new ItemSimple("blue_slate_shard");
    public static ItemSimple clay_slate_tile = new ItemSimple("clay_slate_tile");


    //Init items that require blocks to be registered
    public static void initSeeds() {
        barley_seeds = new ItemSeedBarley();
        lettuce_seeds = new ItemSeedLettuce();
        turnip = new ItemSeedFoodTurnip();
        flax_seeds = new ItemSeedFlax();
        hemp_seeds = new ItemSeedHemp();
        grapes_ceps = new ItemCepGrapes();
        tomato_ceps = new ItemCepTomato();
        cheese = new ItemBlockSpecialCake(BlocksRegistry.cheese_wheel, "cheese");
        bluecheese = new ItemBlockSpecialCake(BlocksRegistry.bluecheese_wheel, "bluecheese");
    }

    public static void register(IForgeRegistry<Item> registry) {
        bronzeToolMaterial.setRepairItem(new ItemStack(bronze_nugget));
        initSeeds(); //NEVER DO THIS AGAIN!
        registry.registerAll(
                ef,
                eo,
                el,
                ed,
                coin_copper,
                coin_silver,
                coin_gold_1,
                coin_gold_2,
                glass_jar_empty,
                glass_jar_bee,
                glass_bottle_empty,
                glass_bottle_rum_empty,
                teapot,
                clay_mug_empty,
                glass_mug_empty,
                glass_tumbler_empty,
                glass_tumbler_dirty,
                glass_mug_dirty,
                clay_mug_dirty,
                gourd_empty,
                gourd,
                glass_jar_water,
                glass_jar_milk,
                teapot_water,
                teapot_hotwater,
                teapot_milk,
                teapot_hotmilk,
                clay_mug_beer,
                clay_mug_mead,
                clay_mug_milk,
                clay_mug_water,
                clay_mug_hotcocoa,
                clay_mug_hotmilk,
                clay_mug_hottea,
                clay_mug_hotwater,
                glass_bottle_water,
                glass_bottle_milk,
                glass_bottle_apple,
                glass_bottle_cider,
                glass_bottle_grapes,
                glass_bottle_vine,
                glass_bottle_sugarcane,
                glass_bottle_beer,
                glass_bottle_mead,
                glass_bottle_rum,
                glass_mug_beer,
                glass_mug_mead,
                glass_tumbler_apple,
                glass_tumbler_cider,
                glass_tumbler_grapes,
                glass_tumbler_vine,
                glass_tumbler_milk,
                glass_tumbler_sugarcane,
                glass_tumbler_rum,
                glass_tumbler_water,
                metal_bucket_apple,
                metal_bucket_cider,
                metal_bucket_barley,
                metal_bucket_beer,
                metal_bucket_grapes,
                metal_bucket_vine,
                metal_bucket_honey,
                metal_bucket_mead,
                metal_bucket_sugarcane,
                metal_bucket_rum,
                metal_bucket_goatmilk,
                wooden_bucket,
                wooden_bucket_water,
                wooden_bucket_milk,
                wooden_bucket_apple,
                wooden_bucket_cider,
                wooden_bucket_barley,
                wooden_bucket_beer,
                wooden_bucket_grapes,
                wooden_bucket_vine,
                wooden_bucket_honey,
                wooden_bucket_mead,
                wooden_bucket_sugarcane,
                wooden_bucket_rum,
                wooden_bucket_goatmilk,
                flour,
                dough,
                biscuit_chocolate,
                boarchop_raw,
                boarchop_cooked,
                cake_slice,
                pumpkin_pie_slice,
                cheese,
                cheese_slice,
                bluecheese,
                bluecheese_slice,
                chocolate,
                egg_boiled,
                egg_fried,
                esper_chocolate,
                fish_herring_raw,
                fish_herring_cooked,
                fish_sardine_raw,
                fish_sardine_cooked,
                fish_trout_raw,
                fish_trout_cooked,
                fish_soup,
                llama_raw,
                llama_cooked,
                bear_raw,
                bear_cooked,
                goat_raw,
                goat_cooked,
                duck_raw,
                duck_cooked,
                deer_raw,
                deer_cooked,
                honey,
                horse_raw,
                horse_cooked,
                larva_raw,
                larva_cooked,
                pumpkin_soup,
                squid_raw,
                squid_cooked,
                glass_jar_marmalade_apple,
                glass_jar_marmalade_grapes,
                rotten_fish,
                rotten_fruit,
                rotten_vegetable,
                rotten_starchy,
                rotten_egg,
                rotten_drink,
                plush_bear,
                plush_sheep,
                doll,
                cloth_boots,
                cloth_shirt,
                cloth_gloves,
                cloth_skirt,
                cloth_longcoat,
                cloth_coat,
                cloth_trousers,
                cloth_habit,
                cloth_robe,
                cloth_underwear_m,
                cloth_underwear_f,
                cocoa,
                butter,
                salt,
                wax,
                roll_blank,
                diamond_raw,
                emerald_raw,
                ink_sack,
                lapis_lazuli_raw,
                lapis_lazuli,
                slate_shard,
                salt_shard,
                alun_shard,
                stone_pebble,
                andesite_pebble,
                granite_pebble,
                diorite_pebble,
                sandstone_pebble,
                red_sandstone_pebble,
                stone_brick,
                andesite_brick,
                granite_brick,
                diorite_brick,
                sandstone_brick,
                red_sandstone_brick,
                quartz_brick,
                teapot_raw,
                clay_mug_raw,
                plank_oak,
                plank_birch,
                plank_spruce,
                plank_jungle,
                plank_big_oak,
                plank_acacia,
                stick_birch,
                stick_spruce,
                stick_jungle,
                stick_big_oak,
                stick_acacia,
                handle,
                shaft,
                pole,
                flower_pot_raw,
                molten_glass,
                paper_wet,
                paper_paste,
                flux,
                tanning_oil,
                copper_raw,
                lead_raw,
                silver_raw,
                tin_raw,
                iron_raw,
                gold_raw,
                steel_nugget,
                copper_nugget,
                lead_nugget,
                silver_nugget,
                tin_nugget,
                bronze_nugget,
                ingot_steel,
                ingot_copper,
                ingot_lead,
                ingot_silver,
                ingot_tin,
                ingot_bronze,
                plate_bronze,
                plate_iron,
                plate_silver,
                plate_gold,
                plate_copper,
                plate_steel,
                plate_tin,
                plate_lead,
                stick_bronze,
                stick_iron,
                stick_silver,
                stick_gold,
                stick_copper,
                stick_steel,
                stick_tin,
                stick_lead,
                book_old,
                book_wet,
                boot,
                pearl,
                youkounkoun,
                // Misc
                dice_6f,
                item_hrp,
                keychain_empty,
                token_stone,
                token_stone_blank,
                //Couture
                cloth_sheet_white,
                cloth_sheet_orange,
                cloth_sheet_magenta,
                cloth_sheet_light_blue,
                cloth_sheet_yellow,
                cloth_sheet_lime,
                cloth_sheet_pink,
                cloth_sheet_gray,
                cloth_sheet_silver,
                cloth_sheet_cyan,
                cloth_sheet_purple,
                cloth_sheet_blue,
                cloth_sheet_brown,
                cloth_sheet_green,
                cloth_sheet_red,
                cloth_sheet_black,
                wool_raw,
                woolen_thread,
                hempen_thread,
                linen_thread,
                leather_scrap,
                cinder,
                sawdust,
                plant_fiber,
                cog,
                simple_mecanism,
                complex_mecanism,
                sophisticated_mecanism,
                //Outils
                broom,
                bronze_spade,
                bronze_axe,
                bronze_pickaxe,
                bronze_hoe,
                bronze_knife,
                bronze_hammer,
                wood_knife,
                wood_hammer,
                stone_knife,
                stone_hammer,
                iron_knife,
                iron_hammer,
                gold_knife,
                gold_hammer,
                diamond_knife,
                diamond_hammer,
                bronze_chef_knife,
                iron_chef_knife,
                steel_chef_knife,
                bronze_lime,
                iron_lime,
                steel_lime,
                bronze_sickle,
                iron_sickle,
                steel_sickle,
                bronze_saw,
                iron_saw,
                steel_saw,
                bronze_chisel,
                iron_chisel,
                steel_chisel,
                bronze_rock_hammer,
                iron_rock_hammer,
                steel_rock_hammer,
                brush,
                //Armes
                pointed_stick,
                bronze_dagger,
                bronze_waraxe,
                bronze_mace,
                bronze_battlesword,
                bronze_battleaxe,
                bronze_battlehammer,
                bronze_spear,
                bronze_halberd,
                bronze_scythe,
                bronze_saber,
                bronze_sword,
                bronze_fork,
                wood_dagger,
                wood_waraxe,
                wood_mace,
                wood_battlesword,
                wood_battleaxe,
                wood_battlehammer,
                wood_spear,
                wood_halberd,
                wood_scythe,
                wood_saber,
                stone_dagger,
                stone_waraxe,
                stone_mace,
                stone_battlesword,
                stone_battleaxe,
                stone_battlehammer,
                stone_spear,
                stone_halberd,
                stone_scythe,
                stone_saber,
                iron_dagger,
                iron_waraxe,
                iron_mace,
                iron_battlesword,
                iron_battleaxe,
                iron_battlehammer,
                iron_spear,
                iron_halberd,
                iron_scythe,
                iron_saber,
                iron_fork,
                gold_dagger,
                gold_waraxe,
                gold_mace,
                gold_battlesword,
                gold_battleaxe,
                gold_battlehammer,
                gold_spear,
                gold_halberd,
                gold_scythe,
                gold_saber,
                diamond_dagger,
                diamond_waraxe,
                diamond_mace,
                diamond_battlesword,
                diamond_battleaxe,
                diamond_battlehammer,
                diamond_spear,
                diamond_halberd,
                diamond_scythe,
                diamond_saber,
                diamond_fork,
                //boucliers
                wood_shield,
                stone_shield,
                iron_shield,
                gold_shield,
                diamond_shield,
                diamond_shield_full,
                //Arcs
                longbow,
                //Pièces d'Outil
                bronze_pickaxe_head,
                iron_pickaxe_head,
                steel_pickaxe_head,
                gold_pickaxe_head,
                pickaxe_mold,
                bronze_shovel_head,
                iron_shovel_head,
                steel_shovel_head,
                gold_shovel_head,
                shovel_mold,
                bronze_hoe_head,
                iron_hoe_head,
                steel_hoe_head,
                gold_hoe_head,
                hoe_mold,
                bronze_axe_head,
                iron_axe_head,
                steel_axe_head,
                gold_axe_head,
                axe_mold,
                bronze_knife_head,
                iron_knife_head,
                steel_knife_head,
                gold_knife_head,
                knife_mold,
                bronze_hammer_head,
                iron_hammer_head,
                steel_hammer_head,
                gold_hammer_head,
                hammer_mold,
                bronze_scythe_head,
                iron_scythe_head,
                steel_scythe_head,
                gold_scythe_head,
                scythe_mold,
                bronze_sword_head,
                iron_sword_head,
                steel_sword_head,
                gold_sword_head,
                sword_mold,
                bronze_saber_head,
                iron_saber_head,
                steel_saber_head,
                gold_saber_head,
                saber_mold,
                bronze_spear_head,
                iron_spear_head,
                steel_spear_head,
                gold_spear_head,
                spear_mold,
                bronze_dagger_head,
                iron_dagger_head,
                steel_dagger_head,
                gold_dagger_head,
                dagger_mold,
                bronze_warhammer_head,
                iron_warhammer_head,
                steel_warhammer_head,
                gold_warhammer_head,
                warhammer_mold,
                bronze_halberd_head,
                iron_halberd_head,
                steel_halberd_head,
                gold_halberd_head,
                halberd_mold,
                bronze_waraxe_head,
                iron_waraxe_head,
                steel_waraxe_head,
                gold_waraxe_head,
                waraxe_mold,
                bronze_mace_head,
                iron_mace_head,
                steel_mace_head,
                gold_mace_head,
                mace_mold,
                bronze_battlesword_head,
                iron_battlesword_head,
                steel_battlesword_head,
                gold_battlesword_head,
                battlesword_mold,
                bronze_chef_knife_head,
                iron_chef_knife_head,
                steel_chef_knife_head,
                chef_knife_mold,
                bronze_sickle_head,
                iron_sickle_head,
                steel_sickle_head,
                sickle_mold,
                bronze_lime_head,
                iron_lime_head,
                steel_lime_head,
                lime_mold,
                bronze_saw_head,
                iron_saw_head,
                steel_saw_head,
                saw_mold,
                bronze_chisel_head,
                iron_chisel_head,
                steel_chisel_head,
                chisel_mold,
                //Pierres précieuses
                amethyst_gemstone,
                amethyst_cut,
                aquamarine_gemstone,
                aquamarine_cut,
                charoite_gemstone,
                charoite_cut,
                citrine_gemstone,
                citrine_cut,
                coraline_gemstone,
                coraline_cut,
                hematite_gemstone,
                hematite_cut,
                malachite_gemstone,
                malachite_cut,
                opale_gemstone,
                opale_cut,
                quartz_gemstone,
                quartz_cut,
                quartzrose_gemstone,
                quartzrose_cut,
                ruby_gemstone,
                ruby_cut,
                tigereye_gemstone,
                tigereye_cut,
                tourmaline_gemstone,
                tourmaline_cut,
                turquoise_gemstone,
                turquoise_cut,
                //Agriculture
                barley,
                barley_seeds,
                flax,
                flax_seeds,
                hemp,
                hemp_seeds,
                lettuce,
                lettuce_seeds,
                tomato,
                tomato_ceps,
                tomato_seeds,
                grapes,
                grapes_ceps,
                grapes_seeds,
                turnip,
                tea_grounded,
                walnut,
                apricot,
                garlic,
                almonds,
                pineapple,
                eggplant,
                avocado,
                banana,
                broccoli,
                cassis,
                chestnut,
                cherry,
                cauliflower,
                cabbage,
                dates,
                endive,
                bean,
                fig,
                strawberry,
                raspberry,
                grapes_white,
                grapes_red,
                pomegranate,
                beans_white,
                beans_red,
                blackberry,
                blueberry,
                onion,
                olives_black,
                olives_green,
                orange,
                peach,
                pear,
                leek,
                pepper_red,
                pepper_yellow,
                pepper_green,
                pepper_chilli,
                prunes,
                radish,
                jerusalem_artichoke,
                salsify,
                plums,
                lemon,
                //animal stuff
                fat_animal,
                bear_fur,
                wolf_fur,
                fox_fur,
                deer_leather,
                boar_leather,
                tanned_leather,
                tanned_skin,
                spice_capers,
                spice_curcuma,
                spice_ginger,
                spice_clove,
                spice_carrogia_herbs,
                spice_manigette,
                spice_nutmeg,
                spice_paprika,
                spice_poppy,
                spice_pepper,
                spice_saffron,
                spice_truffle,
                spice_vanilla,
                varnish,
                yeast,
                blow_pin,
                pliers,
                ingot_mold,
                magnifying_glass,
                stone_pestle_mortar,
                wooden_pestle_mortar,
                //rock_hammer,
                weaver_tools,
                nails,
                bee_helmet,
                bee_chest,
                bee_legging,
                bee_boots,
                arm_chain,
                feet_chain,
                lock_copper,
                lock_iron,
                lock_steel,
                lock_gold,
                lockpick_iron,
                lockpick_steel,
                lockpick_gold,
                key_copper,
                key_iron,
                key_steel,
                key_gold,
                nude_key_copper,
                nude_key_iron,
                nude_key_steel,
                nude_key_gold,
                purse_cloth,
                purse_leather,
                purse_decorated,
                basket,
                backpack,
                pipe_ornate,
                //wall_note_item,
                sign_hrp_item,
                sign_stone_item,
                dice_4f,
                dice_8f,
                dice_10f,
                dice_12f,
                dice_20f,
                dice_glass,
                rook,
                bishop,
                knight,
                king,
                queen,
                pawn,
                ace_heart,
                two_heart,
                three_heart,
                four_heart,
                five_heart,
                six_heart,
                seven_heart,
                eight_heart,
                nine_heart,
                ten_heart,
                jack_heart,
                queen_heart,
                king_heart,
                ace_diamond,
                two_diamond,
                three_diamond,
                four_diamond,
                five_diamond,
                six_diamond,
                seven_diamond,
                eight_diamond,
                nine_diamond,
                ten_diamond,
                jack_diamond,
                queen_diamond,
                king_diamond,
                ace_club,
                two_club,
                three_club,
                four_club,
                five_club,
                six_club,
                seven_club,
                eight_club,
                nine_club,
                ten_club,
                jack_club,
                queen_club,
                king_club,
                ace_spade,
                two_spade,
                three_spade,
                four_spade,
                five_spade,
                six_spade,
                seven_spade,
                eight_spade,
                nine_spade,
                ten_spade,
                jack_spade,
                queen_spade,
                king_spade,
                petanque_iron_ball,
                petanque_bronze_ball,
                petanque_pork_ball,
                oak_block,
                birch_block,
                spruce_block,
                jungle_block,
                dark_oak_block,
                acacia_block,
                rock_wheel,
                gold_amethyst_jewelry,
                gold_aquamarine_jewelry,
                gold_charoite_jewelry,
                gold_citrine_jewelry,
                gold_coraline_jewelry,
                gold_diamond_jewelry,
                gold_emerald_jewelry,
                gold_hematite_jewelry,
                gold_lapis_jewelry,
                gold_malachite_jewelry,
                gold_opale_jewelry,
                gold_quartz_jewelry,
                gold_quartzrose_jewelry,
                gold_ruby_jewelry,
                gold_tigereye_jewelry,
                gold_tourmaline_jewelry,
                gold_turquoise_jewelry,
                silver_amethyst_jewelry,
                silver_aquamarine_jewelry,
                silver_charoite_jewelry,
                silver_citrine_jewelry,
                silver_coraline_jewelry,
                silver_diamond_jewelry,
                silver_emerald_jewelry,
                silver_hematite_jewelry,
                silver_lapis_jewelry,
                silver_malachite_jewelry,
                silver_opale_jewelry,
                silver_quartz_jewelry,
                silver_quartzrose_jewelry,
                silver_ruby_jewelry,
                silver_tigereye_jewelry,
                silver_tourmaline_jewelry,
                silver_turquoise_jewelry,
                copper_jewelry,
                silver_jewelry,
                gold_jewelry,
                blue_slate_shard,
                clay_slate_tile
        );
    }

    public static void registerModels() {
        ef.registerItemModel();
        eo.registerItemModel();
        el.registerItemModel();
        ed.registerItemModel();
        coin_copper.registerItemModel();
        coin_silver.registerItemModel();
        coin_gold_1.registerItemModel();
        coin_gold_2.registerItemModel();
        glass_jar_empty.registerItemModel();
        glass_jar_bee.registerItemModel();
        glass_bottle_empty.registerItemModel();
        glass_bottle_rum_empty.registerItemModel();
        clay_mug_empty.registerItemModel();
        teapot.registerItemModel();
        glass_mug_empty.registerItemModel();
        glass_tumbler_empty.registerItemModel();
        glass_tumbler_dirty.registerItemModel();
        glass_mug_dirty.registerItemModel();
        clay_mug_dirty.registerItemModel();
        gourd_empty.registerItemModel();
        gourd.registerItemModel();
        glass_jar_milk.registerItemModel();
        glass_jar_water.registerItemModel();
        teapot_water.registerItemModel();
        teapot_hotwater.registerItemModel();
        teapot_milk.registerItemModel();
        teapot_hotmilk.registerItemModel();
        clay_mug_beer.registerItemModel();
        clay_mug_mead.registerItemModel();
        clay_mug_milk.registerItemModel();
        clay_mug_water.registerItemModel();
        clay_mug_hotcocoa.registerItemModel();
        clay_mug_hotmilk.registerItemModel();
        clay_mug_hottea.registerItemModel();
        clay_mug_hotwater.registerItemModel();
        glass_bottle_water.registerItemModel();
        glass_bottle_milk.registerItemModel();
        glass_bottle_apple.registerItemModel();
        glass_bottle_cider.registerItemModel();
        glass_bottle_grapes.registerItemModel();
        glass_bottle_vine.registerItemModel();
        glass_bottle_sugarcane.registerItemModel();
        glass_bottle_rum.registerItemModel();
        glass_bottle_mead.registerItemModel();
        glass_bottle_beer.registerItemModel();
        glass_mug_beer.registerItemModel();
        glass_mug_mead.registerItemModel();
        glass_tumbler_apple.registerItemModel();
        glass_tumbler_cider.registerItemModel();
        glass_tumbler_grapes.registerItemModel();
        glass_tumbler_vine.registerItemModel();
        glass_tumbler_milk.registerItemModel();
        glass_tumbler_sugarcane.registerItemModel();
        glass_tumbler_rum.registerItemModel();
        glass_tumbler_water.registerItemModel();
        metal_bucket_apple.registerItemModel();
        metal_bucket_cider.registerItemModel();
        metal_bucket_barley.registerItemModel();
        metal_bucket_beer.registerItemModel();
        metal_bucket_grapes.registerItemModel();
        metal_bucket_vine.registerItemModel();
        metal_bucket_honey.registerItemModel();
        metal_bucket_mead.registerItemModel();
        metal_bucket_sugarcane.registerItemModel();
        metal_bucket_rum.registerItemModel();
        metal_bucket_goatmilk.registerItemModel();
        wooden_bucket.registerItemModel();
        wooden_bucket_water.registerItemModel();
        wooden_bucket_milk.registerItemModel();
        wooden_bucket_apple.registerItemModel();
        wooden_bucket_cider.registerItemModel();
        wooden_bucket_barley.registerItemModel();
        wooden_bucket_beer.registerItemModel();
        wooden_bucket_grapes.registerItemModel();
        wooden_bucket_vine.registerItemModel();
        wooden_bucket_honey.registerItemModel();
        wooden_bucket_mead.registerItemModel();
        wooden_bucket_sugarcane.registerItemModel();
        wooden_bucket_rum.registerItemModel();
        wooden_bucket_goatmilk.registerItemModel();
        flour.registerItemModel();
        dough.registerItemModel();
        biscuit_chocolate.registerItemModel();
        boarchop_raw.registerItemModel();
        boarchop_cooked.registerItemModel();
        cake_slice.registerItemModel();
        pumpkin_pie_slice.registerItemModel();
        cheese.registerItemModel();
        cheese_slice.registerItemModel();
        bluecheese.registerItemModel();
        bluecheese_slice.registerItemModel();
        chocolate.registerItemModel();
        egg_boiled.registerItemModel();
        egg_fried.registerItemModel();
        esper_chocolate.registerItemModel();
        fish_herring_raw.registerItemModel();
        fish_herring_cooked.registerItemModel();
        fish_sardine_raw.registerItemModel();
        fish_sardine_cooked.registerItemModel();
        fish_trout_raw.registerItemModel();
        fish_trout_cooked.registerItemModel();
        fish_soup.registerItemModel();
        llama_raw.registerItemModel();
        llama_cooked.registerItemModel();
        bear_raw.registerItemModel();
        bear_cooked.registerItemModel();
        goat_raw.registerItemModel();
        goat_cooked.registerItemModel();
        duck_raw.registerItemModel();
        duck_cooked.registerItemModel();
        deer_raw.registerItemModel();
        deer_cooked.registerItemModel();
        honey.registerItemModel();
        horse_raw.registerItemModel();
        horse_cooked.registerItemModel();
        larva_raw.registerItemModel();
        larva_cooked.registerItemModel();
        pumpkin_soup.registerItemModel();
        squid_raw.registerItemModel();
        squid_cooked.registerItemModel();
        glass_jar_marmalade_apple.registerItemModel();
        glass_jar_marmalade_grapes.registerItemModel();
        rotten_fish.registerItemModel();
        rotten_fruit.registerItemModel();
        rotten_vegetable.registerItemModel();
        rotten_starchy.registerItemModel();
        rotten_egg.registerItemModel();
        rotten_drink.registerItemModel();
        plush_bear.registerItemModel();
        plush_sheep.registerItemModel();
        doll.registerItemModel();
        cloth_boots.registerItemModel();
        cloth_shirt.registerItemModel();
        cloth_gloves.registerItemModel();
        cloth_skirt.registerItemModel();
        cloth_longcoat.registerItemModel();
        cloth_coat.registerItemModel();
        cloth_trousers.registerItemModel();
        cloth_habit.registerItemModel();
        cloth_robe.registerItemModel();
        cloth_underwear_m.registerItemModel();
        cloth_underwear_f.registerItemModel();
        cocoa.registerItemModel();
        butter.registerItemModel();
        salt.registerItemModel();
        wax.registerItemModel();
        roll_blank.registerItemModel();
        diamond_raw.registerItemModel();
        emerald_raw.registerItemModel();
        ink_sack.registerItemModel();
        lapis_lazuli_raw.registerItemModel();
        lapis_lazuli.registerItemModel();
        slate_shard.registerItemModel();
        salt_shard.registerItemModel();
        alun_shard.registerItemModel();
        stone_pebble.registerItemModel();
        andesite_pebble.registerItemModel();
        granite_pebble.registerItemModel();
        diorite_pebble.registerItemModel();
        sandstone_pebble.registerItemModel();
        red_sandstone_pebble.registerItemModel();
        stone_brick.registerItemModel();
        andesite_brick.registerItemModel();
        granite_brick.registerItemModel();
        diorite_brick.registerItemModel();
        sandstone_brick.registerItemModel();
        red_sandstone_brick.registerItemModel();
        quartz_brick.registerItemModel();
        teapot_raw.registerItemModel();
        clay_mug_raw.registerItemModel();
        plank_oak.registerItemModel();
        plank_birch.registerItemModel();
        plank_spruce.registerItemModel();
        plank_jungle.registerItemModel();
        plank_big_oak.registerItemModel();
        plank_acacia.registerItemModel();
        stick_birch.registerItemModel();
        stick_spruce.registerItemModel();
        stick_jungle.registerItemModel();
        stick_big_oak.registerItemModel();
        stick_acacia.registerItemModel();
        handle.registerItemModel();
        shaft.registerItemModel();
        pole.registerItemModel();
        flower_pot_raw.registerItemModel();
        molten_glass.registerItemModel();
        paper_wet.registerItemModel();
        paper_paste.registerItemModel();
        flux.registerItemModel();
        tanning_oil.registerItemModel();
        copper_raw.registerItemModel();
        lead_raw.registerItemModel();
        silver_raw.registerItemModel();
        tin_raw.registerItemModel();
        iron_raw.registerItemModel();
        gold_raw.registerItemModel();
        steel_nugget.registerItemModel();
        copper_nugget.registerItemModel();
        lead_nugget.registerItemModel();
        silver_nugget.registerItemModel();
        tin_nugget.registerItemModel();
        bronze_nugget.registerItemModel();
        ingot_steel.registerItemModel();
        ingot_copper.registerItemModel();
        ingot_lead.registerItemModel();
        ingot_silver.registerItemModel();
        ingot_tin.registerItemModel();
        ingot_bronze.registerItemModel();
        plate_bronze.registerItemModel();
        plate_iron.registerItemModel();
        plate_silver.registerItemModel();
        plate_gold.registerItemModel();
        plate_copper.registerItemModel();
        plate_steel.registerItemModel();
        plate_tin.registerItemModel();
        plate_lead.registerItemModel();
        stick_bronze.registerItemModel();
        stick_iron.registerItemModel();
        stick_silver.registerItemModel();
        stick_gold.registerItemModel();
        stick_copper.registerItemModel();
        stick_steel.registerItemModel();
        stick_tin.registerItemModel();
        stick_lead.registerItemModel();
        book_old.registerItemModel();
        book_wet.registerItemModel();
        boot.registerItemModel();
        pearl.registerItemModel();
        youkounkoun.registerItemModel();
        broom.registerItemModel();
        bronze_spade.registerItemModel();
        bronze_axe.registerItemModel();
        bronze_pickaxe.registerItemModel();
        bronze_hoe.registerItemModel();
        bronze_knife.registerItemModel();
        bronze_hammer.registerItemModel();
        wood_knife.registerItemModel();
        wood_hammer.registerItemModel();
        stone_knife.registerItemModel();
        stone_hammer.registerItemModel();
        iron_knife.registerItemModel();
        iron_hammer.registerItemModel();
        gold_knife.registerItemModel();
        gold_hammer.registerItemModel();
        diamond_knife.registerItemModel();
        diamond_hammer.registerItemModel();
        bronze_chef_knife.registerItemModel();
        iron_chef_knife.registerItemModel();
        steel_chef_knife.registerItemModel();
        bronze_lime.registerItemModel();
        iron_lime.registerItemModel();
        steel_lime.registerItemModel();
        bronze_sickle.registerItemModel();
        iron_sickle.registerItemModel();
        steel_sickle.registerItemModel();
        bronze_saw.registerItemModel();
        iron_saw.registerItemModel();
        steel_saw.registerItemModel();
        bronze_chisel.registerItemModel();
        iron_chisel.registerItemModel();
        steel_chisel.registerItemModel();
        bronze_rock_hammer.registerItemModel();
        iron_rock_hammer.registerItemModel();
        steel_rock_hammer.registerItemModel();
        brush.registerItemModel();
        dice_6f.registerItemModel();
        item_hrp.registerItemModel();
        keychain_empty.registerItemModel();
        token_stone.registerItemModel();
        token_stone_blank.registerItemModel();
        //Couture
        cloth_sheet_white.registerItemModel();
        cloth_sheet_orange.registerItemModel();
        cloth_sheet_magenta.registerItemModel();
        cloth_sheet_light_blue.registerItemModel();
        cloth_sheet_yellow.registerItemModel();
        cloth_sheet_lime.registerItemModel();
        cloth_sheet_pink.registerItemModel();
        cloth_sheet_gray.registerItemModel();
        cloth_sheet_silver.registerItemModel();
        cloth_sheet_cyan.registerItemModel();
        cloth_sheet_purple.registerItemModel();
        cloth_sheet_blue.registerItemModel();
        cloth_sheet_brown.registerItemModel();
        cloth_sheet_green.registerItemModel();
        cloth_sheet_red.registerItemModel();
        cloth_sheet_black.registerItemModel();
        wool_raw.registerItemModel();
        woolen_thread.registerItemModel();
        hempen_thread.registerItemModel();
        linen_thread.registerItemModel();
        leather_scrap.registerItemModel();
        cinder.registerItemModel();
        sawdust.registerItemModel();
        plant_fiber.registerItemModel();
        cog.registerItemModel();
        simple_mecanism.registerItemModel();
        complex_mecanism.registerItemModel();
        sophisticated_mecanism.registerItemModel();
        //Armes
        pointed_stick.registerItemModel();
        bronze_dagger.registerItemModel();
        bronze_waraxe.registerItemModel();
        bronze_mace.registerItemModel();
        bronze_battlesword.registerItemModel();
        bronze_battleaxe.registerItemModel();
        bronze_battlehammer.registerItemModel();
        bronze_spear.registerItemModel();
        bronze_halberd.registerItemModel();
        bronze_scythe.registerItemModel();
        bronze_saber.registerItemModel();
        bronze_sword.registerItemModel();
        bronze_fork.registerItemModel();
        wood_dagger.registerItemModel();
        wood_waraxe.registerItemModel();
        wood_mace.registerItemModel();
        wood_battlesword.registerItemModel();
        wood_battleaxe.registerItemModel();
        wood_battlehammer.registerItemModel();
        wood_spear.registerItemModel();
        wood_halberd.registerItemModel();
        wood_scythe.registerItemModel();
        wood_saber.registerItemModel();
        stone_dagger.registerItemModel();
        stone_waraxe.registerItemModel();
        stone_mace.registerItemModel();
        stone_battlesword.registerItemModel();
        stone_battleaxe.registerItemModel();
        stone_battlehammer.registerItemModel();
        stone_spear.registerItemModel();
        stone_halberd.registerItemModel();
        stone_scythe.registerItemModel();
        stone_saber.registerItemModel();
        iron_dagger.registerItemModel();
        iron_waraxe.registerItemModel();
        iron_mace.registerItemModel();
        iron_battlesword.registerItemModel();
        iron_battleaxe.registerItemModel();
        iron_battlehammer.registerItemModel();
        iron_spear.registerItemModel();
        iron_halberd.registerItemModel();
        iron_scythe.registerItemModel();
        iron_saber.registerItemModel();
        iron_fork.registerItemModel();
        gold_dagger.registerItemModel();
        gold_waraxe.registerItemModel();
        gold_mace.registerItemModel();
        gold_battlesword.registerItemModel();
        gold_battleaxe.registerItemModel();
        gold_battlehammer.registerItemModel();
        gold_spear.registerItemModel();
        gold_halberd.registerItemModel();
        gold_scythe.registerItemModel();
        gold_saber.registerItemModel();
        diamond_dagger.registerItemModel();
        diamond_waraxe.registerItemModel();
        diamond_mace.registerItemModel();
        diamond_battlesword.registerItemModel();
        diamond_battleaxe.registerItemModel();
        diamond_battlehammer.registerItemModel();
        diamond_spear.registerItemModel();
        diamond_halberd.registerItemModel();
        diamond_scythe.registerItemModel();
        diamond_saber.registerItemModel();
        diamond_fork.registerItemModel();
        //Boucliers
        wood_shield.registerItemModel();
        stone_shield.registerItemModel();
        iron_shield.registerItemModel();
        gold_shield.registerItemModel();
        diamond_shield.registerItemModel();
        diamond_shield_full.registerItemModel();
        //Arcs
        longbow.registerItemModel();
        //Pièces d'outil.
        bronze_pickaxe_head.registerItemModel();
        iron_pickaxe_head.registerItemModel();
        steel_pickaxe_head.registerItemModel();
        gold_pickaxe_head.registerItemModel();
        pickaxe_mold.registerItemModel();
        bronze_shovel_head.registerItemModel();
        iron_shovel_head.registerItemModel();
        steel_shovel_head.registerItemModel();
        gold_shovel_head.registerItemModel();
        shovel_mold.registerItemModel();
        bronze_hoe_head.registerItemModel();
        iron_hoe_head.registerItemModel();
        steel_hoe_head.registerItemModel();
        gold_hoe_head.registerItemModel();
        hoe_mold.registerItemModel();
        bronze_axe_head.registerItemModel();
        iron_axe_head.registerItemModel();
        steel_axe_head.registerItemModel();
        gold_axe_head.registerItemModel();
        axe_mold.registerItemModel();
        bronze_knife_head.registerItemModel();
        iron_knife_head.registerItemModel();
        steel_knife_head.registerItemModel();
        gold_knife_head.registerItemModel();
        knife_mold.registerItemModel();
        bronze_hammer_head.registerItemModel();
        iron_hammer_head.registerItemModel();
        steel_hammer_head.registerItemModel();
        gold_hammer_head.registerItemModel();
        hammer_mold.registerItemModel();
        bronze_scythe_head.registerItemModel();
        iron_scythe_head.registerItemModel();
        steel_scythe_head.registerItemModel();
        gold_scythe_head.registerItemModel();
        scythe_mold.registerItemModel();
        bronze_sword_head.registerItemModel();
        iron_sword_head.registerItemModel();
        steel_sword_head.registerItemModel();
        gold_sword_head.registerItemModel();
        sword_mold.registerItemModel();
        bronze_saber_head.registerItemModel();
        iron_saber_head.registerItemModel();
        steel_saber_head.registerItemModel();
        gold_saber_head.registerItemModel();
        saber_mold.registerItemModel();
        bronze_spear_head.registerItemModel();
        iron_spear_head.registerItemModel();
        steel_spear_head.registerItemModel();
        gold_spear_head.registerItemModel();
        spear_mold.registerItemModel();
        bronze_dagger_head.registerItemModel();
        iron_dagger_head.registerItemModel();
        steel_dagger_head.registerItemModel();
        gold_dagger_head.registerItemModel();
        dagger_mold.registerItemModel();
        bronze_warhammer_head.registerItemModel();
        iron_warhammer_head.registerItemModel();
        steel_warhammer_head.registerItemModel();
        gold_warhammer_head.registerItemModel();
        warhammer_mold.registerItemModel();
        bronze_halberd_head.registerItemModel();
        iron_halberd_head.registerItemModel();
        steel_halberd_head.registerItemModel();
        gold_halberd_head.registerItemModel();
        halberd_mold.registerItemModel();
        bronze_waraxe_head.registerItemModel();
        iron_waraxe_head.registerItemModel();
        steel_waraxe_head.registerItemModel();
        gold_waraxe_head.registerItemModel();
        waraxe_mold.registerItemModel();
        bronze_mace_head.registerItemModel();
        iron_mace_head.registerItemModel();
        steel_mace_head.registerItemModel();
        gold_mace_head.registerItemModel();
        mace_mold.registerItemModel();
        bronze_battlesword_head.registerItemModel();
        iron_battlesword_head.registerItemModel();
        steel_battlesword_head.registerItemModel();
        gold_battlesword_head.registerItemModel();
        battlesword_mold.registerItemModel();
        bronze_chef_knife_head.registerItemModel();
        iron_chef_knife_head.registerItemModel();
        steel_chef_knife_head.registerItemModel();
        chef_knife_mold.registerItemModel();
        bronze_sickle_head.registerItemModel();
        iron_sickle_head.registerItemModel();
        steel_sickle_head.registerItemModel();
        sickle_mold.registerItemModel();
        bronze_lime_head.registerItemModel();
        iron_lime_head.registerItemModel();
        steel_lime_head.registerItemModel();
        lime_mold.registerItemModel();
        bronze_saw_head.registerItemModel();
        iron_saw_head.registerItemModel();
        steel_saw_head.registerItemModel();
        saw_mold.registerItemModel();
        bronze_chisel_head.registerItemModel();
        iron_chisel_head.registerItemModel();
        steel_chisel_head.registerItemModel();
        chisel_mold.registerItemModel();
        //Pierre Précieuse
        amethyst_gemstone.registerItemModel();
        amethyst_cut.registerItemModel();
        aquamarine_gemstone.registerItemModel();
        aquamarine_cut.registerItemModel();
        charoite_gemstone.registerItemModel();
        charoite_cut.registerItemModel();
        citrine_gemstone.registerItemModel();
        citrine_cut.registerItemModel();
        coraline_gemstone.registerItemModel();
        coraline_cut.registerItemModel();
        hematite_gemstone.registerItemModel();
        hematite_cut.registerItemModel();
        malachite_gemstone.registerItemModel();
        malachite_cut.registerItemModel();
        opale_gemstone.registerItemModel();
        opale_cut.registerItemModel();
        quartz_gemstone.registerItemModel();
        quartz_cut.registerItemModel();
        quartzrose_gemstone.registerItemModel();
        quartzrose_cut.registerItemModel();
        ruby_gemstone.registerItemModel();
        ruby_cut.registerItemModel();
        tigereye_gemstone.registerItemModel();
        tigereye_cut.registerItemModel();
        tourmaline_gemstone.registerItemModel();
        tourmaline_cut.registerItemModel();
        turquoise_gemstone.registerItemModel();
        turquoise_cut.registerItemModel();
        //agriculture
        barley.registerItemModel();
        barley_seeds.registerItemModel();
        flax.registerItemModel();
        flax_seeds.registerItemModel();
        hemp.registerItemModel();
        hemp_seeds.registerItemModel();
        lettuce.registerItemModel();
        lettuce_seeds.registerItemModel();
        tomato.registerItemModel();
        tomato_ceps.registerItemModel();
        tomato_seeds.registerItemModel();
        grapes.registerItemModel();
        grapes_ceps.registerItemModel();
        grapes_seeds.registerItemModel();
        turnip.registerItemModel();
        tea_grounded.registerItemModel();
        honey.registerItemModel();
        walnut.registerItemModel();
        apricot.registerItemModel();
        garlic.registerItemModel();
        almonds.registerItemModel();
        pineapple.registerItemModel();
        eggplant.registerItemModel();
        avocado.registerItemModel();
        banana.registerItemModel();
        broccoli.registerItemModel();
        cassis.registerItemModel();
        chestnut.registerItemModel();
        cherry.registerItemModel();
        cauliflower.registerItemModel();
        cabbage.registerItemModel();
        dates.registerItemModel();
        endive.registerItemModel();
        bean.registerItemModel();
        fig.registerItemModel();
        strawberry.registerItemModel();
        raspberry.registerItemModel();
        grapes_white.registerItemModel();
        grapes_red.registerItemModel();
        pomegranate.registerItemModel();
        beans_white.registerItemModel();
        beans_red.registerItemModel();
        blackberry.registerItemModel();
        blueberry.registerItemModel();
        onion.registerItemModel();
        olives_black.registerItemModel();
        olives_green.registerItemModel();
        orange.registerItemModel();
        peach.registerItemModel();
        pear.registerItemModel();
        leek.registerItemModel();
        pepper_red.registerItemModel();
        pepper_yellow.registerItemModel();
        pepper_green.registerItemModel();
        pepper_chilli.registerItemModel();
        prunes.registerItemModel();
        radish.registerItemModel();
        jerusalem_artichoke.registerItemModel();
        salsify.registerItemModel();
        plums.registerItemModel();
        lemon.registerItemModel();
        //animal stuff
        fat_animal.registerItemModel();
        bear_fur.registerItemModel();
        wolf_fur.registerItemModel();
        fox_fur.registerItemModel();
        deer_leather.registerItemModel();
        boar_leather.registerItemModel();
        tanned_leather.registerItemModel();
        tanned_skin.registerItemModel();
        spice_capers.registerItemModel();
        spice_curcuma.registerItemModel();
        spice_ginger.registerItemModel();
        spice_clove.registerItemModel();
        spice_carrogia_herbs.registerItemModel();
        spice_manigette.registerItemModel();
        spice_nutmeg.registerItemModel();
        spice_paprika.registerItemModel();
        spice_poppy.registerItemModel();
        spice_pepper.registerItemModel();
        spice_saffron.registerItemModel();
        spice_truffle.registerItemModel();
        spice_vanilla.registerItemModel();
        varnish.registerItemModel();
        yeast.registerItemModel();
        blow_pin.registerItemModel();
        pliers.registerItemModel();
        ingot_mold.registerItemModel();
        magnifying_glass.registerItemModel();
        stone_pestle_mortar.registerItemModel();
        wooden_pestle_mortar.registerItemModel();
        //rock_hammer.registerItemModel();
        weaver_tools.registerItemModel();
        nails.registerItemModel();
        bee_helmet.registerItemModel();
        bee_chest.registerItemModel();
        bee_legging.registerItemModel();
        bee_boots.registerItemModel();
        arm_chain.registerItemModel();
        feet_chain.registerItemModel();
        lock_copper.registerItemModel();
        lock_iron.registerItemModel();
        lock_steel.registerItemModel();
        lock_gold.registerItemModel();
        lockpick_iron.registerItemModel();
        lockpick_steel.registerItemModel();
        lockpick_gold.registerItemModel();
        key_copper.registerItemModel();
        key_iron.registerItemModel();
        key_steel.registerItemModel();
        key_gold.registerItemModel();
        nude_key_copper.registerItemModel();
        nude_key_iron.registerItemModel();
        nude_key_steel.registerItemModel();
        nude_key_gold.registerItemModel();
        purse_cloth.registerItemModel();
        purse_leather.registerItemModel();
        purse_decorated.registerItemModel();
        basket.registerItemModel();
        backpack.registerItemModel();
        pipe_ornate.registerItemModel();
        //wall_note_item.registerItemModel();
        sign_hrp_item.registerItemModel();
        sign_stone_item.registerItemModel();
        
        //Tabletop DLC
        dice_4f.registerItemModel();
        dice_8f.registerItemModel();
        dice_10f.registerItemModel();
        dice_12f.registerItemModel();
        dice_20f.registerItemModel();
        dice_glass.registerItemModel();
        
        rook.registerItemModel();
        bishop.registerItemModel();
        knight.registerItemModel();
        king.registerItemModel();
        queen.registerItemModel();
        pawn.registerItemModel();
        
        ace_heart.registerItemModel();
        two_heart.registerItemModel();
        three_heart.registerItemModel();
        four_heart.registerItemModel();
        five_heart.registerItemModel();
        six_heart.registerItemModel();
        seven_heart.registerItemModel();
        eight_heart.registerItemModel();
        nine_heart.registerItemModel();
        ten_heart.registerItemModel();
        jack_heart.registerItemModel();
        queen_heart.registerItemModel();
        king_heart.registerItemModel();
        ace_diamond.registerItemModel();
        two_diamond.registerItemModel();
        three_diamond.registerItemModel();
        four_diamond.registerItemModel();
        five_diamond.registerItemModel();
        six_diamond.registerItemModel();
        seven_diamond.registerItemModel();
        eight_diamond.registerItemModel();
        nine_diamond.registerItemModel();
        ten_diamond.registerItemModel();
        jack_diamond.registerItemModel();
        queen_diamond.registerItemModel();
        king_diamond.registerItemModel();
        ace_club.registerItemModel();
        two_club.registerItemModel();
        three_club.registerItemModel();
        four_club.registerItemModel();
        five_club.registerItemModel();
        six_club.registerItemModel();
        seven_club.registerItemModel();
        eight_club.registerItemModel();
        nine_club.registerItemModel();
        ten_club.registerItemModel();
        jack_club.registerItemModel();
        queen_club.registerItemModel();
        king_club.registerItemModel();
        ace_spade.registerItemModel();
        two_spade.registerItemModel();
        three_spade.registerItemModel();
        four_spade.registerItemModel();
        five_spade.registerItemModel();
        six_spade.registerItemModel();
        seven_spade.registerItemModel();
        eight_spade.registerItemModel();
        nine_spade.registerItemModel();
        ten_spade.registerItemModel();
        jack_spade.registerItemModel();
        queen_spade.registerItemModel();
        king_spade.registerItemModel();
        
        petanque_iron_ball.registerItemModel();
        petanque_bronze_ball.registerItemModel();
        petanque_pork_ball.registerItemModel();      
        
        oak_block.registerItemModel();
        birch_block.registerItemModel();
        spruce_block.registerItemModel();
        jungle_block.registerItemModel();
        dark_oak_block.registerItemModel();
        acacia_block.registerItemModel();
        
        rock_wheel.registerItemModel();
        gold_amethyst_jewelry.registerItemModel();
        gold_aquamarine_jewelry.registerItemModel();
        gold_charoite_jewelry.registerItemModel();
        gold_citrine_jewelry.registerItemModel();
        gold_coraline_jewelry.registerItemModel();
        gold_diamond_jewelry.registerItemModel();
        gold_emerald_jewelry.registerItemModel();
        gold_hematite_jewelry.registerItemModel();
        gold_lapis_jewelry.registerItemModel();
        gold_malachite_jewelry.registerItemModel();
        gold_opale_jewelry.registerItemModel();
        gold_quartz_jewelry.registerItemModel();
        gold_quartzrose_jewelry.registerItemModel();
        gold_ruby_jewelry.registerItemModel();
        gold_tigereye_jewelry.registerItemModel();
        gold_tourmaline_jewelry.registerItemModel();
        gold_turquoise_jewelry.registerItemModel();
        silver_amethyst_jewelry.registerItemModel();
        silver_aquamarine_jewelry.registerItemModel();
        silver_charoite_jewelry.registerItemModel();
        silver_citrine_jewelry.registerItemModel();
        silver_coraline_jewelry.registerItemModel();
        silver_diamond_jewelry.registerItemModel();
        silver_emerald_jewelry.registerItemModel();
        silver_hematite_jewelry.registerItemModel();
        silver_lapis_jewelry.registerItemModel();
        silver_malachite_jewelry.registerItemModel();
        silver_opale_jewelry.registerItemModel();
        silver_quartz_jewelry.registerItemModel();
        silver_quartzrose_jewelry.registerItemModel();
        silver_ruby_jewelry.registerItemModel();
        silver_tigereye_jewelry.registerItemModel();
        silver_tourmaline_jewelry.registerItemModel();
        silver_turquoise_jewelry.registerItemModel();
        copper_jewelry.registerItemModel();
        silver_jewelry.registerItemModel();
        gold_jewelry.registerItemModel();
        blue_slate_shard.registerItemModel();
        clay_slate_tile.registerItemModel();
    }
}
