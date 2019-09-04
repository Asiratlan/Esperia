package net.esperia.capabilities.playersize;

public class PlayerSize implements IPlayerSize{

	private float size = 1.8F;
	
	@Override
	public void setSize(float size) {
		this.size = size;
	}

	@Override
	public float getSize() {
		return this.size;
	}

}
