package net.esperia.container;

import net.esperia.slots.SlotChess;
import net.esperia.tileentity.TileEntityChessBoard;
import net.esperia.tileentity.TileEntityPlacard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChessBoard extends Container {

	private TileEntityChessBoard tileEntity;
	private IInventory inventory;
	private int numRows;

	public ContainerChessBoard(IInventory inventory, TileEntityChessBoard tileEntity) {

		this.tileEntity = tileEntity;
		this.inventory = inventory;
		numRows = tileEntity.getSizeInventory() / 8;
		// par2IInventory.openChest();
		int i = 64;

		for (int j = 0; j < numRows; j++)
			for (int i1 = 0; i1 < 8; i1++)
				this.addSlotToContainer(new SlotChess(tileEntity, i1 + j * 8, 20 + i1 * 18, 29 + j * 18));

		for (int k = 0; k < 3; k++)
			for (int j1 = 0; j1 < 9; j1++)
				this.addSlotToContainer(new Slot(inventory, j1 + k * 9 + 9, 8 + j1 * 18, 131 + k * 18 + i));

		for (int l = 0; l < 9; l++)
			this.addSlotToContainer(new Slot(inventory, l, 8 + l * 18, 189 + i));

	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return tileEntity.isUsableByPlayer(playerIn);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.numRows * 8)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 8, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 8, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
	
	public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.inventory.closeInventory(playerIn);
    }

    /**
     * Return this chest container's lower chest inventory.
     */
    public IInventory getLowerChestInventory()
    {
        return this.inventory;
    }

}
