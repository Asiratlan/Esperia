/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block.cake;

import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 *
 * @author Tiago
 */
public class BlockCakeBlueCheese extends BlockCake {

    public BlockCakeBlueCheese() {
		setRegistryName(Esperia.MOD_ID, "bluecheese_wheel");
		setUnlocalizedName(Esperia.MOD_ID + "." + "bluecheese_wheel");
        setHardness(0.5F);
        setSoundType(SoundType.CLOTH);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        int i = ((Integer) state.getValue(BITES)).intValue();

        if (i < 6) {
            worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
        } else {
            worldIn.setBlockToAir(pos);
        }

        playerIn.addItemStackToInventory(new ItemStack(ItemsRegistry.bluecheese_slice));
        return true;
    }
}
