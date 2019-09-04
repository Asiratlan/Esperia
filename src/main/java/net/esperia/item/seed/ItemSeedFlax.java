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
public class ItemSeedFlax extends ItemSeeds{

    public ItemSeedFlax() {
        super(BlocksRegistry.flax_crops, Blocks.FARMLAND);
		setRegistryName(Esperia.MOD_ID, "flax_seeds");
		setUnlocalizedName(Esperia.MOD_ID + "." + "flax_seeds");
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
      Esperia.proxy.registerItemRenderer(this, 0, "flax_seeds");
    }
}
