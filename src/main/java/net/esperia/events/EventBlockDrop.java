/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.events;

import net.esperia.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 *
 * @author Tiago
 */
@Mod.EventBusSubscriber
public class EventBlockDrop {

    @SubscribeEvent
    public static void onBlockDrop(HarvestDropsEvent event) {
        if (event.getState().getBlock() == Block.getBlockById(103)) {
            event.getDrops().clear();
            ItemStack stack = new ItemStack(Block.getBlockById(103));
            event.getDrops().add(stack);
        } else if (event.getState().getBlock() == Block.getBlockFromName("lapis_ore")) {
            event.getDrops().clear();
            ItemStack stack = new ItemStack(ItemsRegistry.lapis_lazuli_raw);
            event.getDrops().add(stack);
        }else if (event.getState().getBlock() == Block.getBlockFromName("coal_ore")) {
            event.getDrops().clear();
            ItemStack stack =new ItemStack(Items.COAL, event.getWorld().rand.nextInt(3) + 1);
            event.getDrops().add(stack);
        }else if (event.getState().getBlock() == Block.getBlockFromName("iron_ore")) {
            event.getDrops().clear();
            ItemStack stack = new ItemStack(ItemsRegistry.iron_raw);
            event.getDrops().add(stack);
        } else if (event.getState().getBlock() == Block.getBlockFromName("gold_ore")) {
            event.getDrops().clear();
            ItemStack stack = new ItemStack(ItemsRegistry.gold_raw);
            event.getDrops().add(stack);
        } else if (event.getState().getBlock() == Block.getBlockFromName("stone")) {
            event.getDrops().clear();
            ItemStack stack;
            switch (Block.getStateId(event.getState())) {
                case 4097:
                    stack = new ItemStack(ItemsRegistry.granite_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
                case 12289:
                    stack = new ItemStack(ItemsRegistry.diorite_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
                case 20481:
                    stack = new ItemStack(ItemsRegistry.andesite_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
                default:
                    stack = new ItemStack(ItemsRegistry.stone_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
            }
            event.getDrops().add(stack);
        } else if (event.getState().getBlock() == Block.getBlockFromName("sandstone")) {
            event.getDrops().clear();
            ItemStack stack;
            switch (Block.getStateId(event.getState())) {
                case 24:
                    stack = new ItemStack(ItemsRegistry.sandstone_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
                default:
                    stack = new ItemStack(ItemsRegistry.stone_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
            }
            event.getDrops().add(stack);
        }else if (event.getState().getBlock() == Block.getBlockFromName("red_sandstone")) {
            event.getDrops().clear();
            ItemStack stack;
            switch (Block.getStateId(event.getState())) {
                case 179:
                    stack = new ItemStack(ItemsRegistry.red_sandstone_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
                default:
                    stack = new ItemStack(ItemsRegistry.stone_pebble, event.getWorld().rand.nextInt(4) + 1);
                    break;
            }
            event.getDrops().add(stack);
        }
    }

}
