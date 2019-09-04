/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.events;

import net.esperia.Esperia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 *
 * @author Tiago
 */
@Mod.EventBusSubscriber
public class EventLootTable {

    public static ResourceLocation ENTITY_LLAMA =  LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "llama"));
    
    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getName().equals(LootTableList.ENTITIES_LLAMA)) {
            event.setTable(event.getLootTableManager().getLootTableFromLocation(ENTITY_LLAMA));
        }
    }
}
