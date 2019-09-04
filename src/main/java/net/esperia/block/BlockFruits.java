/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.BlockCocoa;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class BlockFruits extends BlockCocoa {

    public BlockFruits(String registryName) {
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
    }

}
