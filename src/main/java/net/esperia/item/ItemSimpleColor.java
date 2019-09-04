/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimpleColor extends ItemSimple {

    public String registryName;
    public int defaultColor;

    public ItemSimpleColor(String registryName) {
        super(registryName);
        this.registryName = registryName;
        this.defaultColor = 15790320;
    }
    
    public ItemSimpleColor(String registryName, int defaultColor) {
        super(registryName);
        this.registryName = registryName;
        this.defaultColor = defaultColor;
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    public boolean hasColor(ItemStack stack) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
    }

    public int getColor(ItemStack stack) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        if (nbttagcompound != null) {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3)) {
                return nbttagcompound1.getInteger("color");
            }
        }
        return defaultColor;
    }

    public void removeColor(ItemStack stack) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        if (nbttagcompound != null) {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
            if (nbttagcompound1.hasKey("color")) {
                nbttagcompound1.removeTag("color");
            }
        }
    }

    public void setColor(ItemStack stack, int color) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            stack.setTagCompound(nbttagcompound);
        }
        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
        if (!nbttagcompound.hasKey("display", 10)) {
            nbttagcompound.setTag("display", nbttagcompound1);
        }
        nbttagcompound1.setInteger("color", color);
    }
}
