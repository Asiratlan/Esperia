/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block.crop;

import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 *
 * @author Tiago
 */
public class BlockCropLettuce extends BlockCrops {
	public BlockCropLettuce() {
		setRegistryName(Esperia.MOD_ID, "lettuce_crops");
		setUnlocalizedName(Esperia.MOD_ID + "." + "lettuce_crops");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	protected Item getSeed() {
		return ItemsRegistry.lettuce_seeds;
	}

	@Override
	protected Item getCrop() {
		return ItemsRegistry.lettuce;
	}
}
