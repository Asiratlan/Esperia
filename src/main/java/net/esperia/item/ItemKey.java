package net.esperia.item;

import net.esperia.block.BlockDoorLockable;
import net.esperia.block.BlockTrapDoorLockable;
import net.esperia.tileentity.TileEntityEsperiaLockable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemKey extends ItemLock {

	public ItemKey(String registryName) {
		super(registryName);
		this.setCreativeTab(null);		// TODO Auto-generated constructor stub
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ, EnumHand hand) {

		Block block = worldIn.getBlockState(pos).getBlock();
		ItemStack stack = playerIn.getHeldItem(hand);
		return unlockDoor(worldIn, pos, playerIn, block, stack);
	}
	public static EnumActionResult unlockDoor(World worldIn, BlockPos pos, EntityPlayer playerIn, Block block, ItemStack stack) {
		Long key = 0L;

		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("key"))
			key = stack.getTagCompound().getLong("key");
		
		if (block instanceof BlockDoorLockable && key != 0) {
			TileEntity tileEntityMain = worldIn.getTileEntity(pos);
			TileEntity tileEntityCompl = null;
			TileEntityEsperiaLockable tileLockableMain = null;
			TileEntityEsperiaLockable tileLockableCompl = null;

			if (tileEntityMain instanceof TileEntityEsperiaLockable) {
				tileLockableMain = (TileEntityEsperiaLockable) tileEntityMain;

				if (worldIn.getBlockState(tileLockableMain.getComplHalfDoor(worldIn))
						.getBlock() instanceof BlockDoorLockable) {
					tileEntityCompl = worldIn.getTileEntity(tileLockableMain.getComplHalfDoor(worldIn));

					if (tileEntityCompl != null && tileEntityCompl instanceof TileEntityEsperiaLockable) {
						tileLockableCompl = (TileEntityEsperiaLockable) tileEntityCompl;

						if (tileLockableMain.getKey() == tileLockableCompl.getKey()) {

							if (tileLockableMain.getKey() == key) {

								tileLockableMain.serrure();
								tileLockableCompl.serrure();
								if (!worldIn.isRemote) {
									playerIn.sendMessage(new TextComponentString(
											"(La porte vient d'être " + tileLockableMain.messageSerrure() + ".)")
													.setStyle(new Style().setColor(TextFormatting.BLUE)));
									return EnumActionResult.PASS;
								}
							}
						}
					}
				}
			}
		} else if (block instanceof BlockTrapDoorLockable && key != 0) {
			TileEntity tileEntityMain = worldIn.getTileEntity(pos);
			TileEntityEsperiaLockable tileLockableMain = null;

			if (tileEntityMain instanceof TileEntityEsperiaLockable) {
				tileLockableMain = (TileEntityEsperiaLockable) tileEntityMain;

				if (tileLockableMain.getKey() == key) {
					tileLockableMain.serrure();
					if (!worldIn.isRemote)
						playerIn.sendMessage(new TextComponentString(
								"(La trappe vient d'être " + tileLockableMain.messageSerrure() + ".)")
										.setStyle(new Style().setColor(TextFormatting.BLUE)));
					return EnumActionResult.PASS;
				}
			}

		}
		return EnumActionResult.FAIL;
	}

	public void setKey(Long key, ItemStack stack) {
		NBTTagCompound nbt;
		if (stack.hasTagCompound())
			nbt = stack.getTagCompound();
		else
			nbt = new NBTTagCompound();

		nbt.setLong("key", key);
		stack.setTagCompound(nbt);
	}
}
