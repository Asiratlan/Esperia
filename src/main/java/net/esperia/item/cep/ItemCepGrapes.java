/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item.cep;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

/**
 *
 * @author Tiago
 */
public class ItemCepGrapes extends ItemSeeds {

    public ItemCepGrapes() {
        super(BlocksRegistry.grapes_vines, Blocks.FARMLAND);
		setRegistryName(Esperia.MOD_ID, "grapes_ceps");
		setUnlocalizedName(Esperia.MOD_ID + "." + "grapes_ceps");
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
          Esperia.proxy.registerItemRenderer(this, 0, "grapes_ceps");
    }
}
