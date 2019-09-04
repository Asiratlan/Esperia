package net.esperia.slots;

import net.esperia.item.ItemKey;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotKeyRing extends Slot {

    public SlotKeyRing(IInventory pc, int index, int x, int y) {
        super(pc, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack item) {
        return item.getItem() instanceof ItemKey;
    }
}