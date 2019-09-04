/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlockSpecial;

/**
 *
 * @author Tiago
 */
public class ItemBlockSpecialCake extends ItemBlockSpecial {

    protected String name;

    public ItemBlockSpecialCake(Block block, String name) {
        super(block);
        this.name = name;
		setRegistryName(Esperia.MOD_ID, name);
		setUnlocalizedName(Esperia.MOD_ID + "." + name);
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
     Esperia.proxy.registerItemRenderer(this, 0, name);
    }
}
