/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 *
 * @author Tiago
 */
public class RecipesRegistry {

    public static void init() {
        //Cuisine
        GameRegistry.addSmelting(ItemsRegistry.boarchop_raw, new ItemStack(ItemsRegistry.boarchop_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.fish_herring_raw, new ItemStack(ItemsRegistry.fish_herring_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.fish_sardine_raw, new ItemStack(ItemsRegistry.fish_sardine_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.fish_trout_raw, new ItemStack(ItemsRegistry.fish_trout_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.llama_raw, new ItemStack(ItemsRegistry.llama_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.bear_raw, new ItemStack(ItemsRegistry.bear_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.goat_raw, new ItemStack(ItemsRegistry.goat_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.duck_raw, new ItemStack(ItemsRegistry.duck_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.deer_raw, new ItemStack(ItemsRegistry.deer_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.horse_raw, new ItemStack(ItemsRegistry.horse_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.larva_raw, new ItemStack(ItemsRegistry.larva_cooked), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.squid_raw, new ItemStack(ItemsRegistry.squid_cooked), 0.35F);
        GameRegistry.addSmelting(Items.EGG, new ItemStack(ItemsRegistry.egg_fried), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.dough, new ItemStack(Items.BREAD), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.clay_mug_water, new ItemStack(ItemsRegistry.clay_mug_hotwater), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.clay_mug_milk, new ItemStack(ItemsRegistry.clay_mug_hotmilk), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.teapot_water, new ItemStack(ItemsRegistry.teapot_hotwater), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.teapot_milk, new ItemStack(ItemsRegistry.teapot_hotmilk), 0.35F);
        //Libraire
        GameRegistry.addSmelting(ItemsRegistry.paper_wet, new ItemStack(Items.PAPER), 0.35F);

        //Verrier
        GameRegistry.addSmelting(Blocks.SAND, new ItemStack(ItemsRegistry.molten_glass), 0.35F);

        //Apothicaire
        GameRegistry.addSmelting(Items.COAL, new ItemStack(Items.BLAZE_POWDER), 0.35F);
        GameRegistry.addSmelting(new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.BLAZE_POWDER), 0.35F);

        //TAilleur de pierre
        GameRegistry.addSmelting(ItemsRegistry.flower_pot_raw, new ItemStack(BlocksRegistry.flower_pot), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.clay_mug_raw, new ItemStack(ItemsRegistry.clay_mug_empty), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.teapot_raw, new ItemStack(ItemsRegistry.teapot), 0.35F);
        //minerais
        GameRegistry.addSmelting(ItemsRegistry.iron_raw, new ItemStack(Items.IRON_NUGGET), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.gold_raw, new ItemStack(Items.GOLD_NUGGET), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.copper_raw, new ItemStack(ItemsRegistry.copper_nugget), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.tin_raw, new ItemStack(ItemsRegistry.tin_nugget), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.silver_raw, new ItemStack(ItemsRegistry.silver_nugget), 0.35F);
        GameRegistry.addSmelting(ItemsRegistry.lead_raw, new ItemStack(ItemsRegistry.lead_nugget), 0.35F);
        GameRegistry.addSmelting(BlocksRegistry.salsola, new ItemStack(ItemsRegistry.flux), 0.35F);
    }
}
