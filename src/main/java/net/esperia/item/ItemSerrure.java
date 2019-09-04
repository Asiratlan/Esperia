package net.esperia.item;

import java.util.Random;

import net.esperia.block.BlockDoorLockable;
import net.esperia.block.BlockTrapDoorLockable;
import net.esperia.tileentity.TileEntityEsperiaLockable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemSerrure extends ItemLock {
	
	//LEGACY LOCKS. REMOVED FROM THE GAME

	public ItemSerrure(String registryName) {
		super(registryName);
		this.setCreativeTab(null);
	}

	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tagLock = stack.getTagCompound();
		tagLock.setLong("key", this.generateKey());
	}

	// Generate a Long Key for the Lock. Key can't be 0;
	public long generateKey() {
		Random rand = new Random();
		long i = rand.nextLong();
		while (i == 0) {
			i = rand.nextLong();
		}
		return i;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		/*
		 * IBlockState state = worldIn.getBlockState(pos); Block block =
		 * state.getBlock(); ItemStack stack = playerIn.getHeldItem(hand); Long
		 * key = this.getkey(stack);
		 * 
		 * if (block instanceof BlockDoor && !(block instanceof
		 * BlockDoorLockable) && key != 0) {
		 * 
		 * BlockDoor blockDoor = (BlockDoor) block; BlockPos posCompl =
		 * state.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER ?
		 * pos.up() : pos.down();
		 * 
		 * IBlockState stateCompl = worldIn.getBlockState(posCompl);
		 * 
		 * Block newDoor = Block.REGISTRY.getObject( new
		 * ResourceLocation("esperia", block.getRegistryName().getResourcePath()
		 * + "_lockable"));
		 * 
		 * worldIn.setBlockState(pos, newDoor.getBlockState().getBaseState()
		 * .withProperty(BlockDoorLockable.FACING,
		 * state.getValue(BlockDoor.FACING))
		 * .withProperty(BlockDoorLockable.OPEN, state.getValue(BlockDoor.OPEN))
		 * .withProperty(BlockDoorLockable.HINGE,
		 * state.getValue(BlockDoor.HINGE))
		 * .withProperty(BlockDoorLockable.POWERED,
		 * state.getValue(BlockDoor.POWERED))
		 * .withProperty(BlockDoorLockable.HALF,
		 * state.getValue(BlockDoor.HALF)));
		 * 
		 * worldIn.setBlockState(posCompl,
		 * newDoor.getBlockState().getBaseState()
		 * .withProperty(BlockDoorLockable.FACING,
		 * stateCompl.getValue(BlockDoor.FACING))
		 * .withProperty(BlockDoorLockable.OPEN,
		 * stateCompl.getValue(BlockDoor.OPEN))
		 * .withProperty(BlockDoorLockable.HINGE,
		 * stateCompl.getValue(BlockDoor.HINGE))
		 * .withProperty(BlockDoorLockable.POWERED,
		 * stateCompl.getValue(BlockDoor.POWERED))
		 * .withProperty(BlockDoorLockable.HALF,
		 * stateCompl.getValue(BlockDoor.HALF))); this.setDoorKey(worldIn, pos,
		 * block, key); if (!worldIn.isRemote) playerIn.sendMessage(new
		 * TextComponentString("(Vous avez posé une serrure sur la porte.)")
		 * .setStyle(new Style().setColor(TextFormatting.BLUE))); } else if
		 * (block instanceof BlockTrapDoor && !(block instanceof
		 * BlockTrapDoorLockable) && key != 0) {
		 * 
		 * TileEntity tileEntityMain = null; TileEntityEsperiaLockable
		 * tileLockableMain = null;
		 * 
		 * Block newTrap = Block.REGISTRY.getObject( new
		 * ResourceLocation("esperia", block.getRegistryName().getResourcePath()
		 * + "_lockable"));
		 * 
		 * worldIn.setBlockState(pos, newTrap.getBlockState().getBaseState()
		 * .withProperty(BlockTrapDoorLockable.FACING,
		 * state.getValue(BlockTrapDoor.FACING))
		 * .withProperty(BlockTrapDoorLockable.OPEN,
		 * state.getValue(BlockTrapDoor.OPEN))
		 * .withProperty(BlockTrapDoorLockable.HALF,
		 * state.getValue(BlockTrapDoor.HALF)));
		 * 
		 * tileEntityMain = worldIn.getTileEntity(pos);
		 * 
		 * if (tileEntityMain != null && tileEntityMain instanceof
		 * TileEntityEsperiaLockable) { tileLockableMain =
		 * (TileEntityEsperiaLockable) tileEntityMain; if
		 * (tileLockableMain.getKey() == 0) { tileLockableMain.setKey(key); if
		 * (!worldIn.isRemote) playerIn.sendMessage(new
		 * TextComponentString("(Vous avez posé une serrure sur la trappe.)")
		 * .setStyle(new Style().setColor(TextFormatting.BLUE))); } } }
		 * 
		 * stack.shrink(1);
		 */
		return EnumActionResult.SUCCESS;
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

		if (itemStackIn.hasTagCompound()) {
			NBTTagCompound tagLock = itemStackIn.getTagCompound();
		}

		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	/*private void setDoorKey(World worldIn, BlockPos pos, Block block, Long key) {

		IBlockState stateMain = worldIn.getBlockState(pos);
		BlockPos posCompl = stateMain.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos.up() : pos.down();

		TileEntity tileEntityMain = worldIn.getTileEntity(pos);
		TileEntity tileEntityCompl = null;
		TileEntityEsperiaLockable tileLockableMain = null;
		TileEntityEsperiaLockable tileLockableCompl = null;

		if (tileEntityMain != null && tileEntityMain instanceof TileEntityEsperiaLockable) {
			tileLockableMain = (TileEntityEsperiaLockable) tileEntityMain;
			tileEntityCompl = worldIn.getTileEntity(posCompl);

			if (tileEntityCompl != null && tileEntityCompl instanceof TileEntityEsperiaLockable) {
				tileLockableCompl = (TileEntityEsperiaLockable) tileEntityCompl;

				if (tileLockableMain.getKey() == 0 && tileLockableCompl.getKey() == 0) {
					tileLockableMain.setKey(key);
					tileLockableCompl.setKey(key);
				}
			}
		}
	}*/
}
