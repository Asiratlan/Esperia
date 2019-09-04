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
public class BlockCropBarley extends BlockCrops {

	public BlockCropBarley() {
		setRegistryName(Esperia.MOD_ID, "barley_crops");
		setUnlocalizedName(Esperia.MOD_ID + "." + "barley_crops");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	protected Item getSeed() {
		return ItemsRegistry.barley_seeds;
	}

	@Override
	protected Item getCrop() {
		return ItemsRegistry.barley;
	}
}
