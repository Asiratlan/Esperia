package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.Esperia;
import net.esperia.capabilities.emoteplayer.EmotePlayerProvider;
import net.esperia.capabilities.emoteplayer.IEmotePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerIconePacket implements IMessage {

	public int icone;
	public int playerID;
	
	public PlayerIconePacket() {
	}

	public PlayerIconePacket(int icone) {
		this.icone = icone;
		this.playerID = 0;
	}
	
	public PlayerIconePacket(int icone, int playerID) {
		this.icone = icone;
		this.playerID = playerID;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.icone = buf.readInt();
		this.playerID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.icone);
		buf.writeInt(this.playerID);
	}
	
	public static class ServerHandler implements IMessageHandler<PlayerIconePacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerIconePacket message, MessageContext ctx) {
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
					Esperia.network.sendToAll(new PlayerIconePacket(message.icone, sendingPlayer.getEntityId()));
					IEmotePlayer icone = sendingPlayer.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
					icone.setEmote(message.icone);
					/*if(icone.getPosition() == 1 || icone.getPosition() == 2)
						sendingPlayer.capabilities.setPlayerWalkSpeed(0.0F);
					else
						sendingPlayer.capabilities.setPlayerWalkSpeed(0.1F);*/
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerIconePacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerIconePacket message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world
							.getEntityByID(message.playerID);
					if(player == null)
						return;
					
					IEmotePlayer icone = player.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
					icone.setEmote(message.icone);
				}
			});

			return null;
		}
	}
}