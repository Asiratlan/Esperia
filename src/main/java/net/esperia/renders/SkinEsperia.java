package net.esperia.renders;

import java.io.File;
import java.util.UUID;

import net.esperia.capabilities.skinplayer.ISkinPlayer;
import net.esperia.capabilities.skinplayer.SkinPlayer.SkinState;
import net.esperia.capabilities.skinplayer.SkinPlayerProvider;
import net.esperia.util.ThreadDownloadImageDataEsperia;
import net.esperia.util.UUIDHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class SkinEsperia {
	
	public static void DownloadImageSkin(ResourceLocation resourceLocationIn, String username, EntityPlayer player) {		
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		ITextureObject itextureobject = texturemanager.getTexture(resourceLocationIn);
		//EntityPlayer player = (EntityPlayer) abstractPlayer;
		ISkinPlayer capDownloaded = player.getCapability(SkinPlayerProvider.SKIN_DOWNLOADED, null);		
		if (itextureobject != null && capDownloaded != null && capDownloaded.getDownloaded() == SkinState.NULL.name()) {
			
			
			//Esperia.network.sendToServer(new UUIDPlayerMessage(player.getEntityId()));
			
			UUID uuid = UUIDHelper.isPlayerOffline(player) ? player.getGameProfile().getId() /*UUIDHelper.getOfflineUUID(username)*/ : UUIDHelper.getOnlineUUID(player.getName());			
			itextureobject = new ThreadDownloadImageDataEsperia((File) null,
					String.format("http://esperia-rp.net/skins/%s", new Object[] { StringUtils.stripControlCodes(uuid.toString()) }), uuid.toString(), DefaultPlayerSkin.getDefaultSkin(uuid),
					new ImageBufferDownloadCustom());
			
			texturemanager.loadTexture(resourceLocationIn, itextureobject);
			capDownloaded.setDownloaded(SkinState.DOWNLOADED.name());
		}

		//return (ThreadDownloadImageData) itextureobject;
	}

}