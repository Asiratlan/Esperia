package net.esperia.capabilities.emoteplayer;

public class EmotePlayer implements IEmotePlayer {

	private int emote = 0;
	
	@Override
	public void setEmote(int emote) {
		this.emote = emote;	
	}

	@Override
	public int getEmote() {
		return this.emote;
	}

}
