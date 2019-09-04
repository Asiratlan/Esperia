package net.esperia;

import net.esperia.entity.EntityBee;
import net.esperia.entity.EntityBoar;
import net.esperia.entity.EntityDeer;
import net.esperia.entity.EntityDuck;
import net.esperia.entity.EntityFox;
import net.esperia.entity.EntityGoat;
import net.esperia.renders.RenderBee;
import net.esperia.renders.RenderBoar;
import net.esperia.renders.RenderDeer;
import net.esperia.renders.RenderDuck;
import net.esperia.renders.RenderFox;
import net.esperia.renders.RenderGoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitiesRegistry {

    public static void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "duck"), EntityDuck.class, "duck", 1, Esperia.instance(), 80, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "boar"), EntityBoar.class, "boar", 2, Esperia.instance(), 80, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "goat"), EntityGoat.class, "goat", 3, Esperia.instance(), 80, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "deer"), EntityDeer.class, "deer", 4, Esperia.instance(), 80, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "bee"), EntityBee.class, "bee", 5, Esperia.instance(), 80, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Esperia.MOD_ID, "fox"), EntityFox.class, "fox", 6, Esperia.instance(), 80, 1, false);

        EntityRegistry.registerEgg(new ResourceLocation("esperia:duck"), 1595928, 16776960);
        EntityRegistry.registerEgg(new ResourceLocation("esperia:boar"), 6838862, 2958880);
        EntityRegistry.registerEgg(new ResourceLocation("esperia:goat"), 6573874, 2498068);
        EntityRegistry.registerEgg(new ResourceLocation("esperia:deer"), 6961423, 9860957);
        EntityRegistry.registerEgg(new ResourceLocation("esperia:bee"), 16776960, 0);
        EntityRegistry.registerEgg(new ResourceLocation("esperia:fox"), 8996106, 10260089);
        int[] wild_biomes = {1, 3, 4, 5, 6, 18, 19, 20, 21, 22, 23, 25, 27, 28, 29, 30, 31, 35, 36};

        for (int i : wild_biomes) {
//            Biome.getBiome(i).getSpawnableList(EnumCreatureType.CREATURE).clear();
            EntityRegistry.addSpawn(EntityDuck.class, 25, 3, 4, EnumCreatureType.CREATURE, Biome.getBiome(i));
            EntityRegistry.addSpawn(EntityRabbit.class, 25, 3, 4, EnumCreatureType.CREATURE, Biome.getBiome(i));
            EntityRegistry.addSpawn(EntityWolf.class, 10, 5, 6, EnumCreatureType.CREATURE, Biome.getBiome(i));
            EntityRegistry.addSpawn(EntityBoar.class, 15, 5, 6, EnumCreatureType.CREATURE, Biome.getBiome(i));
            EntityRegistry.addSpawn(EntityPolarBear.class, 10, 1, 2, EnumCreatureType.CREATURE, Biome.getBiome(i));
            EntityRegistry.addSpawn(EntityDeer.class, 10, 1, 2, EnumCreatureType.CREATURE, Biome.getBiome(i));
        }
    }

    public static void registerDuck(Class<? extends EntityDuck> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityDuck>() {
            @Override
            public Render<? super EntityDuck> createRenderFor(RenderManager manager) {
                return new RenderDuck(manager);
            }
        });
    }

    public static void registerBoar(Class<? extends EntityBoar> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityBoar>() {
            @Override
            public Render<? super EntityBoar> createRenderFor(RenderManager manager) {
                return new RenderBoar(manager);
            }
        });
    }

    public static void registerGoat(Class<? extends EntityGoat> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityGoat>() {
            @Override
            public Render<? super EntityGoat> createRenderFor(RenderManager manager) {
                return new RenderGoat(manager);
            }
        });
    }

    public static void registerDeer(Class<? extends EntityDeer> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityDeer>() {
            @Override
            public Render<? super EntityDeer> createRenderFor(RenderManager manager) {
                return new RenderDeer(manager);
            }
        });
    }

    public static void registerBee(Class<? extends EntityBee> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityBee>() {
            @Override
            public Render<? super EntityBee> createRenderFor(RenderManager manager) {
                return new RenderBee(manager);
            }
        });
    }

    public static void registerFox(Class<? extends EntityFox> entity) {
        RenderingRegistry.registerEntityRenderingHandler(entity, new IRenderFactory<EntityFox>() {
            @Override
            public Render<? super EntityFox> createRenderFor(RenderManager manager) {
                return new RenderFox(manager);
            }
        });
    }
}
