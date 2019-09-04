package net.esperia.network;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.esperia.capabilities.skinplayer.ISkinPlayer;
import net.esperia.capabilities.skinplayer.SkinPlayerProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SkinMessage implements IMessage {
	
	private String uuid;
	
	public SkinMessage() {
	}
	
	public SkinMessage(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.uuid = ByteBufUtils.readUTF8String(buf);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.uuid);
		
	}
	
	public static class ServerHandler implements IMessageHandler<SkinMessage, IMessage> {

		@Override
		public IMessage onMessage(final SkinMessage message, MessageContext ctx) {
			/*if (ctx.side != Side.SERVER) {
				return null;
			}

			
			final EntityPlayerMP sendingPlayer = ctx.getServerHandler().playerEntity;
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
			});*/

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<SkinMessage, IMessage> {

		@Override
		public IMessage onMessage(final SkinMessage message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}
			

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					UUID uuid = UUID.fromString(message.uuid);
					EntityPlayer player = worldClient.getPlayerEntityByUUID(uuid);
					ISkinPlayer capability = player.getCapability(SkinPlayerProvider.SKIN_DOWNLOADED, null);
					if (capability == null)
						return;
					else {
						capability.setDownloaded("NULL");
					}

				}
			});

			return null;
		}
	}

}
