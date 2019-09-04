package net.esperia.capabilities.playerwalkspeed;

import java.util.UUID;

import net.esperia.util.positions.WalkPosition;
import net.minecraft.entity.ai.attributes.AttributeModifier;

public class PlayerWalkSpeed implements IPlayerWalkSpeed {

	private String enumName = EnumWalkSpeed.NORMAL.name();
	
	@Override
	public void saveWalkSpeed(String enumName) {
		this.enumName = enumName;
	}

	@Override
	public String readWalkSpeedUUID() {
		return EnumWalkSpeed.valueOf(this.enumName).getUUID().toString() != null ? EnumWalkSpeed.valueOf(this.enumName).getUUID().toString() : null;
	}

	@Override
	public AttributeModifier getWalkSpeed() {
		return EnumWalkSpeed.valueOf(this.enumName).getModifier() != null ? EnumWalkSpeed.valueOf(this.enumName).getModifier() : null;
	}

	@Override
	public void increaseWalkSpeed() {
		if(this.enumName.equals(EnumWalkSpeed.REDUCED.name()))
			this.enumName = EnumWalkSpeed.AVERAGE.name();
		else if(this.enumName.equals(EnumWalkSpeed.AVERAGE.name()))
			this.enumName = EnumWalkSpeed.NORMAL.name();
		
	}

	@Override
	public void decreaseWalkSpeed() {
		if(this.enumName.equals(EnumWalkSpeed.NORMAL.name()))
			this.enumName = EnumWalkSpeed.AVERAGE.name();
		else if(this.enumName.equals(EnumWalkSpeed.AVERAGE.name()))
			this.enumName = EnumWalkSpeed.REDUCED.name();
	}
	
	public enum EnumWalkSpeed{
		NORMAL(null, null),
		AVERAGE(WalkPosition.getUUIDAverageSpeedModifier(), WalkPosition.getAverageSpeedModifier()),
		REDUCED(WalkPosition.getUUIDReducedSpeedModifier(), WalkPosition.getReducedSpeedModifier());
		
		
		private UUID uuid;
		private AttributeModifier modifier;
		
		EnumWalkSpeed(UUID uuid, AttributeModifier modifier){
			this.uuid = uuid;
			this.modifier = modifier;
		}
		
		public UUID getUUID(){
			return this.uuid;
		}
		
		public AttributeModifier getModifier(){
			return this.modifier;
		}
	}

	@Override
	public String getWalkSpeedEnumName() {
		// TODO Auto-generated method stub
		return this.enumName;
	}

}
