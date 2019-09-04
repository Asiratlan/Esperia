package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.Esperia;
import net.esperia.capabilities.playerdescription.IPlayerDescription;
import net.esperia.capabilities.playerdescription.PlayerDescriptionProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerDescriptionPacket implements IMessage {

	public String description = "";
	public int playerID;

	public PlayerDescriptionPacket() {
	}

	public PlayerDescriptionPacket(int playerID) {
		this.playerID = playerID;
	}

	public PlayerDescriptionPacket(String description) {
		this.description = description;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.description = ByteBufUtils.readUTF8String(buf);
		this.playerID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.description);
		buf.writeInt(this.playerID);
	}

	public static class ServerHandler implements IMessageHandler<PlayerDescriptionPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerDescriptionPacket message, MessageContext ctx) {
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
					IPlayerDescription description = playerWorldServer.getEntityByID(message.playerID).getCapability(PlayerDescriptionProvider.PLAYER_DESCRIPTION, null);
					Esperia.network.sendTo(new PlayerDescriptionPacket(description.getDescription()), sendingPlayer);
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerDescriptionPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerDescriptionPacket message, MessageContext ctx) {

			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString(message.description).setStyle(new Style().setColor(TextFormatting.GREEN)));
				}
			});

			return null;
		}
	}
}
