package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.Esperia;
import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.enumerator.EnumPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerPositionPacket implements IMessage {

	public String positionValue;
	public int playerID;

	public PlayerPositionPacket() {
	}

	public PlayerPositionPacket(EnumPosition position) {
		this.positionValue = position.name();
		this.playerID = 0;
	}
	
	public PlayerPositionPacket(EnumPosition position, int playerID) {
		this.positionValue = position.name();
		this.playerID = playerID;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.positionValue = ByteBufUtils.readUTF8String(buf);
		this.playerID = buf.readInt();

	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.positionValue);

		buf.writeInt(this.playerID);
	}

	public static class ServerHandler implements IMessageHandler<PlayerPositionPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerPositionPacket message, MessageContext ctx) {
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
					Esperia.network.sendToAll(new PlayerPositionPacket(EnumPosition.valueOf(message.positionValue), sendingPlayer.getEntityId()));
					IPlayerPosition position = sendingPlayer.getCapability(PlayerPositionProvider.POSITION_CAP, null);
					position.setEnumPosition(EnumPosition.valueOf(message.positionValue));
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerPositionPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerPositionPacket message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world
							.getEntityByID(message.playerID);
					IPlayerPosition position = player.getCapability(PlayerPositionProvider.POSITION_CAP, null);
					position.setEnumPosition(EnumPosition.valueOf(message.positionValue));
				}
			});

			return null;
		}
	}

}
