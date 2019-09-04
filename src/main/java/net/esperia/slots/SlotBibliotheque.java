package net.esperia.slots;

import net.esperia.item.ItemSignEsperia;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemWrittenBook;

public class SlotBibliotheque  extends Slot {
    public SlotBibliotheque(IInventory inv, int index, int x, int y) {
        super(inv, index, x, y);
    }
    
    @Override
    public boolean isItemValid(ItemStack item) {
        return item.getItem() instanceof ItemBook 
        		|| item.getItem() instanceof ItemWritableBook
        		|| item.getItem() instanceof ItemWrittenBook
        		//|| item.getItem() instanceof Item.oldBook.itemID
        		//|| item.getItem() instanceof Item.wetBook.itemID
        		
        		|| item.getItem() == Items.PAPER
        		|| item.getItem() instanceof ItemMap
        		//|| item.getItem() instanceof Item.emptyMap.itemID
        		|| item.getItem() instanceof ItemSignEsperia;
    }

}
