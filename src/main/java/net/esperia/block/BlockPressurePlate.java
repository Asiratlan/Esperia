package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockPressurePlate extends net.minecraft.block.BlockPressurePlate {

	public BlockPressurePlate(Material materialIn, Sensitivity sensitivityIn, String name) {
		super(materialIn, sensitivityIn);
		setRegistryName(Esperia.MOD_ID, name);
		setUnlocalizedName(Esperia.MOD_ID + "." + name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
