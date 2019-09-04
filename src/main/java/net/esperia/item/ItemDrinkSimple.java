/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ItemDrinkSimple extends ItemFood {

    public ItemDrinkSimple(String registryName, int amount, float saturation, Item container) {
        this(registryName, amount, saturation, container, 1);
    }

    public ItemDrinkSimple(String registryName, int amount, float saturation, Item container, int uses) {
        super(amount, saturation, false);
        this.setContainerItem(container);
        this.setMaxDamage(uses);
        this.setMaxStackSize(1);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.FOOD);
        setAlwaysEdible();
        setNoRepair();
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

            return getContainerItem(stack);
        }
        return stack;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getItemDamage() == itemStack.getMaxDamage() - 1) {
             return new ItemStack(getContainerItem());
        } else {
            ItemStack itemcopy = itemStack.copy();
            itemcopy.setItemDamage(itemcopy.getItemDamage() + 1);
            return itemcopy;
        }
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
    }

}
