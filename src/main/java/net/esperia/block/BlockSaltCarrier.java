package net.esperia.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockSaltCarrier extends BlockFruitTree {

	public BlockSaltCarrier(Item fruit, String registryName) {
		super(fruit, registryName);
                
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(net.minecraft.init.Blocks.SAND);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return true;
	}

}
