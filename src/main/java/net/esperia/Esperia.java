package net.esperia;

import java.io.IOException;

import net.esperia.capabilities.CapabilityHandler;
import net.esperia.events.EventGuiTchat;
import net.esperia.events.EventHandler;
import net.esperia.events.EventRightClick;
import net.esperia.events.FOVModifierEvent;
import net.esperia.events.KeyEventsHandler;
import net.esperia.events.RenderModelPlayerEvent;
import net.esperia.network.HRPSignEsperiaGuiPacket;
import net.esperia.network.OpenEditWallNoteMessage;
import net.esperia.network.PlayerIconePacket;
import net.esperia.network.PlayerSpeedPacket;
import net.esperia.network.SignEsperiaInfoServerPacket;
import net.esperia.network.StoneSignEsperiaGuiPacket;
import net.esperia.network.UpdateWallNoteMessage;
import net.esperia.proxy.CommonProxy;
import net.esperia.recipe.RecipesClothDyes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Esperia.MOD_ID, version = Esperia.VERSION)
public class Esperia {

    @Mod.Instance(Esperia.MOD_ID)
    private static Esperia instance;

    public static Esperia instance() {
        return Esperia.instance;
    }

    public static final String MOD_ID = "esperia";
    public static final String MOD_NAME = "Esperia";
    public static final String VERSION = "1.3.0";
    public static final String CLIENT_PROXY_CLASS = "net.esperia.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.esperia.proxy.ServerProxy";

    public static SimpleNetworkWrapper network;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ItemsRegistry.register(event.getRegistry());
            BlocksRegistry.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlocksRegistry.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
            event.getRegistry().register(new RecipesClothDyes().setRegistryName(Esperia.MOD_ID, "clothdye"));
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ItemsRegistry.registerModels();
            BlocksRegistry.registerModels();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EntitiesRegistry.registerEntities();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        proxy.init(event);
        OreDictionaryRegistry.init();
        RecipesRegistry.init();

        network = NetworkRegistry.INSTANCE.newSimpleChannel("EsperiaChannel");
        registerNetworkEvent(network);

        MinecraftForge.EVENT_BUS.register(new RenderModelPlayerEvent());
        MinecraftForge.EVENT_BUS.register(new EventRightClick());
        MinecraftForge.EVENT_BUS.register(new KeyEventsHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventGuiTchat());
        MinecraftForge.EVENT_BUS.register(new FOVModifierEvent());
        int idEntity = 1;

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) throws IOException {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

    }

    public void registerNetworkEvent(SimpleNetworkWrapper network) {
        int id = 0;
//        network.registerMessage(PlayerPositionPacket.ClientHandler.class, PlayerPositionPacket.class, id++, Side.CLIENT);
//        network.registerMessage(PlayerPositionPacket.ServerHandler.class, PlayerPositionPacket.class, id++, Side.SERVER);
//        network.registerMessage(PlayerRenderPacket.ClientHandler.class, PlayerRenderPacket.class, id++, Side.CLIENT);
//        network.registerMessage(PlayerRenderPacket.ServerHandler.class, PlayerRenderPacket.class, id++, Side.SERVER);
        network.registerMessage(HRPSignEsperiaGuiPacket.ClientHandler.class, HRPSignEsperiaGuiPacket.class, 5, Side.CLIENT);
        network.registerMessage(StoneSignEsperiaGuiPacket.ClientHandler.class, StoneSignEsperiaGuiPacket.class, 6, Side.CLIENT);
        network.registerMessage(SignEsperiaInfoServerPacket.ServerHandler.class, SignEsperiaInfoServerPacket.class, 7, Side.SERVER);
        network.registerMessage(OpenEditWallNoteMessage.ClientHandler.class, OpenEditWallNoteMessage.class, 8, Side.CLIENT);
        network.registerMessage(UpdateWallNoteMessage.ServerHandler.class, UpdateWallNoteMessage.class, 9, Side.SERVER);
        network.registerMessage(PlayerIconePacket.ClientHandler.class, PlayerIconePacket.class, 10, Side.CLIENT);
        network.registerMessage(PlayerIconePacket.ServerHandler.class, PlayerIconePacket.class, 11, Side.SERVER);
//        network.registerMessage(UUIDPlayerMessage.ServerHandler.class, UUIDPlayerMessage.class, id++, Side.SERVER);
//        network.registerMessage(UUIDPlayerMessage.ClientHandler.class, UUIDPlayerMessage.class, id++, Side.CLIENT);
//        network.registerMessage(SkinMessage.ClientHandler.class, SkinMessage.class, id++, Side.CLIENT);
        network.registerMessage(PlayerSpeedPacket.ServerHandler.class, PlayerSpeedPacket.class, 15, Side.SERVER);
        network.registerMessage(PlayerSpeedPacket.ClientHandler.class, PlayerSpeedPacket.class, 16, Side.CLIENT);
//        network.registerMessage(PlayerSizePacket.ClientHandler.class, PlayerSizePacket.class, id++, Side.CLIENT);
//        network.registerMessage(PlayerSizePacket.ServerHandler.class, PlayerSizePacket.class, id++, Side.SERVER);
    }

}
