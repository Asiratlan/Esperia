package net.esperia.network;

import java.io.File;
import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.esperia.Esperia;
import net.esperia.renders.ImageBufferDownloadCustom;
import net.esperia.util.ThreadDownloadImageDataEsperia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.StringUtils;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class UUIDPlayerMessage implements IMessage {

	public int playerID;
	public String uuid = "0";

	public UUIDPlayerMessage() {
	}

	public UUIDPlayerMessage(int playerID) {
		this.playerID = playerID;
	}

	public UUIDPlayerMessage(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.playerID = buf.readInt();
		this.uuid = ByteBufUtils.readUTF8String(buf);

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.playerID);
		ByteBufUtils.writeUTF8String(buf, this.uuid);
	}

	public static class ServerHandler implements IMessageHandler<UUIDPlayerMessage, IMessage> {

		@Override
		public IMessage onMessage(final UUIDPlayerMessage message, MessageContext ctx) {
			if (ctx.side != Side.SERVER) {
				return null;
			}

			
			final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
			if (sendingPlayer == null) {
				System.err.println("EntityPlayerMP est null !");
				return null;
			}

			final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
			playerWorldServer.addScheduledTask(new Runnable() {
				public void run() {
					Entity entity = playerWorldServer.getEntityByID(message.playerID);
					EntityPlayer player = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;
					String uuid = player.getUniqueID().toString();
					Esperia.network.sendTo(new UUIDPlayerMessage(uuid), sendingPlayer);
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<UUIDPlayerMessage, IMessage> {

		@Override
		public IMessage onMessage(final UUIDPlayerMessage message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}
			

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					UUID uuid = UUID.fromString(message.uuid);
					EntityPlayer player = worldClient.getPlayerEntityByUUID(uuid);
					String username = player.getName();
					NetworkPlayerInfo networkplayerinfo = Minecraft.getMinecraft().getConnection()
							.getPlayerInfo(uuid);

					ITextureObject itextureobject = Minecraft.getMinecraft().getTextureManager()
							.getTexture(networkplayerinfo.getLocationSkin());

					itextureobject = new ThreadDownloadImageDataEsperia((File) null,
							String.format("http://esperia.gwendal.me/skins/%s", new Object[] { StringUtils.stripControlCodes(uuid.toString()) }), uuid.toString(), DefaultPlayerSkin.getDefaultSkin(uuid),
							new ImageBufferDownloadCustom());

					Minecraft.getMinecraft().getTextureManager().loadTexture(networkplayerinfo.getLocationSkin(),
							itextureobject);

				}
			});

			return null;
		}
	}

}
