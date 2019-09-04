/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class BlockStairs extends net.minecraft.block.BlockStairs {

	public String registryName;

	public BlockStairs(String registryName, IBlockState modelState) {
		super(modelState);
		this.registryName = registryName;
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		useNeighborBrightness = true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
