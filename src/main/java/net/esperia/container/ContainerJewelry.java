package net.esperia.container;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.esperia.itemcontainer.InventaireJewelry;
import net.esperia.slots.SlotInventoryBourse;
import net.esperia.slots.SlotInventoryJewelry;
import net.esperia.slots.SlotJewelry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerJewelry extends Container {

	InventoryPlayer inv;
	InventaireJewelry pc;

	public ContainerJewelry(InventoryPlayer inv, InventaireJewelry pc) {
		this.inv = inv;
		this.pc = pc;

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlotToContainer(new SlotJewelry(pc, j + i * 3, 62 + j * 18, 17 + i * 18));
			}
		}

		for (int k = 0; k < 9; k++)
			addSlotToContainer(new SlotInventoryJewelry(inv, k, 8 + k * 18, 142));

		for (int j = 0; j < 3; j++)
			for (int i1 = 0; i1 < 9; i1++)
				addSlotToContainer(new SlotInventoryJewelry(inv, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));

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
		if (player.isCreative()) {
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

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
