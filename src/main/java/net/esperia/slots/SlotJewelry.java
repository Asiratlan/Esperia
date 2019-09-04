package net.esperia.slots;

import net.esperia.item.ItemDice;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SlotJewelry extends Slot {

	public SlotJewelry(IInventory pc, int index, int x, int y) {
		super(pc, index, x, y);
	}

	@Override
	public boolean canTakeStack(EntityPlayer player) {
		return player.isCreative();
	}

	@Override
	public boolean isItemValid(ItemStack item) {
		return true;
	}
}