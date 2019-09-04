package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.capabilities.playerwalkspeed.IPlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedProvider;
import net.esperia.enumerator.EnumPosition;
import net.esperia.util.positions.WalkPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerSpeedPacket implements IMessage {

	/*private static final UUID averageWalkSpeedUUID = UUID.fromString("5a99d6b4-48f9-42d0-beec-7a1ea0d5ef73");
	private static final UUID reducedWalkSpeedUUID = UUID.fromString("2ed7d4ee-b293-4ab5-b7ef-237b123e12eb");
	private static final UUID sitSpeedUUID = UUID.fromString("09e07d75-0b2b-40cf-bfef-b248378073cf");
	private static final UUID laySpeedUUID = UUID.fromString("328b14d7-4662-4d9d-92e9-0ce89f7b9cfb");
	private static final UUID facedownSpeedUUID = UUID.fromString("572810e5-d5cd-4ab5-94af-419d2c1553c9");

	private static final AttributeModifier averageWalkSpeed = new AttributeModifier(averageWalkSpeedUUID,
			"vitesse moyenne", -0.25D, 2);
	private static final AttributeModifier reducedWalkSpeed = new AttributeModifier(reducedWalkSpeedUUID,
			"vitesse basse", -0.5D, 2);
	private static final AttributeModifier sitSpeed = new AttributeModifier(sitSpeedUUID, "vitesse assis", -0.8D, 2);
	private static final AttributeModifier laySpeed = new AttributeModifier(laySpeedUUID, "vitesse couch�", -0.9D, 2);
	private static final AttributeModifier facedownSpeed = new AttributeModifier(facedownSpeedUUID, "vitesse � plat ventre",
			-0.6D, 2);*/

	//private static final AttributeModifier modifierTable[] = {averageWalkSpeed, reducedWalkSpeed, sitSpeed, laySpeed, facedownSpeed};
	
	private String walkSpeedName;

	public PlayerSpeedPacket() {
	}

	public PlayerSpeedPacket(String walkSpeedName) {
		this.walkSpeedName = walkSpeedName;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.walkSpeedName = ByteBufUtils.readUTF8String(buf);
		;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.walkSpeedName);
	}

	public static class ServerHandler implements IMessageHandler<PlayerSpeedPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerSpeedPacket message, MessageContext ctx) {
			if (ctx.side != Side.SERVER) {
				return null;
			}

			final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
			final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
			playerWorldServer.addScheduledTask(new Runnable() {
				public void run() {
					IAttributeInstance movement = sendingPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
					
					IPlayerPosition position = sendingPlayer.getCapability(PlayerPositionProvider.POSITION_CAP, null);
					IPlayerWalkSpeed walkSpeed = sendingPlayer.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
					if(position != null && walkSpeed != null){
						walkSpeed.saveWalkSpeed(message.walkSpeedName);
						if(position.getEnumPosition().equals(EnumPosition.STAND) && position.getEnumPosition().getClassPosition() instanceof WalkPosition){
							if(((WalkPosition) position.getEnumPosition().getClassPosition()).getSpeedModifier(walkSpeed.getWalkSpeedEnumName()) != null){
								for(AttributeModifier modifier : movement.getModifiers()) {
									movement.removeModifier(modifier);
								}
								movement.applyModifier(((WalkPosition)position.getEnumPosition().getClassPosition()).getSpeedModifier(walkSpeed.getWalkSpeedEnumName()));
							}
							else
								for(AttributeModifier modifier : movement.getModifiers()) {
									movement.removeModifier(modifier);
								}
						}
						else{
							if(position.getEnumPosition().getClassPosition().getSpeedModifier() != null){
								if(movement.getModifier(position.getEnumPosition().getClassPosition().getUUIDSpeedModifier()) != null)
									movement.removeModifier(position.getEnumPosition().getClassPosition().getSpeedModifier());
								else if(movement.getModifier(position.getEnumPosition().getClassPosition().getUUIDSpeedModifier()) == null){
									for(AttributeModifier modifier : movement.getModifiers()) {
										movement.removeModifier(modifier);
									}
									movement.applyModifier(position.getEnumPosition().getClassPosition().getSpeedModifier());
								}
							}
						}		
					}
				}
			});

			return null;
		}
	}

	public static class ClientHandler implements IMessageHandler<PlayerSpeedPacket, IMessage> {

		@Override
		public IMessage onMessage(final PlayerSpeedPacket message, MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}

			Minecraft minecraft = Minecraft.getMinecraft();
			final WorldClient worldClient = minecraft.world;
			minecraft.addScheduledTask(new Runnable() {
				public void run() {
					EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().player;
					IPlayerWalkSpeed walkSpeed = player.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
					walkSpeed.saveWalkSpeed(message.walkSpeedName);					
				}
			});

			return null;
		}
	}
	
	private void setModifierAndApply(String category){
		
	}

}
