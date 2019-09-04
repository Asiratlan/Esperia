package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockFence extends net.minecraft.block.BlockFence {

	public BlockFence(Material materialIn, MapColor mapColorIn, String registryName) {
		super(materialIn, mapColorIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, this.getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
