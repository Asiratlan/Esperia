package net.esperia.capabilities.playerdescription;

public class PlayerDescription implements IPlayerDescription {

	private String description = "";
	
	@Override
	public void setDescription(String description) {
		this.description=description;	
	}

	@Override
	public String getDescription() {
		return this.description;		
	}

}
