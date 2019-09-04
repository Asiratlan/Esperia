/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.handler;

import net.esperia.Esperia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

/**
 *
 * @author Tiago
 */
public class LootTableHandler {

    public static final ResourceLocation DUCK = LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "duck"));
    public static final ResourceLocation DEER = LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "deer"));
    public static final ResourceLocation BOAR = LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "boar"));
    public static final ResourceLocation FOX = LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "fox"));
    public static final ResourceLocation GOAT = LootTableList.register(new ResourceLocation(Esperia.MOD_ID, "GOAT"));

}
