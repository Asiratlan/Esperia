/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.events;

import net.esperia.ItemsRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 *
 * @author Tiago
 */
@Mod.EventBusSubscriber
public class EventRightClick {

    @SubscribeEvent()
    public void onPlayerInteractionWithEntity(EntityInteract event) {
        if (event.getHand() == EnumHand.MAIN_HAND) {
            ItemStack itemStack = event.getItemStack();
            if (itemStack.getItem() instanceof ItemShears && event.getTarget() instanceof EntitySheep) {
                final EntitySheep sheep = (EntitySheep) event.getTarget();
                    if (sheep.isShearable(itemStack, event.getWorld(), event.getPos())) {
                        if (!event.getWorld().isRemote) {
                        	event.setCanceled(true);
                            event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ItemsRegistry.wool_raw, event.getWorld().rand.nextInt(5) + 3)));
                            sheep.setSheared(true);
                            sheep.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
                            event.getItemStack().damageItem(1, event.getEntityPlayer());
                        }
                    }
                }
            
            if (itemStack.getItem() == ItemsRegistry.wooden_bucket && event.getTarget() instanceof EntityCow) {
                    event.getEntityPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(ItemsRegistry.wooden_bucket_milk, 1, 0)); 
                }
            }
        }
    }
