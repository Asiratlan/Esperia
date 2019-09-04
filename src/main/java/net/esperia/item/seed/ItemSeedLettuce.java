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
import net.minecraft.item.ItemSeeds;

/**
 *
 * @author Tiago
 */
public class ItemSeedLettuce extends ItemSeeds {

    public ItemSeedLettuce() {
        super(BlocksRegistry.lettuce_crops, Blocks.FARMLAND);
		setRegistryName(Esperia.MOD_ID, "lettuce_seeds");
		setUnlocalizedName(Esperia.MOD_ID + "." + "lettuce_seeds");
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
     Esperia.proxy.registerItemRenderer(this, 0, "lettuce_seeds");
    }
}
