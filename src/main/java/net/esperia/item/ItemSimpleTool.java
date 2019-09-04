/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimpleTool extends Item {

    public String registryName;

    public ItemSimpleTool(String registryName, int durability) {
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxDamage(durability - 1);
        setMaxStackSize(1);
        setNoRepair();
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {

        if (itemStack.getItemDamage() == itemStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemcopy = itemStack.copy();
            itemcopy.setItemDamage(itemcopy.getItemDamage() + 1);
            return itemcopy;
        }
    }

}
