package net.esperia.capabilities;

import net.esperia.Esperia;
import net.esperia.capabilities.emoteplayer.EmotePlayerProvider;
import net.esperia.capabilities.playerlangages.PlayerLangagesProvider;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.capabilities.playersize.PlayerSizeProvider;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedProvider;
import net.esperia.capabilities.skinplayer.SkinPlayerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	 public static final ResourceLocation POSITION_CAP = new ResourceLocation(Esperia.MOD_ID, "position");
	 public static final ResourceLocation SKIN_DOWNLOADED = new ResourceLocation(Esperia.MOD_ID, "skin");
	 public static final ResourceLocation PLAYER_LANGAGES = new ResourceLocation(Esperia.MOD_ID, "langages");
	 public static final ResourceLocation PLAYER_EMOTE = new ResourceLocation(Esperia.MOD_ID, "emote");
	 public static final ResourceLocation PLAYER_SIZE = new ResourceLocation(Esperia.MOD_ID, "size");
	 public static final ResourceLocation WALK_SPEED = new ResourceLocation(Esperia.MOD_ID, "walkspeed");

	    @SubscribeEvent
	    public void attachCapability(AttachCapabilitiesEvent event)
	    {
	    	if (!(event.getObject() instanceof EntityPlayer)) return;
	        event.addCapability(POSITION_CAP, new PlayerPositionProvider());
	        event.addCapability(SKIN_DOWNLOADED, new SkinPlayerProvider());
	        event.addCapability(PLAYER_LANGAGES, new PlayerLangagesProvider());
	        event.addCapability(PLAYER_EMOTE, new EmotePlayerProvider());
	        event.addCapability(PLAYER_SIZE, new PlayerSizeProvider());
	        event.addCapability(WALK_SPEED, new PlayerWalkSpeedProvider());
	}

}
