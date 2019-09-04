package net.esperia.container;

import net.esperia.item.ItemKey;
import net.esperia.itemcontainer.InventaireKeyRing;
import net.esperia.slots.SlotInventoryBourse;
import net.esperia.slots.SlotKeyRing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;

public class ContainerKeyRing extends Container {

	InventoryPlayer inv;
	InventaireKeyRing pc;

	public ContainerKeyRing(InventoryPlayer inv, InventaireKeyRing pc) {
		this.inv = inv;
		this.pc = pc;

		float angles[] = { 0F, 27.5F, 62.5F, 90F, 117.5F, 152.5F, 180F, 207.5F, 242.5F, 270F, 297.5F, 332.5F };
		for (int i = 0; i < pc.getSizeInventory(); i++) {
			float angle = (float) (Math.PI * angles[i] / 180F);
			int offsetX = Math.round(52.0F * MathHelper.cos(angle));
			int offsetY = Math.round(52.0F * MathHelper.sin(angle));
			addSlotToContainer(new SlotKeyRing(pc, i, 80 + offsetX, 60 + offsetY));
		}

		int pos = 36;
		for (int m = 0; m < 9; m++) {
			addSlotToContainer(new SlotInventoryBourse(inv, m, 8 + m * 18, 161 + pos));
		}

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 9; l++) {
				addSlotToContainer(new SlotInventoryBourse(inv, l + k * 9 + 9, 8 + l * 18, 103 + k * 18 + pos));
			}
		}

	}
	
	
	public void writeToNBT(ItemStack stack) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
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

		/*NBTTagList list = new NBTTagList("Inventory");
		for(int i=0; i<bourse.getSizeInventory(); i++) {
			if(bourse.getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				bourse.getStackInSlot(i).writeToNBT(nbttagcompound);
				list.appendTag(nbttagcompound);
			}
		}

		if(entityplayer.inventory.getCurrentItem() != null)
			entityplayer.inventory.getCurrentItem().setTagInfo("Inventory", list);*/
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// Prevents backpack-ception (backpack inside backpack) with shift-click
			if (!(itemstack.getItem() instanceof ItemKey)) return ItemStack.EMPTY;

			if (index < this.pc.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.pc.getSizeInventory(), this.inventorySlots.size(), true)) return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, this.pc.getSizeInventory(), false)) { return ItemStack.EMPTY; }

			if (itemstack1.getCount() == 0)
				slot.putStack((ItemStack) ItemStack.EMPTY);
			else
				slot.onSlotChanged();
		}

		return itemstack;
	}

	@Override
	public ItemStack slotClick(int slotIndex, int buttonPressed, ClickType clickType, EntityPlayer player) {
		if (clickType == ClickType.QUICK_CRAFT && buttonPressed == player.inventory.currentItem) return ItemStack.EMPTY;
		this.writeToNBT(player.getHeldItemMainhand());
		return super.slotClick(slotIndex, buttonPressed, clickType, player);
	}
}
