package net.esperia.slots;

import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.esperia.item.ItemKeyRing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInventoryBourse extends Slot {

    public SlotInventoryBourse(IInventory pc, int index, int x, int y) {
        super(pc, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack item) {
        return !(item.getItem() instanceof ItemContainer);
    }
    
    @Override
    public boolean canTakeStack(EntityPlayer playerIn)
    {
        return !(this.getStack().getItem() instanceof ItemContainer || this.getStack().getItem() instanceof ItemBackpack || this.getStack().getItem() instanceof ItemKeyRing);
    }
}