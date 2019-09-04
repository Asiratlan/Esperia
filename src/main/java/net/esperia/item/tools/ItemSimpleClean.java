/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

/**
 *
 * @author Tiago
 */
public class ItemSimpleClean extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.WEB);
    public String registryName;

    public ItemSimpleClean(String registryName) {
        super(Item.ToolMaterial.WOOD, EFFECTIVE_ON);
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.WEB ? super.getDestroySpeed(stack, state) : 15.0F;

    }
}
