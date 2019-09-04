package net.esperia.container;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.esperia.slots.SlotInventoryBourse;
import net.esperia.slots.SlotJewelry;
import net.esperia.tileentity.TileEntityContainerHRP;
import net.esperia.tileentity.TileEntityPlacard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHRP extends Container {

	private TileEntityContainerHRP tileEntity;
	private IInventory inventory;

	public ContainerHRP(IInventory inventory, TileEntityContainerHRP tileEntity) {

		this.inventory = inventory;
		this.tileEntity = tileEntity;

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlotToContainer(new Slot(tileEntity, j + i * 3, 62 + j * 18, 17 + i * 18));
			}
		}

		for (int k = 0; k < 9; k++)
			addSlotToContainer(new Slot(inventory, k, 8 + k * 18, 142));

		for (int j = 0; j < 3; j++)
			for (int i1 = 0; i1 < 9; i1++)
				addSlotToContainer(new Slot(inventory, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));

	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return tileEntity.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// Prevents backpack-ception (backpack inside backpack) with
			// shift-click
			if (itemstack.getItem() instanceof ItemContainer || itemstack.getItem() instanceof ItemBackpack)
				return ItemStack.EMPTY;

			if (index < this.tileEntity.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.tileEntity.getSizeInventory(), this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, this.tileEntity.getSizeInventory(), false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0)
				slot.putStack((ItemStack) ItemStack.EMPTY);
			else
				slot.onSlotChanged();
		}

		return itemstack;
	}

	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		this.inventory.closeInventory(playerIn);
	}

	/**
	 * Return this chest container's lower chest inventory.
	 */
	public IInventory getLowerChestInventory() {
		return this.inventory;
	}

}
