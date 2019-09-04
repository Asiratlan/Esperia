package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.enumerator.EnumPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerRenderPacket implements IMessage {

	public int playerID;

	public PlayerRenderPacket() {
	}

	public PlayerRenderPacket(int playerID) {
		this.playerID = playerID;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.playerID = buf.readInt();

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.playerID);
	}

	public static class ServerHandler implements IMessageHandler<PlayerRenderPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerRenderPacket message, MessageContext ctx) {
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
					//Esperia.network.sendTo(new PlayerPositionPacket(message.playerID, sendingPlayer.getEntityId()), sendingPlayer);
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerRenderPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerRenderPacket message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world
							.getEntityByID(message.playerID);
					if(Minecraft.getMinecraft().player == player)
					{
						player = Minecraft.getMinecraft().player;
						IPlayerPosition position = player.getCapability(PlayerPositionProvider.POSITION_CAP, null);
						if(position != null){
							if(position.getEnumPosition().equals(EnumPosition.SIT))
								player.eyeHeight = 1.2F;
							else if(position.getEnumPosition().equals(EnumPosition.LAY) || position.getEnumPosition().equals(EnumPosition.FACEDOWN))
								player.eyeHeight = 0.5F;
								
						}
					}
				}
			});

			return null;
		}
	}

}
