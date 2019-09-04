/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class BlockSimple extends Block {
	
	public String registryName;

    public BlockSimple(String registryName, Material materialIn, SoundType sound, float hardness) {
        super(materialIn);
        this.registryName = registryName;
        setSoundType(sound);
        setHardness(hardness);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
    
    
}
