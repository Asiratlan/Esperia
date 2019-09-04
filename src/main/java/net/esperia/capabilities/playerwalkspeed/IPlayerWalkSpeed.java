package net.esperia.capabilities.playerwalkspeed;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public interface IPlayerWalkSpeed {
	
	public void saveWalkSpeed(String enumName);
	
	public String readWalkSpeedUUID();
	
	public AttributeModifier getWalkSpeed();
	
	public String getWalkSpeedEnumName();
	
	public void increaseWalkSpeed();
	
	public void decreaseWalkSpeed();

}
