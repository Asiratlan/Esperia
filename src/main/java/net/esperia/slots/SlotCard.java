package net.esperia.slots;

import net.esperia.item.ItemCard;
import net.esperia.item.ItemContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCard extends Slot {

    public SlotCard(IInventory pc, int index, int x, int y) {
        super(pc, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack item) {
        return item.getItem() instanceof ItemCard;
    }
}