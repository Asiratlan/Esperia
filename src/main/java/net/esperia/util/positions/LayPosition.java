package net.esperia.util.positions;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class LayPosition extends Positions {

	private static final UUID laySpeedUUID = UUID.fromString("328b14d7-4662-4d9d-92e9-0ce89f7b9cfb");
	private static final AttributeModifier laySpeed = new AttributeModifier(laySpeedUUID, "vitesse couché", -0.9D, 2);
	
	public AttributeModifier getSpeedModifier(){
		return laySpeed;
	}
	
	@Override
	public void setHitBox(EntityPlayer player/*, float size*/){
		AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();
        float height = 0.6F;
		
        //On ne modifie pas la taille Ã  cause du changement de position
        player.height = height;
        player.eyeHeight = 0.3F;

        player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ,
                axisalignedbb.minX + player.width, axisalignedbb.minY + (double) height,
                axisalignedbb.minZ + player.width));
        player.getEntityBoundingBox().setMaxY(axisalignedbb.maxY);

		
	}
	
	public static UUID getUUIDSpeedModifier(){
		return laySpeedUUID;
	}
	
}
