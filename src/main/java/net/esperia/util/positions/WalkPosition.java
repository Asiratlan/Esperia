package net.esperia.util.positions;

import java.util.UUID;

import net.esperia.capabilities.playerwalkspeed.PlayerWalkSpeed;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class WalkPosition extends Positions {
	
	private static final UUID averageWalkSpeedUUID = UUID.fromString("5a99d6b4-48f9-42d0-beec-7a1ea0d5ef73");
	private static final UUID reducedWalkSpeedUUID = UUID.fromString("2ed7d4ee-b293-4ab5-b7ef-237b123e12eb");
	private static final AttributeModifier averageWalkSpeed = new AttributeModifier(averageWalkSpeedUUID,
			"vitesse moyenne", -0.25D, 2);
	private static final AttributeModifier reducedWalkSpeed = new AttributeModifier(reducedWalkSpeedUUID,
			"vitesse basse", -0.5D, 2);
	
	/*public static AttributeModifier getSpeedModifier(){
		return sitSpeed;
	}*/
	
	public AttributeModifier getSpeedModifier(String enumName){
		return PlayerWalkSpeed.EnumWalkSpeed.valueOf(enumName).getModifier();
	}
	
	public static UUID getUUIDAverageSpeedModifier(){
		return averageWalkSpeedUUID;
	}
	
	public static UUID getUUIDReducedSpeedModifier(){
		return reducedWalkSpeedUUID;
	}
	
	public static AttributeModifier getAverageSpeedModifier(){
		return averageWalkSpeed;
	}
	
	public static AttributeModifier getReducedSpeedModifier(){
		return reducedWalkSpeed;
	}
	
	@Override
	public void setHitBox(EntityPlayer player/*, float size*/){
		AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();
        
        //On ne modifie pas la taille à cause du changement de position
        player.height = 1.8F;
        player.eyeHeight = 1.6F;

        player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ,
                axisalignedbb.minX + player.width, axisalignedbb.minY + (double)player.height,
                axisalignedbb.minZ + player.width));
        player.getEntityBoundingBox().setMaxY(axisalignedbb.maxY);

		
	}
	
	/*public static UUID getUUIDSpeedModifier(){
		return sitSpeedUUID;
	}*/


}
