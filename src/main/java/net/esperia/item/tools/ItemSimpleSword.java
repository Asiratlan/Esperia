/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item.tools;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimpleSword extends ItemSword {

    public String registryName;

    public ItemSimpleSword(String registryName, ToolMaterial material) {
        super(material);
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.COMBAT);
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
