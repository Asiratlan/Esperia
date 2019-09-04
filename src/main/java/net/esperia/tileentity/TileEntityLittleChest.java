package net.esperia.tileentity;

import net.esperia.container.ContainerLittleChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.NonNullList;

public class TileEntityLittleChest extends TileEntityLockableLoot implements IInventory {

	private NonNullList<ItemStack> contents = NonNullList.<ItemStack>withSize(16, ItemStack.EMPTY);
	private String customName;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.hasCustomName() ? this.customName : "container.little_chest.name";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomName(String name) {
		this.customName = name;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return contents.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		this.fillWithLoot((EntityPlayer) null);
		ItemStack itemstack = ItemStackHelper.getAndSplit(this.contents, index, count);

		if (itemstack != null) {
			this.markDirty();
		}

		return itemstack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		this.fillWithLoot((EntityPlayer) null);
		return ItemStackHelper.getAndRemove(this.contents, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.fillWithLoot((EntityPlayer) null);
		this.contents.set(index, stack);

		if (stack != null && stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		this.markDirty();

	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.contents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.contents.size()) {
					this.contents.set(j, new ItemStack(nbttagcompound));
				}
			}
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.contents.size(); ++i) {
				if (this.contents.get(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.contents.get(i).writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			compound.setTag("Items", nbttaglist);
		}

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
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

		return true;
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
		this.fillWithLoot((EntityPlayer) null);

		for (int i = 0; i < this.contents.size(); ++i) {
			this.contents.set(i, ItemStack.EMPTY);
		}
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerLittleChest(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		// TODO Auto-generated method stub
		return "esperia:little_chest";
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound compound = super.getUpdateTag();

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.contents.size(); ++i) {
				if (this.contents.get(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.contents.get(i).writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			compound.setTag("Items", nbttaglist);
		}

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound compound) {
		super.handleUpdateTag(compound);
		this.contents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.contents.size()) {
					this.contents.set(j, new ItemStack(nbttagcompound));
				}
			}
		}
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		if (net.getDirection() == EnumPacketDirection.CLIENTBOUND) {
			readFromNBT(pkt.getNbtCompound());
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
