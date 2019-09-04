/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item.seed;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

/**
 *
 * @author Tiago
 */
public class ItemSeedFoodTurnip extends ItemSeedFood {

    public ItemSeedFoodTurnip() {
        super(4, 0.3F, BlocksRegistry.turnip_crops, Blocks.FARMLAND);
		setRegistryName(Esperia.MOD_ID, "turnip");
		setUnlocalizedName(Esperia.MOD_ID + "." + "turnip");
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, "turnip");
    }
}
