package net.esperia.util;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public class SpeedPlayerModifier {
	
	private static final UUID averageWalkSpeedUUID = UUID.fromString("5a99d6b4-48f9-42d0-beec-7a1ea0d5ef73");
	private static final UUID reducedWalkSpeedUUID = UUID.fromString("2ed7d4ee-b293-4ab5-b7ef-237b123e12eb");
	private static final UUID sitSpeedUUID = UUID.fromString("09e07d75-0b2b-40cf-bfef-b248378073cf");
	private static final UUID laySpeedUUID = UUID.fromString("328b14d7-4662-4d9d-92e9-0ce89f7b9cfb");
	private static final UUID facedownSpeedUUID = UUID.fromString("572810e5-d5cd-4ab5-94af-419d2c1553c9");

	private static final AttributeModifier averageWalkSpeed = new AttributeModifier(averageWalkSpeedUUID,
			"vitesse moyenne", -0.25D, 2);
	private static final AttributeModifier reducedWalkSpeed = new AttributeModifier(reducedWalkSpeedUUID,
			"vitesse basse", -0.5D, 2);
	private static final AttributeModifier sitSpeed = new AttributeModifier(sitSpeedUUID, "vitesse assis", -0.8D, 2);
	private static final AttributeModifier laySpeed = new AttributeModifier(laySpeedUUID, "vitesse couché", -0.9D, 2);
	private static final AttributeModifier facedownSpeed = new AttributeModifier(facedownSpeedUUID, "vitesse à plat ventre",
			-0.6D, 2);

	private static final AttributeModifier modifierTable[] = {averageWalkSpeed, reducedWalkSpeed, sitSpeed, laySpeed, facedownSpeed};
	
	public AttributeModifier[] getModifierTable(){
		return this.modifierTable;
	}
	
	public enum EnumSpeedPlayer {
		NORMAL_SPEED("walkspeed", null),
		AVERAGE_SPEED("walkspeed", averageWalkSpeed),
		REDUCED_SPEED("walkspeed", reducedWalkSpeed),
		SIT_SPEED("sitspeed", sitSpeed),
		LAY_SPEED("layspeed", laySpeed),
		FACEDOWN_SPEED("facedownspeed", facedownSpeed);
		
		private final String category;
		private final AttributeModifier modifier;
		
		private EnumSpeedPlayer(String category, AttributeModifier modifier){
			this.category = category;
			this.modifier = modifier;
		}
		
		public String getCategory(){
			return this.category;
		}
		
		public AttributeModifier getModifier(){
			return this.modifier;
		}
	}

}
