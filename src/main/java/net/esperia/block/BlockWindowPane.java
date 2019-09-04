package net.esperia.block;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWindowPane extends BlockDoor {

	public BlockWindowPane(String registryName, Material materialIn) {
		super(registryName, materialIn);
	}
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		if (pos.getY() >= worldIn.getHeight() - 1) {
			return false;
		} else {
			//Need to be changed        
			return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up());
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		// Si c'est la partie du dessus
		if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER) {
			BlockPos blockpos = pos.down();
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this) {
				worldIn.setBlockToAir(pos);
			} else if (blockIn != this) {
				iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
			}
			// Si c'est la partie du bas
		} else {
			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);
			// Si la partie du top n'est pas une porte
			if (iblockstate1.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

			if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean) iblockstate1.getValue(POWERED)).booleanValue()) {
				worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

				if (flag != ((Boolean) state.getValue(OPEN)).booleanValue()) {
					worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
					worldIn.markBlockRangeForRenderUpdate(pos, pos);
					worldIn.playEvent((EntityPlayer) null, flag ? this.getOpenSound() : this.getCloseSound(), pos, 0);
				}
			}

		}
	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.addIgnoreToModel(this, POWERED);
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}
	
	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }
    
	private Item getItem() {
		if(this == BlocksRegistry.black_window)
			return BlocksRegistry.black_window_item;
		else if(this == BlocksRegistry.blue_window)
			return BlocksRegistry.blue_window_item;
		else if(this == BlocksRegistry.brown_window)
			return BlocksRegistry.brown_window_item;
		else if(this == BlocksRegistry.clear_window)
			return BlocksRegistry.clear_window_item;
		else if(this == BlocksRegistry.cyan_window)
			return BlocksRegistry.cyan_window_item;
		else if(this == BlocksRegistry.gray_window)
			return BlocksRegistry.gray_window_item;
		else if(this == BlocksRegistry.green_window)
			return BlocksRegistry.green_window_item;
		else if(this == BlocksRegistry.light_blue_window)
			return BlocksRegistry.light_blue_window_item;
		else if(this == BlocksRegistry.lime_window)
			return BlocksRegistry.lime_window_item;
		else if(this == BlocksRegistry.magenta_window)
			return BlocksRegistry.magenta_window_item;
		else if(this == BlocksRegistry.orange_window)
			return BlocksRegistry.orange_window_item;
		else if(this == BlocksRegistry.pink_window)
			return BlocksRegistry.pink_window_item;
		else if(this == BlocksRegistry.purple_window)
			return BlocksRegistry.purple_window_item;
		else if(this == BlocksRegistry.red_window)
			return BlocksRegistry.red_window_item;
		else if(this == BlocksRegistry.silver_window)
			return BlocksRegistry.silver_window_item;
		else if(this == BlocksRegistry.white_window)
			return BlocksRegistry.white_window_item;
		else if(this == BlocksRegistry.yellow_window)
			return BlocksRegistry.yellow_window_item;
		else
			return Items.AIR;
	}
	
	private int getCloseSound() {
		return this.blockMaterial == Material.IRON ? 1011 : 1012;
	}

	private int getOpenSound() {
		return this.blockMaterial == Material.IRON ? 1005 : 1006;
	}
}
