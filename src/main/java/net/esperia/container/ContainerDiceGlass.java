package net.esperia.container;

import net.esperia.item.ItemDice;
import net.esperia.itemcontainer.InventaireDiceGlass;
import net.esperia.slots.SlotBourse;
import net.esperia.slots.SlotDice;
import net.esperia.slots.SlotInventoryBourse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerDiceGlass extends Container {

	InventoryPlayer inv;
	InventaireDiceGlass pc;

	public ContainerDiceGlass(InventoryPlayer inv, InventaireDiceGlass pc) {
		this.inv = inv;
		this.pc = pc;

		addSlotToContainer(new SlotDice(pc, 0, 80, 18));
		addSlotToContainer(new SlotDice(pc, 1, 62, 36));
		addSlotToContainer(new SlotDice(pc, 2, 80, 36));
		addSlotToContainer(new SlotDice(pc, 3, 98, 36));
		addSlotToContainer(new SlotDice(pc, 4, 71, 56));
		addSlotToContainer(new SlotDice(pc, 5, 89, 56));

		for (int k = 0; k < 9; k++)
			addSlotToContainer(new SlotInventoryBourse(inv, k, 8 + k * 18, 142));

		for (int j = 0; j < 3; j++)
			for (int i1 = 0; i1 < 9; i1++)
				addSlotToContainer(new SlotInventoryBourse(inv, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));

	}

	public void writeToNBT(ItemStack stack) {
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		pc.writeToNBT(stack.getTagCompound());
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return pc.isUsableByPlayer(entityplayer);
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		this.writeToNBT(entityplayer.getHeldItemMainhand());
		super.onContainerClosed(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (!(itemstack.getItem() instanceof ItemDice))
				return ItemStack.EMPTY;

			if (index < this.pc.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.pc.getSizeInventory(), this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, this.pc.getSizeInventory(), false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0)
				slot.putStack((ItemStack) ItemStack.EMPTY);
			else
				slot.onSlotChanged();
		}

		return itemstack;
	}

	@Override
	public ItemStack slotClick(int slotIndex, int buttonPressed, ClickType clickType, EntityPlayer player) {
		if (clickType == ClickType.QUICK_CRAFT && buttonPressed == player.inventory.currentItem)
			return ItemStack.EMPTY;
		this.writeToNBT(player.getHeldItemMainhand());
		return super.slotClick(slotIndex, buttonPressed, clickType, player);
	}
}
