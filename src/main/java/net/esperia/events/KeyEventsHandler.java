package net.esperia.events;

import net.esperia.Esperia;
import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.capabilities.playerwalkspeed.IPlayerWalkSpeed;
import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeedProvider;
import net.esperia.enumerator.EnumPosition;
import net.esperia.network.PlayerSpeedPacket;
import net.esperia.proxy.ClientProxy;
import net.esperia.util.positions.WalkPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyEventsHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(KeyInputEvent event) {

        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        if (keyBindings[0].isPressed()) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            IPlayerWalkSpeed walkSpeed = player.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
            if (walkSpeed != null) {
                walkSpeed.increaseWalkSpeed();
            }
            Esperia.network.sendToServer(new PlayerSpeedPacket(walkSpeed.getWalkSpeedEnumName()));
            this.setClientSpeedModifier(player);

        }

        if (keyBindings[1].isPressed()) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            IPlayerWalkSpeed walkSpeed = player.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
            if (walkSpeed != null) {
                walkSpeed.decreaseWalkSpeed();
            }
            Esperia.network.sendToServer(new PlayerSpeedPacket(walkSpeed.getWalkSpeedEnumName()));
            this.setClientSpeedModifier(player);
        }
    }

    private void setClientSpeedModifier(EntityPlayer player) {

        IAttributeInstance movement = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

        IPlayerPosition position = player.getCapability(PlayerPositionProvider.POSITION_CAP, null);
        IPlayerWalkSpeed walkSpeed = player.getCapability(PlayerWalkSpeedProvider.PLAYER_WALKSPEED, null);
        if (position != null && walkSpeed != null) {
            if (position.getEnumPosition().equals(EnumPosition.STAND)
                    && position.getEnumPosition().getClassPosition() instanceof WalkPosition) {
                if (((WalkPosition) position.getEnumPosition().getClassPosition())
                        .getSpeedModifier(walkSpeed.getWalkSpeedEnumName()) != null) {
                    movement.removeAllModifiers();
                    movement.applyModifier(((WalkPosition) position.getEnumPosition().getClassPosition())
                            .getSpeedModifier(walkSpeed.getWalkSpeedEnumName()));
                } else {
                    movement.removeAllModifiers();
                }
            } else {
                if (position.getEnumPosition().getClassPosition().getSpeedModifier() != null) {
                    if (movement
                            .getModifier(position.getEnumPosition().getClassPosition().getUUIDSpeedModifier()) != null) {
                        movement.removeModifier(position.getEnumPosition().getClassPosition().getSpeedModifier());
                    } else if (movement.getModifier(
                            position.getEnumPosition().getClassPosition().getUUIDSpeedModifier()) == null) {
                        movement.removeAllModifiers();
                        movement.applyModifier(position.getEnumPosition().getClassPosition().getSpeedModifier());
                    }
                }
            }
        }
    }
}
