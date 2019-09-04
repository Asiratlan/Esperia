package net.esperia.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLock extends ItemSimple {

	public ItemLock(String registryName) {
		super(registryName);
		// TODO Auto-generated constructor stub
	}
	
	public static long getkey(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("key")) 
			return stack.getTagCompound().getLong("key");
		return 0;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		if(advanced.isAdvanced()) {
			tooltip.add("" + getkey(stack));
		}
		super.addInformation(stack, worldIn, tooltip, advanced);
	}

	/*
	 * protected PosBlockDoor getPosBlockDoor (World worldIn, BlockPos pos){
	 * BlockPos posUp = pos.up(); BlockPos posDown = pos.down();
	 * 
	 * PosBlockDoor posDoor;
	 * 
	 * if (worldIn.getBlockState(posUp).getBlock() instanceof BlockDoor &&
	 * !(worldIn.getBlockState(posDown).getBlock() instanceof BlockDoor)) posDoor =
	 * PosBlockDoor.UP; else if (worldIn.getBlockState(posDown).getBlock()
	 * instanceof BlockDoor && !(worldIn.getBlockState(posUp).getBlock() instanceof
	 * BlockDoor)) posDoor = PosBlockDoor.DOWN; else posDoor = PosBlockDoor.ERROR;
	 * 
	 * return posDoor; }
	 * 
	 * protected enum PosBlockDoor { UP, DOWN, ERROR; };
	 */

}
