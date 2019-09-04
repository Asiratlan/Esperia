package net.esperia.item;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.block.BlockWallSignEsperia;
import net.esperia.network.OpenEditWallNoteMessage;
import net.esperia.tileentity.TileEntityLargeSign;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Item de la note murale.
 *
 * @author Mc-Fr
 */
public class ItemWallNote extends ItemSimple {
	public ItemWallNote() {
		super("wall_note");
		setCreativeTab(CreativeTabs.DECORATIONS);
		setMaxStackSize(16);

	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		if (player.canPlayerEdit(pos, facing, stack)) {
			if (!world.isRemote) {
				if (facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
					return EnumActionResult.FAIL;
				} else if (BlocksRegistry.wall_note.canPlaceBlockAt(world, pos.offset(facing))) {
					pos = pos.offset(facing);
					world.setBlockState(pos, BlocksRegistry.wall_note.getDefaultState().withProperty(BlockWallSignEsperia.FACING, facing), 11);
				}

				stack.shrink(1);
				TileEntity te = world.getTileEntity(pos);

				if (te != null && te instanceof TileEntityLargeSign) {
					Esperia.network.sendTo(new OpenEditWallNoteMessage(pos), (EntityPlayerMP) player);
				}
			} else
				world.playSound(player, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 2f, 0.75f);

			return EnumActionResult.SUCCESS;
		}

		return EnumActionResult.FAIL;
	}
}
