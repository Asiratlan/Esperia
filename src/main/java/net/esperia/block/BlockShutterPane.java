package net.esperia.block;

import net.esperia.BlocksRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShutterPane extends BlockWindowPane {

	public BlockShutterPane(String registryName, Material materialIn) {
		super(registryName, materialIn);
	}
	
	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }
    
	private Item getItem() {
		if(this == BlocksRegistry.acacia_shutter)
			return BlocksRegistry.acacia_shutter_item;
		else if(this == BlocksRegistry.birch_shutter)
			return BlocksRegistry.birch_shutter_item;
		else if(this == BlocksRegistry.dark_oak_shutter)
			return BlocksRegistry.dark_oak_shutter_item;
		else if(this == BlocksRegistry.jungle_shutter)
			return BlocksRegistry.jungle_shutter_item;
		else if(this == BlocksRegistry.oak_shutter)
			return BlocksRegistry.oak_shutter_item;
		else if(this == BlocksRegistry.spruce_shutter)
			return BlocksRegistry.spruce_shutter_item;
		else
			return Items.AIR;
	}
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }
}
