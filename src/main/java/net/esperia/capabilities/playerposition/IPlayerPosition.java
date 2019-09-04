package net.esperia.capabilities.playerposition;

import net.esperia.enumerator.EnumPosition;

public interface IPlayerPosition {
	
	//public int getIntPosition();
	
	//public void setIntPosition(int type);
	
	public EnumPosition getEnumPosition();
	
	public void setEnumPosition(EnumPosition position);
	
	public String getEnumPositionValue();
	
	public void setEnumPositionValue(String positionValue);
}
