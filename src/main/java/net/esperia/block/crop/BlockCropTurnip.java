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
public class BlockCropTurnip extends BlockCrops {

	public BlockCropTurnip() {
		setRegistryName(Esperia.MOD_ID, "turnip_crops");
		setUnlocalizedName(Esperia.MOD_ID + "." + "turnip_crops");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	protected Item getSeed() {
		return ItemsRegistry.turnip;
	}

	@Override
	protected Item getCrop() {
		return ItemsRegistry.turnip;
	}
}
