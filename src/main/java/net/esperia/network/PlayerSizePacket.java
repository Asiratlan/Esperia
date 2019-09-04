package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.Esperia;
import net.esperia.capabilities.playersize.IPlayerSize;
import net.esperia.capabilities.playersize.PlayerSizeProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerSizePacket implements IMessage {
	
	private float size;
	public int playerID;
	
	public PlayerSizePacket(){
	}
	
	public PlayerSizePacket(float size){
		this.size= size;
		this.playerID = 0;
	}
	
	public PlayerSizePacket(float size, int playerID) {
		this.size = size;
		this.playerID = playerID;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.size = buf.readFloat();
		this.playerID = buf.readInt();

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(this.size);
		buf.writeInt(this.playerID);
	}

	public static class ServerHandler implements IMessageHandler<PlayerSizePacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerSizePacket message, MessageContext ctx) {
			if (ctx.side != Side.SERVER) {
				return null;
			}

			final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
			if (sendingPlayer == null) {
				return null;
			}

			final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
			playerWorldServer.addScheduledTask(new Runnable() {
				public void run() {
					Esperia.network.sendToAll(new PlayerSizePacket(message.size, sendingPlayer.getEntityId()));
					IPlayerSize size = sendingPlayer.getCapability(PlayerSizeProvider.PLAYER_SIZE, null);
					size.setSize(message.size);
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerSizePacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerSizePacket message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world
							.getEntityByID(message.playerID);
					IPlayerSize size = player.getCapability(PlayerSizeProvider.PLAYER_SIZE, null);
					size.setSize(message.size);
				}
			});

			return null;
		}
	}

}
