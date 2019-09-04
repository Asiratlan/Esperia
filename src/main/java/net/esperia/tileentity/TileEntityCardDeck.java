package net.esperia.tileentity;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.Nullable;

import net.esperia.ItemsRegistry;
import net.esperia.container.ContainerCardDeck;
import net.esperia.item.ItemCard;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityCardDeck extends TileEntityLockableLoot implements ISidedInventory {
	private static final int[] SLOTS = new int[64];
	private NonNullList<ItemStack> items;
	private boolean hasBeenCleared;
	private int openCount;
	private float progress;
	private float progressOld;
	private boolean destroyedByCreativePlayer;

	public TileEntityCardDeck() {
		this.items = NonNullList.<ItemStack>withSize(64, ItemStack.EMPTY);
		this.fillCards();
	}
	
	public void fillCards(){
		this.items.set(0, new ItemStack(ItemsRegistry.ace_heart, 1, 0));
		this.items.set(1, new ItemStack(ItemsRegistry.two_heart, 1, 0));
		this.items.set(2, new ItemStack(ItemsRegistry.three_heart, 1, 0));
		this.items.set(3, new ItemStack(ItemsRegistry.four_heart, 1, 0));
		this.items.set(4, new ItemStack(ItemsRegistry.five_heart, 1, 0));
		this.items.set(5, new ItemStack(ItemsRegistry.six_heart, 1, 0));
		this.items.set(6, new ItemStack(ItemsRegistry.seven_heart, 1, 0));
		this.items.set(7, new ItemStack(ItemsRegistry.eight_heart, 1, 0));
		this.items.set(8, new ItemStack(ItemsRegistry.nine_heart, 1, 0));
		this.items.set(9, new ItemStack(ItemsRegistry.ten_heart, 1, 0));
		this.items.set(10, new ItemStack(ItemsRegistry.jack_heart, 1, 0));
		this.items.set(11, new ItemStack(ItemsRegistry.queen_heart, 1, 0));
		this.items.set(12, new ItemStack(ItemsRegistry.king_heart, 1, 0));
		this.items.set(13, new ItemStack(ItemsRegistry.ace_diamond, 1, 0));
		this.items.set(14, new ItemStack(ItemsRegistry.two_diamond, 1, 0));
		this.items.set(15, new ItemStack(ItemsRegistry.three_diamond, 1, 0));
		this.items.set(16, new ItemStack(ItemsRegistry.four_diamond, 1, 0));
		this.items.set(17, new ItemStack(ItemsRegistry.five_diamond, 1, 0));
		this.items.set(18, new ItemStack(ItemsRegistry.six_diamond, 1, 0));
		this.items.set(19, new ItemStack(ItemsRegistry.seven_diamond, 1, 0));
		this.items.set(20, new ItemStack(ItemsRegistry.eight_diamond, 1, 0));
		this.items.set(21, new ItemStack(ItemsRegistry.nine_diamond, 1, 0));
		this.items.set(22, new ItemStack(ItemsRegistry.ten_diamond, 1, 0));
		this.items.set(23, new ItemStack(ItemsRegistry.jack_diamond, 1, 0));
		this.items.set(24, new ItemStack(ItemsRegistry.queen_diamond, 1, 0));
		this.items.set(25, new ItemStack(ItemsRegistry.king_diamond, 1, 0));
		this.items.set(26, new ItemStack(ItemsRegistry.ace_club, 1, 0));
		this.items.set(27, new ItemStack(ItemsRegistry.two_club, 1, 0));
		this.items.set(28, new ItemStack(ItemsRegistry.three_club, 1, 0));
		this.items.set(29, new ItemStack(ItemsRegistry.four_club, 1, 0));
		this.items.set(30, new ItemStack(ItemsRegistry.five_club, 1, 0));
		this.items.set(31, new ItemStack(ItemsRegistry.six_club, 1, 0));
		this.items.set(32, new ItemStack(ItemsRegistry.seven_club, 1, 0));
		this.items.set(33, new ItemStack(ItemsRegistry.eight_club, 1, 0));
		this.items.set(34, new ItemStack(ItemsRegistry.nine_club, 1, 0));
		this.items.set(35, new ItemStack(ItemsRegistry.ten_club, 1, 0));
		this.items.set(36, new ItemStack(ItemsRegistry.jack_club, 1, 0));
		this.items.set(37, new ItemStack(ItemsRegistry.queen_club, 1, 0));
		this.items.set(38, new ItemStack(ItemsRegistry.king_club, 1, 0));
		this.items.set(39, new ItemStack(ItemsRegistry.ace_spade, 1, 0));
		this.items.set(40, new ItemStack(ItemsRegistry.two_spade, 1, 0));
		this.items.set(41, new ItemStack(ItemsRegistry.three_spade, 1, 0));
		this.items.set(42, new ItemStack(ItemsRegistry.four_spade, 1, 0));
		this.items.set(43, new ItemStack(ItemsRegistry.five_spade, 1, 0));
		this.items.set(44, new ItemStack(ItemsRegistry.six_spade, 1, 0));
		this.items.set(45, new ItemStack(ItemsRegistry.seven_spade, 1, 0));
		this.items.set(46, new ItemStack(ItemsRegistry.eight_spade, 1, 0));
		this.items.set(47, new ItemStack(ItemsRegistry.nine_spade, 1, 0));
		this.items.set(48, new ItemStack(ItemsRegistry.ten_spade, 1, 0));
		this.items.set(49, new ItemStack(ItemsRegistry.jack_spade, 1, 0));
		this.items.set(50, new ItemStack(ItemsRegistry.queen_spade, 1, 0));
		this.items.set(51, new ItemStack(ItemsRegistry.king_spade, 1, 0));
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */

	public AxisAlignedBB getBoundingBox(IBlockState p_190584_1_) {
		return this.getBoundingBox((EnumFacing) p_190584_1_.getValue(BlockShulkerBox.FACING));
	}

	public AxisAlignedBB getBoundingBox(EnumFacing p_190587_1_) {
		return Block.FULL_BLOCK_AABB.expand((double) (0.5F * this.getProgress(1.0F) * (float) p_190587_1_.getFrontOffsetX()),
				(double) (0.5F * this.getProgress(1.0F) * (float) p_190587_1_.getFrontOffsetY()), (double) (0.5F * this.getProgress(1.0F) * (float) p_190587_1_.getFrontOffsetZ()));
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return this.items.size();
	}

	// Get a Random Itemstack that isn't empty. Return Empty if the inventory
	// have no item
	public ItemStack getRandomCard() {
		ArrayList<ItemStack> cards = new ArrayList<ItemStack>();
		for (int i = 0; i < items.size(); i++) {
			if (!items.get(i).isEmpty()) {
				cards.add(items.get(i));
			}
		}
		if (cards.size() > 0) {
			Random r = new Random();
			return cards.get(r.nextInt(cards.size()));
		}

		return ItemStack.EMPTY;
	}
	
	//Return the first compatible slot with the same item under MaxStackSize or first empty slot
	public int getCompatibleSlot(ItemStack stack){
		for (int i = 0; i < items.size(); i++) {
			if(ItemStack.areItemsEqual(stack, items.get(i)) && items.get(i).getCount() != items.get(i).getMaxStackSize())
				return i;
		}
		
		return getEmptySlot();
	}

	// Get the first ItemStack index that is empty to insert card
	public int getEmptySlot() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).isEmpty()) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be
	 * 64, possibly will be extended.
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.openCount = type;

			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}
	}

	public void openInventory(EntityPlayer player) {
		if (!player.isSpectator()) {
			if (this.openCount < 0) {
				this.openCount = 0;
			}

			++this.openCount;
			this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.openCount);

			if (this.openCount == 1) {
				this.world.playSound((EntityPlayer) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
	}

	public void closeInventory(EntityPlayer player) {
		if (!player.isSpectator()) {
			--this.openCount;
			this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.openCount);

			if (this.openCount <= 0) {
				this.world.playSound((EntityPlayer) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerCardDeck(playerInventory, this);
	}

	public String getGuiID() {
		return "esperia:card_deck";
	}

	/**
	 * Get the name of this object. For players this returns their username
	 */
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.card_deck.name";
	}

	public static void registerFixesShulkerBox(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityCardDeck.class, new String[] { "Items" }));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.loadFromNbt(compound);
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		return this.saveToNbt(compound);
	}

	public void loadFromNbt(NBTTagCompound compound) {
		this.items = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (!this.checkLootAndRead(compound) && compound.hasKey("Items", 9)) {
			ItemStackHelper.loadAllItems(compound, this.items);
		}

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound saveToNbt(NBTTagCompound compound) {
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.items, false);
		}

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		if (!compound.hasKey("Lock") && this.isLocked()) {
			this.getLockCode().toNBT(compound);
		}

		return compound;
	}

	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	public int[] getSlotsForFace(EnumFacing side) {
		return SLOTS;
	}

	/**
	 * Returns true if automation can insert the given item in the given slot
	 * from the given side.
	 */
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return itemStackIn.getItem() instanceof ItemCard;
	}

	/**
	 * Returns true if automation can extract the given item in the given slot
	 * from the given side.
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	public void clear() {
		this.hasBeenCleared = true;
		super.clear();
	}

	public boolean isCleared() {
		return this.hasBeenCleared;
	}

	public float getProgress(float p_190585_1_) {
		return this.progressOld + (this.progress - this.progressOld) * p_190585_1_;
	}

	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 10, this.getUpdateTag());
	}

	public boolean isDestroyedByCreativePlayer() {
		return this.destroyedByCreativePlayer;
	}

	public void setDestroyedByCreativePlayer(boolean p_190579_1_) {
		this.destroyedByCreativePlayer = p_190579_1_;
	}

	public boolean shouldDrop() {
		return !this.isDestroyedByCreativePlayer() || !this.isEmpty() || this.hasCustomName() || this.lootTable != null;
	}

	static {
		for (int i = 0; i < SLOTS.length; SLOTS[i] = i++) {
			;
		}
	}

	protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
		return new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.UP);
	}

}