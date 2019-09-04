package net.esperia.tileentity;

import java.util.Random;

import net.esperia.block.BlockBibliotheque;
import net.esperia.container.ContainerBibliotheque;
import net.esperia.item.ItemSignEsperia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.NonNullList;

public class TileEntityBibliotheque extends TileEntityLockableLoot implements IInventory {

	private NonNullList<ItemStack> biblioContents = NonNullList.<ItemStack>withSize(16, ItemStack.EMPTY);

	private Random biblioRandom = new Random();
	public int numPlayersUsing;

	private String customName;

	private boolean[] books = new boolean[16];

	public TileEntityBibliotheque() {
		for (int i = 0; i < 16; i++)
			this.books[i] = false;
	}

	@Override
	public int getSizeInventory() {
		return 16;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		this.fillWithLoot((EntityPlayer) null);
		return biblioContents.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		/*
		 * if (biblioContents[index] != null) { if (biblioContents[index].stackSize <=
		 * count) { ItemStack itemstack = biblioContents[index]; biblioContents[index] =
		 * null; onInventoryChanged(); return itemstack; }
		 * 
		 * ItemStack itemstack1 = biblioContents[index].splitStack(count);
		 * 
		 * if (biblioContents[index].stackSize == 0) biblioContents[index] = null;
		 * 
		 * onInventoryChanged(); return itemstack1; } else return null;
		 */
		this.fillWithLoot((EntityPlayer) null);
		ItemStack itemstack = ItemStackHelper.getAndSplit(this.biblioContents, index, count);

		if (itemstack != null) {
			this.markDirty();
		}

		return itemstack;
	}

	/*
	 * @Override public ItemStack getStackInSlotOnClosing(int par1) { if
	 * (biblioContents[par1] != null) { ItemStack itemstack = biblioContents[par1];
	 * biblioContents[par1] = null; return itemstack; } else return null; }
	 */

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.fillWithLoot((EntityPlayer) null);
		this.biblioContents.set(index, stack);

		if (stack != null && stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (stack != null)
			if (this.isItemValidForSlot(index, stack))
				this.books[index] = true;
			else
				this.books[index] = false;
		else
			this.books[index] = false;

		// this.getUpdatePacket();
		this.markDirty();
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.biblioContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8))
			this.customName = compound.getString("CustomName");

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); i++) {
				NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.biblioContents.size())
					this.biblioContents.set(j, new ItemStack(nbttagcompound));
			}

		}
		NBTTagList nbttaglistBooks = compound.getTagList("TagBooks", 10);

		for (int i = 0; i < nbttaglistBooks.tagCount(); i++) {
			NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglistBooks.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("SlotBooks");
			if (j >= 0 && j < this.books.length)
				this.books[j] = nbttagcompound.getBoolean("Books");
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();
			NBTTagList nbttaglistBooks = new NBTTagList();
			for (int i = 0; i < this.biblioContents.size(); i++) {
				if (this.biblioContents.get(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.biblioContents.get(i).writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);

				}

				if (this.books[i]) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("SlotBooks", (byte) i);
					nbttagcompound.setBoolean("Books", true);
					nbttaglistBooks.appendTag(nbttagcompound);

				}
			}

			compound.setTag("Items", nbttaglist);
			compound.setTag("TagBooks", nbttaglistBooks);
		}

		if (this.hasCustomName())
			compound.setString("CustomName", this.customName);

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

	/*
	 * // permet de lire le packet de custom tile entity public void public void
	 * readCustomNBT(NBTTagCompound nbt) { byte[] bbooks =
	 * nbt.getByteArray("booksExist"); for (int i = 0; i < bbooks.length; i++) {
	 * this.books[i] = (bbooks[i] == 1); } }
	 */

	public boolean hasBook(int i) {
		return this.books[i];
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		return item.getItem() instanceof ItemBook || item.getItem() instanceof ItemWritableBook || item.getItem() instanceof ItemWrittenBook
		// || item.getItem() instanceof Item.oldBook.itemID
		// || item.getItem() instanceof Item.wetBook.itemID

				|| item.getItem() == Items.PAPER || item.getItem() instanceof ItemMap
				// || item.getItem() instanceof Item.emptyMap.itemID
				|| item.getItem() instanceof ItemSignEsperia;

	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.bookshelf.name";
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
		return ItemStackHelper.getAndRemove(this.biblioContents, index);
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
		if (!player.isSpectator() && this.getBlockType() instanceof BlockBibliotheque) {
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

		for (int i = 0; i < this.biblioContents.size(); ++i) {
			this.biblioContents.set(i, ItemStack.EMPTY);
		}
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerBibliotheque(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "esperia:bibliotheque";
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound compound = super.getUpdateTag();

		if (!this.checkLootAndWrite(compound)) {
			NBTTagList nbttaglist = new NBTTagList();
			NBTTagList nbttaglistBooks = new NBTTagList();
			for (int i = 0; i < this.biblioContents.size(); i++) {
				if (this.biblioContents.get(i) != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.biblioContents.get(i).writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);

				}

				if (this.books[i]) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("SlotBooks", (byte) i);
					nbttagcompound.setBoolean("Books", true);
					nbttaglistBooks.appendTag(nbttagcompound);

				}
			}

			compound.setTag("Items", nbttaglist);
			compound.setTag("TagBooks", nbttaglistBooks);
		}

		if (this.hasCustomName())
			compound.setString("CustomName", this.customName);

		return compound;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound compound) {
		super.handleUpdateTag(compound);
		this.biblioContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (compound.hasKey("CustomName", 8))
			this.customName = compound.getString("CustomName");

		if (!this.checkLootAndRead(compound)) {
			NBTTagList nbttaglist = compound.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); i++) {
				NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.biblioContents.size())
					this.biblioContents.set(j, new ItemStack(nbttagcompound));
			}

		}
		NBTTagList nbttaglistBooks = compound.getTagList("TagBooks", 10);

		for (int i = 0; i < nbttaglistBooks.tagCount(); i++) {
			NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglistBooks.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("SlotBooks");
			if (j >= 0 && j < this.books.length)
				this.books[j] = nbttagcompound.getBoolean("Books");
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
		for (ItemStack itemstack : this.biblioContents) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return this.biblioContents;
	}

}
