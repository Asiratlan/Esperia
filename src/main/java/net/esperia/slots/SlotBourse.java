package net.esperia.slots;

import net.esperia.item.ItemContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBourse extends Slot {

    public SlotBourse(IInventory pc, int index, int x, int y) {
        super(pc, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack item) {
        return !(item.getItem() instanceof ItemContainer);
    }
}