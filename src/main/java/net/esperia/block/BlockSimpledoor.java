/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 * @author Tiago
 */
public class BlockSimpledoor extends BlockDoor {

    public BlockSimpledoor(String registryName, Material materialIn, SoundType sound, float hardness) {
        super(materialIn);
        setSoundType(sound);
        setHardness(hardness);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
