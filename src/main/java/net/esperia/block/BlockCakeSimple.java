/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.BlockCake;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class BlockCakeSimple extends BlockCake {

    public BlockCakeSimple(String registryName, Material materialIn) {
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
