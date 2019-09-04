package net.esperia.capabilities.playerlangages;

public class PlayerLangages implements IPlayerLangages {

	/*
	 * 0 quand le joueur ne parle pas la lange, 1 quand il la parle Dans l'ordre
	 * {Adaarion, Hura, Qadjaride}
	 */

	private int langages[] = { 0, 0, 0 };

	@Override
	public void setLangages(int[] langages) {
		if (langages.length == 3)
			this.langages = langages;

	}

	@Override
	public int[] getLangages() {
		return this.langages;
	}
	
	@Override
	public int getLangages(int langage){
		return this.langages[langage];
	}

	@Override
	public void setLangages(int langage, int value) {
		this.langages[langage] = value;
		
	}

}
