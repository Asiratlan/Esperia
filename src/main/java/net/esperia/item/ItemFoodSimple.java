/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemFoodSimple extends ItemFood {

	public String registryName;
	
    public ItemFoodSimple(String registryName, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.FOOD);
        setAlwaysEdible();
    }
    
    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

}
