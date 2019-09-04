package net.esperia;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry {

    public static void init() {
        //Nuggets de poussin
        OreDictionary.registerOre("nugget", new ItemStack(Items.IRON_NUGGET, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(Items.GOLD_NUGGET, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.steel_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.copper_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.lead_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.silver_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.tin_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("nugget", new ItemStack(ItemsRegistry.bronze_nugget, 1, OreDictionary.WILDCARD_VALUE));
        
        OreDictionary.registerOre("metal_nugget", new ItemStack(Items.IRON_NUGGET, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_nugget", new ItemStack(ItemsRegistry.steel_nugget, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_nugget", new ItemStack(ItemsRegistry.bronze_nugget, 1, OreDictionary.WILDCARD_VALUE));
        
        //Eau
        OreDictionary.registerOre("water_medium", new ItemStack(ItemsRegistry.glass_jar_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water_medium", new ItemStack(ItemsRegistry.glass_bottle_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water_medium", new ItemStack(ItemsRegistry.gourd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.glass_tumbler_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.clay_mug_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(Items.POTIONITEM, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(Items.SPLASH_POTION, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(Items.LINGERING_POTION, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water_large", new ItemStack(ItemsRegistry.wooden_bucket_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water_large", new ItemStack(Items.WATER_BUCKET, 1, OreDictionary.WILDCARD_VALUE));

//Lait
        OreDictionary.registerOre("milk_medium", new ItemStack(ItemsRegistry.glass_jar_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk_medium", new ItemStack(ItemsRegistry.glass_bottle_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.glass_tumbler_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.clay_mug_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk_large", new ItemStack(ItemsRegistry.wooden_bucket_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk_large", new ItemStack(Items.MILK_BUCKET, 1, OreDictionary.WILDCARD_VALUE));
        
        OreDictionary.registerOre("bucket_grapes", new ItemStack(ItemsRegistry.wooden_bucket_grapes, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_grapes", new ItemStack(ItemsRegistry.metal_bucket_grapes, 1, OreDictionary.WILDCARD_VALUE));     
        OreDictionary.registerOre("bucket_vine", new ItemStack(ItemsRegistry.wooden_bucket_vine, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_vine", new ItemStack(ItemsRegistry.metal_bucket_vine, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_apple", new ItemStack(ItemsRegistry.wooden_bucket_apple, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_apple", new ItemStack(ItemsRegistry.metal_bucket_apple, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_cider", new ItemStack(ItemsRegistry.wooden_bucket_cider, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_cider", new ItemStack(ItemsRegistry.metal_bucket_cider, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_barley", new ItemStack(ItemsRegistry.wooden_bucket_barley, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_barley", new ItemStack(ItemsRegistry.metal_bucket_barley, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_beer", new ItemStack(ItemsRegistry.wooden_bucket_beer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_beer", new ItemStack(ItemsRegistry.metal_bucket_beer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_honey", new ItemStack(ItemsRegistry.wooden_bucket_honey, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_honey", new ItemStack(ItemsRegistry.metal_bucket_honey, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_mead", new ItemStack(ItemsRegistry.wooden_bucket_mead, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_mead", new ItemStack(ItemsRegistry.metal_bucket_mead, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_sugarcane", new ItemStack(ItemsRegistry.wooden_bucket_sugarcane, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_sugarcane", new ItemStack(ItemsRegistry.metal_bucket_sugarcane, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_rum", new ItemStack(ItemsRegistry.wooden_bucket_rum, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("bucket_rum", new ItemStack(ItemsRegistry.metal_bucket_rum, 1, OreDictionary.WILDCARD_VALUE));
         
        //Planches
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_oak, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_spruce, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_birch, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_jungle, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_big_oak, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plank", new ItemStack(ItemsRegistry.plank_acacia, 1, OreDictionary.WILDCARD_VALUE));
        
        //Tables
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.oak_table, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.spruce_table, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.birch_table, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.jungle_table, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.big_oak_table, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("table", new ItemStack(BlocksRegistry.acacia_table, 1, OreDictionary.WILDCARD_VALUE));
        
        //Bâtons
        OreDictionary.registerOre("stick", new ItemStack(Items.STICK, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stick", new ItemStack(ItemsRegistry.stick_spruce, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stick", new ItemStack(ItemsRegistry.stick_birch, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stick", new ItemStack(ItemsRegistry.stick_jungle, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stick", new ItemStack(ItemsRegistry.stick_big_oak, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stick", new ItemStack(ItemsRegistry.stick_acacia, 1, OreDictionary.WILDCARD_VALUE));

        //Bâtons métaliques
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_bronze, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_copper, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_gold, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_iron, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_lead, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_silver, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_steel, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("metal_stick", new ItemStack(ItemsRegistry.stick_tin, 1, OreDictionary.WILDCARD_VALUE));

        //Briques
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.stone_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.andesite_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.granite_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.diorite_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.sandstone_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.red_sandstone_brick, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("brick", new ItemStack(ItemsRegistry.quartz_brick, 1, OreDictionary.WILDCARD_VALUE));
        //Pierre
        OreDictionary.registerOre("pebble", new ItemStack(ItemsRegistry.stone_pebble, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pebble", new ItemStack(ItemsRegistry.andesite_pebble, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pebble", new ItemStack(ItemsRegistry.granite_pebble, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pebble", new ItemStack(ItemsRegistry.diorite_pebble, 1, OreDictionary.WILDCARD_VALUE));
        //Bois
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.oak_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.birch_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.spruce_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.jungle_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.dark_oak_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("wood_block", new ItemStack(ItemsRegistry.acacia_block, 1, OreDictionary.WILDCARD_VALUE));

        //Tissu
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_black, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_blue, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_brown, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_cyan, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_gray, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_green, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_light_blue, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_lime, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_magenta, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_orange, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_pink, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_purple, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_red, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_silver, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_white, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cloth", new ItemStack(ItemsRegistry.cloth_sheet_yellow, 1, OreDictionary.WILDCARD_VALUE));
        //thread
        OreDictionary.registerOre("thread", new ItemStack(ItemsRegistry.linen_thread, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("thread", new ItemStack(ItemsRegistry.woolen_thread, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("thread", new ItemStack(ItemsRegistry.hempen_thread, 1, OreDictionary.WILDCARD_VALUE));
        //Strap
        OreDictionary.registerOre("strap", new ItemStack(ItemsRegistry.leather_scrap, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("strap", new ItemStack(Items.STRING, 1, OreDictionary.WILDCARD_VALUE));
        //Eau
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.glass_bottle_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.glass_jar_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.glass_tumbler_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(ItemsRegistry.clay_mug_water, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("water", new ItemStack(Items.WATER_BUCKET, 1, OreDictionary.WILDCARD_VALUE));
//Lait
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.glass_bottle_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.glass_jar_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.glass_tumbler_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(ItemsRegistry.clay_mug_milk, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("milk", new ItemStack(Items.MILK_BUCKET, 1, OreDictionary.WILDCARD_VALUE));
//outils
        OreDictionary.registerOre("axeTool", new ItemStack(net.minecraft.init.Items.WOODEN_AXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("axeTool", new ItemStack(net.minecraft.init.Items.STONE_AXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("axeTool", new ItemStack(net.minecraft.init.Items.IRON_AXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("axeTool", new ItemStack(net.minecraft.init.Items.GOLDEN_AXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("axeTool", new ItemStack(net.minecraft.init.Items.DIAMOND_AXE, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.wood_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.stone_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.iron_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.gold_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.diamond_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hammerTool", new ItemStack(ItemsRegistry.bronze_hammer, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.wood_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.stone_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.iron_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.gold_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.diamond_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("knifeTool", new ItemStack(ItemsRegistry.bronze_knife, 1, OreDictionary.WILDCARD_VALUE));

//        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.wood_chef_knife, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.stone_chef_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.iron_chef_knife, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.gold_chef_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.steel_chef_knife, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chef_knifeTool", new ItemStack(ItemsRegistry.bronze_chef_knife, 1, OreDictionary.WILDCARD_VALUE));

//        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.wood_lime, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.stone_lime, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.iron_lime, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.gold_lime, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.steel_lime, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("limeTool", new ItemStack(ItemsRegistry.bronze_lime, 1, OreDictionary.WILDCARD_VALUE));

//            OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.wood_sickle, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.stone_sickle, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.iron_sickle, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.gold_sickle, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.steel_sickle, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sickleTool", new ItemStack(ItemsRegistry.bronze_sickle, 1, OreDictionary.WILDCARD_VALUE));

//        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.wood_saw, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.stone_saw, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.iron_saw, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.gold_saw, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.steel_saw, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("sawTool", new ItemStack(ItemsRegistry.bronze_saw, 1, OreDictionary.WILDCARD_VALUE));

//            OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.wood_chisel, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.stone_chisel, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.iron_chisel, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.gold_chisel, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.steel_chisel, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chiselTool", new ItemStack(ItemsRegistry.bronze_chisel, 1, OreDictionary.WILDCARD_VALUE));

//                OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.wood_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.stone_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.iron_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.gold_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.steel_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("rock_hammerTool", new ItemStack(ItemsRegistry.bronze_rock_hammer, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.wooden_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.stone_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.iron_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.gold_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.steel_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("pestle_mortarTool", new ItemStack(ItemsRegistry.bronze_pestle_mortar, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.iron_battlesword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.gold_battlesword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.diamond_battlesword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.bronze_battlesword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.stone_battlesword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("battleswordTool", new ItemStack(ItemsRegistry.wood_battlesword, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.iron_mace, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.gold_mace, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.diamond_mace, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.bronze_mace, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.stone_mace, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("maceTool", new ItemStack(ItemsRegistry.wood_mace, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.iron_waraxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.gold_waraxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.diamond_waraxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.bronze_waraxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.stone_waraxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("waraxeTool", new ItemStack(ItemsRegistry.wood_waraxe, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.iron_halberd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.gold_halberd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.diamond_halberd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.bronze_halberd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.stone_halberd, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("halberdTool", new ItemStack(ItemsRegistry.wood_halberd, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.iron_battlehammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.gold_battlehammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.diamond_battlehammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.bronze_battlehammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.stone_battlehammer, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("warhammerTool", new ItemStack(ItemsRegistry.wood_battlehammer, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.iron_dagger, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.gold_dagger, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.diamond_dagger, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.bronze_dagger, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.stone_dagger, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("daggerTool", new ItemStack(ItemsRegistry.wood_dagger, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.iron_spear, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.gold_spear, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.diamond_spear, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.bronze_spear, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.stone_spear, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("spearTool", new ItemStack(ItemsRegistry.wood_spear, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.iron_saber, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.gold_saber, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.diamond_saber, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.bronze_saber, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.stone_saber, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("saberTool", new ItemStack(ItemsRegistry.wood_saber, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("swordTool", new ItemStack(Items.IRON_SWORD, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("swordTool", new ItemStack(Items.GOLDEN_SWORD, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("swordTool", new ItemStack(Items.DIAMOND_SWORD, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("swordTool", new ItemStack(ItemsRegistry.bronze_sword, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("swordTool", new ItemStack(Items.STONE_SWORD, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("swordTool", new ItemStack(Items.WOODEN_SWORD, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.iron_scythe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.gold_scythe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.diamond_scythe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.bronze_scythe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.stone_scythe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("scytheTool", new ItemStack(ItemsRegistry.wood_scythe, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("hoeTool", new ItemStack(Items.IRON_HOE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hoeTool", new ItemStack(Items.GOLDEN_HOE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hoeTool", new ItemStack(Items.DIAMOND_HOE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hoeTool", new ItemStack(ItemsRegistry.bronze_hoe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hoeTool", new ItemStack(Items.STONE_HOE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("hoeTool", new ItemStack(Items.WOODEN_HOE, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("shovelTool", new ItemStack(Items.IRON_SHOVEL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("shovelTool", new ItemStack(Items.GOLDEN_SHOVEL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("shovelTool", new ItemStack(Items.DIAMOND_SHOVEL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("shovelTool", new ItemStack(ItemsRegistry.bronze_spade, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("shovelTool", new ItemStack(Items.STONE_SHOVEL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("shovelTool", new ItemStack(Items.WOODEN_SHOVEL, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("pickaxeTool", new ItemStack(Items.IRON_PICKAXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pickaxeTool", new ItemStack(Items.GOLDEN_PICKAXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pickaxeTool", new ItemStack(Items.DIAMOND_PICKAXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pickaxeTool", new ItemStack(ItemsRegistry.bronze_pickaxe, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pickaxeTool", new ItemStack(Items.STONE_PICKAXE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("pickaxeTool", new ItemStack(Items.WOODEN_PICKAXE, 1, OreDictionary.WILDCARD_VALUE));
    }
}
