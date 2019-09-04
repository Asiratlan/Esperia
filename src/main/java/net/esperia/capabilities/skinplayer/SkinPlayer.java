package net.esperia.capabilities.skinplayer;

public class SkinPlayer implements ISkinPlayer {

	private SkinState downloaded = SkinState.NULL;
	
	@Override
	public void setDownloaded(String downloaded) {
		this.downloaded = SkinState.valueOf(downloaded);
	}

	@Override
	public String getDownloaded() {
		return this.downloaded.name();
	}
	
	public enum SkinState {
		DOWNLOADED,
		PENDING,
		NULL;
	}

}
