package net.esperia.itemcontainer;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.util.Constants;

public class InventaireItemContainer implements IInventory {

	public NonNullList<ItemStack> content;
	
	public int size;
	
	public InventaireItemContainer(ItemStack container, int size){
		this.size = size;
		this.content = NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
		if(!container.hasTagCompound())
			container.setTagCompound(new NBTTagCompound());
		this.readFromNBT(container.getTagCompound());
	}
	
	public void readFromNBT(NBTTagCompound comp) {
		NBTTagList nbtlist = comp.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < nbtlist.tagCount(); i++) {
			NBTTagCompound comp1 = nbtlist.getCompoundTagAt(i);
			int slot = comp1.getInteger("Slot");
			this.content.set(slot, new ItemStack(comp1));
		}
	}

	public void writeToNBT(NBTTagCompound comp) {
		NBTTagList nbtlist = new NBTTagList();

		for (int i = 0; i < this.size; i++) {
			if (this.content.get(i) != null) {
				NBTTagCompound comp1 = new NBTTagCompound();
				comp1.setInteger("Slot", i);
				this.content.get(i).writeToNBT(comp1);
				nbtlist.appendTag(comp1);
			}
		}
		comp.setTag("Inventory", nbtlist);
	}


	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ItemContainer";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("esperia.container.wallet");
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return this.content.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) {
			if (stack.getCount() > count) {
				stack = stack.splitStack(count);
				if (stack.getCount() == 0) 
					this.content.set(index, ItemStack.EMPTY);
			} else {
				this.content.set(index, ItemStack.EMPTY);
			}
		}
		return stack;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) this.content.set(index, ItemStack.EMPTY);
;
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.content.set(index, stack);

	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return !(stack.getItem() instanceof ItemContainer || !(stack.getItem() instanceof ItemBackpack));
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
