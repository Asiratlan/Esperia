package net.esperia.util.positions;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class SitPosition extends Positions {
	
	private static final UUID sitSpeedUUID = UUID.fromString("09e07d75-0b2b-40cf-bfef-b248378073cf");
	private static final AttributeModifier sitSpeed = new AttributeModifier(sitSpeedUUID, "vitesse assis", -0.8D, 2);
	
	@Override
	public AttributeModifier getSpeedModifier(){
		return sitSpeed;
	}
	
	@Override
	public void setHitBox(EntityPlayer player/*, float size*/){
		AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();
        
        //On ne modifie pas la taille à cause du changement de position
        player.height = 1.3F;
        player.eyeHeight = 1.1F;

        player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ,
                axisalignedbb.minX + player.width, axisalignedbb.minY + (double) player.height,
                axisalignedbb.minZ + player.width));
        player.getEntityBoundingBox().setMaxY(axisalignedbb.maxY);

		
	}
	
	public static UUID getUUIDSpeedModifier(){
		return sitSpeedUUID;
	}

}
