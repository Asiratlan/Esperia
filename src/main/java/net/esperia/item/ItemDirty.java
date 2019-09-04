/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemDirty extends Item {

    public String registryName;
    public Item itemReturned;

    public ItemDirty(String registryName) {
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.MISC);
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
        if (raytraceresult == null) {
            return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        } else {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = raytraceresult.getBlockPos();
                if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, playerIn.getHeldItem(handIn))) {
                    return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
                }
                if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER
                        || (worldIn.getBlockState(blockpos).getBlock() == Blocks.CAULDRON && worldIn.getBlockState(blockpos).getValue(BlockCauldron.LEVEL) > 0)) {

                    worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    switch (playerIn.getHeldItem(handIn).getUnlocalizedName()) {
                        case "item.esperia.glass_mug_dirty":
                            itemReturned = ItemsRegistry.glass_mug_empty;
                            break;
                        case "item.esperia.glass_tumbler_dirty":
                            itemReturned = ItemsRegistry.glass_tumbler_empty;
                            break;
                        case "item.esperia.clay_mug_dirty":
                            itemReturned = ItemsRegistry.clay_mug_empty;
                            break;
                    }
                    if (worldIn.getBlockState(blockpos).getBlock() == Blocks.CAULDRON) {
                        double randNumber = Math.random();
                        double d = randNumber * 100;
                        int i = (int) d + 1;
                        if (i > 75) {
                            worldIn.setBlockState(blockpos, worldIn.getBlockState(blockpos).withProperty(BlockCauldron.LEVEL, worldIn.getBlockState(blockpos).getValue(BlockCauldron.LEVEL) - 1));
                        }

                    }
                    return new ActionResult(EnumActionResult.SUCCESS, this.turnBottleIntoItem(playerIn.getHeldItem(handIn), playerIn, new ItemStack(itemReturned)));
                }
            }

            return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }

    }

    protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, EntityPlayer player, ItemStack stack) {
        p_185061_1_.shrink(1);;
        player.addStat(StatList.getObjectUseStats(this));

        if (p_185061_1_.getCount() <= 0) {
            return stack;
        } else {
            if (!player.inventory.addItemStackToInventory(stack)) {
                player.dropItem(stack, false);
            }

            return p_185061_1_;
        }
    }
}
