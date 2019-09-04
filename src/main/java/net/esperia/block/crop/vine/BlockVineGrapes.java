/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block.crop.vine;

import java.util.Random;

import net.esperia.ItemsRegistry;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 *
 * @author Tiago
 */
public class BlockVineGrapes extends BlockCrops {

    public BlockVineGrapes() {
        setUnlocalizedName("grapes_vines");
        setRegistryName("grapes_vines");
        setCreativeTab(CreativeTabs.FOOD);
        setSoundType(SoundType.WOOD);
        setHardness(2.0F);
    }

    @Override
    protected Item getSeed() {
        return ItemsRegistry.grapes;
    }

    @Override
    protected Item getCrop() {
        return ItemsRegistry.grapes_seeds;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (state.getValue(this.getAgeProperty()) == 7) {
            dropBlockAsItem(worldIn, pos, state, lightValue);
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(this.getAgeProperty(), 0));
            Random rand = worldIn instanceof World ? ((World) worldIn).rand : new Random();
            int random = rand.nextInt(4 + 1);
            if (random == 4) {
                worldIn.playSound(playerIn, pos, SoundEvents.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, SoundCategory.BLOCKS, 2.0F, 1);
                worldIn.destroyBlock(pos, false);
            }
            return true;
        } else {
            return false;
        }
    }
}
