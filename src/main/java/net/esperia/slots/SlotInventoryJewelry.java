package net.esperia.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotInventoryJewelry extends Slot {

    public SlotInventoryJewelry(IInventory pc, int index, int x, int y) {
        super(pc, index, x, y);
    }
    
    @Override
    public boolean canTakeStack(EntityPlayer playerIn)
    {
        return playerIn.isCreative();
    }
}