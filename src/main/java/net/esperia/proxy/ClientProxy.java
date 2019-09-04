package net.esperia.proxy;

import org.lwjgl.input.Keyboard;

import net.esperia.BlocksRegistry;
import net.esperia.EntitiesRegistry;
import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.esperia.TileEntitiesRegistry;
import net.esperia.block.BlockDistaff;
import net.esperia.block.BlockDoorLockable;
import net.esperia.entity.EntityBee;
import net.esperia.entity.EntityBoar;
import net.esperia.entity.EntityDeer;
import net.esperia.entity.EntityDuck;
import net.esperia.entity.EntityFox;
import net.esperia.entity.EntityGoat;
import net.esperia.item.ItemSimpleColor;
import net.esperia.renders.TileEntityBibliothequeRenderer;
import net.esperia.renders.TileEntityHRPSignRenderer;
import net.esperia.renders.TileEntityInventoryRenderHelper;
import net.esperia.renders.TileEntityShowcaseRenderer;
import net.esperia.renders.TileEntityStoneSignRenderer;
import net.esperia.renders.TileEntityWallNoteRenderer;
import net.esperia.tileentity.TileEntityBibliotheque;
import net.esperia.tileentity.TileEntityCustomBed;
import net.esperia.tileentity.TileEntityCustomBedRenderer;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityShowcase;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.esperia.tileentity.TileEntityWallNote;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public static KeyBinding[] keyBindings;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        registerEntityRenders();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        ModelLoader.setCustomStateMapper(BlocksRegistry.acacia_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.birch_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.dark_oak_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.iron_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.jungle_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.oak_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.spruce_door_lockable, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        ModelLoader.setCustomStateMapper(BlocksRegistry.distaff, (new StateMap.Builder()).ignore(new IProperty[]{BlockDistaff.AGE}).build());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHRPSignEsperia.class, new TileEntityHRPSignRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneSignEsperia.class, new TileEntityStoneSignRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBibliotheque.class, new TileEntityBibliothequeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWallNote.class, new TileEntityWallNoteRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBed.class, new TileEntityCustomBedRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShowcase.class, new TileEntityShowcaseRenderer());
        TileEntityItemStackRenderer.instance = new TileEntityInventoryRenderHelper();

        keyBindings = new KeyBinding[2];
        keyBindings[0] = new KeyBinding("key.increase_walkSpeed", Keyboard.KEY_E, "key.categories.gameplay");
        keyBindings[1] = new KeyBinding("key.decrease_walkspeed",Keyboard.KEY_A , "key.categories.gameplay");

        for (int i = 0; i < keyBindings.length; i++) {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }

        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
                return tintIndex > 0 ? -1 : BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
            }
        }, BlocksRegistry.apple_bloom, BlocksRegistry.cherry_bloom, BlocksRegistry.chestnut_bloom, BlocksRegistry.lemon_bloom, BlocksRegistry.peach_bloom, BlocksRegistry.apricot_bloom, 
        		BlocksRegistry.leaves_layer, BlocksRegistry.leaves_spruce_layer, BlocksRegistry.leaves_jungle_layer, BlocksRegistry.leaves_acacia_layer, BlocksRegistry.leaves_dark_oak_layer
        		//BlocksRegistry.oak_leaves_stairs, BlocksRegistry.spruce_leaves_stairs, BlocksRegistry.jungle_leaves_stairs, BlocksRegistry.acacia_leaves_stairs, BlocksRegistry.dark_oak_leaves_stairs
        		);

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
            public int colorMultiplier(ItemStack stack, int tintIndex) {
                return tintIndex > 0 ? -1 : ColorizerFoliage.getFoliageColorBasic();
            }
        }, new Block[]{BlocksRegistry.apple_bloom, BlocksRegistry.cherry_bloom, BlocksRegistry.chestnut_bloom, BlocksRegistry.lemon_bloom, BlocksRegistry.peach_bloom, BlocksRegistry.apricot_bloom, BlocksRegistry.leaves_layer, BlocksRegistry.leaves_spruce_layer, BlocksRegistry.leaves_jungle_layer, BlocksRegistry.leaves_acacia_layer, BlocksRegistry.leaves_dark_oak_layer
        		//BlocksRegistry.oak_leaves_stairs, BlocksRegistry.spruce_leaves_stairs, BlocksRegistry.jungle_leaves_stairs, BlocksRegistry.acacia_leaves_stairs, BlocksRegistry.dark_oak_leaves_stairs
        		});

        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
                return ColorizerFoliage.getFoliageColorBirch();
            }
        }, BlocksRegistry.raspberry_bloom, BlocksRegistry.cassis_bloom, BlocksRegistry.strawberry_bloom/*, BlocksRegistry.birch_leaves_stairs */, BlocksRegistry.leaves_birch_layer);

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
            public int colorMultiplier(ItemStack stack, int tintIndex) {
                return tintIndex > 0 ? -1 : ColorizerFoliage.getFoliageColorBirch();
            }
        }, new Block[]{BlocksRegistry.raspberry_bloom, BlocksRegistry.cassis_bloom, BlocksRegistry.strawberry_bloom /*, BlocksRegistry.birch_leaves_stairs*/, BlocksRegistry.leaves_birch_layer});

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
            public int colorMultiplier(ItemStack stack, int tintIndex) {
                return tintIndex > 0 ? -1 : ((ItemSimpleColor) stack.getItem()).getColor(stack);
            }
        }, new Item[]{ItemsRegistry.cloth_robe, ItemsRegistry.cloth_boots, ItemsRegistry.cloth_gloves, ItemsRegistry.cloth_longcoat, ItemsRegistry.cloth_coat, ItemsRegistry.cloth_habit, ItemsRegistry.cloth_shirt, ItemsRegistry.cloth_skirt, ItemsRegistry.cloth_trousers,
            ItemsRegistry.cloth_underwear_f, ItemsRegistry.cloth_underwear_m, ItemsRegistry.plush_sheep, ItemsRegistry.plush_bear, ItemsRegistry.token_stone, ItemsRegistry.doll, ItemsRegistry.dice_4f, ItemsRegistry.dice_6f, ItemsRegistry.dice_8f, ItemsRegistry.dice_10f, 
            ItemsRegistry.dice_12f, ItemsRegistry.dice_20f, ItemsRegistry.petanque_pork_ball, ItemsRegistry.king, ItemsRegistry.queen, ItemsRegistry.bishop, ItemsRegistry.rook, ItemsRegistry.knight, ItemsRegistry.pawn}); 
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);

    }

    @Override
    public void registerEntityRenders() {
        EntitiesRegistry.registerDuck(EntityDuck.class);
        EntitiesRegistry.registerBoar(EntityBoar.class);
        EntitiesRegistry.registerGoat(EntityGoat.class);
        EntitiesRegistry.registerDeer(EntityDeer.class);
        EntitiesRegistry.registerBee(EntityBee.class);
        EntitiesRegistry.registerFox(EntityFox.class);
    }

    public static void registerRender(Block block) {
        if (block instanceof BlockDoorLockable) {
            ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(new IProperty[]{BlockDoorLockable.POWERED}).build());
        }
        if (block instanceof BlockDistaff) {
            ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(new IProperty[]{BlockDistaff.AGE}).build());

        }
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

    }

    public static void registerRenderMeta(Block block, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName() + "_" + name, "inventory"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ModelResourceLocation(block.getRegistryName() + "_" + name, "inventory"));
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Esperia.MOD_ID + ":" + id, "inventory"));
    }

    @Override
    public void addIgnoreToModel(Block block, IProperty property) {
        ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(new IProperty[]{property}).build());
    }

}
