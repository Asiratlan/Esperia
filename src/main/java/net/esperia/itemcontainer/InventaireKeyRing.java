package net.esperia.itemcontainer;

import net.esperia.item.ItemKey;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.util.Constants;

public class InventaireKeyRing extends InventaireItemContainer {

    public InventaireKeyRing(ItemStack container) {
        super(container, 12);
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack item) {
        return item.getItem() instanceof ItemKey;
    }

    public void readFromNBT(NBTTagCompound comp) {
        NBTTagList nbtlist = comp.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < nbtlist.tagCount(); i++) {
            NBTTagCompound comp1 = nbtlist.getCompoundTagAt(i);
            int slot = comp1.getInteger("Slot");
            this.content.set(slot, new ItemStack(comp1));
        }
    }

    public void writeToNBT(NBTTagCompound comp) {
        NBTTagList nbtlist = new NBTTagList();

        for (int i = 0; i < this.size; i++) {
            if (!this.content.get(i).isEmpty()) {
                NBTTagCompound comp1 = new NBTTagCompound();
                comp1.setInteger("Slot", i);
                this.content.get(i).writeToNBT(comp1);
                nbtlist.appendTag(comp1);
            }
        }
        comp.setTag("Inventory", nbtlist);
    }
    
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("esperia.container.keyring");
	}

}
