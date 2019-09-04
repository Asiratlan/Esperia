package net.esperia.proxy;

import net.esperia.Esperia;
import net.esperia.TileEntitiesRegistry;
import net.esperia.capabilities.emoteplayer.EmotePlayer;
import net.esperia.capabilities.emoteplayer.EmotePlayerStorage;
import net.esperia.capabilities.emoteplayer.IEmotePlayer;
import net.esperia.capabilities.playerlangages.IPlayerLangages;
import net.esperia.capabilities.playerlangages.PlayerLangages;
import net.esperia.capabilities.playerlangages.PlayerLangagesStorage;
import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionStorage;
import net.esperia.capabilities.playersize.IPlayerSize;
import net.esperia.capabilities.playersize.PlayerSize;
import net.esperia.capabilities.playersize.PlayerSizeStorage;
import net.esperia.capabilities.playerwalkspeed.IPlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedStorage;
import net.esperia.capabilities.skinplayer.ISkinPlayer;
import net.esperia.capabilities.skinplayer.SkinPlayer;
import net.esperia.capabilities.skinplayer.SkinPlayerStorage;
import net.esperia.handler.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        TileEntitiesRegistry.init();

        CapabilityManager.INSTANCE.register(IPlayerPosition.class, new PlayerPositionStorage(), PlayerPosition.class);
        CapabilityManager.INSTANCE.register(ISkinPlayer.class, new SkinPlayerStorage(), SkinPlayer.class);
        CapabilityManager.INSTANCE.register(IPlayerLangages.class, new PlayerLangagesStorage(), PlayerLangages.class);
        CapabilityManager.INSTANCE.register(IEmotePlayer.class, new EmotePlayerStorage(), EmotePlayer.class);
        //CapabilityManager.INSTANCE.register(IPlayerDescription.class, new PlayerDescriptionStorage(), PlayerDescription.class);
        CapabilityManager.INSTANCE.register(IPlayerWalkSpeed.class, new PlayerWalkSpeedStorage(), PlayerWalkSpeed.class);
        CapabilityManager.INSTANCE.register(IPlayerSize.class, new PlayerSizeStorage(), PlayerSize.class);
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Esperia.instance(), new GuiHandler());

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerEntityRenders() {
    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void addIgnoreToModel(Block block, IProperty property) {

    }

}
