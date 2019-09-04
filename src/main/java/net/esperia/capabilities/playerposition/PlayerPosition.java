package net.esperia.capabilities.playerposition;

import net.esperia.enumerator.EnumPosition;

public class PlayerPosition implements IPlayerPosition {

	//private int type = 0;
	private String enumValue;
	
	
	/*@Override
	public int getIntPosition() {
		return this.type;

	}

	@Override
	public void setIntPosition(int type) {
		this.type = type;

	}*/

	@Override
	public EnumPosition getEnumPosition() {
		return enumValue != null ? EnumPosition.valueOf(enumValue) : EnumPosition.STAND;
	}

	@Override
	public void setEnumPosition(EnumPosition position) {
		this.enumValue = position.name();
		
	}

	@Override
	public String getEnumPositionValue() {
		return this.enumValue != null ? this.enumValue : EnumPosition.STAND.name();
	}

	@Override
	public void setEnumPositionValue(String positionValue) {
		this.enumValue = positionValue;
		
	}


}
