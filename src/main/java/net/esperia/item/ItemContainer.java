package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemContainer extends ItemSimple {
	
	int size;
	
	public ItemContainer(String registryName, int size) {
		super(registryName);
		this.size = size;
		this.maxStackSize = 1;
	}
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		playerIn.openGui(Esperia.instance(), size, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}
}
