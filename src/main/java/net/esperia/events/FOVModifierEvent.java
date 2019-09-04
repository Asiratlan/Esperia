package net.esperia.events;

import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.capabilities.playerwalkspeed.IPlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedProvider;
import net.esperia.enumerator.EnumPosition;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FOVModifierEvent {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void FOVSpeedModifier(FOVUpdateEvent event) {

		IAttributeInstance iattributeinstance = event.getEntity()
				.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		IPlayerPosition position = event.getEntity().getCapability(PlayerPositionProvider.POSITION_CAP, null);
		IPlayerWalkSpeed walkSpeed = event.getEntity().getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
		if (!position.getEnumPosition().equals(EnumPosition.STAND)
				|| (position.getEnumPosition().equals(EnumPosition.STAND) && !PlayerWalkSpeed.EnumWalkSpeed
						.valueOf(walkSpeed.getWalkSpeedEnumName()).equals(PlayerWalkSpeed.EnumWalkSpeed.NORMAL))) {
			double modifier = 0.0F;
			if (!position.getEnumPosition().equals(EnumPosition.STAND)) {
				modifier = (double) (position.getEnumPosition().getClassPosition().getSpeedModifier()
							.getAmount() / 10.0F);
			} else if (position.getEnumPosition().equals(EnumPosition.STAND) && !PlayerWalkSpeed.EnumWalkSpeed
					.valueOf(walkSpeed.getWalkSpeedEnumName()).equals(PlayerWalkSpeed.EnumWalkSpeed.NORMAL)) {
				modifier = (double) (walkSpeed.getWalkSpeed().getAmount() / 10.0F);
			}
			
			event.setNewfov(this.applyNewfov(modifier, event.getEntity()));
		} 
	}

	private float applyNewfov(double modifier, EntityPlayer player) {
		float f = 1.0F;

		if (player.capabilities.isFlying) {
			f *= 1.1F;
		}

		IAttributeInstance iattributeinstance = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		f = (float) ((double) f
				* (((iattributeinstance.getAttributeValue() - modifier) / (double) player.capabilities.getWalkSpeed()
						+ 1.0D) / 2.0D));

		if (player.capabilities.getWalkSpeed() == 0.0F || Float.isNaN(f) || Float.isInfinite(f)) {
			f = 1.0F;
		}

		if (player.isHandActive() && player.getActiveItemStack().getItem() == Items.BOW) {
			int i = player.getItemInUseMaxCount();
			float f1 = (float) i / 20.0F;

			if (f1 > 1.0F) {
				f1 = 1.0F;
			} else {
				f1 = f1 * f1;
			}

			f *= 1.0F - f1 * 0.15F;
		}
		return f;

	}
}
