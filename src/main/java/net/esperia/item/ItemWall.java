package net.esperia.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemWall extends net.minecraft.item.ItemMultiTexture {

	public ItemWall(Block block, Block block2, ItemMultiTexture.Mapper nameFunction) {
		super(block, block2, nameFunction);
		setRegistryName(block.getRegistryName());
		setUnlocalizedName(block.getRegistryName().getResourcePath());

	}

}
