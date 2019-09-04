package net.esperia.tileentity;

import net.esperia.block.BlockFurniture;
import net.esperia.container.ContainerFurniture;
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

public class TileEntityFurniture extends TileEntityLockableLoot implements IInventory {

	private NonNullList<ItemStack> content = NonNullList.<ItemStack>withSize(16, ItemStack.EMPTY);

	public int numPlayersUsing;

	private String customName;

	public TileEntityFurniture() {
	}

	@Override
	public int getSizeInventory() {
		return 16;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		this.fillWithLoot((EntityPlayer) null);
		return content.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		
		this.fillWithLoot((EntityPlayer) null);
		ItemStack itemstack = ItemStackHelper.getAndSplit(this.content, index, count);

		if (itemstack != null) {
			this.markDirty();
		}

		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.fillWithLoot((EntityPlayer) null);
		this.content.set(index, stack);

		if (stack != null && stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		this.markDirty();

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.content = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.content.size()) {
					this.content.set(j, new ItemStack(nbttagcompound));
				}
			}
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.content.size(); ++i) {
				if (this.content.get(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.content.get(i).writeToNBT(nbttagcompound);
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
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		return true;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.furniture";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomName(String name) {
		this.customName = name;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		this.fillWithLoot((EntityPlayer) null);
		return ItemStackHelper.getAndRemove(this.content, index);
	}

	@Override
	public void openInventory(EntityPlayer player) {
		if (!player.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}

			++this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
			this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
		}

	}

	@Override
	public void closeInventory(EntityPlayer player) {
		if (!player.isSpectator() && this.getBlockType() instanceof BlockFurniture) {
			--this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
			this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
		}

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

		for (int i = 0; i < this.content.size(); ++i) {
			this.content.set(i, ItemStack.EMPTY);
		}
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerFurniture(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "esperia:furniture";
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound compound = super.getUpdateTag();

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.content.size(); ++i) {
				if (!this.content.get(i).isEmpty()) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.content.get(i).writeToNBT(nbttagcompound);
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
		this.content = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.content.size()) {
					this.content.set(j, new ItemStack(nbttagcompound));
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
		for (ItemStack itemstack : this.content) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return this.content;
	}

}
