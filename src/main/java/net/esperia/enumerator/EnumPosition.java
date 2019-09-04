package net.esperia.enumerator;

import net.esperia.util.positions.FaceDownPosition;
import net.esperia.util.positions.LayPosition;
import net.esperia.util.positions.Positions;
import net.esperia.util.positions.SitPosition;
import net.esperia.util.positions.WalkPosition;

public enum EnumPosition {

	STAND(new WalkPosition()),
	SIT(new SitPosition()),
	LAY(new LayPosition()),
	FACEDOWN(new FaceDownPosition());
	
	private Positions position = new WalkPosition();
	
	EnumPosition(Positions position){
		this.position = position;
	}
	
	public Positions getClassPosition(){
		return this.position;
	}
}
