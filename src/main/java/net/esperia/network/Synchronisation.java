package net.esperia.network;

import net.esperia.Esperia;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class Synchronisation {

	public static void syncPlayerToOther(EntityPlayer player) {
		if (player.isServerWorld()) {
			Esperia.network.sendToAll(new PlayerPositionPacket(
					player.getCapability(PlayerPositionProvider.POSITION_CAP, null).getEnumPosition(),
					player.getEntityId()));
			Esperia.network.sendTo(new PlayerRenderPacket(player.getEntityId()), (EntityPlayerMP) player);
			Esperia.network.sendToAll(new PlayerPositionPacket(
					player.getCapability(PlayerPositionProvider.POSITION_CAP, null).getEnumPosition(),
					player.getEntityId()));
			Esperia.network.sendTo(new PlayerRenderPacket(player.getEntityId()), (EntityPlayerMP) player);
			
		}

	}

	public static void syncOtherToPlayer(EntityPlayerMP player) {
		if (player.isServerWorld()) {
			for (EntityPlayer otherPlayer : player.getServerWorld().playerEntities) {

				Esperia.network.sendTo(new PlayerPositionPacket(
						otherPlayer.getCapability(PlayerPositionProvider.POSITION_CAP, null).getEnumPosition(),
						otherPlayer.getEntityId()), player);
			}
		}
	}

	public static void syncServerToPlayer(EntityPlayerMP player) {
		if (player.isServerWorld()) {
			Esperia.network.sendTo(new PlayerSpeedPacket(player.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null).getWalkSpeedEnumName()), player);
		}
	}

}
