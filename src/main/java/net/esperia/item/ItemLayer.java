package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.block.BlockLayer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLayer extends ItemBlock {
	public ItemLayer(Block block, String registryName) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
}

	/**
	 * Called when a Block is right-clicked with this Item
	 */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		if (stack.getCount() != 0 && playerIn.canPlayerEdit(pos, facing, stack)) {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();
			BlockPos blockpos = pos;

			if ((facing != EnumFacing.UP || block != this.block) && !block.isReplaceable(worldIn, pos)) {
				blockpos = pos.offset(facing);
				iblockstate = worldIn.getBlockState(blockpos);
				block = iblockstate.getBlock();
			}

			if (block == this.block) {
				int i = ((Integer) iblockstate.getValue(BlockLayer.LAYERS)).intValue();

				if (i <= 7) {
					IBlockState iblockstate1 = iblockstate.withProperty(BlockLayer.LAYERS, Integer.valueOf(i + 1));
					AxisAlignedBB axisalignedbb = iblockstate1.getCollisionBoundingBox(worldIn, blockpos);

					if (axisalignedbb != Block.NULL_AABB && worldIn.checkNoEntityCollision(axisalignedbb.offset(blockpos)) && worldIn.setBlockState(blockpos, iblockstate1, 10)) {
						SoundType soundtype = this.block.getSoundType(iblockstate1, worldIn, blockpos, playerIn);
						worldIn.playSound(playerIn, blockpos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
						stack.shrink(1);
						return EnumActionResult.SUCCESS;
					}
				}
			}

			return super.onItemUse(playerIn, worldIn, blockpos, hand, facing, hitX, hitY, hitZ);
		} else {
			return EnumActionResult.FAIL;
		}
	}

	/**
	 * Converts the given ItemStack damage value into a metadata value to be placed
	 * in the world when this Item is placed as a Block (mostly used with
	 * ItemBlocks).
	 */
	public int getMetadata(int damage) {
		return damage;
	}

	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack) {
		IBlockState state = world.getBlockState(pos);
		return (!(state.getBlock() == this.block) || ((Integer) state.getValue(BlockLayer.LAYERS)) > 7) ? super.canPlaceBlockOnSide(world, pos, side, player, stack) : true;
	}
}