package net.esperia.container;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.esperia.itemcontainer.InventaireItemContainer;
import net.esperia.slots.SlotBourse;
import net.esperia.slots.SlotInventoryBourse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerItemContainer extends Container {

	public InventoryPlayer inv;
	public InventaireItemContainer bourse;

	public ContainerItemContainer(InventoryPlayer inv, InventaireItemContainer bourse) {
		this.inv = inv;
		this.bourse = bourse;

		int size = bourse.getSizeInventory();
		if(size == 2) {
			addSlotToContainer(new SlotBourse(bourse, 0, 71, 36));
			addSlotToContainer(new SlotBourse(bourse, 1, 89, 36));
		} else if(size == 4) {
			addSlotToContainer(new SlotBourse(bourse, 0, 60, 36));
			addSlotToContainer(new SlotBourse(bourse, 1, 80, 27));
			addSlotToContainer(new SlotBourse(bourse, 2, 80, 45));
			addSlotToContainer(new SlotBourse(bourse, 3, 100, 36));
		} else if(size == 6) {
			addSlotToContainer(new SlotBourse(bourse, 0, 80, 18));
			addSlotToContainer(new SlotBourse(bourse, 1, 62, 36));
			addSlotToContainer(new SlotBourse(bourse, 2, 80, 36));
			addSlotToContainer(new SlotBourse(bourse, 3, 98, 36));
			addSlotToContainer(new SlotBourse(bourse, 4, 71, 56));
			addSlotToContainer(new SlotBourse(bourse, 5, 89, 56));
		}

        for (int k = 0; k < 9; k++)
        	addSlotToContainer(new SlotInventoryBourse(inv, k, 8 + k * 18, 142));
        
        for (int j = 0; j < 3; j++)
            for (int i1 = 0; i1 < 9; i1++)
            	addSlotToContainer(new SlotInventoryBourse(inv, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));
	}
	
	public void writeToNBT(ItemStack stack) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		bourse.writeToNBT(stack.getTagCompound());
	}



	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return bourse.isUsableByPlayer(entityplayer);
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

			// Prevents backpack-ception (backpack inside backpack) with
			// shift-click
			if (itemstack.getItem() instanceof ItemContainer || itemstack.getItem() instanceof ItemBackpack) return ItemStack.EMPTY;

			if (index < this.bourse.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.bourse.getSizeInventory(), this.inventorySlots.size(), true)) return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, this.bourse.getSizeInventory(), false)) { return ItemStack.EMPTY; }

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
		  
		 /* if(slot >= bourse.getSizeInventory() && slot < (bourse.getSizeInventory()+9)) {
			int id = slot - bourse.getSizeInventory();
			if(id == player.inventory.currentItem)
				return null;
		}

		if(par3 == 2)
			return null;

		ItemStack parent = super.slotClick(slot, clickType, par3, player);

		if(slot >= 0 && slot < bourse.getSizeInventory()) {
			NBTTagList list = new NBTTagList("Inventory");
			for(int i=0; i<bourse.getSizeInventory(); i++) {
				if(bourse.getStackInSlot(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte)i);
					bourse.getStackInSlot(i).writeToNBT(nbttagcompound);
					list.appendTag(nbttagcompound);
				}
			}

			if(player.inventory.getCurrentItem() != null)
				player.inventory.getCurrentItem().setTagInfo("Inventory", list);
		}

		return parent;*/
	}

}
