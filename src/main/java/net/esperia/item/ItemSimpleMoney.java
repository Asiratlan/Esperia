/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.item.Item;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemSimpleMoney extends Item {

    public String registryName;
    
    public ItemSimpleMoney(String registryName) {
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName );
    }
}
