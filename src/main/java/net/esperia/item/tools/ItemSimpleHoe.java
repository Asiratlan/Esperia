/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item.tools;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimpleHoe extends ItemHoe {

    public String registryName;

    public ItemSimpleHoe(String registryName,ToolMaterial material) {
        super(material);
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.TOOLS);
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
            return new ItemStack(itemStack.getItem(), itemStack.getCount(), (itemStack.getItemDamage() + 1));
        }
    }
    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }
}
