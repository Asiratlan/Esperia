/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimple extends Item {

    public String registryName;

    public ItemSimple(String registryName) {
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.MISC);
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }
}
